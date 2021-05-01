package com.example.lagyuihotle.dao;

import com.example.lagyuihotle.pojo.entity.Hoteldata;

public interface HoteldataDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Hoteldata record);

    int insertSelective(Hoteldata record);

    Hoteldata selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hoteldata record);

    int updateByPrimaryKey(Hoteldata record);
}