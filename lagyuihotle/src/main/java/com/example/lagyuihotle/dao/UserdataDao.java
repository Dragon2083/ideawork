package com.example.lagyuihotle.dao;

import com.example.lagyuihotle.pojo.entity.Userdata;

import java.util.List;

public interface UserdataDao {
    int deleteByPrimaryKey(String idcard);

    int insert(Userdata record);

    int insertSelective(Userdata record);

    Userdata selectByPrimaryKey(String idcard);

    int updateByPrimaryKeySelective(Userdata record);

    int updateByPrimaryKey(Userdata record);

    List<Userdata> allUserData(Userdata userdata);

    //int insertall(Userdata recod);
}