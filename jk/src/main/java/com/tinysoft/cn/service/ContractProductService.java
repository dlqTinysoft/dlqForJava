package com.tinysoft.cn.service;

import com.tinysoft.cn.domain.ContractProduct;

import java.util.List;
import java.util.Map;

/**
 * Created by 董乐强 on 2017/11/3.
 */
public interface ContractProductService extends BaseService<ContractProduct> {
      public List<ContractProduct> find(Map map);
      public void insert(ContractProduct contractProduct);
}
