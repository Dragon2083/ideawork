package com.example.lagyuihotle.service.Impl;

import com.example.lagyuihotle.dao.RoomdataDao;
import com.example.lagyuihotle.pojo.entity.Record;
import com.example.lagyuihotle.pojo.entity.Roomdata;
import com.example.lagyuihotle.service.RoomdataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ：dragon2082
 * @date ：Created in 2021/3/23 14:00
 */
@Service
public class RoomdataServiceImpl implements RoomdataService {

    @Resource
    RoomdataDao roomdataDao;

    @Override
    public List<Roomdata> roomlist(Roomdata roomdata) {
        return roomdataDao.allRoomdata(roomdata);
    }  //返回房间列表

    @Override
    public int roomdel(int id) {
        return roomdataDao.deleteByPrimaryKey(id);
    } //删除房间

    @Override
    public int roomadd(Roomdata roomdata) {
        return roomdataDao.insertSelective(roomdata);
    }    //添加房间

    @Override
    public int roomupdate(Roomdata roomdata) {
        return roomdataDao.updateByPrimaryKeySelective(roomdata);
    }

    @Override
    public int graphrstate(String state) {
        return roomdataDao.selectrstate(state);
    }

    @Override
    public int Availablerooms(int type) {
        return roomdataDao.selecttypecount(type);
    }

    @Override
    public List<Roomdata> resroomlist(int type) {
        return roomdataDao.selectbytype(type);
    }

    @Override
    public List<Roomdata> reserveroom(int type) {
        return roomdataDao.selectuseroom(type);
    }

    @Override
    public List<Roomdata> reservroomrecord(int rtype, Record record) {
        List<Roomdata> list = roomdataDao.selectreservation(rtype,record);
        return roomdataDao.selectreservation(rtype,record);
    }

    @Override
    public List<Roomdata> roombystate() {
        return roomdataDao.roombystate();
    }

    @Override
    public int selectpricebyrname(int rname) {
        return roomdataDao.selectpricebyrname(rname);
    }


}
