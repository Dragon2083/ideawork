package com.example.lagyuihotle.service;


import com.example.lagyuihotle.pojo.entity.Userdata;

import java.util.List;

public interface UserdataService {

    boolean blongin(Userdata user); //判断登录

     List<Userdata> ulist(Userdata userdata);   //返回全部用户

    int udel(String id);

    Userdata usersearch(String id); //查询用户

    Integer userupdata(Userdata user); //更新数据

    Integer insertuser(Userdata user); //添加用户

}
