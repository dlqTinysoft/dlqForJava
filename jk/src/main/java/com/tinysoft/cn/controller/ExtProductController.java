package com.tinysoft.cn.controller;

import com.tinysoft.cn.dao.ExtProductDao;
import com.tinysoft.cn.domain.Factory;
import com.tinysoft.cn.domain.ProductExt;
import com.tinysoft.cn.domain.SysCode;
import com.tinysoft.cn.service.ExtPrdouctService;
import com.tinysoft.cn.service.FactoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.jws.WebResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 董乐强 on 2017/11/5.
 */
@Controller
public class ExtProductController extends  BaseController {

    @Resource
    private ExtPrdouctService extProductService;
    @Resource
    private FactoryService factoryService;
     //创建附件
    @RequestMapping("cargo/extcproduct/tocreate.action")
    public String tocreate(String contractProductId, Model model){
         //得到该货物下的所有附件
        Map<String ,Object> map = new HashMap<String ,Object>();
        map.put("contractProductId",contractProductId);
        List<ProductExt> dataList = extProductService.find(map);
        model.addAttribute("dataList",dataList);

        //得到所有厂家列表
        List<Factory> factoryList = factoryService.getStartFactoryList();
        model.addAttribute("factoryList",factoryList);

        //得到附件的分类
        Map<String, Object> map_ext = new HashMap<String ,Object>();
        map_ext.put("parentId","0103");
        List<SysCode> sysCodes =  extProductService.findExtType(map_ext);
        model.addAttribute("ctypeList",sysCodes);
        //把该附件的对应的货物id传入到页面
        model.addAttribute("contractProductId",contractProductId);
        return "/cargo/contract/jExtCproductCreate.jsp";
    }


    @RequestMapping("cargo/extcproduct/insert.action")
    public String insert(ProductExt productExt,Model model){
         extProductService.insert(productExt);
          model.addAttribute("contractProductId",productExt.getContractProductId());
        return "redirect:/cargo/extcproduct/tocreate.action";
    }

    //附件修改功能实现
    @RequestMapping("cargo/extcproduct/toupdate.action")
    public String toudpate(String id,Model model){
        ProductExt productExt = extProductService.get(id);
        System.out.println(productExt);
        model.addAttribute("obj",productExt);
        //得到所有厂家列表
        List<Factory> factoryList = factoryService.getStartFactoryList();
        model.addAttribute("factoryList",factoryList);
        //得到附件的分类
        Map<String, Object> map_ext = new HashMap<String ,Object>();
        map_ext.put("parentId","0103");
        List<SysCode> sysCodes =  extProductService.findExtType(map_ext);
        model.addAttribute("ctypeList",sysCodes);
       return "/cargo/contract/jExtCproductUpdate.jsp";
    }

    @RequestMapping("cargo/extcproduct/update.action")
    public String update(ProductExt productExt,Model model){
          extProductService.update(productExt);
          model.addAttribute("contractProductId",productExt.getContractProductId());
        return "redirect:/cargo/extcproduct/tocreate.action";
    }
    //删除附件功能的实现
    @RequestMapping("cargo/extcproduct/deleteById.action")
    public String deleteById(String id,String contractProductId ){
         extProductService.deleteById(id);
        return "redirect:/cargo/extcproduct/tocreate.action?contractProductId="+contractProductId;
    }

}
