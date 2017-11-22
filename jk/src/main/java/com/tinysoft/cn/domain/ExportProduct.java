package com.tinysoft.cn.domain;

/**
 * Created by 董乐强 on 2017/11/11.
 */
public class ExportProduct {
    private String id;
    private String exportId;			//外键 一个报运单对应多个货物
    private String factoryId;			//外键 一个生产厂家对应多个货物
    private String factoryName;			//冗余字段，为了报运获取数据更加快捷 冗余字段 ，冗余的原因是加快查询速度
    //货物照片
    private String productImage;
    //货物号
    private String productNo;
    //货物描述
    private String productDesc;
    //货物数量
    private Integer cnumber;
    //包装单位
    private String packingUnit;
    //货物的件数
    private Integer boxNum;
    //单价
    private Double price;
    //总数
    private Double amount;
    //毛重
    private Double grossWeight;
    //净重
    private Double netWeight;
    //尺寸长
    private Double sizeLength;
    //尺寸宽
    private Double sizeWidth;
    //尺寸高
    private Double sizeHeight;
    //
    private Double csize;
    //出口单价
    private Double exPrice;
    //税
    private Double tax;
    private Integer orderNo;

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExportId() {
        return exportId;
    }

    public void setExportId(String exportId) {
        this.exportId = exportId;
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

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
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

    public Integer getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
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

    public Double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
    }

    public Double getSizeLength() {
        return sizeLength;
    }

    public void setSizeLength(Double sizeLength) {
        this.sizeLength = sizeLength;
    }

    public Double getSizeWidth() {
        return sizeWidth;
    }

    public void setSizeWidth(Double sizeWidth) {
        this.sizeWidth = sizeWidth;
    }

    public Double getSizeHeight() {
        return sizeHeight;
    }

    public void setSizeHeight(Double sizeHeight) {
        this.sizeHeight = sizeHeight;
    }

    public Double getCsize() {
        return csize;
    }

    public void setCsize(Double csize) {
        this.csize = csize;
    }

    public Double getExPrice() {
        return exPrice;
    }

    public void setExPrice(Double exPrice) {
        this.exPrice = exPrice;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "ExportProduct{" +
                "id='" + id + '\'' +
                ", exportId='" + exportId + '\'' +
                ", factoryId='" + factoryId + '\'' +
                ", factoryName='" + factoryName + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productNo='" + productNo + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", cnumber=" + cnumber +
                ", packingUnit='" + packingUnit + '\'' +
                ", boxNum=" + boxNum +
                ", price=" + price +
                ", amount=" + amount +
                ", grossWeight=" + grossWeight +
                ", netWeight=" + netWeight +
                ", sizeLength=" + sizeLength +
                ", sizeWidth=" + sizeWidth +
                ", sizeHeight=" + sizeHeight +
                ", csize=" + csize +
                ", exPrice=" + exPrice +
                ", tax=" + tax +
                '}';
    }
}
