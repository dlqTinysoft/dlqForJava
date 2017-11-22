package com.tinysoft.cn.dao;

import com.tinysoft.cn.domain.ExtEProduct;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by 董乐强 on 2017/11/11.
 */
public interface ExtEProductDao extends BaseDao<ExtEProduct> {
    public void deleteByExportId(Serializable id);
}
