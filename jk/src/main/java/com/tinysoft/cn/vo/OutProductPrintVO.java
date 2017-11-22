package com.tinysoft.cn.vo;

/**
 * Created by 董乐强 on 2017/11/7.
 * 这个主要是用来打印出货表的
 */
public class OutProductPrintVO {
    private String customName;
    private String contractNo;
    private String deliveryPeriod;
    private String shipTime;
    private String tradeTerms;
    private String productNo;
    private String cnumber;
    private String factoryName;

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public void setDeliveryPeriod(String deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
    }

    public String getShipTime() {
        return shipTime;
    }

    public void setShipTime(String shipTime) {
        this.shipTime = shipTime;
    }

    public String getTradeTerms() {
        return tradeTerms;
    }

    public void setTradeTerms(String tradeTerms) {
        this.tradeTerms = tradeTerms;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    @Override
    public String toString() {
        return "OutProductPrintVO{" +
                "customName='" + customName + '\'' +
                ", contractNo='" + contractNo + '\'' +
                ", deliveryPeriod='" + deliveryPeriod + '\'' +
                ", shipTime='" + shipTime + '\'' +
                ", tradeTerms='" + tradeTerms + '\'' +
                ", productNo='" + productNo + '\'' +
                ", cnumber='" + cnumber + '\'' +
                ", factoryName='" + factoryName + '\'' +
                '}';
    }
}
