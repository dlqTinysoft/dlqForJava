package com.tinysoft.cn.service;

import com.tinysoft.cn.domain.Factory;
import com.tinysoft.cn.domain.ProductExt;
import com.tinysoft.cn.domain.SysCode;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 董乐强 on 2017/11/5.
 */
public interface ExtPrdouctService extends BaseService<ProductExt> {

    public List<ProductExt> find(Map map);

    public void insert(ProductExt productExt);

    public List<SysCode> findExtType(Map map);
}
