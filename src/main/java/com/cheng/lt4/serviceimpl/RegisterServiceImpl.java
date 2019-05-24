package com.cheng.lt4.serviceimpl;

import com.cheng.lt4.dao.RegisterDao;
import com.cheng.lt4.entity.User;
import com.cheng.lt4.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: lt4
 * @description:
 * @class; RegisterServiceImpl
 * @author: SanCheng
 * @create: 2018-09-21 09:00
 **/
@Service
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    private RegisterDao registerDao;

    @Override
    public String checkUserName(String username) {
        List<String> idList=registerDao.idList();
        for(String staffid:idList){
            if(staffid.equals(username)){
                return "用户名已被注册";
            }
        }
        return "用户名可以使用";
    }

    @Override
    public String register(User user) {
        if (!user.getStaffId().isEmpty()||
                !user.getPassWord().isEmpty()||
                !user.getStaffName().isEmpty()||
                !String.valueOf(user.getAge()).isEmpty()||
                !user.getDepartment().isEmpty()){
            return "注册失败";
        }
        try{
            registerDao.insert(user);
        }catch (Exception e)
        {
            return "注册失败";
        }
        return "注册成功";
    }
}
