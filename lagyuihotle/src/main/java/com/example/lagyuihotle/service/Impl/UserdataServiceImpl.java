package com.example.lagyuihotle.service.Impl;

import com.example.lagyuihotle.dao.UserdataDao;
import com.example.lagyuihotle.pojo.entity.Userdata;
import com.example.lagyuihotle.service.UserdataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：dragon2082
 * @date ：Created in 2021/3/4 18:26
 */
@Service  //交给spring  IOC
public class UserdataServiceImpl implements UserdataService {

    @Resource
    UserdataDao userdataDao;
        //登录判断
    @Override
    public boolean blongin(Userdata user) {

        Userdata dbuser = userdataDao.selectByPrimaryKey(user.getIdcard());
        if(dbuser == null){
            return  false;
        }else{
            if (user.getPsw() == null){
                return false;
            }
            if(user.getPsw().equals(dbuser.getPsw())){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Userdata> ulist(Userdata userdata) {
        List<Userdata>  list = userdataDao.allUserData(userdata);
        return list;
    }

    @Override
    public int udel(String id) {
        return userdataDao.deleteByPrimaryKey(id);
    }

    @Override
    public Userdata usersearch(String id) {
        return userdataDao.selectByPrimaryKey(id);
    }

    @Override
    public Integer userupdata(Userdata user) {
        return userdataDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public Integer insertuser(Userdata user) {
        return userdataDao.insertSelective(user);
    }


}
