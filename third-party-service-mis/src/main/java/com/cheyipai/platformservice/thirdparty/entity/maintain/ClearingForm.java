package com.cheyipai.platformservice.thirdparty.entity.maintain;

import javax.persistence.*;

@Table(name = "maintain_clearing_form")
public class ClearingForm {
    /**
     * 结算单ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 结算单状态0待支付 1支付完成 2作废
     */
    private Integer status;

    /**
     * 供应商ID
     */
    @Column(name = "supplier_id")
    private Integer supplierId;

    /**
     * 结算商品ID
     */
    @Column(name = "commodity_id")
    private Integer commodityId;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private String createDate;

    /**
     * 结算范围(结束开始)
     */
    @Column(name = "clearing_start")
    private String clearingStart;

    /**
     * 结算范围(结束时间)
     */
    @Column(name = "clearing_end")
    private String clearingEnd;

    /**
     * 结算周期（月结）
     */
    @Column(name = "clearing_period")
    private String clearingPeriod;

    /**
     * 结算金额
     */
    @Column(name = "clearing_price")
    private Integer clearingPrice;

    /**
     * 支付银行代码
     */
    @Column(name = "pay_bank")
    private String payBank;

    /**
     * 付款银行账号ID（用户）
     */
    @Column(name = "ubank_id")
    private String ubankId;

    /**
     * 我方签约公司
     */
    @Column(name = "our_company")
    private String ourCompany;

    /**
     * 收款银行（公司的）
     */
    @Column(name = "receive_bank")
    private String receiveBank;

    /**
     * 收款银行账号ID（公司的）
     */
    @Column(name = "bank_id")
    private String bankId;

    /**
     * 收款类型 1:订单应收(车款) 2:商信通代收 10:保证金 20:订金 30：退反车款 40：扣款 50：充值
     */
    @Column(name = "receive_type")
    private String receiveType;

    /**
     * 发票状态0未开1已开
     */
    @Column(name = "invoice_staus")
    private Integer invoiceStaus;

    /**
     * 发票抬头
     */
    @Column(name = "invoice_title")
    private String invoiceTitle;

    /**
     * 发票类型
     */
    @Column(name = "invoice_type")
    private String invoiceType;

    /**
     * 获取结算单ID
     *
     * @return id - 结算单ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置结算单ID
     *
     * @param id 结算单ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取结算单状态0待支付 1支付完成 2作废
     *
     * @return status - 结算单状态0待支付 1支付完成 2作废
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置结算单状态0待支付 1支付完成 2作废
     *
     * @param status 结算单状态0待支付 1支付完成 2作废
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * 获取结算商品ID
     *
     * @return commodity_id - 结算商品ID
     */
    public Integer getCommodityId() {
        return commodityId;
    }

    /**
     * 设置结算商品ID
     *
     * @param commodityId 结算商品ID
     */
    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取结算范围(结束开始)
     *
     * @return clearing_start - 结算范围(结束开始)
     */
    public String getClearingStart() {
        return clearingStart;
    }

    /**
     * 设置结算范围(结束开始)
     *
     * @param clearingStart 结算范围(结束开始)
     */
    public void setClearingStart(String clearingStart) {
        this.clearingStart = clearingStart;
    }

    /**
     * 获取结算范围(结束时间)
     *
     * @return clearing_end - 结算范围(结束时间)
     */
    public String getClearingEnd() {
        return clearingEnd;
    }

    /**
     * 设置结算范围(结束时间)
     *
     * @param clearingEnd 结算范围(结束时间)
     */
    public void setClearingEnd(String clearingEnd) {
        this.clearingEnd = clearingEnd;
    }

    /**
     * 获取结算周期（月结）
     *
     * @return clearing_period - 结算周期（月结）
     */
    public String getClearingPeriod() {
        return clearingPeriod;
    }

    /**
     * 设置结算周期（月结）
     *
     * @param clearingPeriod 结算周期（月结）
     */
    public void setClearingPeriod(String clearingPeriod) {
        this.clearingPeriod = clearingPeriod;
    }

