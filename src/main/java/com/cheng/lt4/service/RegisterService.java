package com.cheng.lt4.service;

import com.cheng.lt4.entity.User;
import com.cheng.lt4.util.Tip;

/**
 * @program: lt4
 * @description:
 * @class; RegisterService
 * @author: SanCheng
 * @create: 2018-09-21 08:23
 **/
public interface RegisterService {
     String checkUserName(String username);
     String register(User user);
}
