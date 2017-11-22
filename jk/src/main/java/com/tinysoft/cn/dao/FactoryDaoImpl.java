package com.tinysoft.cn.dao;


import com.tinysoft.cn.domain.Factory;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by 董乐强 on 2017/11/1.
 */
@Repository
public class FactoryDaoImpl extends BaseDaoImpl<Factory> implements FactoryDao {
    //设置命名空间
    public FactoryDaoImpl() {
        super.setNs("com.tinysoft.cn.domain.Factory");
    }

    //更新生产厂家的状态
    public void updateState(Map map) {
        this.getSqlSession().update(super.getNs() + ".updateState", map);
    }

    public List<Factory> getFactoryList(Map map) {
        List<Factory> factorys = this.getSqlSession().selectList(super.getNs()+".find",map);
        return factorys;
    }
}
