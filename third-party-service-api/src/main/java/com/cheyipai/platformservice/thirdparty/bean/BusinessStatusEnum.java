/**
 *
 */
package com.cheyipai.platformservice.thirdparty.bean;

/**
 * @author Fermi(fermi@youleyu.com)
 * @date Aug 18, 2014
 * @desc 业务状态
 */
public enum BusinessStatusEnum {

    //成功与失败的key-value , key长度为1
    SUCCESS("1", "操作成功"),
    FAIL("0", "发生错误"),
    SERVICE_NOT_EXISTS("2", "服务不存在"),


    PARAM_EMPTY("10001", "输入参数为空"),
    CAPTCHA_ERROR("10002", "验证码错误"),
    SECURE_ERROR("10003", "安全校验错误");

    private BusinessStatusEnum(String resultCode, String stateDescription) {
        this.resultCode = resultCode;
        this.StateDescription = stateDescription;
    }

    private String resultCode;
    private String StateDescription;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getStateDescription() {
        return StateDescription;
    }

    public void setStateDescription(String stateDescription) {
        StateDescription = stateDescription;
    }
}
