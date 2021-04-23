package com.example.lagyuihotle.controller;

import com.example.lagyuihotle.dao.UserdataDao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class testcontroller {
    @Resource
    UserdataDao userdataDao;
    @RequestMapping("/test")
    public String hello(){
        return "/back/index";
    }

    @RequestMapping("/test1")
    String  test(){
        return "/back/console";
    }

    @RequestMapping("/test2")
    String  test1(){
        return "/back/userlist/userlisttest";
    }


    @RequestMapping("/test3")
    String  test3(){
        return "/back/userlist/edituser";
    }

    @RequestMapping("/test4")
    String  test4(){
        return "/back/userlist/adduser";
    }
}
