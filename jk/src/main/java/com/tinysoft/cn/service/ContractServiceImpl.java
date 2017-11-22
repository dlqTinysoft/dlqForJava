package com.tinysoft.cn.service;

import com.tinysoft.cn.dao.*;
import com.tinysoft.cn.domain.Contract;
import com.tinysoft.cn.domain.ContractProduct;
import com.tinysoft.cn.domain.Export;
import com.tinysoft.cn.vo.ContractVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 董乐强 on 2017/11/3.
 */
@Service
public class ContractServiceImpl extends BaseServiceImpl<Contract> implements ContractService {
    @Resource
    private ContractDao contractDao;

    @Resource
    private ContractProductDao contractProductDao;

    @Resource
    private ExportDao exportDao;

    public List<Contract> find(Map map) {
         super.set(contractDao);
         List<Contract> contracts = contractDao.find(map);
        return contracts;
    }

    public void insert(Contract contract) {
        contract.setId(UUID.randomUUID().toString());
        contract.setState(0);//新增默认为草稿
        contractDao.insert(contract);
    }

    public void submit(String [] ids) {
        Map<String ,Object> map = new HashMap<String,Object>();
        map.put("state",1);
        map.put("ids",ids);
        contractDao.updateState(map);
    }
    //如果未报运，则可以取消，否则不能够取消的
    //这部分逻辑功能还未实现
    public void cancle(String[] ids) {

        Map<String ,Object> map = new HashMap<String,Object>();
        map.put("state",0);
        map.put("ids",ids);
        contractDao.updateState(map);
    }

    //这个地方。功能还未实现,sql语句查询的有问题
    public ContractVO getContractVO(String id) {
        ContractVO contractVO = contractDao.getView(id);
        return contractVO;
    }

    @Override
    public void delete(Serializable[] ids) {
        //删除合同下的所有附件
        contractDao.deleteExtProductByContractId(ids);
        //先删除合同下的所有货物
       contractProductDao.deleteContractProductByContractId(ids);
       //删除合同
        super.delete(ids);
    }
}
