package com.tinysoft.cn.service;

import com.tinysoft.cn.vo.OutProductPrintVO;

import java.util.List;

/**
 * Created by 董乐强 on 2017/11/7.
 */
public interface OutProductPrintService {
    public List<OutProductPrintVO> find(String inputDate);
}

