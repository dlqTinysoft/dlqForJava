package com.tinysoft.cn.service;

import com.tinysoft.cn.dao.PackingListDao;
import com.tinysoft.cn.domain.PackingList;
import com.tinysoft.cn.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 董乐强 on 2017/11/20.
 */
@Service
public class PackingListServiceImpl implements PackingListService {
    //注册packingListDao
    @Resource
    private PackingListDao packingListDao;

    public List<PackingList> findPage(Page page) {
        List<PackingList> pageList = packingListDao.findPage(page);
        return pageList;
    }

    public List<PackingList> find(Map paraMap) {

        List<PackingList> datas = packingListDao.find(paraMap);
        return datas;
    }

    public PackingList get(Serializable id) {
        PackingList packingList = packingListDao.get(id);
        return packingList;
    }

    public void insert(PackingList packingList) {
         packingList.setId(UUID.randomUUID().toString());
         //插入的时候为草稿
          packingList.setState(0);
          packingListDao.insert(packingList);
    }

    public void update(PackingList packingList) {
              packingListDao.update(packingList);
    }

    public void deleteById(Serializable id) {
       packingListDao.deleteById(id);
    }

    public void delete(Serializable[] ids) {
        packingListDao.delete(ids);
    }

    //提交
    public void submit(Serializable[] ids) {
          Map<String,Object> map = new HashMap<String,Object>();
          map.put("ids",ids);
          map.put("state",1);
          packingListDao.updateState(map);
    }
    //草稿
    public void cancel(Serializable[] ids) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("ids",ids);
        map.put("state",0);
        packingListDao.updateState(map);
    }

    public String getDivDataCreate(String[] exportIds) {
        return null;
    }

    public String getDivDataUpdate(String[] exportIds, String[] exportNos) {
        return null;
    }

    public String getDivDataView(String[] exportNos) {
        return null;
    }
}
