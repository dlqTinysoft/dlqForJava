package com.tinysoft.cn.dao;

import com.tinysoft.cn.domain.Contract;
import com.tinysoft.cn.vo.ContractVO;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by 董乐强 on 2017/11/3.
 */
@Repository
public class ContractDaoImpl extends BaseDaoImpl<Contract> implements ContractDao{
     public ContractDaoImpl(){
         super.setNs("com.tinysoft.cn.domain.Contract");
     }

     public void updateState(Map map) {
        this.getSqlSession().update(super.getNs()+".updateState",map);
    }

    public void deleteExtProductByContractId(Serializable [] ids) {
        this.getSqlSession().delete(super.getNs()+".deleteExtProductByContractId",ids);
    }

    public ContractVO getView(Serializable id) {
         ContractVO contractVO = this.getSqlSession().selectOne(super.getNs()+".view",id);
        return contractVO;
    }
}
