package com.example.lagyuihotle.controller.back.JumpController;

import com.alibaba.fastjson.JSONObject;
import com.example.lagyuihotle.pojo.entity.Hoteldata;
import com.example.lagyuihotle.service.HotelService;
import com.example.lagyuihotle.service.RoomdataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Resource
    HotelService hotelService;

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

    @RequestMapping("/back/hoteldata")
    String hoteldata(HttpSession session){
        Hoteldata hoteldata = hotelService.selectbyid();
        session.setAttribute("hotelphone",hoteldata.getPhone());
        session.setAttribute("hotelabout",hoteldata.getAbout());
        session.setAttribute("hotelsingle",hoteldata.getSingle());
        session.setAttribute("hoteltwo",hoteldata.getTwo());
        session.setAttribute("hotelthree",hoteldata.getThree());
        return  "/back/hoteldata";
    }
    //更新前台的数据显示
    @RequestMapping("/back/hotelupdata")
    @ResponseBody
    String hotel(Model model, Hoteldata hoteldata){
        int flag =  hotelService.updatehoteldata(hoteldata);
        JSONObject json =  new JSONObject();
        json.put("flag",flag);
        return json.toString();
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
