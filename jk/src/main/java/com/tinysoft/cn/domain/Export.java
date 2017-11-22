package com.tinysoft.cn.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 董乐强 on 2017/11/10.
 */
public class Export implements Serializable {
    private String id;
    //制单日期
    private Date inputDate;

    private String epnum;
    private String extnum;

    //合同的id集合
    private String contractIds;

    //合同或确认书号
    private String customerContract;
    //信用证号
    private String lcno;
    //收货人及地址
    private String consignee;
    //唛头
    private String marks;
    private String remark;

    //装运港
    private String shipmentPort;
    //目的港
    private String destinationPort;
    //运输方式
    private String transportMode;
    //价格条件
    private String priceCondition;
    //0草稿1已上报2装箱3委托4发票5财务
    private  Integer state;
    //毛重
    private Double grossWeight;
    private Double netWeight;//净重
    private Double measurement;//体积
    private String createBy;
    private String createDept;
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getEpnum() {
        return epnum;
    }

    public void setEpnum(String epnum) {
        this.epnum = epnum;
    }

    public String getExtnum() {
        return extnum;
    }

    public void setExtnum(String extnum) {
        this.extnum = extnum;
    }

    public String getContractIds() {
        return contractIds;
    }

    public void setContractIds(String contractIds) {
        this.contractIds = contractIds;
    }

    public String getCustomerContract() {
        return customerContract;
    }

    public void setCustomerContract(String customerContract) {
        this.customerContract = customerContract;
    }

    public String getLcno() {
        return lcno;
    }

    public void setLcno(String lcno) {
        this.lcno = lcno;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getShipmentPort() {
        return shipmentPort;
    }

    public void setShipmentPort(String shipmentPort) {
        this.shipmentPort = shipmentPort;
    }

    public String getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(String destinationPort) {
        this.destinationPort = destinationPort;
    }

    public String getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode;
    }

    public String getPriceCondition() {
        return priceCondition;
    }

    public void setPriceCondition(String priceCondition) {
        this.priceCondition = priceCondition;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public Double getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Double measurement) {
        this.measurement = measurement;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDept() {
        return createDept;
    }

    public void setCreateDept(String createDept) {
        this.createDept = createDept;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Export{" +
                "id='" + id + '\'' +
                ", inputDate=" + inputDate +
                ", epnum='" + epnum + '\'' +
                ", extnum='" + extnum + '\'' +
                ", contractIds='" + contractIds + '\'' +
                ", customerContract='" + customerContract + '\'' +
                ", lcno='" + lcno + '\'' +
                ", consignee='" + consignee + '\'' +
                ", marks='" + marks + '\'' +
                ", remark='" + remark + '\'' +
                ", shipmentPort='" + shipmentPort + '\'' +
                ", destinationPort='" + destinationPort + '\'' +
                ", transportMode='" + transportMode + '\'' +
                ", priceCondition='" + priceCondition + '\'' +
                ", state=" + state +
                ", grossWeight=" + grossWeight +
                ", netWeight=" + netWeight +
                ", measurement=" + measurement +
                ", createBy='" + createBy + '\'' +
                ", createDept='" + createDept + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
