package com.tinysoft.cn.service;

import com.tinysoft.cn.domain.Contract;
import com.tinysoft.cn.domain.Factory;
import com.tinysoft.cn.pagination.Page;
import com.tinysoft.cn.vo.ContractVO;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 董乐强 on 2017/11/3.
 */
public interface ContractService extends BaseService<Contract> {

    public void insert(Contract contract);            //插入，用实体作为参数
    public List<Contract> find(Map map);

    public void submit(String[] ids); //上报合同
    public void cancle(String[] ids);//取消合同

    public ContractVO getContractVO(String id);

}
