package com.tinysoft.cn.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.tinysoft.cn.domain.Factory;
import com.tinysoft.cn.pagination.Page;
import org.apache.poi.ss.formula.functions.T;


/**
 * @Description:
 * @Author: nutony
 * @Company: http://java.itcast.cn
 * @CreateDate: 2014年10月9日
 */
public interface FactoryService extends BaseService<Factory>{

    public void start(Serializable[] ids);            //启用
    public List<Factory> find(Map map);
    public void stop(Serializable[] ids);            //停用
    public void insert(Factory factory);            //插入，用实体作为参数
    public List<Factory> getStartFactoryList();
}
