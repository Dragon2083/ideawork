package com.example.lagyuihotle.controller.back.JumpController;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.example.lagyuihotle.pojo.entity.Record;
import com.example.lagyuihotle.pojo.entity.Roomdata;
import com.example.lagyuihotle.service.RecordService;
import com.example.lagyuihotle.service.RefundService;
import com.example.lagyuihotle.service.RoomdataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author ：dragon2082
 * @date ：Created in 2021/3/30 19:08
 */
@Controller
public class recordcontroller {

    @Resource
    RecordService recordService;
    @Resource
    RoomdataService roomdataService;
    @Resource
    RefundService refundService;

    @RequestMapping("/back/record")
    String record(){
        return "/back/record/record";
    }

    @RequestMapping("/back/recordlist")
    @ResponseBody
    String recordlist(int page,int limit,Record record){
        PageHelper.startPage(page,limit);
        List<Record> list = recordService.recordlist(record);
        PageInfo<Record> pageInfo = new PageInfo(list);
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",pageInfo.getTotal());
        obj.put("data",pageInfo.getList());
        return obj.toString();
    }
    @RequestMapping("/back/recordlistbycid")
    @ResponseBody
    String recordlistbycid(int page,int limit,Record record){
        PageHelper.startPage(page,limit);
        List<Record> list = recordService.recordbycid(record);
        PageInfo<Record> pageInfo = new PageInfo(list);
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",pageInfo.getTotal());
        obj.put("data",pageInfo.getList());
        return obj.toString();
    }

    /**
     * 主页的当天入住记录
     * @return
     */
    @RequestMapping("/back/recordbydate")
    @ResponseBody
    String recordbydate(){
        List<Record> list = recordService.recordbydate();
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",15);
        obj.put("data",list);
        return obj.toString();
    }

    @RequestMapping("/back/editrecord")
    String editrecord(){
        return "/back/record/editrecord";
    }

    @RequestMapping("/back/updaterecord")
    @ResponseBody
    String updaterecord(Record record){
        int flag = recordService.updaterecord(record);
        JSONObject json = new JSONObject();
        json.put("flag",flag);
        return json.toString();
    }

    @RequestMapping("/back/delrecord")
    @ResponseBody
    String delrecod(int id){
        int flag  =  recordService.delrecord(id);
        JSONObject json = new JSONObject();
        json.put("flag",flag);
        return json.toString();
    }

    /**
     * 开房登记
     * @return
     */
    @RequestMapping("/back/reservation")
    String reservation(){
        return "/back/reservation";
    }

    @RequestMapping("/back/reserve")
    @ResponseBody
    String reserve(Record record, int rtype, HttpSession session){
        Roomdata room;
        int flag;
        JSONObject json=new JSONObject();
        List<Roomdata> list = roomdataService.reserveroom(rtype);
        if(list.size()!=0){
            room = list.get(0);
            record.setRnumber(room.getRname());
            record.setPrice(room.getRprice());
            //session.setAttribute("backrecord",record);
            flag = recordService.addrecord(record);
            json.put("flag",1);
            json.put("roomnumber",room.getRname());
            return json.toString();
        }else {
            List<Roomdata> reslist =roomdataService.reservroomrecord(rtype,record);
            if(reslist.size()==0){
                json.put("flag",2);
                return json.toString();
            }else {
                room = reslist.get(0);
                record.setRnumber(room.getRname());
                record.setPrice(room.getRprice());
               // session.setAttribute("backrecord", record);
                flag = recordService.addrecord(record);
                json.put("roomnumber", room.getRname());
                json.put("flag", flag);
                return json.toString();
            }
        }
    }

    /**
     * 退订
     * @param id
     * @param ordernumber
     * @return
     */
    @RequestMapping("/back/Unsubscribe")
    @ResponseBody
    String Unsubscribe(int id,String ordernumber)throws AlipayApiException {
        Object object = refundService.refund(ordernumber);
        int flag  =  recordService.delrecord(id);
        JSONObject json = new JSONObject();
        json.put("flag",flag);
        return json.toString();
    }

    /**
     * 办理入住
     * @param id
     * @param rnumber
     * @return
     */
    @RequestMapping("/back/verifycheckin")
    @ResponseBody
    String recordshow(int id,int rnumber) {
        Record record = new Record();
        record.setId(id);
        record.setCheckin(1);
        Roomdata roomdata = roomdataService.selectpricebyrname(rnumber);
        roomdata.setRstate("入住");
        int res = recordService.updaterecord(record);
        int flag = roomdataService.roomupdate(roomdata);
        JSONObject json = new JSONObject();
        json.put("flag",flag);
        return json.toString();
    }

    /**
     * 办理退房
     */
    @RequestMapping("/back/verifycheckout")
    @ResponseBody
    String verifycheckou(int id,int rnumber) {
        Record record = new Record();
        record.setId(id);
        record.setUseable(0);
        Roomdata roomdata = roomdataService.selectpricebyrname(rnumber);
        roomdata.setRstate("待清洁");
        int res = recordService.updaterecord(record);
        int flag = roomdataService.roomupdate(roomdata);
        JSONObject json = new JSONObject();
        json.put("flag",flag);
        return json.toString();
    }


    /**
     *办理入住
     */
    @RequestMapping("/back/checkin")
    String checkin(){
        return  "/back/checkin";
    }

    /**
     * 办理退房
     */
    @RequestMapping("/back/checkout")
    String checkout(){
        return "/back/checkout";
    }

}
