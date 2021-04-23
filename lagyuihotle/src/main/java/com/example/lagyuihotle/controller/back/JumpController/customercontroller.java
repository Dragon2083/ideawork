package com.example.lagyuihotle.controller.back.JumpController;

import com.alibaba.fastjson.JSONObject;
import com.example.lagyuihotle.pojo.entity.Customerdata;
import com.example.lagyuihotle.service.CustomerdataService;
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

    @RequestMapping("/back/customerlist")
    @ResponseBody
    String customerlist(){

        List list = customerdataService.customerlist();
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",15);
        obj.put("data",list);
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
