package com.cheyipai.platformservice.thirdparty.entity.maintain;

import javax.persistence.*;

@Table(name = "maintain_supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 供应商名称
     */
    @Column(name = "supplier_name")
    private String supplierName;

    /**
     * 地址
     */
    private String address;

    /**
     * 公司电话
     */
    @Column(name = "company_phone")
    private String companyPhone;

    /**
     * 联系人姓名
     */
    private String contacts;

    /**
     * 联系人电话
     */
    @Column(name = "contacts_phone")
    private String contactsPhone;

    /**
     * 汇款账户
     */
    private String account;

    /**
     * 供应商状态：1正常0下线
     */
    @Column(name = "supplier_status")
    private Integer supplierStatus;

    /**
     * 结算方式
     */
    @Column(name = "clearing_form")
    private String clearingForm;

    /**
     * 备注
     */
    private String remarks;

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
     * 获取供应商名称
     *
     * @return supplier_name - 供应商名称
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * 设置供应商名称
     *
     * @param supplierName 供应商名称
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取公司电话
     *
     * @return company_phone - 公司电话
     */
    public String getCompanyPhone() {
        return companyPhone;
    }

    /**
     * 设置公司电话
     *
     * @param companyPhone 公司电话
     */
    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    /**
     * 获取联系人姓名
     *
     * @return contacts - 联系人姓名
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * 设置联系人姓名
     *
     * @param contacts 联系人姓名
     */
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    /**
     * 获取联系人电话
     *
     * @return contacts_phone - 联系人电话
     */
    public String getContactsPhone() {
        return contactsPhone;
    }

    /**
     * 设置联系人电话
     *
     * @param contactsPhone 联系人电话
     */
    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    /**
     * 获取汇款账户
     *
     * @return account - 汇款账户
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置汇款账户
     *
     * @param account 汇款账户
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取供应商状态：1正常0下线
     *
     * @return supplier_status - 供应商状态：1正常0下线
     */
    public Integer getSupplierStatus() {
        return supplierStatus;
    }

    /**
     * 设置供应商状态：1正常0下线
     *
     * @param supplierStatus 供应商状态：1正常0下线
     */
    public void setSupplierStatus(Integer supplierStatus) {
        this.supplierStatus = supplierStatus;
    }

    /**
     * 获取结算方式
     *
     * @return clearing_form - 结算方式
     */
    public String getClearingForm() {
        return clearingForm;
    }

    /**
     * 设置结算方式
     *
     * @param clearingForm 结算方式
     */
    public void setClearingForm(String clearingForm) {
        this.clearingForm = clearingForm;
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}