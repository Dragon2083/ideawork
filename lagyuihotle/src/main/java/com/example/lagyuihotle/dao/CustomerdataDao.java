package com.example.lagyuihotle.dao;

import com.example.lagyuihotle.pojo.entity.Customerdata;

import java.util.List;

public interface CustomerdataDao {
    int deleteByPrimaryKey(Integer cid);

    int insert(Customerdata record);

    int insertSelective(Customerdata record);

    Customerdata selectByPrimaryKey(Integer cid);

    Customerdata selectBykey(String account);

    int updateByPrimaryKeySelective(Customerdata record);

    int updateByPrimaryKey(Customerdata record);

    List<Customerdata> allcustomer(Customerdata customerdata);
}