package com.example.lagyuihotle.dao;

import com.example.lagyuihotle.pojo.entity.Record;
import com.example.lagyuihotle.pojo.entity.Roomdata;

import java.util.Date;
import java.util.List;

public interface RoomdataDao {
    int deleteByPrimaryKey(Integer roomid);

    int insert(Roomdata record);

    int insertSelective(Roomdata record);

    Roomdata selectByPrimaryKey(Integer roomid);

    int updateByPrimaryKeySelective(Roomdata record);

    int updateByPrimaryKey(Roomdata record);

    List<Roomdata> allRoomdata(Roomdata roomdata);

    int selectrstate(String state);

    int selecttypecount(int rtype);

    List<Roomdata> selectbytype(int rtype);

    List<Roomdata> selectuseroom(int rtype);  //查询没有被预定房间

    List<Roomdata>  selectreservation(int rtype, Record rec);

    List<Roomdata> roombystate();

    int selectpricebyrname(int rname);

}