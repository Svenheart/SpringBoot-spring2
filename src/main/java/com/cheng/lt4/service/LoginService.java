package com.cheng.lt4.service;

import com.cheng.lt4.util.Tip;

/**
 * @program: lt4
 * @description:
 * @class; LoginService
 * @author: SanCheng
 * @create: 2018-09-19 20:39
 **/

public interface LoginService {
    Tip check(String userName,String passWord);
}
