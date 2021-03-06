package com.newxton.nxtframework.struct;

import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.List;

/**
 * @author soyojo.earth@gmail.com
 * @time 2020/11/25
 * @address Shenzhen, China
 */
public class NxtStructOrderFormRefund {

    /**
     * 售后id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 订单id
     */
    private Long orderFormId;
    /**
     * 售后原因 （数字）0:无理由 1:质量问题
     */
    private Integer reasonType;
    /**
     * 售后原因 （文字）
     */
    private String reasonTypeText;
    /**
     * 售后原因 描述
     */
    private String reasionDescription;
    /**
     * 售后状态 数字）状态（-1:拒绝退款 0:已申请 1:完成 2:等用户发货 3:收到货退款 4:收到货有问题，请修改金额 5:用户已寄出物品）
     */
    private Integer status;
    /**
     * 售后状态（文字）
     */
    private String statusText;
    /**
     * 售后申请时间
     */
    private Long datelineCreate;
    private String datelineCreateReadable;
    /**
     * 售后结束时间
     */
    private Long datelineEnd;
    private String datelineEndReadable;

    private String orderFormSerialNum;

    /**
     * 售后单中的物品
     */
    private List<NxtStructOrderFormRefundProduct> orderFormRefundProductList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderFormId() {
        return orderFormId;
    }

    public void setOrderFormId(Long orderFormId) {
        this.orderFormId = orderFormId;
    }

    public Integer getReasonType() {
        return reasonType;
    }

    public void setReasonType(Integer reasonType) {
        this.reasonType = reasonType;
    }

    public String getReasonTypeText() {
        return reasonTypeText;
    }

    public void setReasonTypeText(String reasonTypeText) {
        this.reasonTypeText = reasonTypeText;
    }

    public String getReasionDescription() {
        return reasionDescription;
    }

    public void setReasionDescription(String reasionDescription) {
        this.reasionDescription = reasionDescription;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Long getDatelineCreate() {
        return datelineCreate;
    }

    public void setDatelineCreate(Long datelineCreate) {
        this.datelineCreate = datelineCreate;
    }

    public String getDatelineCreateReadable() {
        return datelineCreateReadable;
    }

    public void setDatelineCreateReadable(String datelineCreateReadable) {
        this.datelineCreateReadable = datelineCreateReadable;
    }

    public Long getDatelineEnd() {
        return datelineEnd;
    }

    public void setDatelineEnd(Long datelineEnd) {
        this.datelineEnd = datelineEnd;
    }

    public String getDatelineEndReadable() {
        return datelineEndReadable;
    }

    public void setDatelineEndReadable(String datelineEndReadable) {
        this.datelineEndReadable = datelineEndReadable;
    }

    public String getOrderFormSerialNum() {
        return orderFormSerialNum;
    }

    public void setOrderFormSerialNum(String orderFormSerialNum) {
        this.orderFormSerialNum = orderFormSerialNum;
    }

    public List<NxtStructOrderFormRefundProduct> getOrderFormRefundProductList() {
        return orderFormRefundProductList;
    }

    public void setOrderFormRefundProductList(List<NxtStructOrderFormRefundProduct> orderFormRefundProductList) {
        this.orderFormRefundProductList = orderFormRefundProductList;
    }

}
