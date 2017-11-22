package com.tinysoft.cn.dao;

import com.tinysoft.cn.vo.OutProductPrintVO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 董乐强 on 2017/11/7.
 */
public interface OutProductPrintDao extends  BaseDao<OutProductPrintVO> {
    public List<OutProductPrintVO> find(Serializable inputDate);
}
