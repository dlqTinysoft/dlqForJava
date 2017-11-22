package com.tinysoft.cn.service;

import com.tinysoft.cn.dao.ExtProductDao;
import com.tinysoft.cn.domain.ProductExt;
import com.tinysoft.cn.domain.SysCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 董乐强 on 2017/11/5.
 */
@Service
public class ExtProductServiceImpl extends BaseServiceImpl<ProductExt> implements ExtPrdouctService {

    @Resource
    private ExtProductDao extProductDao;

    public List<ProductExt> find(Map map) {
        super.set(extProductDao);
        List<ProductExt> productExts = extProductDao.find(map);
        return productExts;
    }

    //插入操作
    public void insert(ProductExt productExt) {
        productExt.setId(UUID.randomUUID().toString());
        extProductDao.insert(productExt);
    }

    public List<SysCode> findExtType(Map map) {
        return extProductDao.findExtType(map);
    }
}
