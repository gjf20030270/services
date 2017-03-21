package com.cheyipai.platformservice.thirdparty.entity.maintain;

import javax.persistence.*;

@Table(name = "maintain_order_form_table")
public class OrderFormTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 根据规则生成的订单ID
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 车商、检测员ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户编码
     */
    @Column(name = "member_code")
    private String memberCode;

    /**
     * 业务单ID
     */
    @Column(name = "business_id")
    private Integer businessId;

    /**
     * 订单状态0待支付1已失效2付款成功3付款失败4退款中5退款成功6退款失败
     */
    @Column(name = "order_state")
    private Integer orderState;

    /**
     * 付款类型（weixinalipaycoinpoint）
     */
    @Column(name = "payment_type")
    private String paymentType;

    /**
     * 应付金额
     */
    @Column(name = "payment_sum")
    private Integer paymentSum;

    /**
     * 订单生成时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * 付款时间
     */
    @Column(name = "payment_time")
    private Long paymentTime;

    /**
     * 发起退款时间
     */
    @Column(name = "refund_time_start")
    private Long refundTimeStart;

    /**
     * 退款完成时间
     */
    @Column(name = "refund_time_finish")
    private Long refundTimeFinish;

    /**
     * 到期时间
     */
    @Column(name = "expire_time")
    private Long expireTime;

    /**
     * 项目名
     */
    @Column(name = "project_name")
    private String projectName;

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
     * 获取根据规则生成的订单ID
     *
     * @return order_id - 根据规则生成的订单ID
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置根据规则生成的订单ID
     *
     * @param orderId 根据规则生成的订单ID
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取车商、检测员ID
     *
     * @return user_id - 车商、检测员ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置车商、检测员ID
     *
     * @param userId 车商、检测员ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户编码
     *
     * @return member_code - 用户编码
     */
    public String getMemberCode() {
        return memberCode;
    }

    /**
     * 设置用户编码
     *
     * @param memberCode 用户编码
     */
    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    /**
     * 获取业务单ID
     *
     * @return business_id - 业务单ID
     */
    public Integer getBusinessId() {
        return businessId;
    }

    /**
     * 设置业务单ID
     *
     * @param businessId 业务单ID
     */
    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    /**
     * 获取订单状态0待支付1已失效2付款成功3付款失败4退款中5退款成功6退款失败
     *
     * @return order_state - 订单状态0待支付1已失效2付款成功3付款失败4退款中5退款成功6退款失败
     */
    public Integer getOrderState() {
        return orderState;
    }

    /**
     * 设置订单状态0待支付1已失效2付款成功3付款失败4退款中5退款成功6退款失败
     *
     * @param orderState 订单状态0待支付1已失效2付款成功3付款失败4退款中5退款成功6退款失败
     */
    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    /**
     * 获取付款类型（weixinalipaycoinpoint）
     *
     * @return payment_type - 付款类型（weixinalipaycoinpoint）
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * 设置付款类型（weixinalipaycoinpoint）
     *
     * @param paymentType 付款类型（weixinalipaycoinpoint）
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 获取应付金额
     *
     * @return payment_sum - 应付金额
     */
    public Integer getPaymentSum() {
        return paymentSum;
    }

    /**
     * 设置应付金额
     *
     * @param paymentSum 应付金额
     */
    public void setPaymentSum(Integer paymentSum) {
        this.paymentSum = paymentSum;
    }

    /**
     * 获取订单生成时间
     *
     * @return create_time - 订单生成时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 设置订单生成时间
     *
     * @param createTime 订单生成时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取付款时间
     *
     * @return payment_time - 付款时间
     */
    public Long getPaymentTime() {
        return paymentTime;
    }

    /**
     * 设置付款时间
     *
     * @param paymentTime 付款时间
     */
    public void setPaymentTime(Long paymentTime) {
        this.paymentTime = paymentTime;
    }

    /**
     * 获取发起退款时间
     *
     * @return refund_time_start - 发起退款时间
     */
    public Long getRefundTimeStart() {
        return refundTimeStart;
    }

    /**
     * 设置发起退款时间
     *
     * @param refundTimeStart 发起退款时间
     */
    public void setRefundTimeStart(Long refundTimeStart) {
        this.refundTimeStart = refundTimeStart;
    }

    /**
     * 获取退款完成时间
     *
     * @return refund_time_finish - 退款完成时间
     */
    public Long getRefundTimeFinish() {
        return refundTimeFinish;
    }

    /**
     * 设置退款完成时间
     *
     * @param refundTimeFinish 退款完成时间
     */
    public void setRefundTimeFinish(Long refundTimeFinish) {
        this.refundTimeFinish = refundTimeFinish;
    }

    /**
     * 获取到期时间
     *
     * @return expire_time - 到期时间
     */
    public Long getExpireTime() {
        return expireTime;
    }

    /**
     * 设置到期时间
     *
     * @param expireTime 到期时间
     */
    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * 获取项目名
     *
     * @return project_name - 项目名
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置项目名
     *
     * @param projectName 项目名
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}