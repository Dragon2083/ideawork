package com.example.lagyuihotle.controller.back.JumpController;

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

    @RequestMapping("/pieroom")
    String pieroom(Model model){

        int[] state = new int[4];
         state[0] = roomdataService.graphrstate("可用");
        state[1] = roomdataService.graphrstate("不可用");
        state[2] = roomdataService.graphrstate("待清洁");
        state[3] = roomdataService.graphrstate("待维修");
        model.addAttribute("states",state);
        return "/table/pieroom";
    }

}
