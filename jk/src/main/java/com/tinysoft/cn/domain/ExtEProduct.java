package com.tinysoft.cn.domain;

/**
 * Created by 董乐强 on 2017/11/11.
 */
public class ExtEProduct {
    private String id;

    private String exportProductId;
    private String factoryId;

    private String factoryName;
    private String ctype;

    private String productNo;
    private String productImage;
    private String productDesc;
    private Integer cnumber;
    private String packingUnit;			//包装单位
    private Double price;
    private Double amount;
    private String productRequest;
    private Integer orderNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExportProductId() {
        return exportProductId;
    }

    public void setExportProductId(String exportProductId) {
        this.exportProductId = exportProductId;
    }

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getCnumber() {
        return cnumber;
    }

    public void setCnumber(Integer cnumber) {
        this.cnumber = cnumber;
    }

    public String getPackingUnit() {
        return packingUnit;
    }

    public void setPackingUnit(String packingUnit) {
        this.packingUnit = packingUnit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getProductRequest() {
        return productRequest;
    }

    public void setProductRequest(String productRequest) {
        this.productRequest = productRequest;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "ExtEProduct{" +
                "id='" + id + '\'' +
                ", exportProductId='" + exportProductId + '\'' +
                ", factoryId='" + factoryId + '\'' +
                ", factoryName='" + factoryName + '\'' +
                ", ctype='" + ctype + '\'' +
                ", productNo='" + productNo + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", cnumber=" + cnumber +
                ", packingUnit='" + packingUnit + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", productRequest='" + productRequest + '\'' +
                ", orderNo=" + orderNo +
                '}';
    }
}
