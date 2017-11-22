package com.tinysoft.cn.dao;

import com.tinysoft.cn.pagination.Page;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 董乐强 on 2017/11/1.
 * 常见的增删改查 都封装到一个类中
 */
public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {

    @Autowired
    //mybatis-spring 1.0无需此方法；mybatis-spring1.2必须注入。
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    private String ns;        //命名空间

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    public List<T> findPage(Page page) {
        List<T> oList = this.getSqlSession().selectList(ns + ".findPage", page);
        return oList;
    }

    public List<T> find(Map paraMap) {
        List<T> oList = this.getSqlSession().selectList(ns + ".find", paraMap);
        return oList;
    }

    public T get(Serializable id) {
        T t = this.getSqlSession().selectOne(ns + ".get", id);
        return t;
    }

    //插入元素
    public void insert(T entity) {
        this.getSqlSession().insert(ns + ".insert", entity);

    }

    public void update(T entity) {
        this.getSqlSession().update(ns + ".update", entity);
    }

    public void deleteById(Serializable id) {
        this.getSqlSession().delete(ns + ".deleteById", id);
    }

    public void delete(Serializable[] ids) {
        this.getSqlSession().delete(ns + ".delete", ids);
    }
}
