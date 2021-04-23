package com.example.lagyuihotle.controller.back.JumpController;

import com.alibaba.fastjson.JSONObject;
import com.example.lagyuihotle.pojo.entity.Record;
import com.example.lagyuihotle.service.RecordService;
import com.example.lagyuihotle.service.RoomdataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

    @RequestMapping("/back/record")
    String record(){
        return "/back/record/record";
    }

    @RequestMapping("/back/recordlist")
    @ResponseBody
    String recordlist(){
        List<Record> list = recordService.recordlist();
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",15);
        obj.put("data",list);
        return obj.toString();
    }
    @RequestMapping("/back/recordlistbycid")
    @ResponseBody
    String recordlistbycid(int cid){
        List<Record> list = recordService.recordbycid(cid);
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",15);
        obj.put("data",list);
        return obj.toString();
    }

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

    @RequestMapping("/recordshow")
    @ResponseBody
    String recordshow(int id,int rnumber) {
        int time = recordService.selectprice(id)+1;
        int price = roomdataService.selectpricebyrname(rnumber);
        int  sum= time*price;
        JSONObject json = new JSONObject();
        json.put("price",sum);
        return json.toString();
    }

}
