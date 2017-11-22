package com.tinysoft.cn.dao;

import com.tinysoft.cn.domain.ContractProduct;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by 董乐强 on 2017/11/3.
 */
@Repository
public class ContractProductDaoImpl extends BaseDaoImpl<ContractProduct> implements ContractProductDao {

    public ContractProductDaoImpl(){
        super.setNs("com.tinysoft.cn.domain.ContractProduct");
    }


    public void deleteContractProductByContractId(Serializable[] ids) {
        this.getSqlSession().delete(super.getNs()+".deleteContractProductByContractId",ids);
    }
}
