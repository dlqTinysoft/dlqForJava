package com.tinysoft.cn.dao;

import com.tinysoft.cn.domain.ProductExt;
import com.tinysoft.cn.domain.SysCode;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 董乐强 on 2017/11/5.
 */
@Repository
public class ExtProductDaoImpl extends BaseDaoImpl<ProductExt> implements  ExtProductDao{
    public ExtProductDaoImpl(){
        super.setNs("com.tinysoft.cn.domain.ProductExt");
    }

    public List<SysCode> findExtType(Map map) {
        List<SysCode> sysCodes = this.getSqlSession().selectList("com.tinysoft.cn.domain.SysCode.findExtType",map);
        return sysCodes;
    }

    public void deleteExtByContractProductId(Serializable[] ids) {
        this.getSqlSession().delete(super.getNs()+".deleteExtByContractProductId",ids);
    }
}
