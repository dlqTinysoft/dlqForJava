package com.tinysoft.cn.service;

import com.tinysoft.cn.dao.OutProductPrintDao;
import com.tinysoft.cn.vo.OutProductPrintVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 董乐强 on 2017/11/7.
 */
@Service
public class OutProductPrintServiceImpl implements OutProductPrintService {
    @Resource
    private OutProductPrintDao outProductPrintDao;
    public List<OutProductPrintVO> find(String inputDate) {
        return outProductPrintDao.find(inputDate);
    }
}
