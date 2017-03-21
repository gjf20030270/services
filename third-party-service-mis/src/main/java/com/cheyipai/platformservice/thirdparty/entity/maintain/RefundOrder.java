package com.cheyipai.platformservice.thirdparty.entity.maintain;

import javax.persistence.*;

@Table(name = "maintain_refund_order")
public class RefundOrder {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 退款开始时间
     */
    @Column(name = "refund_time_start")
    private Long refundTimeStart;

    /**
     * 退款完成时间
     */
    @Column(name = "refund_time_finish")
    private Long refundTimeFinish;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * 退款单号
     */
    @Column(name = "refund_order_num")
    private String refundOrderNum;

    /**
     * 退款流水号
     */
    @Column(name = "refund_batch")
    private String refundBatch;

    /**
     * 交易流水号
     */
    @Column(name = "trade_no")
    private String tradeNo;

    /**
     * 订单号
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 支付状态0退款中1退款成功2退款失败
     */
    @Column(name = "refund_status")
    private Integer refundStatus;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取退款开始时间
     *
     * @return refund_time_start - 退款开始时间
     */
    public Long getRefundTimeStart() {
        return refundTimeStart;
    }

    /**
     * 设置退款开始时间
     *
     * @param refundTimeStart 退款开始时间
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
     * 获取退款单号
     *
     * @return refund_order_num - 退款单号
     */
    public String getRefundOrderNum() {
        return refundOrderNum;
    }

    /**
     * 设置退款单号
     *
     * @param refundOrderNum 退款单号
     */
    public void setRefundOrderNum(String refundOrderNum) {
        this.refundOrderNum = refundOrderNum;
    }

    /**
     * 获取退款流水号
     *
     * @return refund_batch - 退款流水号
     */
    public String getRefundBatch() {
        return refundBatch;
    }

    /**
     * 设置退款流水号
     *
     * @param refundBatch 退款流水号
     */
    public void setRefundBatch(String refundBatch) {
        this.refundBatch = refundBatch;
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
     * 获取支付状态0退款中1退款成功2退款失败
     *
     * @return refund_status - 支付状态0退款中1退款成功2退款失败
     */
    public Integer getRefundStatus() {
        return refundStatus;
    }

    /**
     * 设置支付状态0退款中1退款成功2退款失败
     *
     * @param refundStatus 支付状态0退款中1退款成功2退款失败
     */
    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }
}