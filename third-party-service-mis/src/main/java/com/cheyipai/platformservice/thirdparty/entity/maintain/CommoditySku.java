package com.cheyipai.platformservice.thirdparty.entity.maintain;

import javax.persistence.*;

@Table(name = "maintain_commodity_sku")
public class CommoditySku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品ID
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 商品名称
     */
    @Column(name = "commodity_name")
    private String commodityName;

    /**
     * 供应商ID
     */
    @Column(name = "supplier_id")
    private Integer supplierId;

    /**
     * 成本价格（元）
     */
    @Column(name = "cost_price")
    private Integer costPrice;

    /**
     * 查询价格（元）
     */
    @Column(name = "query_price")
    private Integer queryPrice;

    /**
     * 商品品状态1正常0下线
     */
    @Column(name = "commodity_status")
    private Integer commodityStatus;

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
     * 获取产品ID
     *
     * @return product_id - 产品ID
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置产品ID
     *
     * @param productId 产品ID
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取商品名称
     *
     * @return commodity_name - 商品名称
     */
    public String getCommodityName() {
        return commodityName;
    }

    /**
     * 设置商品名称
     *
     * @param commodityName 商品名称
     */
    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
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
     * 获取成本价格（元）
     *
     * @return cost_price - 成本价格（元）
     */
    public Integer getCostPrice() {
        return costPrice;
    }

    /**
     * 设置成本价格（元）
     *
     * @param costPrice 成本价格（元）
     */
    public void setCostPrice(Integer costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * 获取查询价格（元）
     *
     * @return query_price - 查询价格（元）
     */
    public Integer getQueryPrice() {
        return queryPrice;
    }

    /**
     * 设置查询价格（元）
     *
     * @param queryPrice 查询价格（元）
     */
    public void setQueryPrice(Integer queryPrice) {
        this.queryPrice = queryPrice;
    }

    /**
     * 获取商品品状态1正常0下线
     *
     * @return commodity_status - 商品品状态1正常0下线
     */
    public Integer getCommodityStatus() {
        return commodityStatus;
    }

    /**
     * 设置商品品状态1正常0下线
     *
     * @param commodityStatus 商品品状态1正常0下线
     */
    public void setCommodityStatus(Integer commodityStatus) {
        this.commodityStatus = commodityStatus;
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