package com.example.lagyuihotle.service;

import com.example.lagyuihotle.pojo.entity.Record;

import java.util.List;

/**
 * @author ：dragon2082
 * @date ：Created in 2021/3/30 19:22
 */
public interface RecordService {

    List<Record> recordlist(Record record);

    List<Record> recordbycid(int cid);

    List<Record> recordbydate();

    int updaterecord(Record record);

    int delrecord(int id);

    int addrecord(Record record); //添加预定

    int selectprice(int id);
}
