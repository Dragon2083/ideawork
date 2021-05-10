package com.example.lagyuihotle.controller.back.JumpController;

import com.example.lagyuihotle.service.CustomerdataService;
import com.example.lagyuihotle.service.RoomdataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author ：dragon2082
 * @date ：Created in 2021/3/26 4:45
 */
@Controller
public class graphcontroller {

    @Resource
    RoomdataService roomdataService;
    @Resource
    CustomerdataService customerdataService;

    @RequestMapping("/pieroom")
    String pieroom(Model model){

        int[] state = new int[10];
        state[0] = roomdataService.graphrstate("可用");
        state[1] = roomdataService.graphrstate("不可用");
        state[2] = roomdataService.graphrstate("待清洁");
        state[3] = roomdataService.graphrstate("待维修");
        state[6] = roomdataService.graphrstate("入住");
        //男女比例
        state[4] = customerdataService.countgender("男");
        state[5] = customerdataService.countgender("女");
        //房间统计
        state[7] = roomdataService.countbyrtype(1);
        state[8] = roomdataService.countbyrtype(2);
        state[9] = roomdataService.countbyrtype(3);

        model.addAttribute("states",state);
        return "/table/pieroom";
    }

}
