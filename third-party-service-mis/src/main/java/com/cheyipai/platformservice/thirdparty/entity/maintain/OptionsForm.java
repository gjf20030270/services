package com.cheyipai.platformservice.thirdparty.entity.maintain;

import javax.persistence.*;

@Table(name = "maintain_options_form")
public class OptionsForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 模块名称
     */
    private String model;

    /**
     * 动作名称
     */
    private String action;

    /**
     * 操作人id
     */
    @Column(name = "option_user_id")
    private Integer optionUserId;

    /**
     * 操作人
     */
    @Column(name = "option_user_name")
    private String optionUserName;

    /**
     * 操作时间
     */
    @Column(name = "option_time")
    private Long optionTime;

    /**
     * 业务单号
     */
    @Column(name = "business_id")
    private Integer businessId;

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
     * 获取模块名称
     *
     * @return model - 模块名称
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置模块名称
     *
     * @param model 模块名称
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 获取动作名称
     *
     * @return action - 动作名称
     */
    public String getAction() {
        return action;
    }

    /**
     * 设置动作名称
     *
     * @param action 动作名称
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * 获取操作人id
     *
     * @return option_user_id - 操作人id
     */
    public Integer getOptionUserId() {
        return optionUserId;
    }

    /**
     * 设置操作人id
     *
     * @param optionUserId 操作人id
     */
    public void setOptionUserId(Integer optionUserId) {
        this.optionUserId = optionUserId;
    }

    /**
     * 获取操作人
     *
     * @return option_user_name - 操作人
     */
    public String getOptionUserName() {
        return optionUserName;
    }

    /**
     * 设置操作人
     *
     * @param optionUserName 操作人
     */
    public void setOptionUserName(String optionUserName) {
        this.optionUserName = optionUserName;
    }

    /**
     * 获取操作时间
     *
     * @return option_time - 操作时间
     */
    public Long getOptionTime() {
        return optionTime;
    }

    /**
     * 设置操作时间
     *
     * @param optionTime 操作时间
     */
    public void setOptionTime(Long optionTime) {
        this.optionTime = optionTime;
    }

    /**
     * 获取业务单号
     *
     * @return business_id - 业务单号
     */
    public Integer getBusinessId() {
        return businessId;
    }

    /**
     * 设置业务单号
     *
     * @param businessId 业务单号
     */
    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }
}