package com.tinysoft.cn.dao;

import com.tinysoft.cn.domain.ExportProduct;

import java.io.Serializable;

/**
 * Created by 董乐强 on 2017/11/11.
 */
public interface ExportProductDao extends  BaseDao<ExportProduct> {
     public void deleteByExportId(Serializable id);
}
