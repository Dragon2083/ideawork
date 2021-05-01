package com.example.lagyuihotle.service;

import com.example.lagyuihotle.pojo.entity.Hoteldata;

/**
 * @author ：dragon2082
 * @date ：Created in 2021/5/1 20:24
 */
public interface HotelService {
    int  updatehoteldata(Hoteldata hoteldata);

    Hoteldata selectbyid();
}
