package com.example.lagyuihotle.controller.back.JumpController;

import com.alibaba.fastjson.JSONObject;
import com.example.lagyuihotle.pojo.entity.Hoteldata;
import com.example.lagyuihotle.pojo.entity.Roomdata;
import com.example.lagyuihotle.service.HotelService;
import com.example.lagyuihotle.service.RoomdataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：dragon2082
 * @date ：Created in 2021/3/23 13:40
 */
@Controller
public class roomcontroller {

    @Resource
    RoomdataService roomdataService;
    @Resource
    HotelService hotelService;


    /**
     * 房间列表
     * @return
     */
    @RequestMapping("/back/roomlist")
    @ResponseBody
    String roomlist(int page,int limit,Roomdata roomdata){
        if(roomdata.getRstate()!=null&&roomdata.getRstate().equals("")){
            roomdata.setRstate(null);
        }
        PageHelper.startPage(page,limit);
        List<Roomdata> list = roomdataService.roomlist(roomdata);
        PageInfo<Roomdata> pageInfo = new PageInfo(list);
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",pageInfo.getTotal());
        obj.put("data",pageInfo.getList());
        return obj.toString();
    }

    @RequestMapping("/back/roombystate")
    @ResponseBody
    String roombystate(){

        List<Roomdata> list = roomdataService.roombystate();
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",15);
        obj.put("data",list);
        return obj.toString();
    }
    /**
     * 删除房间
     */
    @RequestMapping("/back/roomdel")
    @ResponseBody
    String roomdel(int id){

        int flag = roomdataService.roomdel(id);
        JSONObject json =  new JSONObject();
        json.put("flag",flag);
        return json.toString();
    }

    /**
     * 添加房间
     * @param roomdata
     * @return
     */
    @RequestMapping("/back/roomadd")
    @ResponseBody
    String roomadd(Roomdata roomdata){

        Hoteldata hoteldata = hotelService.selectbyid();
        if(roomdata.getRtype()==1){
            roomdata.setRprice(hoteldata.getSingle());
        }else if(roomdata.getRtype()==1){
            roomdata.setRprice(hoteldata.getTwo());
        }else{
            roomdata.setRprice(hoteldata.getThree());
        }
        int flag = roomdataService.roomadd(roomdata);
        JSONObject json = new JSONObject();
        json.put("flag",flag);
        return json.toString();
    }

    @RequestMapping("/back/addroompage")
    String addroompage(){return "/back/room/addroom";}

    /**
     * 修改房间信息
     */
    @RequestMapping("/back/editroom")
    String editroom(){
        return "/back/room/editroom";
    }

    @RequestMapping("/back/roomupate")
    @ResponseBody
    String roomupdate(Roomdata roomdata){
        int flag = roomdataService.roomupdate(roomdata);
        JSONObject json = new JSONObject();
        json.put("flag",flag);
        return json.toString();
    }

}
