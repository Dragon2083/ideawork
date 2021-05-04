package com.example.lagyuihotle.controller.front;

import com.alibaba.fastjson.JSONObject;
import com.example.lagyuihotle.pojo.entity.Customerdata;
import com.example.lagyuihotle.pojo.entity.Hoteldata;
import com.example.lagyuihotle.pojo.entity.Record;
import com.example.lagyuihotle.pojo.entity.Roomdata;
import com.example.lagyuihotle.service.CustomerdataService;
import com.example.lagyuihotle.service.HotelService;
import com.example.lagyuihotle.service.RecordService;
import com.example.lagyuihotle.service.RoomdataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ：dragon2082
 * @date ：Created in 2021/3/22 15:53
 */
@Controller
public class frontcontroller {

    @Resource
    CustomerdataService customerdataService;
    @Resource
    RoomdataService roomdataService;
    @Resource
    RecordService recordService;
    @Resource
    HotelService hotelService;

   @RequestMapping("/")
   String index(Model model){
       Hoteldata hoteldata = hotelService.selectbyid();
       model.addAttribute("phone",hoteldata.getPhone());
       model.addAttribute("single",hoteldata.getSingle());
       model.addAttribute("two",hoteldata.getTwo());
       model.addAttribute("three",hoteldata.getThree());
       return "/front/index";
   }

   @RequestMapping("/about")
   String  about(Model model){
       String about = hotelService.selectbyid().getAbout();
       model.addAttribute("about",about);
       return "/front/about";
   }

   @RequestMapping("/room")
   String  room(Model model,int type){

       //剩余可用房间
        int singleroom = roomdataService.Availablerooms(1);
        int doubleroom = roomdataService.Availablerooms(2);
        int tripleroom = roomdataService.Availablerooms(3);
        model.addAttribute("single",singleroom);
        model.addAttribute("double",doubleroom);
        model.addAttribute("triole",tripleroom);
        model.addAttribute("type",type);
       return "/front/reserve";
   }

   @RequestMapping("/login")
   @ResponseBody
    String login(Customerdata customerdata, HttpSession session){

       boolean res = customerdataService.flogin(customerdata);
       JSONObject json=new JSONObject();
       json.put("flag",res);
        if(res){
            session.setAttribute("flogin",customerdataService.selectbyaccount(customerdata));
            return json.toString();
        }
       return json.toString();
   }

   @RequestMapping("/register")
   @ResponseBody
   String register(Customerdata customerdata){
        //注册
       int flag = customerdataService.addcustomer(customerdata);
       JSONObject json=new JSONObject();
       json.put("flag",flag);
       return json.toString();
   }

    /**
     * 预定房间
     * @param record
     * @param rtype
     * @param session
     * @return
     */
   @RequestMapping("/reserve")
   @ResponseBody
   String reserve(Record record,int rtype,HttpSession session){
      //List<Roomdata> res =roomdataService.reservroomrecord(rtype,record);
       JSONObject json=new JSONObject();
        if(session.getAttribute("flogin")!=null){
            Roomdata room;
            int flag;
            List<Roomdata> list = roomdataService.reserveroom(rtype);
            Customerdata cus = (Customerdata) session.getAttribute("flogin");
            if(list.size()!=0){
                room = list.get(0);
                record.setRnumber(room.getRname());
                record.setCid(cus.getCid());
                record.setCname(cus.getCname());
                session.setAttribute("record",record);
                //flag = recordService.addrecord(record);
                json.put("flag",1);
                json.put("roomnumber",room.getRname());
                return json.toString();
            }else{
                List<Roomdata> reslist =roomdataService.reservroomrecord(rtype,record);
                if(reslist.size()==0){
                    json.put("flag",2);
                    return json.toString();
                }else{
                    room = reslist.get(0);
                    record.setRnumber(room.getRname());
                    record.setCid(cus.getCid());
                    record.setCname(cus.getCname());
                    session.setAttribute("record",record);
                    //flag = recordService.addrecord(record);
                    json.put("roomnumber",room.getRname());
                    json.put("flag",1);
                    return json.toString();
                }
            }
        }else {
            json.put("flag",3);
            return json.toString();
        }
   }
    //预定成功
   @RequestMapping("/reservesuccess")
   String reservation(HttpSession session){

       Record record = (Record) session.getAttribute("record");
       recordService.addrecord(record);
       return "redirect:/record";
   }

    /**
     * 登出
     * @param session
     * @return
     */
   @RequestMapping("/logout")
    String logout(HttpSession session){
       session.removeAttribute("flogin");
       return "redirect:/";
   }

    /**
     * 顾客基本信息
     */
    @RequestMapping("/information")
    String information(){
        return "/front/information";
    }

    /**
     * 顾客预定记录
     */
    @RequestMapping("/record")
    String record(){
        return "/front/record";
    }

    /**
     * 地址
     */
    @RequestMapping("/address")
    String address(){
        return "/front/address";
    }
}
