package com.cheng.lt4.controller;


import com.cheng.lt4.entity.User;
import com.cheng.lt4.serviceimpl.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @program: lt4
 * @description:
 * @class; RegisterServlet
 * @author: SanCheng
 * @create: 2018-09-18 14:02
 **/
@Controller
public class RegisterServlet{

    @Autowired
    private RegisterServiceImpl registerService;

    /**
     * @Description:intoRegisterPage
     * @Param:[]
     * @return:java.lang.String
     * @Author:SanCheng
     * @Date:2018/9/30
     **/
    @PostMapping("/intoRegisterPage")
    public String intoRegisterPage(){
        return "redirect:register.html";
    }

    /**
     * @Description:checkUserName
     * @Param:[username]
     * @return:java.lang.String
     * @Author:SanCheng
     * @Date:2018/9/30
     **/
    @PostMapping("/checkUserName")
    @ResponseBody
    public String checkUserName(@RequestParam("username") String username){
        String checkBackTip=registerService.checkUserName(username);
        return checkBackTip;
    }

    /**
     * @Description:register
     * @Param:[user]
     * @return:java.lang.String
     * @Author:SanCheng
     * @Date:2018/9/30
     **/
    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user){
        String registerBackTip=registerService.register(user);
        return registerBackTip;
    }
}