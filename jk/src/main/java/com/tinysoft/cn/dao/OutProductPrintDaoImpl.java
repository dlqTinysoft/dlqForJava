package com.tinysoft.cn.dao;

import com.tinysoft.cn.vo.OutProductPrintVO;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 董乐强 on 2017/11/7.
 */
@Repository
public class OutProductPrintDaoImpl extends BaseDaoImpl<OutProductPrintVO> implements OutProductPrintDao{
    public OutProductPrintDaoImpl(){
        super.setNs("com.tinysoft.cn.vo.OutProductPrintVO");
    }
    public List<OutProductPrintVO> find(Serializable inputDate) {
        List<OutProductPrintVO> dataList = this.getSqlSession().selectList(super.getNs()+".find",inputDate);
        return dataList;
    }
}
