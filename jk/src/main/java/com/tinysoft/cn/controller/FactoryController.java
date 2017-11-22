package com.tinysoft.cn.controller;

import java.util.List;

import javax.annotation.Resource;

import com.tinysoft.cn.domain.Factory;
import com.tinysoft.cn.service.FactoryService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author: nutony
 * @Company: http://java.itcast.cn
 * @CreateDate: 2014年10月9日
 */
@Controller
public class FactoryController extends BaseController {
    @Resource
    FactoryService factoryService;

    //列表
    @RequestMapping("/basicinfo/factory/list.action")
    public String list(Model model) {
        List<Factory> dataList = factoryService.find(null);
        model.addAttribute("dataList", dataList);            //将数据传递到页面
        System.out.println("--------" + dataList);
        return "/basicinfo/factory/jFactoryList.jsp";        //转向页面
    }

    //增加厂家信息的功能实现
    @RequestMapping("/basicinfo/factory/tocreate.action")
    public String tocreate() {
        return "/basicinfo/factory/jFactoryCreate.jsp";
    }

    @RequestMapping("/basicinfo/factory/insert.action")
    public String insert(Factory factory) {
        //SpringMvc会自动封装将表单的数据封装为factory
        factoryService.insert(factory);
        //重定向到list.action，这样做的原因是，插入到数据后，需要从新对页面进行更新
        return "redirect:/basicinfo/factory/list.action";
    }

    //修改厂家信息功能实现
    @RequestMapping("/basicinfo/factory/toupdate.action")
    public String toUpdate(String id, Model model) {
        //根据id查出厂家信息
        Factory factory = factoryService.get(id);
        //将数据带回页面
        model.addAttribute("factory", factory);
        return "/basicinfo/factory/jFactoryUpdate.jsp";
    }

    @RequestMapping("/basicinfo/factory/update.action")
    public String update(Factory factory) {
        factoryService.update(factory);
        return "redirect:/basicinfo/factory/list.action";
    }

    //删除厂家信息功能实现
    @RequestMapping("/basicinfo/factory/deleteById.action")
    public String deleteById(String id) {
        factoryService.deleteById(id);
        //删除之后，回到主页
        return "redirect:/basicinfo/factory/list.action";
    }

    @RequestMapping("/basicinfo/factory/delete.action")
    //RequestParam的使用 将id 封装为ids 其实就是给id起个别名,当选中多个id是，springmvc会自动封装为一个字符串
    public String delete(@RequestParam("id") String[] ids) {
        factoryService.delete(ids);
        return "redirect:/basicinfo/factory/list.action";
    }

    //停用和启用功能的实现
    @RequestMapping("/basicinfo/factory/start.action")
    public String start(@RequestParam("id") String[] ids) {
        factoryService.start(ids);
        return "redirect:/basicinfo/factory/list.action";
    }

    @RequestMapping("/basicinfo/factory/stop.action")
    public String stop(@RequestParam("id") String[] ids) {
        factoryService.stop(ids);
        return "redirect:/basicinfo/factory/list.action";
    }

    @RequestMapping("/basicinfo/factory/toview.action")
    public String toview(String id, Model model) {
        Factory factory = factoryService.get(id);
        model.addAttribute("factory", factory);
        return "/basicinfo/factory/jFactoryView.jsp";
    }
}
