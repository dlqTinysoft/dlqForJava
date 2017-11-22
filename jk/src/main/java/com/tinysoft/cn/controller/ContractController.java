package com.tinysoft.cn.controller;

import com.tinysoft.cn.domain.Contract;
import com.tinysoft.cn.service.ContractService;
import com.tinysoft.cn.vo.ContractVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 董乐强 on 2017/11/3.
 */
@Controller
public class ContractController extends BaseController{
    @Resource
    private ContractService contractService;
    @RequestMapping("cargo/contract/list.action")
    public String list(Model model){
        List<Contract> dataList = contractService.find(null);
        model.addAttribute("dataList",dataList);
        return "/cargo/contract/jContractList.jsp";
    }

    @RequestMapping("cargo/contract/toinsert.action")
    public String toinsert(){
        return "/cargo/contract/jContractCreate.jsp";
    }
    @RequestMapping("cargo/contract/insert.action")
    public String insert(Contract contract){
        contractService.insert(contract);
        return "redirect:/cargo/contract/list.action";
    }

    //修改功能的实现
    @RequestMapping("cargo/contract/toupdate.action")
    public String toupdate(String id,Model model){
        Contract contract = contractService.get(id);
        model.addAttribute("contract",contract);
        return "/cargo/contract/jContractUpdate.jsp";
    }
    @RequestMapping("cargo/contract/update.action")
    public String update(Contract contract){
        contractService.update(contract);
        return "redirect:/cargo/contract/list.action";
    }

    @RequestMapping("cargo/contract/delete.action")
    public String delete(@RequestParam("id") String[] ids){
        contractService.delete(ids);
        return "redirect:/cargo/contract/list.action";
    }

    //查看功能实现
    @RequestMapping("cargo/contract/toview.action")
    public String toview(String id,Model model){
       ContractVO contractVO = contractService.getContractVO(id);
        System.out.println(contractVO);
       model.addAttribute("obj",contractVO);
        return "/cargo/contract/jContractView.jsp";
    }

    //上报和取消功能实现
    @RequestMapping("cargo/contract/submit.action")
    public String submit(@RequestParam("id") String[] ids){
        contractService.submit(ids);
        return "redirect:/cargo/contract/list.action";
    }
    @RequestMapping("cargo/contract/cancle.action")
    public String cancle(@RequestParam("id") String[] ids){
        System.out.println(ids);
        contractService.cancle(ids);
        return "redirect:/cargo/contract/list.action";
    }

}
