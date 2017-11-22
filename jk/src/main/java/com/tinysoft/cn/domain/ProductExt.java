package com.tinysoft.cn.domain;

/**
 * Created by 董乐强 on 2017/11/5.
 * 附件实体
 */
public class ProductExt {

    private String id;
    //该附件对应的货物Id
    private String contractProductId;
    //该附件对应的生产厂家的id
    private String factoryId;
    //生产厂家的名字
    private String factoryName;
    //该附件的类型，所对应的是系统基础表的ctype，关于数据字典的应用
    private String ctype;
    //货物编号
    private String productNo;
    //货物照片
    private String productImage;
    //货物的描述
    private String productDesc;
    //货物的数量
    private Integer cnumber;
    //货物的包装单位
    private String packingUnit;
    //货物的价格
    private Double price;
    //货物的数量
    private Double amount;
    //货物的要求
    private String productRequest;
    //排序号
    private Integer orderNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContractProductId() {
        return contractProductId;
    }

    public void setContractProductId(String contractProductId) {
        this.contractProductId = contractProductId;
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
        return "ProductExt{" +
                "id='" + id + '\'' +
                ", contractProductId='" + contractProductId + '\'' +
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
