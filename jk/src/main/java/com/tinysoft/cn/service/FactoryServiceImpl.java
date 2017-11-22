package com.tinysoft.cn.service;

import com.tinysoft.cn.dao.FactoryDao;
import com.tinysoft.cn.domain.Factory;
import com.tinysoft.cn.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 董乐强 on 2017/11/1.
 */
@Service
public class FactoryServiceImpl extends BaseServiceImpl<Factory> implements FactoryService {

    @Resource
    private FactoryDao factoryDao;
    public List<Factory> find(Map map) {
        super.set(factoryDao);
        List<Factory> factorys = factoryDao.find(null);
        return factorys;
    }

    //插入操作
    public void insert(Factory factory) {
         factory.setId(UUID.randomUUID().toString());
         factoryDao.insert(factory);
    }

    public List<Factory> getStartFactoryList() {
        Map<String ,Object> map = new HashMap<String ,Object>();
        map.put("state",1);
        return factoryDao.getFactoryList(map);
    }

    //启用功能实现
    public void start(Serializable[] ids) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("state", 1);//1表示启用，0表示停用
        map.put("ids", ids);
        factoryDao.updateState(map);
    }

    //停用功能的实现
    public void stop(Serializable[] ids) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("state", 0);//1表示启用，0表示停用
        map.put("ids", ids);
        factoryDao.updateState(map);
    }


}
