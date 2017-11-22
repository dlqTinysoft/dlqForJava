package com.tinysoft.cn.dao;

import com.tinysoft.cn.domain.ExportProduct;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by 董乐强 on 2017/11/11.
 */
@Repository
public class ExportProductDaoImpl extends BaseDaoImpl<ExportProduct> implements ExportProductDao {

    public ExportProductDaoImpl(){
        super.setNs("com.tinysoft.cn.domain.ExportProduct");
    }

    //级联删除
    public void deleteByExportId(Serializable id) {
         this.getSqlSession().delete(this.getNs()+".deleteByExportId",id);
    }
}
