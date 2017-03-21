/**
 *
 */
package com.cheyipai.platformservice.thirdparty.commons.constants;

/**
 * @author Fermi(fermi@youleyu.com)
 * @date Aug 18, 2014
 * @desc 业务状态
 */
public enum BusinessStatusEnum {

    //成功与失败的key-value , key长度为1
    SUCCESS(1, "操作成功"),
    FAIL(-1, "发生错误"),
    PAGE_NOT_FOUND(404,"页面没有找到"),


    PARAM_EMPTY(1001, "输入参数为空"),
    CAPTCHA_ERROR(1002, "验证码错误"),

    ;

    private BusinessStatusEnum(int status, String statusmsg) {
        this.status = status;
        this.statusmsg = statusmsg;
    }

    public static BusinessStatusEnum statusMsgOfEnum(int status) {
        for (BusinessStatusEnum ase : values()) {
            if (ase.getStatus() == status) {
                return ase;
            }
        }
        return null;
    }

    public static BusinessStatusEnum statusOfEnum(String statusmsg) {
        for (BusinessStatusEnum ase : values()) {
            if (ase.getStatusmsg().equals(statusmsg)) {
                return ase;
            }
        }
        return null;
    }

    private int status;
    private String statusmsg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusmsg() {
        return statusmsg;
    }

    public void setStatusmsg(String statusmsg) {
        this.statusmsg = statusmsg;
    }

}
