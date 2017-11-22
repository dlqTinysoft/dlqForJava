package com.tinysoft.cn.dao;

import com.tinysoft.cn.domain.ContractProduct;

import java.io.Serializable;

/**
 * Created by 董乐强 on 2017/11/3.
 */
public interface ContractProductDao extends BaseDao<ContractProduct> {
    //通过合同的id删除货物
    public void deleteContractProductByContractId(Serializable [] ids);
}
