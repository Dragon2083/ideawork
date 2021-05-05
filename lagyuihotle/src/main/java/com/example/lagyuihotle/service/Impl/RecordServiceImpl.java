package com.example.lagyuihotle.service.Impl;


import com.example.lagyuihotle.dao.RecordDao;
import com.example.lagyuihotle.pojo.entity.Record;
import com.example.lagyuihotle.service.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：dragon2082
 * @date ：Created in 2021/3/30 19:23
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Resource
    RecordDao recordDao;

    @Override
    public List<Record> recordlist(Record record) {
        return recordDao.allrecord(record);
    }

    @Override
    public List<Record> recordbycid(Record record) {
        return recordDao.recordbylist(record);
    }

    @Override
    public List<Record> recordbydate() {
        return recordDao.recordbydate();
    }

    @Override
    public int updaterecord(Record record) {
        return recordDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delrecord(int id) {
        return recordDao.deleteByPrimaryKey(id);
    }

    @Override
    public int addrecord(Record record) {
        return recordDao.insertSelective(record);
    }

    @Override
    public int selectprice(int id) {
        return recordDao.selectprice(id);
    }

}
