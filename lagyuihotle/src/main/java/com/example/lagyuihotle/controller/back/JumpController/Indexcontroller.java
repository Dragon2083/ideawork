package com.example.lagyuihotle.controller.back.JumpController;

import com.example.lagyuihotle.service.RoomdataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author ：dragon2082
 * @date ：Created in 2021/3/8 22:37
 */
@Controller
public class Indexcontroller {

    @Resource
    RoomdataService roomdataService;

    @RequestMapping("/back/user/list")
    String touserlist(){
        return "/back/userlist/userlist";
    }

    @RequestMapping("/back/room")
    String roompage(){
        return "/back/room/room";
    }

    @RequestMapping("/back/information")
    String information(){
        return "/back/information";
    }

    @RequestMapping("/back/console")
    String console(HttpSession session){
        int useable = roomdataService.graphrstate("可用");
        int unable = roomdataService.graphrstate("不可用");
        int clean = roomdataService.graphrstate("待清洁");
        int maintain = roomdataService.graphrstate("待维修");
        session.setAttribute("useable",useable);
        session.setAttribute("unable",unable);
        session.setAttribute("clean",clean);
        session.setAttribute("maintain",maintain);
        return "/back/console";
    }
}
