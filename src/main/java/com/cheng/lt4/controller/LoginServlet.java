package com.cheng.lt4.controller;

import com.cheng.lt4.service.LoginService;
import com.cheng.lt4.serviceimpl.LoginServiceImpl;
import com.cheng.lt4.util.Tip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: lt4
 * @description:
 * @class; LoginServlet
 * @author: SanCheng
 * @create: 2018-09-20 10:09
 **/

@Controller
public class LoginServlet {

    @Autowired
    private LoginService loginServiceImpl;

    /**
     * @Description:login
     * @Param:[]
     * @return:java.lang.String
     * @Author:SanCheng
     * @Date:2018/9/30
     **/
    @GetMapping("/login")
    public String login(){
        return "redirect:login.html";
    }

    /**
     * @Description:loginCheck
     * @Param:[username, password, request]
     * @return:java.lang.String
     * @Author:SanCheng
     * @Date:2018/9/30
     **/
    @PostMapping("/loginCheck")
    public String loginCheck(@RequestParam("username") String username, @RequestParam("password") String password,
                             HttpServletRequest request){
        Tip tip=loginServiceImpl.check(username,password);
        request.getSession().setAttribute("username",username);
        if(tip!=null&&tip.isManager()){
            return "redirect:manageroperation.html?id="+username;
        }
        if(tip!=null){
            return "redirect:operation.html?id="+username;
        }
        return "redirect:login.html";
    }
}
