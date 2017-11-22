package com.tinysoft.cn.dao;

import com.tinysoft.cn.domain.PackingList;

import java.util.Map;

/**
 * Created by 董乐强 on 2017/11/20.
 */
public interface PackingListDao extends BaseDao<PackingList> {
    //用于实现装箱状态
    public void updateState(Map map);
}
