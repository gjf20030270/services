package com.cheyipai.platformservice.thirdparty.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by gongjunfeng on 2017/3/17.
 */
public class JuheCityResult {
    private String resultcode;
    private String reason;
    private List<JuheProvince> result;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<JuheProvince> getResult() {
        return result;
    }

    public void setResult(List<JuheProvince> result) {
        this.result = result;
    }

    public static class JuheProvince{
        private String province;
        @JSONField(name="province_code")
        private String provinceCode;
        private List<JuheCity> citys;

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getProvinceCode() {
            return provinceCode;
        }

        public void setProvinceCode(String provinceCode) {
            this.provinceCode = provinceCode;
        }

        public List<JuheCity> getCitys() {
            return citys;
        }

        public void setCitys(List<JuheCity> citys) {
            this.citys = citys;
        }
    }
    public static class JuheCity{
        @JSONField(name="city_name")
        private String cityName;
        @JSONField(name="city_code")
        private String cityCode;
        private String abbr;
        private String engine;
        private String engineno;
        private String classa;
        private String classno;
        private String regist;
        private String registno;

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getAbbr() {
            return abbr;
        }

        public void setAbbr(String abbr) {
            this.abbr = abbr;
        }

        public String getEngine() {
            return engine;
        }

        public void setEngine(String engine) {
            this.engine = engine;
        }

        public String getEngineno() {
            return engineno;
        }

        public void setEngineno(String engineno) {
            this.engineno = engineno;
        }

        public String getClassa() {
            return classa;
        }

        public void setClassa(String classa) {
            this.classa = classa;
        }

        public String getClassno() {
            return classno;
        }

        public void setClassno(String classno) {
            this.classno = classno;
        }

        public String getRegist() {
            return regist;
        }

        public void setRegist(String regist) {
            this.regist = regist;
        }

        public String getRegistno() {
            return registno;
        }

        public void setRegistno(String registno) {
            this.registno = registno;
        }
    }
}

