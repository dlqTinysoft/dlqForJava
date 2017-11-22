package com.tinysoft.cn.service;

import com.tinysoft.cn.dao.ContractProductDao;
import com.tinysoft.cn.dao.ExtProductDao;
import com.tinysoft.cn.domain.ContractProduct;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 董乐强 on 2017/11/3.
 */
@Service
public  class ContractProductServiceImpl extends BaseServiceImpl<ContractProduct> implements ContractProductService {
    @Resource
    private ContractProductDao contractProductDao;
    @Resource
    private ExtProductDao extProductDao;

    public List<ContractProduct> find(Map map) {
        super.set(contractProductDao);
         List<ContractProduct> dataLists = contractProductDao.find(map);
        return dataLists;
    }

    public void insert(ContractProduct contractProduct) {
          //通过传过来的数量，包装单位，装率，箱数，单价 ，则可以计算总金额，
          contractProduct.setId(UUID.randomUUID().toString());
          super.set(contractProductDao);
          contractProductDao.insert(contractProduct);
    }

    @Override
    public void delete(Serializable[] ids) {
        super.set(contractProductDao);
       //删除货物下所有附件
        extProductDao.deleteExtByContractProductId(ids);
        //删除货物
        super.delete(ids);
    }
}
