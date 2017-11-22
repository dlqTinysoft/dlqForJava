package com.tinysoft.cn.service;


import com.tinysoft.cn.domain.Contract;
import com.tinysoft.cn.domain.Export;
import com.tinysoft.cn.pagination.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 董乐强 on 2017/11/10.
 */
public interface ExportService extends BaseService<Export> {

    public List<Export> find(Map map);
    public void insert(String[] contractIds);	//插入，用实体作为参数
    public void delete(Serializable[] ids);//级联删除
    public void submit(Serializable[] ids);		//上报
    public void cancel(Serializable[] ids);		//取消
    //同时更新报运信息和报运下的货物信息
    public void update(Export export,
                       String[] mr_id,
                       Integer[] mr_orderNo,
                       Integer[] mr_cnumber,
                       Double[] mr_grossWeight,
                       Double[] mr_netWeight,
                       Double[] mr_sizeLength,
                       Double[] mr_sizeWidth,
                       Double[] mr_sizeHeight,
                       Double[] mr_exPrice,
                       Double[] mr_tax,
                       Integer[] mr_changed
    );
    public List<Contract> getContractList();	//获取购销合同列表（已上报）
    public String getMrecordData(String exportId);		//拼接js串
}
