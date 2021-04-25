package com.example.lagyuihotle.dao;

import com.example.lagyuihotle.pojo.entity.Record;

import java.util.List;

public interface RecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    List<Record> allrecord(Record record);

    List<Record> recordbylist(Record record);

    List<Record> recordbydate();

    int selectprice(int id);
}