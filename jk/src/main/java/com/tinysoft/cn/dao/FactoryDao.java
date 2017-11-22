package com.tinysoft.cn.dao;

import com.tinysoft.cn.domain.Factory;

import java.util.List;
import java.util.Map;

/**
 * Created by 董乐强 on 2017/11/1.
 */
public interface FactoryDao extends BaseDao<Factory> {
    //更新生产厂家的转态
    public void updateState(Map map);
    //查询所有已经启用的生产厂家
    public List<Factory> getFactoryList(Map map);
}
