package com.tinysoft.cn.dao;

import com.tinysoft.cn.domain.Export;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by 董乐强 on 2017/11/10.
 */
@Repository
public class ExportDaoImpl extends BaseDaoImpl<Export> implements  ExportDao {


    public ExportDaoImpl(){
        super.setNs("com.tinysoft.cn.domain.Export");
    }


    public void updateState(Map map) {
        this.getSqlSession().update(super.getNs()+".updateState",map);
    }
}
