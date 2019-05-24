package com.cheng.lt4.controller;

import com.alibaba.fastjson.JSON;
import com.cheng.lt4.entity.BookMenu;
import com.cheng.lt4.entity.Menu;
import com.cheng.lt4.entity.Suggestion;
import com.cheng.lt4.service.NormalOperationService;
import com.cheng.lt4.util.Tip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: lt4
 * @description:
 * @class; NormalOperationServlet
 * @author: SanCheng
 * @create: 2018-09-23 14:22
 **/
@Controller
public class NormalOperationServlet {

    @Autowired
    private NormalOperationService normalOperationServiceImpl;

    /**
     * @Description:submitSuggestion
     * @Param:[suggestion, request]
     * @return:java.lang.String
     * @Author:SanCheng
     * @Date:2018/9/30
     **/
    @PostMapping("/submitSuggestion")
    @ResponseBody
    public String submitSuggestion(@RequestBody Suggestion suggestion,HttpServletRequest request){
        suggestion.setStaffid(String.valueOf(request.getSession().getAttribute("username")));
        Tip tip=normalOperationServiceImpl.submitSuggestion(suggestion);
        String json= JSON.toJSONString(tip.getBackTip());
        return json;
    }

    /**
     * @Description:queryMenu
     * @Param:[]
     * @return:java.lang.String
     * @Author:SanCheng
     * @Date:2018/9/30
     **/
    @PostMapping("/queryMenu")
    @ResponseBody
    public String queryMenu(){
        List<Menu> menuList=normalOperationServiceImpl.queryMenu();
        String json=JSON.toJSONString(menuList);
        return json;
    }

    /**
     * @Description:bookMenu
     * @Param:[bookMenu, request]
     * @return:java.lang.String
     * @Author:SanCheng
     * @Date:2018/9/30
     **/
    @PostMapping("/bookMenu")
    @ResponseBody
    public String bookMenu(@RequestBody BookMenu bookMenu,HttpServletRequest request){
        bookMenu.setStaffid(String.valueOf(request.getSession().getAttribute("username")));
        Tip tip=normalOperationServiceImpl.submitBookMenu(bookMenu);
        String json=JSON.toJSONString(tip.getBackTip());
        return json;
    }

    /**
     * @Description:queryBookMenuById
     * @Param:[request]
     * @return:java.lang.String
     * @Author:SanCheng
     * @Date:2018/9/30
     **/
    @PostMapping("/queryBookMenuById")
    @ResponseBody
    public String queryBookMenuById(HttpServletRequest request){
    	List<BookMenu> bookMenuList=normalOperationServiceImpl.queryMenuById(String.valueOf(request.getSession().getAttribute("username")));
    	String json=JSON.toJSONString(bookMenuList);
    	return json;
    }
}
