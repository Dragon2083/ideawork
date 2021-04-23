package com.example.lagyuihotle.controller.back.JumpController;


import com.alibaba.fastjson.JSONObject;
import com.example.lagyuihotle.pojo.entity.Userdata;
import com.example.lagyuihotle.service.UserdataService;
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
 * @date ：Created in 2021/3/11 16:45
 */
@Controller
public class usercontroller {

    @Resource
    UserdataService userdataService;

    @RequestMapping("/back/userlist")
    @ResponseBody
    String userlist(int page,int limit,Userdata userdata){
        PageHelper.startPage(page,limit);
        List<Userdata> list =  userdataService.ulist(userdata);
        PageInfo<Userdata> pageInfo = new PageInfo(list);
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",pageInfo.getTotal());
        obj.put("data",pageInfo.getList());
        return obj.toString();
    }

    @RequestMapping(value = "/back/userdel")
    @ResponseBody
    String userdel(String id,Model model){
        JSONObject json=new JSONObject();
        int flag = userdataService.udel(id);
        json.put("flag",flag);
        return json.toString();
    }


    @RequestMapping("/back/adduser")
    @ResponseBody
    String add_user(Userdata user){
        Integer flag = userdataService.insertuser(user);
        JSONObject json=new JSONObject();
        json.put("flag",flag);
        return json.toString();
    }

    @RequestMapping("/back/useredit")
    String  useredit(){
        return "/back/userlist/edituser";
    }

    @RequestMapping("/back/adduserpage")
    String adduser(){
        return "/back/userlist/adduser";
    }


    @RequestMapping(value="/back/userupdata")
    @ResponseBody
    String userupdata(Userdata user){
        Integer flag = userdataService.userupdata(user);
       /* model.addAttribute("res",true);
        return "redirect:/test2";*/
        JSONObject json = new JSONObject();
        json.put("flag",flag);
        return json.toString();
    }

}
