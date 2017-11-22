package com.tinysoft.cn.service;

import com.tinysoft.cn.dao.BaseDao;
import com.tinysoft.cn.pagination.Page;
import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 董乐强 on 2017/11/3.
 */
public  class BaseServiceImpl<T> implements BaseService<T> {
    private BaseDao baseDao;
    public void set(BaseDao baseDao){
        this.baseDao = baseDao;
    }
    public List<T> findPage(Page page) {
        return null;
    }

    public T get(Serializable id) {
        return (T)baseDao.get(id);
    }

    public void update(T t) {
        baseDao.update(t);
    }

    public void deleteById(Serializable id) {
        baseDao.deleteById(id);
    }

    public void delete(Serializable[] ids) {
        baseDao.delete(ids);
    }


    public List<T> getFactoryList() {
        return null;
    }
}
