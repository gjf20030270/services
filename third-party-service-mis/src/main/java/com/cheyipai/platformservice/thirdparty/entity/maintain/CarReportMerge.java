package com.cheyipai.platformservice.thirdparty.entity.maintain;

import javax.persistence.*;

@Table(name = "maintain_car_report_merge")
public class CarReportMerge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 车辆vin识别码
     */
    @Column(name = "car_vin")
    private String carVin;

    /**
     * 维修时间
     */
    @Column(name = "repair_date")
    private String repairDate;

    /**
     * 公里数
     */
    private String kilometre;

    /**
     * 维修类型
     */
    @Column(name = "repair_type")
    private String repairType;

    /**
     * 图片地址
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 状态
     */
    private String status;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private String updateDate;

    /**
     * 维修保养内容
     */
    @Column(name = "repair_content")
    private String repairContent;

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
     * 获取车辆vin识别码
     *
     * @return car_vin - 车辆vin识别码
     */
    public String getCarVin() {
        return carVin;
    }

    /**
     * 设置车辆vin识别码
     *
     * @param carVin 车辆vin识别码
     */
    public void setCarVin(String carVin) {
        this.carVin = carVin;
    }

    /**
     * 获取维修时间
     *
     * @return repair_date - 维修时间
     */
    public String getRepairDate() {
        return repairDate;
    }

    /**
     * 设置维修时间
     *
     * @param repairDate 维修时间
     */
    public void setRepairDate(String repairDate) {
        this.repairDate = repairDate;
    }

    /**
     * 获取公里数
     *
     * @return kilometre - 公里数
     */
    public String getKilometre() {
        return kilometre;
    }

    /**
     * 设置公里数
     *
     * @param kilometre 公里数
     */
    public void setKilometre(String kilometre) {
        this.kilometre = kilometre;
    }

    /**
     * 获取维修类型
     *
     * @return repair_type - 维修类型
     */
    public String getRepairType() {
        return repairType;
    }

    /**
     * 设置维修类型
     *
     * @param repairType 维修类型
     */
    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    /**
     * 获取图片地址
     *
     * @return img_url - 图片地址
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置图片地址
     *
     * @param imgUrl 图片地址
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取维修保养内容
     *
     * @return repair_content - 维修保养内容
     */
    public String getRepairContent() {
        return repairContent;
    }

    /**
     * 设置维修保养内容
     *
     * @param repairContent 维修保养内容
     */
    public void setRepairContent(String repairContent) {
        this.repairContent = repairContent;
    }
}