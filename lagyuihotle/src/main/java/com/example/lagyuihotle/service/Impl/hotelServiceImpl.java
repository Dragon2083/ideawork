package com.example.lagyuihotle.service.Impl;

import com.example.lagyuihotle.dao.HoteldataDao;
import com.example.lagyuihotle.pojo.entity.Hoteldata;
import com.example.lagyuihotle.service.HotelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：dragon2082
 * @date ：Created in 2021/5/1 20:24
 */
@Service
public class hotelServiceImpl implements HotelService {

    @Resource
    HoteldataDao  hoteldataDao;

    @Override
    public int updatehoteldata(Hoteldata hoteldata) {
        return hoteldataDao.updateByPrimaryKeySelective(hoteldata);
    }

    @Override
    public Hoteldata selectbyid() {
        return hoteldataDao.selectByPrimaryKey(1);
    }
}
