package com.cheyipai.platformservice.thirdparty.entity.maintain;

import javax.persistence.*;

@Table(name = "maintain_car_info")
public class CarInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 车辆vin识别码
     */
    @Column(name = "car_vin")
    private String carVin;

    /**
     * 发动机号码
     */
    @Column(name = "engine_no")
    private String engineNo;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 车型
     */
    @Column(name = "car_type")
    private String carType;

    /**
     * 初次登记日期
     */
    @Column(name = "first_date")
    private String firstDate;

    /**
     * 最后一次保养里程表数
     */
    @Column(name = "odometer_count")
    private Integer odometerCount;

    /**
     * 报告时间
     */
    @Column(name = "report_time")
    private String reportTime;

    /**
     * 行驶证地址
     */
    @Column(name = "driving_url")
    private String drivingUrl;

    /**
     * 备注
     */
    private String mark;

    /**
     * 车辆图片地址
     */
    @Column(name = "car_photo")
    private String carPhoto;

    /**
     * 车辆颜色
     */
    @Column(name = "car_color")
    private String carColor;

    /**
     * 操作时间
     */
    @Column(name = "operation_time")
    private Long operationTime;

    /**
     * 车辆等级例如：50
     */
    private Integer grade;

    /**
     * 车辆等级编码例如：C
     */
    @Column(name = "grade_code")
    private String gradeCode;

    /**
     * 地区
     */
    private String area;

    /**
     * 排放标准
     */
    @Column(name = "discharge_standard")
    private String dischargeStandard;

    /**
     * 手动/自动档
     */
    private String transmission;

    /**
     * 排量
     */
    private String volume;

    /**
     * 最后入店时间
     */
    @Column(name = "last_time_to_shop")
    private String lastTimeToShop;

    /**
     * 事故次数
     */
    @Column(name = "number_of_accidents")
    private Integer numberOfAccidents;

    /**
     * 报告简述
     */
    @Column(name = "report_sketch")
    private String reportSketch;

    /**
     * 汽车零部件状况
     */
    @Column(name = "car_parts_status")
    private String carPartsStatus;

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
     * 获取发动机号码
     *
     * @return engine_no - 发动机号码
     */
    public String getEngineNo() {
        return engineNo;
    }

    /**
     * 设置发动机号码
     *
     * @param engineNo 发动机号码
     */
    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    /**
     * 获取品牌
     *
     * @return brand - 品牌
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置品牌
     *
     * @param brand 品牌
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 获取车型
     *
     * @return car_type - 车型
     */
    public String getCarType() {
        return carType;
    }

    /**
     * 设置车型
     *
     * @param carType 车型
     */
    public void setCarType(String carType) {
        this.carType = carType;
    }

    /**
     * 获取初次登记日期
     *
     * @return first_date - 初次登记日期
     */
    public String getFirstDate() {
        return firstDate;
    }

    /**
     * 设置初次登记日期
     *
     * @param firstDate 初次登记日期
     */
    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    /**
     * 获取最后一次保养里程表数
     *
     * @return odometer_count - 最后一次保养里程表数
     */
    public Integer getOdometerCount() {
        return odometerCount;
    }

    /**
     * 设置最后一次保养里程表数
     *
     * @param odometerCount 最后一次保养里程表数
     */
    public void setOdometerCount(Integer odometerCount) {
        this.odometerCount = odometerCount;
    }

    /**
     * 获取报告时间
     *
     * @return report_time - 报告时间
     */
    public String getReportTime() {
        return reportTime;
    }

    /**
     * 设置报告时间
     *
     * @param reportTime 报告时间
     */
    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    /**
     * 获取行驶证地址
     *
     * @return driving_url - 行驶证地址
     */
    public String getDrivingUrl() {
        return drivingUrl;
    }

    /**
     * 设置行驶证地址
     *
     * @param drivingUrl 行驶证地址
     */
    public void setDrivingUrl(String drivingUrl) {
        this.drivingUrl = drivingUrl;
    }

    /**
     * 获取备注
     *
     * @return mark - 备注
     */
    public String getMark() {
        return mark;
    }

    /**
     * 设置备注
     *
     * @param mark 备注
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    /**
     * 获取车辆图片地址
     *
     * @return car_photo - 车辆图片地址
     */
    public String getCarPhoto() {
        return carPhoto;
    }

    /**
     * 设置车辆图片地址
     *
     * @param carPhoto 车辆图片地址
     */
    public void setCarPhoto(String carPhoto) {
        this.carPhoto = carPhoto;
    }

    /**
     * 获取车辆颜色
     *
     * @return car_color - 车辆颜色
     */
    public String getCarColor() {
        return carColor;
    }

    /**
     * 设置车辆颜色
     *
     * @param carColor 车辆颜色
     */
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    /**
     * 获取操作时间
     *
     * @return operation_time - 操作时间
     */
    public Long getOperationTime() {
        return operationTime;
    }

    /**
     * 设置操作时间
     *
     * @param operationTime 操作时间
     */
    public void setOperationTime(Long operationTime) {
        this.operationTime = operationTime;
    }

    /**
     * 获取车辆等级例如：50
     *
     * @return grade - 车辆等级例如：50
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * 设置车辆等级例如：50
     *
     * @param grade 车辆等级例如：50
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * 获取车辆等级编码例如：C
     *
     * @return grade_code - 车辆等级编码例如：C
     */
    public String getGradeCode() {
        return gradeCode;
    }

    /**
     * 设置车辆等级编码例如：C
     *
     * @param gradeCode 车辆等级编码例如：C
     */
    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    /**
     * 获取地区
     *
     * @return area - 地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置地区
     *
     * @param area 地区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取排放标准
     *
     * @return discharge_standard - 排放标准
     */
    public String getDischargeStandard() {
        return dischargeStandard;
    }

    /**
     * 设置排放标准
     *
     * @param dischargeStandard 排放标准
     */
    public void setDischargeStandard(String dischargeStandard) {
        this.dischargeStandard = dischargeStandard;
    }

    /**
     * 获取手动/自动档
     *
     * @return transmission - 手动/自动档
     */
    public String getTransmission() {
        return transmission;
    }

    /**
     * 设置手动/自动档
     *
     * @param transmission 手动/自动档
     */
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    /**
     * 获取排量
     *
     * @return volume - 排量
     */
    public String getVolume() {
        return volume;
    }

    /**
     * 设置排量
     *
     * @param volume 排量
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * 获取最后入店时间
     *
     * @return last_time_to_shop - 最后入店时间
     */
    public String getLastTimeToShop() {
        return lastTimeToShop;
    }

    /**
     * 设置最后入店时间
     *
     * @param lastTimeToShop 最后入店时间
     */
    public void setLastTimeToShop(String lastTimeToShop) {
        this.lastTimeToShop = lastTimeToShop;
    }

    /**
     * 获取事故次数
     *
     * @return number_of_accidents - 事故次数
     */
    public Integer getNumberOfAccidents() {
        return numberOfAccidents;
    }

    /**
     * 设置事故次数
     *
     * @param numberOfAccidents 事故次数
     */
    public void setNumberOfAccidents(Integer numberOfAccidents) {
        this.numberOfAccidents = numberOfAccidents;
    }

    /**
     * 获取报告简述
     *
     * @return report_sketch - 报告简述
     */
    public String getReportSketch() {
        return reportSketch;
    }

    /**
     * 设置报告简述
     *
     * @param reportSketch 报告简述
     */
    public void setReportSketch(String reportSketch) {
        this.reportSketch = reportSketch;
    }

    /**
     * 获取汽车零部件状况
     *
     * @return car_parts_status - 汽车零部件状况
     */
    public String getCarPartsStatus() {
        return carPartsStatus;
    }

    /**
     * 设置汽车零部件状况
     *
     * @param carPartsStatus 汽车零部件状况
     */
    public void setCarPartsStatus(String carPartsStatus) {
        this.carPartsStatus = carPartsStatus;
    }
}