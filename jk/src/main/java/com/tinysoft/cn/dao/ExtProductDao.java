package com.tinysoft.cn.dao;

import com.tinysoft.cn.domain.ProductExt;
import com.tinysoft.cn.domain.SysCode;
import sun.plugin2.message.Serializer;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 董乐强 on 2017/11/5.
 */
public interface ExtProductDao extends BaseDao<ProductExt> {
    public List<SysCode> findExtType(Map map);
    //根据货物的id删除这个货物下的所有附件
    public void deleteExtByContractProductId(Serializable[] ids);
}
