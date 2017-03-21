package com.cheyipai.platformservice.thirdparty.entity.maintain;

import javax.persistence.*;

@Table(name = "maintain_query_detail")
public class QueryDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 查询ID
     */
    @Column(name = "query_id")
    private Integer queryId;

    /**
     * 供应商ID
     */
    @Column(name = "supplier_id")
    private Integer supplierId;

    /**
     * 车辆VIN码
     */
    @Column(name = "car_vin")
    private String carVin;

    /**
     * 调用时间yyyy-MM-dd HH:mm:ss
     */
    @Column(name = "call_time")
    private String callTime;

    /**
     * 回调时间yyyy-MM-dd HH:mm:ss
     */
    @Column(name = "call_back_time")
    private String callBackTime;

    /**
     * 查询第三方返回的订单号
     */
    @Column(name = "thrid_order_id")
    private String thridOrderId;

    /**
     * 是否查询到报告0查询中1是2已执行过定时任务
     */
    @Column(name = "has_report")
    private Integer hasReport;

    /**
     * 查询结果状态
     */
    @Column(name = "result_status")
    private String resultStatus;

    /**
     * 查询结果描述
     */
    @Column(name = "result_message")
    private String resultMessage;

    /**
     * 供应商回调地址
     */
    @Column(name = "call_back_url")
    private String callBackUrl;

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
     * 获取查询ID
     *
     * @return query_id - 查询ID
     */
    public Integer getQueryId() {
        return queryId;
    }

    /**
     * 设置查询ID
     *
     * @param queryId 查询ID
     */
    public void setQueryId(Integer queryId) {
        this.queryId = queryId;
    }

    /**
     * 获取供应商ID
     *
     * @return supplier_id - 供应商ID
     */
    public Integer getSupplierId() {
        return supplierId;
    }

    /**
     * 设置供应商ID
     *
     * @param supplierId 供应商ID
     */
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * 获取车辆VIN码
     *
     * @return car_vin - 车辆VIN码
     */
    public String getCarVin() {
        return carVin;
    }

    /**
     * 设置车辆VIN码
     *
     * @param carVin 车辆VIN码
     */
    public void setCarVin(String carVin) {
        this.carVin = carVin;
    }

    /**
     * 获取调用时间yyyy-MM-dd HH:mm:ss
     *
     * @return call_time - 调用时间yyyy-MM-dd HH:mm:ss
     */
    public String getCallTime() {
        return callTime;
    }

    /**
     * 设置调用时间yyyy-MM-dd HH:mm:ss
     *
     * @param callTime 调用时间yyyy-MM-dd HH:mm:ss
     */
    public void setCallTime(String callTime) {
        this.callTime = callTime;
    }

    /**
     * 获取回调时间yyyy-MM-dd HH:mm:ss
     *
     * @return call_back_time - 回调时间yyyy-MM-dd HH:mm:ss
     */
    public String getCallBackTime() {
        return callBackTime;
    }

    /**
     * 设置回调时间yyyy-MM-dd HH:mm:ss
     *
     * @param callBackTime 回调时间yyyy-MM-dd HH:mm:ss
     */
    public void setCallBackTime(String callBackTime) {
        this.callBackTime = callBackTime;
    }

    /**
     * 获取查询第三方返回的订单号
     *
     * @return thrid_order_id - 查询第三方返回的订单号
     */
    public String getThridOrderId() {
        return thridOrderId;
    }

    /**
     * 设置查询第三方返回的订单号
     *
     * @param thridOrderId 查询第三方返回的订单号
     */
    public void setThridOrderId(String thridOrderId) {
        this.thridOrderId = thridOrderId;
    }

    /**
     * 获取是否查询到报告0查询中1是2已执行过定时任务
     *
     * @return has_report - 是否查询到报告0查询中1是2已执行过定时任务
     */
    public Integer getHasReport() {
        return hasReport;
    }

    /**
     * 设置是否查询到报告0查询中1是2已执行过定时任务
     *
     * @param hasReport 是否查询到报告0查询中1是2已执行过定时任务
     */
    public void setHasReport(Integer hasReport) {
        this.hasReport = hasReport;
    }

    /**
     * 获取查询结果状态
     *
     * @return result_status - 查询结果状态
     */
    public String getResultStatus() {
        return resultStatus;
    }

    /**
     * 设置查询结果状态
     *
     * @param resultStatus 查询结果状态
     */
    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    /**
     * 获取查询结果描述
     *
     * @return result_message - 查询结果描述
     */
    public String getResultMessage() {
        return resultMessage;
    }

    /**
     * 设置查询结果描述
     *
     * @param resultMessage 查询结果描述
     */
    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    /**
     * 获取供应商回调地址
     *
     * @return call_back_url - 供应商回调地址
     */
    public String getCallBackUrl() {
        return callBackUrl;
    }

    /**
     * 设置供应商回调地址
     *
     * @param callBackUrl 供应商回调地址
     */
    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }
}