package com.tinysoft.cn.dao;

import com.tinysoft.cn.domain.Contract;
import com.tinysoft.cn.vo.ContractVO;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by 董乐强 on 2017/11/3.
 */
public interface ContractDao extends BaseDao<Contract> {
    //更新购销合同的状态，1表示已上报，0表示未上报
    public void updateState(Map map);

    //根据购销合同id删除附件
    public void deleteExtProductByContractId(Serializable [] ids);

    //面向对象关联查询
    public ContractVO getView(Serializable id);
}
