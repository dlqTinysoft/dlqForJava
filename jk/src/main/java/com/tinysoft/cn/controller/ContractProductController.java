package com.tinysoft.cn.controller;

import com.tinysoft.cn.domain.ContractProduct;
import com.tinysoft.cn.domain.Factory;
import com.tinysoft.cn.service.ContractProductService;
import com.tinysoft.cn.service.FactoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 董乐强 on 2017/11/3.
 */
@Controller
public class ContractProductController {
    @Resource
    private ContractProductService contractProductService;
    @Resource
    private FactoryService factoryService;


    //新增货物
    @RequestMapping("cargo/contract_product/tocreate.action")
    //spring_mvc可以从url中得到购销合同的id即contractId
    public String tocreate(String contractId , Model model){
          //在新增页面时，得到所有已启用的生产厂家列表
          List<Factory> factoryList = factoryService.getStartFactoryList();
          //将生长家列表，封装到model中
          model.addAttribute("factoryList",factoryList);
          //查询某个合同下的新增货物
          Map map = new HashMap<String , Object>();
          map.put("contractId",contractId);
          //得到当前购销合同下的所有货物信息
           List<ContractProduct> dataList = contractProductService.find(map);
           //封装到model对象中
           model.addAttribute("dataList",dataList);
          //保存购销合同的id,注意必须把购销合同的id往下传，否则新增货物没有所属哪个购销合同，则插入的记录会成为僵尸记录
         model.addAttribute("contractId",contractId);
        //跳转到新增货物页面
        return "/cargo/contract/jContractProductCreate.jsp";
    }

    //将数据插入到数据库，然后在跳到新增页面
    @RequestMapping("cargo/contract_product/insert.action")
    //springmvc将货物的信息自动封装到Contractproduct中。
    public String create(ContractProduct contractProduct,Model model){

        String id = contractProduct.getContractId();
        //继续添加，购销合同id还要继续传递下去
        model.addAttribute("contractId",id);
        contractProduct.setId(UUID.randomUUID().toString());
        //特别注意，contractProduct必须有购销合同的id和生产厂家的字段,否则插入的货物信息又有什么意义呢？？？？
        contractProductService.insert(contractProduct);
        //为什么转发， 不可以？？？ 浏览器会自动加上 http://localhost：8080/jk......
        return "redirect:/cargo/contract_product/tocreate.action";
    }

    //修改货物信息功能模块实现
    @RequestMapping("cargo/contract_product/toupdate.action")
    public String toupdate(String contractProductId,Model model){
        //得到要修改货物的信息
        ContractProduct contractProduct = contractProductService.get(contractProductId);
        //封装到model中
        model.addAttribute("obj",contractProduct);
        List<Factory> factoryList = factoryService.getStartFactoryList();
        model.addAttribute("factoryList",factoryList);
        //转发到新增页面
        return "/cargo/contract/jContractProductUpdate.jsp";
    }

    //修改功能的实现
    @RequestMapping("cargo/contract_product/update.action")
    public String update(ContractProduct contractProduct,Model model){
        contractProductService.update(contractProduct);
        return "redirect:/cargo/contract_product/tocreate.action?contractId"+contractProduct.getContractId();
    }
    //删除功能的实现
    @RequestMapping("cargo/contract_product/deleteById.action")
    public String delete(String id,String contractId){
        contractProductService.deleteById(id);
        return "redirect:/cargo/contract_product/tocreate.action?contractId="+contractId;
    }

}
