package com.cheng.lt4.serviceimpl;

import com.cheng.lt4.dao.LoginDao;
import com.cheng.lt4.entity.User;
import com.cheng.lt4.service.LoginService;
import com.cheng.lt4.util.Tip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: lt4
 * @description:
 * @class; LoginServiceImpl
 * @author: SanCheng
 * @create: 2018-09-19 20:46
 **/
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginDao loginDao;

    @Override
    public Tip check(String userName,String passWord) {
        User user=loginDao.getUserInfo(userName);
        if (user.getPassWord().equals(passWord)&&user.getDepartment().equals("餐饮")){
            Tip tip=new Tip(user.getStaffName(),true);
            return tip;
        }
        if(user.getPassWord().equals(passWord)){
            Tip tip=new Tip(user.getStaffName(),false);
            return tip;
        }
        return null;
    }
}
