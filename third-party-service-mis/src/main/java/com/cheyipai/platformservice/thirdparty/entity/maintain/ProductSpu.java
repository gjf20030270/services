package com.cheyipai.platformservice.thirdparty.entity.maintain;

import javax.persistence.*;

@Table(name = "maintain_product_spu")
public class ProductSpu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 产品状态1正常0下线
     */
    @Column(name = "product_status")
    private Integer productStatus;

    /**
     * 备注
     */
    @Column(name = "finance_remark")
    private String financeRemark;

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
     * 获取产品名称
     *
     * @return product_name - 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取产品状态1正常0下线
     *
     * @return product_status - 产品状态1正常0下线
     */
    public Integer getProductStatus() {
        return productStatus;
    }

    /**
     * 设置产品状态1正常0下线
     *
     * @param productStatus 产品状态1正常0下线
     */
    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * 获取备注
     *
     * @return finance_remark - 备注
     */
    public String getFinanceRemark() {
        return financeRemark;
    }

    /**
     * 设置备注
     *
     * @param financeRemark 备注
     */
    public void setFinanceRemark(String financeRemark) {
        this.financeRemark = financeRemark;
    }
}