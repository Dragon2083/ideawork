package com.example.lagyuihotle.service.Impl;

import com.example.lagyuihotle.dao.CustomerdataDao;
import com.example.lagyuihotle.pojo.entity.Customerdata;
import com.example.lagyuihotle.service.CustomerdataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：dragon2082
 * @date ：Created in 2021/3/28 23:29
 */
@Service
public class CustomerdataServiceImpl implements CustomerdataService {

    @Resource
    CustomerdataDao customerdataDao;

    /**
     * g顾客信息
     * @return
     */
    @Override
    public List<Customerdata> customerlist(Customerdata customerdata) {
        return customerdataDao.allcustomer(customerdata);
    }

    @Override
    public int delcustomer(int cid) {
        return customerdataDao.deleteByPrimaryKey(cid);
    }

    @Override
    public int updatecustomer(Customerdata customerdata) {
        return customerdataDao.updateByPrimaryKeySelective(customerdata);
    }

    @Override
    public boolean flogin(Customerdata customerdata) {

        Customerdata res = customerdataDao.selectBykey(customerdata.getAccount());

        if(res==null){
            return false;
        }else{
            if (customerdata.getCpsw()==null){
                return false;
            }
            if(customerdata.getCpsw().equals(res.getCpsw())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Customerdata selectbyaccount(Customerdata customerdata) {
        return customerdataDao.selectBykey(customerdata.getAccount());
    }

    @Override
    public int addcustomer(Customerdata customerdata) {
        return customerdataDao.insertSelective(customerdata);
    }


}
