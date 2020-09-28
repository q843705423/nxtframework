package com.newxton.nxtframework.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.newxton.nxtframework.entity.NxtUser;
import com.newxton.nxtframework.service.NxtUserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author soyojo.earth@gmail.com
 * @time 2020/7/21
 * @address Shenzhen, China
 * @copyright NxtFramework
 */
public class NxtAdminInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private NxtUserService nxtUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Map<String,Object> errorResult = new HashMap<>();
        errorResult.put("status",41);
        errorResult.put("message","未登录");


        String user_id = request.getHeader("user_id");

        String token = request.getHeader("token");

        if (user_id == null || token == null){
            sendJsonMessage(response,errorResult);
            return false;
        }

        if (token.length() == 0 || user_id.length() == 0){
            //校验不通过
            sendJsonMessage(response,errorResult);
            return false;
        }

        NxtUser user = nxtUserService.queryById(Long.valueOf(user_id));

        if (user == null){
            //校验不通过
            sendJsonMessage(response,errorResult);
            return false;
        }
        else {
            if (!user.getToken().equals(token)){
                //校验不通过
                sendJsonMessage(response,errorResult);
                return false;
            }
            if (user.getStatus().equals(-1)){
                //校验不通过
                errorResult.put("status",-1);
                errorResult.put("message","已被禁止");
                sendJsonMessage(response,errorResult);
                return false;
            }
        }

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        super.afterCompletion(request, response, handler, ex);
    }



    /**
     * 将某个对象转换成json格式并发送到客户端
     * @param response
     * @param obj
     * @throws Exception
     */
    public void sendJsonMessage(HttpServletResponse response, Object obj) throws Exception {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(JSONObject.toJSONString(obj, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat));
        writer.close();
        response.flushBuffer();
    }

}
