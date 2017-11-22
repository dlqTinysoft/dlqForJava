package com.tinysoft.cn.dao;

import com.tinysoft.cn.domain.PackingList;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by 董乐强 on 2017/11/20.
 */
@Repository
public class PackingListDaoImpl extends BaseDaoImpl<PackingList> implements PackingListDao {
    public PackingListDaoImpl(){
        super.setNs("com.tinysoft.cn.domain.PackingList");
    }

    public void updateState(Map map) {
        this.getSqlSession().update(super.getNs()+".updateState",map);
    }
}
