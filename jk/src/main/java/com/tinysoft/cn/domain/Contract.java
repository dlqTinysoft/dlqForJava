package com.tinysoft.cn.domain;

import java.util.Date;

/**
 * Created by 董乐强 on 2017/11/3.
 CONTRACT_ID
 收购方	OFFEROR
 合同号	CONTRACT_NO
 签单日期	SIGNING_DATE
 制单人	INPUT_BY
 审单人	CHECK_BY
 验货员	INSPECTOR
 总金额	TOTAL_AMOUNT
 重要程度	IMPORT_NUM
 要求	CREQUEST
 客户名称	CUSTOM_NAME
 交货期限	DELIVERY_PERIOD
 船期	SHIP_TIME
 贸易条款	TRADE_TERMS
 说明	REMARK
 打印版式	PRINT_STYLE
 归档前状态	OLD_STATE
 状态	STATE
 走货状态	OUT_STATE
 创建人	CREATE_BY
 创建部门	CREATE_DEPT
 创建日期	CREATE_TIME
 */
public class Contract {
    private String cpnum;
    private String extnum;
    private String id;
    //收购方
    private String offeror;
    //合同号
    private String contractNo;
    //签单日期
    private java.util.Date signingDate;
    //制单人
    private String inputBy;
    //审单人
    private String checkBy;
    //验货员
    private String inspector;
    //总金额
    private Double totalAmount;
    //重要程度
    private Integer importNum;
    //要求
    private String crequest;
    //客户名称
    private String customName;
    //交货期限
    private java.util.Date deliveryPeriod;
    //船期
    private java.util.Date shipTime;
    //贸易条款
    private String tradeTerms;
    //说明
    private String remark;
    //打印版式
    private String printStyle;
    //归档前转态
    private Integer oldState;
    //状态
    private Integer state;
    //走货状态
    private Integer outState;
    //创建人
    private String createBy;
    //创建部门
    private String createDept;
    //创建日期
    private java.util.Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getOfferor() {
        return offeror;
    }

    public void setOfferor(String offeror) {
        this.offeror = offeror;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getSigningDate() {
        return signingDate;
    }

    public void setSigningDate(Date signingDate) {
        this.signingDate = signingDate;
    }

    public String getInputBy() {
        return inputBy;
    }

    public void setInputBy(String inputBy) {
        this.inputBy = inputBy;
    }

    public String getCheckBy() {
        return checkBy;
    }

    public void setCheckBy(String checkBy) {
        this.checkBy = checkBy;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getImportNum() {
        return importNum;
    }

    public void setImportNum(Integer importNum) {
        this.importNum = importNum;
    }

    public String getCrequest() {
        return crequest;
    }

    public void setCrequest(String crequest) {
        this.crequest = crequest;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public Date getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public void setDeliveryPeriod(Date deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
    }

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    public String getTradeTerms() {
        return tradeTerms;
    }

    public void setTradeTerms(String tradeTerms) {
        this.tradeTerms = tradeTerms;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPrintStyle() {
        return printStyle;
    }

    public void setPrintStyle(String printStyle) {
        this.printStyle = printStyle;
    }

    public Integer getOldState() {
        return oldState;
    }

    public void setOldState(Integer oldState) {
        this.oldState = oldState;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getOutState() {
        return outState;
    }

    public void setOutState(Integer outState) {
        this.outState = outState;
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

    public String getCpnum() {
        return cpnum;
    }

    public void setCpnum(String cpnum) {
        this.cpnum = cpnum;
    }

    public String getExtnum() {
        return extnum;
    }

    public void setExtnum(String extnum) {
        this.extnum = extnum;
    }
}
