package com.cheng.lt4.controller;

import com.alibaba.fastjson.JSON;
import com.cheng.lt4.entity.Menu;
import com.cheng.lt4.entity.Suggestion;
import com.cheng.lt4.entity.TodayMenu;
import com.cheng.lt4.service.ManagerOperationService;
import com.cheng.lt4.util.Tip;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @program: lt4
 * @description:
 * @class; ManagerOperationServlet
 * @author: SanCheng
 * @create: 2018-09-21 19:10
 **/
@Controller
public class ManagerOperationServlet {

    @Autowired
    private ManagerOperationService managerOperationServiceImpl;

    /**
     * @Description:makeMenu
     * @Param:[todayMenu]
     * @return:java.lang.String
     * @Author:SanCheng
     * @Date:2018/9/30
     **/
    @PostMapping("/makeMenu")
    @ResponseBody
    public String makeMenu(@RequestBody TodayMenu todayMenu){
        Tip tip=managerOperationServiceImpl.makeMenu(todayMenu);
        String json=JSON.toJSONString(tip.getBackTip());
        return json;
    }
    /**
     * @Description:addMenu
     * @Param:[menu]
     * @return:java.lang.String
     * @Author:SanCheng
     * @Date:2018/9/30
     **/
    @PostMapping("/addMenu")
    @ResponseBody
    public String addMenu(@RequestBody Menu menu){
        Tip tip=managerOperationServiceImpl.addMenu(menu);
        String json=JSON.toJSONString(tip.getBackTip());
        return json;
    }

    /**
     * @Description:querySuggestion
     * @Param:[]
     * @return:java.lang.String
     * @Author:SanCheng
     * @Date:2018/9/30
     **/
    @PostMapping("/querySuggestion")
    @ResponseBody
    public String querySuggestion(){
        List<Suggestion> suggestionList=managerOperationServiceImpl.querySuggestion();
        String json=JSON.toJSONString(suggestionList);
        return json;
    }

    /**
     * @Description:setBookTime
     * @Param:[time]
     * @return:java.lang.String
     * @Author:SanCheng
     * @Date:2018/9/30
     **/
    @PostMapping("/setBookTime")
    @ResponseBody
    public String setBookTime(@RequestBody int time){
        Tip tip=managerOperationServiceImpl.setBookTime(time);
        String json=JSON.toJSONString(tip.getBackTip());
        return json;
    }

    /**
     * @Description:queryBookMenu
     * @Param:[]
     * @return:java.lang.String
     * @Author:SanCheng
     * @Date:2018/9/30
     **/
    @PostMapping("/queryBookMenu")
    @ResponseBody
    public String queryBookMenu(){
        String json=JSON.toJSONString(managerOperationServiceImpl.queryBookMenu());
        return json;
    }

    /**
     * @Description:downloadSpendXLS
     * @Param:[response]
     * @return:void
     * @Author:SanCheng
     * @Date:2018/9/30
     **/
    @PostMapping("/downloadSpendXLS")
    public void downloadSpendXLS(HttpServletResponse response){
        HSSFWorkbook wb=managerOperationServiceImpl.queryDeptSpendRecord();
        try {
            response.setHeader("content-disposition", "attachment;filename=SpendRecord.xls");
            OutputStream outputStream=response.getOutputStream();
            wb.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
