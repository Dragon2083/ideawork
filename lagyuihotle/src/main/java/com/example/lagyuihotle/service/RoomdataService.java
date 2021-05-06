package com.example.lagyuihotle.service;

import com.example.lagyuihotle.pojo.entity.Record;
import com.example.lagyuihotle.pojo.entity.Roomdata;

import java.util.Date;
import java.util.List;

/**
 * @author ：dragon2082
 * @date ：Created in 2021/3/23 13:55
 */
public interface RoomdataService {

    List<Roomdata> roomlist(Roomdata roomdata);  //查询房间列表

    int roomdel(int id);

    int roomadd(Roomdata roomdata);

    int roomupdate(Roomdata roomdata);

    int graphrstate(String state);

    int Availablerooms(int type);

    List<Roomdata> resroomlist(int type);  //更具房间类型查看可用房间

    List<Roomdata> reserveroom(int type);  //预定没有预定的房间

    List<Roomdata> reservroomrecord(int rtype, Record record);

    List<Roomdata> roombystate(); //首页的当前要处理的房间

    Roomdata selectpricebyrname(int rname);
}
