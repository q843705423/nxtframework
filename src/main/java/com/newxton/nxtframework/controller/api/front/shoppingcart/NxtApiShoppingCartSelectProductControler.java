package com.newxton.nxtframework.controller.api.front.shoppingcart;

import com.google.gson.Gson;
import com.newxton.nxtframework.entity.NxtShoppingCart;
import com.newxton.nxtframework.entity.NxtShoppingCartProduct;
import com.newxton.nxtframework.service.NxtShoppingCartProductService;
import com.newxton.nxtframework.service.NxtShoppingCartService;
import com.newxton.nxtframework.struct.NxtStructApiResult;
import com.newxton.nxtframework.struct.NxtStructShoppingCartPOST;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author soyojo.earth@gmail.com
 * @time 2020/11/25
 * @address Shenzhen, China
 */
@RestController
public class NxtApiShoppingCartSelectProductControler {

    @Resource
    private NxtShoppingCartService nxtShoppingCartService;
    @Resource
    private NxtShoppingCartProductService nxtShoppingCartProductService;

    @RequestMapping(value = "/api/shopping_cart/select_product", method = RequestMethod.POST)
    public NxtStructApiResult index(@RequestHeader(value = "user_id", required = false) Long userId, @RequestBody String json) {

        Gson gson = new Gson();
        NxtStructShoppingCartPOST shoppingCartItem;

        try {
            shoppingCartItem = gson.fromJson(json, NxtStructShoppingCartPOST.class);
        }
        catch (Exception e){
            return new NxtStructApiResult(53,"json格式不正确");
        }

        if (userId == null && (shoppingCartItem.getGuestToken() == null || shoppingCartItem.getGuestToken().isEmpty())) {
            return new NxtStructApiResult(54,"缺少user_id或guestToken");
        }

        Long shoppingCartItemId = shoppingCartItem.getProduct().getId();
        if (shoppingCartItemId == null) {
            return new NxtStructApiResult(34,"传入购物车物品id为空");
        }

        Boolean selected = shoppingCartItem.getProduct().getSelected();
        if (selected == null) {
            return new NxtStructApiResult(34,"缺少selected");
        }

        NxtShoppingCart shoppingCart;

        // 检查条件user_id有值，还是guestToken有值，如果都有值以user_id为主
        if (userId != null) {
            // 已登录用户 购物车
            shoppingCart = nxtShoppingCartService.queryByUserId(userId);
        } else {
            // 匿名用户流程 购物车
            String token = shoppingCartItem.getGuestToken();
            shoppingCart = nxtShoppingCartService.queryByToken(token);
        }

        if (shoppingCart == null){
            return new NxtStructApiResult(34,"没找到购物车，请检查上传参数");
        }

        NxtShoppingCartProduct shoppingCartProduct = nxtShoppingCartProductService.queryById(shoppingCartItemId);

        if (shoppingCartProduct == null){
            return new NxtStructApiResult(34,"购物车里没有该物品");
        }

        if (!shoppingCartProduct.getShoppingCartId().equals(shoppingCart.getId())){
            return new NxtStructApiResult(34,"购物车里没有该物品");
        }

        shoppingCartProduct.setSelected(selected ? 1 : 0);

        nxtShoppingCartProductService.update(shoppingCartProduct);

        return new NxtStructApiResult();

    }

}
