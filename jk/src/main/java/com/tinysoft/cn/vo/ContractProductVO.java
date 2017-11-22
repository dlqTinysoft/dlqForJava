package com.tinysoft.cn.vo;

import com.tinysoft.cn.domain.Contract;
import com.tinysoft.cn.domain.Factory;
import com.tinysoft.cn.domain.ProductExt;

import java.util.List;

/**
 * Created by 董乐强 on 2017/11/6.
 */
public class ContractProductVO {
    private String id;
    //通过购销合同的编号，可以找到这个货物属于哪个合同
    //private String contractId;
    private Contract contract;
    //通过生产厂家的编号，可以找到属于哪个生产厂家
    //private String factoryId;
    private Factory factory;
    //附件
    private List<ExtProductVO> extProducts;
    //生产厂家的名字
    //private String factoryName;
    //货物编号
    private String productNo;
    //货物的照片
    private String productImage;
    //货物的描述
    private String productDesc;
    //数量
    private Integer cnumber;
    //实际出货量
    private Integer outNumber;
    //装率
    private String loadingRate;
    //箱数
    private Integer boxNum;
    //包装单位
    private String packingUnit;
    //单价
    private Double price;
    //总金额
    private Double amount;
    //是否出货完毕
    private Integer finished;
    //附件
    private String exts;
    //排序号
    private Integer orderNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public List<ExtProductVO> getExtProducts() {
        return extProducts;
    }

    public void setExtProducts(List<ExtProductVO> extProducts) {
        this.extProducts = extProducts;
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

    public Integer getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(Integer outNumber) {
        this.outNumber = outNumber;
    }

    public String getLoadingRate() {
        return loadingRate;
    }

    public void setLoadingRate(String loadingRate) {
        this.loadingRate = loadingRate;
    }

    public Integer getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
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

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    public String getExts() {
        return exts;
    }

    public void setExts(String exts) {
        this.exts = exts;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "ContractProductVO{" +
                "id='" + id + '\'' +
                ", contract=" + contract +
                ", factory=" + factory +
                ", extProducts=" + extProducts +
                ", productNo='" + productNo + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", cnumber=" + cnumber +
                ", outNumber=" + outNumber +
                ", loadingRate='" + loadingRate + '\'' +
                ", boxNum=" + boxNum +
                ", packingUnit='" + packingUnit + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", finished=" + finished +
                ", exts='" + exts + '\'' +
                ", orderNo=" + orderNo +
                '}';
    }
}
