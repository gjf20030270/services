package com.cheyipai.platformservice.thirdparty.entity.maintain;

import javax.persistence.*;

@Table(name = "maintain_payment_order")
public class PaymentOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 付款单号
     */
    @Column(name = "payment_order_id")
    private String paymentOrderId;

    /**
     * 订单号
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 支付状态0待支付1支付成功2支付失败
     */
    @Column(name = "pay_status")
    private Integer payStatus;

    /**
     * 交易流水号
     */
    @Column(name = "trade_no")
    private String tradeNo;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * 支付时间
     */
    @Column(name = "pay_time")
    private Long payTime;

    /**
     * 支付类型weixin/alipay
     */
    @Column(name = "pay_type")
    private String payType;

    /**
     * 付款金额
     */
    private Integer amount;

    /**
     * 合作号
     */
    private String cooperation;

    /**
     * 合作号对应key
     */
    @Column(name = "coo_key")
    private String cooKey;

    /**
     * pc,ios,andriod
     */
    private String resource;

    /**
     * 1新版，由mapi调用0旧版
     */
    @Column(name = "is_new_version")
    private Integer isNewVersion;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取付款单号
     *
     * @return payment_order_id - 付款单号
     */
    public String getPaymentOrderId() {
        return paymentOrderId;
    }

    /**
     * 设置付款单号
     *
     * @param paymentOrderId 付款单号
     */
    public void setPaymentOrderId(String paymentOrderId) {
        this.paymentOrderId = paymentOrderId;
    }

    /**
     * 获取订单号
     *
     * @return order_id - 订单号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单号
     *
     * @param orderId 订单号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取支付状态0待支付1支付成功2支付失败
     *
     * @return pay_status - 支付状态0待支付1支付成功2支付失败
     */
    public Integer getPayStatus() {
        return payStatus;
    }

    /**
     * 设置支付状态0待支付1支付成功2支付失败
     *
     * @param payStatus 支付状态0待支付1支付成功2支付失败
     */
    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 获取交易流水号
     *
     * @return trade_no - 交易流水号
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * 设置交易流水号
     *
     * @param tradeNo 交易流水号
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取支付时间
     *
     * @return pay_time - 支付时间
     */
    public Long getPayTime() {
        return payTime;
    }

    /**
     * 设置支付时间
     *
     * @param payTime 支付时间
     */
    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取支付类型weixin/alipay
     *
     * @return pay_type - 支付类型weixin/alipay
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 设置支付类型weixin/alipay
     *
     * @param payType 支付类型weixin/alipay
     */
    public void setPayType(String payType) {
        this.payType = payType;
    }

    /**
     * 获取付款金额
     *
     * @return amount - 付款金额
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 设置付款金额
     *
     * @param amount 付款金额
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 获取合作号
     *
     * @return cooperation - 合作号
     */
    public String getCooperation() {
        return cooperation;
    }

    /**
     * 设置合作号
     *
     * @param cooperation 合作号
     */
    public void setCooperation(String cooperation) {
        this.cooperation = cooperation;
    }

    /**
     * 获取合作号对应key
     *
     * @return coo_key - 合作号对应key
     */
    public String getCooKey() {
        return cooKey;
    }

    /**
     * 设置合作号对应key
     *
     * @param cooKey 合作号对应key
     */
    public void setCooKey(String cooKey) {
        this.cooKey = cooKey;
    }

    /**
     * 获取pc,ios,andriod
     *
     * @return resource - pc,ios,andriod
     */
    public String getResource() {
        return resource;
    }

    /**
     * 设置pc,ios,andriod
     *
     * @param resource pc,ios,andriod
     */
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     * 获取1新版，由mapi调用0旧版
     *
     * @return is_new_version - 1新版，由mapi调用0旧版
     */
    public Integer getIsNewVersion() {
        return isNewVersion;
    }

    /**
     * 设置1新版，由mapi调用0旧版
     *
     * @param isNewVersion 1新版，由mapi调用0旧版
     */
    public void setIsNewVersion(Integer isNewVersion) {
        this.isNewVersion = isNewVersion;
    }
}