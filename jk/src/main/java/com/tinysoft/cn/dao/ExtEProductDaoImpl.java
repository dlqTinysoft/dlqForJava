package com.tinysoft.cn.dao;

import com.tinysoft.cn.domain.ExtEProduct;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by 董乐强 on 2017/11/11.
 */
@Repository
public class ExtEProductDaoImpl extends  BaseDaoImpl<ExtEProduct> implements  ExtEProductDao{
    public ExtEProductDaoImpl(){
        super.setNs("com.tinysoft.cn.domain.ExtEProduct");
    }
    //进行级联删除
    public void deleteByExportId(Serializable id) {
        this.getSqlSession().delete(".deleteByExportId",id);
    }
}