    /**
     * 获取结算金额
     *
     * @return clearing_price - 结算金额
     */
    public Integer getClearingPrice() {
        return clearingPrice;
    }

    /**
     * 设置结算金额
     *
     * @param clearingPrice 结算金额
     */
    public void setClearingPrice(Integer clearingPrice) {
        this.clearingPrice = clearingPrice;
    }

    /**
     * 获取支付银行代码
     *
     * @return pay_bank - 支付银行代码
     */
    public String getPayBank() {
        return payBank;
    }

    /**
     * 设置支付银行代码
     *
     * @param payBank 支付银行代码
     */
    public void setPayBank(String payBank) {
        this.payBank = payBank;
    }

    /**
     * 获取付款银行账号ID（用户）
     *
     * @return ubank_id - 付款银行账号ID（用户）
     */
    public String getUbankId() {
        return ubankId;
    }

    /**
     * 设置付款银行账号ID（用户）
     *
     * @param ubankId 付款银行账号ID（用户）
     */
    public void setUbankId(String ubankId) {
        this.ubankId = ubankId;
    }

    /**
     * 获取我方签约公司
     *
     * @return our_company - 我方签约公司
     */
    public String getOurCompany() {
        return ourCompany;
    }

    /**
     * 设置我方签约公司
     *
     * @param ourCompany 我方签约公司
     */
    public void setOurCompany(String ourCompany) {
        this.ourCompany = ourCompany;
    }

    /**
     * 获取收款银行（公司的）
     *
     * @return receive_bank - 收款银行（公司的）
     */
    public String getReceiveBank() {
        return receiveBank;
    }

    /**
     * 设置收款银行（公司的）
     *
     * @param receiveBank 收款银行（公司的）
     */
    public void setReceiveBank(String receiveBank) {
        this.receiveBank = receiveBank;
    }

    /**
     * 获取收款银行账号ID（公司的）
     *
     * @return bank_id - 收款银行账号ID（公司的）
     */
    public String getBankId() {
        return bankId;
    }

    /**
     * 设置收款银行账号ID（公司的）
     *
     * @param bankId 收款银行账号ID（公司的）
     */
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    /**
     * 获取收款类型 1:订单应收(车款) 2:商信通代收 10:保证金 20:订金 30：退反车款 40：扣款 50：充值
     *
     * @return receive_type - 收款类型 1:订单应收(车款) 2:商信通代收 10:保证金 20:订金 30：退反车款 40：扣款 50：充值
     */
    public String getReceiveType() {
        return receiveType;
    }

    /**
     * 设置收款类型 1:订单应收(车款) 2:商信通代收 10:保证金 20:订金 30：退反车款 40：扣款 50：充值
     *
     * @param receiveType 收款类型 1:订单应收(车款) 2:商信通代收 10:保证金 20:订金 30：退反车款 40：扣款 50：充值
     */
    public void setReceiveType(String receiveType) {
        this.receiveType = receiveType;
    }

    /**
     * 获取发票状态0未开1已开
     *
     * @return invoice_staus - 发票状态0未开1已开
     */
    public Integer getInvoiceStaus() {
        return invoiceStaus;
    }

    /**
     * 设置发票状态0未开1已开
     *
     * @param invoiceStaus 发票状态0未开1已开
     */
    public void setInvoiceStaus(Integer invoiceStaus) {
        this.invoiceStaus = invoiceStaus;
    }

    /**
     * 获取发票抬头
     *
     * @return invoice_title - 发票抬头
     */
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    /**
     * 设置发票抬头
     *
     * @param invoiceTitle 发票抬头
     */
    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    /**
     * 获取发票类型
     *
     * @return invoice_type - 发票类型
     */
    public String getInvoiceType() {
        return invoiceType;
    }

    /**
     * 设置发票类型
     *
     * @param invoiceType 发票类型
     */
    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }
}