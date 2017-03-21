package com.cheyipai.platformservice.thirdparty.entity.maintain;

import javax.persistence.*;

@Table(name = "maintain_query_form")
public class QueryForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
     * 渠道：商户端、检测端、微信公众号、平台、API
     */
    @Column(name = "channel_from")
    private String channelFrom;

    /**
     * 来源：iosandoridpcjcd
     */
    @Column(name = "from_type")
    private String fromType;

    /**
     * 前端传入，并非自己的car_id
     */
    @Column(name = "car_id")
    private Integer carId;

    /**
     * vin码
     */
    @Column(name = "car_vin")
    private String carVin;

    /**
     * 记录生成时间
     */
    @Column(name = "create_date")
    private Long createDate;

    /**
     * 记录返回时间
     */
    @Column(name = "result_back_time")
    private String resultBackTime;

    /**
     * 查询状态0查询中1查询失败2查询成功3job处理中
     */
    @Column(name = "query_status")
    private Integer queryStatus;

    /**
     * 结算标识1已结算0未结算
     */
    @Column(name = "clearing_flag")
    private Integer clearingFlag;

    /**
     * 是否4S查询入口1是0不是
     */
    @Column(name = "is_tool")
    private Integer isTool;

    /**
     * 是否查新报告1是0否
     */
    @Column(name = "is_new_report")
    private Integer isNewReport;

    /**
     * 是否发过推送0否1是
     */
    @Column(name = "push_flag")
    private Integer pushFlag;

    /**
     * maintain_product_spu 主键ID
     */
    @Column(name = "product_id")
    private Integer productId;

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
     * 获取渠道：商户端、检测端、微信公众号、平台、API
     *
     * @return channel_from - 渠道：商户端、检测端、微信公众号、平台、API
     */
    public String getChannelFrom() {
        return channelFrom;
    }

    /**
     * 设置渠道：商户端、检测端、微信公众号、平台、API
     *
     * @param channelFrom 渠道：商户端、检测端、微信公众号、平台、API
     */
    public void setChannelFrom(String channelFrom) {
        this.channelFrom = channelFrom;
    }

    /**
     * 获取来源：iosandoridpcjcd
     *
     * @return from_type - 来源：iosandoridpcjcd
     */
    public String getFromType() {
        return fromType;
    }

    /**
     * 设置来源：iosandoridpcjcd
     *
     * @param fromType 来源：iosandoridpcjcd
     */
    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    /**
     * 获取前端传入，并非自己的car_id
     *
     * @return car_id - 前端传入，并非自己的car_id
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * 设置前端传入，并非自己的car_id
     *
     * @param carId 前端传入，并非自己的car_id
     */
    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    /**
     * 获取vin码
     *
     * @return car_vin - vin码
     */
    public String getCarVin() {
        return carVin;
    }

    /**
     * 设置vin码
     *
     * @param carVin vin码
     */
    public void setCarVin(String carVin) {
        this.carVin = carVin;
    }

    /**
     * 获取记录生成时间
     *
     * @return create_date - 记录生成时间
     */
    public Long getCreateDate() {
        return createDate;
    }

    /**
     * 设置记录生成时间
     *
     * @param createDate 记录生成时间
     */
    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取记录返回时间
     *
     * @return result_back_time - 记录返回时间
     */
    public String getResultBackTime() {
        return resultBackTime;
    }

    /**
     * 设置记录返回时间
     *
     * @param resultBackTime 记录返回时间
     */
    public void setResultBackTime(String resultBackTime) {
        this.resultBackTime = resultBackTime;
    }

    /**
     * 获取查询状态0查询中1查询失败2查询成功3job处理中
     *
     * @return query_status - 查询状态0查询中1查询失败2查询成功3job处理中
     */
    public Integer getQueryStatus() {
        return queryStatus;
    }

    /**
     * 设置查询状态0查询中1查询失败2查询成功3job处理中
     *
     * @param queryStatus 查询状态0查询中1查询失败2查询成功3job处理中
     */
    public void setQueryStatus(Integer queryStatus) {
        this.queryStatus = queryStatus;
    }

    /**
     * 获取结算标识1已结算0未结算
     *
     * @return clearing_flag - 结算标识1已结算0未结算
     */
    public Integer getClearingFlag() {
        return clearingFlag;
    }

    /**
     * 设置结算标识1已结算0未结算
     *
     * @param clearingFlag 结算标识1已结算0未结算
     */
    public void setClearingFlag(Integer clearingFlag) {
        this.clearingFlag = clearingFlag;
    }

    /**
     * 获取是否4S查询入口1是0不是
     *
     * @return is_tool - 是否4S查询入口1是0不是
     */
    public Integer getIsTool() {
        return isTool;
    }

    /**
     * 设置是否4S查询入口1是0不是
     *
     * @param isTool 是否4S查询入口1是0不是
     */
    public void setIsTool(Integer isTool) {
        this.isTool = isTool;
    }

    /**
     * 获取是否查新报告1是0否
     *
     * @return is_new_report - 是否查新报告1是0否
     */
    public Integer getIsNewReport() {
        return isNewReport;
    }

    /**
     * 设置是否查新报告1是0否
     *
     * @param isNewReport 是否查新报告1是0否
     */
    public void setIsNewReport(Integer isNewReport) {
        this.isNewReport = isNewReport;
    }

    /**
     * 获取是否发过推送0否1是
     *
     * @return push_flag - 是否发过推送0否1是
     */
    public Integer getPushFlag() {
        return pushFlag;
    }

    /**
     * 设置是否发过推送0否1是
     *
     * @param pushFlag 是否发过推送0否1是
     */
    public void setPushFlag(Integer pushFlag) {
        this.pushFlag = pushFlag;
    }

    /**
     * 获取maintain_product_spu 主键ID
     *
     * @return product_id - maintain_product_spu 主键ID
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置maintain_product_spu 主键ID
     *
     * @param productId maintain_product_spu 主键ID
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}