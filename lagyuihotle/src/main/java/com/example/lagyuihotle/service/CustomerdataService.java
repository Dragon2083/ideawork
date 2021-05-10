package com.example.lagyuihotle.service;

import com.example.lagyuihotle.pojo.entity.Customerdata;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：dragon2082
 * @date ：Created in 2021/3/28 23:28
 */

public interface CustomerdataService {

    List<Customerdata> customerlist(Customerdata customerdata);

    //删除

    int delcustomer(int cid);

    int updatecustomer(Customerdata customerdata);

    boolean flogin(Customerdata customerdata);

    Customerdata selectbyaccount(Customerdata customerdata);

    int addcustomer(Customerdata customerdata);

    int countgender(String sex);

}
