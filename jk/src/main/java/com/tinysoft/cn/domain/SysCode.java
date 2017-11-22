package com.tinysoft.cn.domain;

/**
 * Created by 董乐强 on 2017/11/5.
 * 系统实体，主要是用来控制权限的，相当于一个数字字典的作用
 */
public class SysCode {
    private String id;
    private Integer orderNo;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SysCode{" +
                "id='" + id + '\'' +
                ", orderNo=" + orderNo +
                ", name='" + name + '\'' +
                '}';
    }
}
