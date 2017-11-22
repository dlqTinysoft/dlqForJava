package com.tinysoft.cn.dao;

import com.tinysoft.cn.domain.Export;

import java.util.Map;

/**
 * Created by 董乐强 on 2017/11/10.
 */
public interface ExportDao extends  BaseDao<Export>{
    //更新报运单的状态
    public void updateState(Map map);

}
