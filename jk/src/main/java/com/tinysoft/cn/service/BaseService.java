package com.tinysoft.cn.service;

import com.tinysoft.cn.domain.Factory;
import com.tinysoft.cn.pagination.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 董乐强 on 2017/11/3.
 */
public interface BaseService<T> {
    public List<T> findPage(Page page);        //分页查询

    public T get(Serializable id);            //只查询一个，常用于修改

    public void update(T t);            //修改，用实体作为参数

    public void deleteById(Serializable id);        //按id删除，删除一条；支持整数型和字符串类型ID

    public void delete(Serializable[] ids);            //批量删除；支持整数型和字符串类型ID

    public List<T> getFactoryList();            //获取生产厂家列表
}
