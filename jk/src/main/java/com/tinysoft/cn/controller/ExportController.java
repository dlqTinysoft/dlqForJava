package com.tinysoft.cn.controller;

import com.tinysoft.cn.domain.Contract;
import com.tinysoft.cn.domain.Export;
import com.tinysoft.cn.service.ExportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 董乐强 on 2017/11/10.
 */
@Controller
public class ExportController {
    @Resource
    private ExportService exportService;

    //展示所有报运单信息列表
    @RequestMapping("/cargo/export/list.action")
    public String list(Model model){
        List<Export> dataList= exportService.find(null);
        model.addAttribute("dataList",dataList);
        return "/cargo/export/jExportList.jsp";
    }

    //查询所有已经上报的购销合同
    @RequestMapping("/cargo/export/contractLists.action")
    public String contractLists(Model model){
        List<Contract> dataList= exportService.getContractList();
        model.addAttribute("dataList",dataList);
        return "/cargo/export/jContractList.jsp";
    }

    //报运功能的实现，报运的同时，把合同下的货物和附件到加入到报运下的货物和附件
    @RequestMapping("/cargo/export/insert.action")
    public String insert(@RequestParam("id") String [] contractIds){
        exportService.insert(contractIds);
        //跳转到报运页面
        return "redirect:/cargo/export/list.action";
    }

    //修改
    @RequestMapping("/cargo/export/toupdate.action")
    public String toupdate(Model model,String id){
         Export export = exportService.get(id);
         model.addAttribute("obj",export);
         //准备批量修改数据的记录
        model.addAttribute("mRecordData", exportService.getMrecordData(id));
         return "/cargo/export/jExportUpdate.jsp";
    }

    //修改后，跳转到报运页面,批量修改，是个难点和重点
    @RequestMapping("http://localhost:8080/jk/cargo/export1/update1.action")
    public String update(Export export,
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
    )
    {
      exportService.update(export, mr_id, mr_orderNo, mr_cnumber, mr_grossWeight, mr_netWeight,
              mr_sizeLength, mr_sizeWidth, mr_sizeHeight, mr_exPrice, mr_tax, mr_changed);

        System.out.println("hello world");

      return "redirect:/cargo/export/list.action";
    }
}
