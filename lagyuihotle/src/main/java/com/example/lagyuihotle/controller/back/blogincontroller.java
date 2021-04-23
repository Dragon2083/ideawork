package com.example.lagyuihotle.controller.back;

import com.example.lagyuihotle.pojo.entity.Userdata;
import com.example.lagyuihotle.service.UserdataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/back")
public class blogincontroller {

    @Resource
    UserdataService userdataService;

    @RequestMapping("blogin")
    public String blogin(){
        return "/back/login";
    }

    @RequestMapping("/blogout")
    public String blogout(HttpSession session){
        session.removeAttribute("login");
        return "/back/login";
    }
    //验证登录
    @RequestMapping("/blogindata")
    String longin(Userdata user, Model model, HttpSession session){
        if ("".equals(user.getIdcard())||user.getIdcard()==null){
            model.addAttribute("errormsg","请输入账号！");
            return "/back/login";
        }
        boolean blonginResult = userdataService.blongin(user);
        if(blonginResult){
            session.setAttribute("login",userdataService.usersearch(user.getIdcard()));
            return "/back/index";
        }
        return "/back/login";
    }
}
