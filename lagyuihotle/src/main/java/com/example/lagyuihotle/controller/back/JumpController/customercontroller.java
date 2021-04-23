package com.example.lagyuihotle.controller.back.JumpController;

import com.alibaba.fastjson.JSONObject;
import com.example.lagyuihotle.pojo.entity.Customerdata;
import com.example.lagyuihotle.pojo.entity.Record;
import com.example.lagyuihotle.service.CustomerdataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：dragon2082
 * @date ：Created in 2021/3/28 19:51
 */
@Controller
public class customercontroller {

    @Resource
    CustomerdataService customerdataService;

    @RequestMapping("/back/customer")
    String customer(Model model){
        return "/back/customer/customer";
    }

    /**
     * 顾客列表
     * @return
     */
    @RequestMapping("/back/customerlist")
    @ResponseBody
    String customerlist(int page,int limit,Customerdata customerdata){
        PageHelper.startPage(page,limit);
        List list = customerdataService.customerlist(customerdata);
        PageInfo<Customerdata> pageInfo = new PageInfo(list);
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",pageInfo.getTotal());
        obj.put("data",pageInfo.getList());
        return obj.toString();
    }

    @RequestMapping("/back/delcustomer")
    @ResponseBody
    String delcustomer(int id){
        int flag = customerdataService.delcustomer(id);
        JSONObject json =  new JSONObject();
        json.put("flag",flag);
        return json.toString();
    }

    @RequestMapping("/back/editcustomer")
    String editcustomer(){
        return "/back/customer/editcustomer";
    }

    @RequestMapping("/back/updatecustomer")
    @ResponseBody
    String updatecustomer(Customerdata customerdata){
        int flag = customerdataService.updatecustomer(customerdata);
        JSONObject json = new JSONObject();
        json.put("flag",flag);
        return json.toString();
    }
}
