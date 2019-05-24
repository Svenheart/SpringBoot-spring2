package com.cheng.lt4.dao;

import com.cheng.lt4.entity.*;
import com.cheng.lt4.util.Tip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: lt4
 * @description:
 * @class; ManagerOperationDao
 * @author: SanCheng
 * @create: 2018-09-21 19:10
 **/
@Mapper
public interface ManagerOperationDao {

        @Select(value = {"select * from staffsuggestion"})
        List<Suggestion> querySuggestion();

        @Select(value = {"select * from bookmenu"})
        List<BookMenu> bookMenu();

        @Select(value = {"insert into todaymenu(date,food1,food2,food3,food4)" +
                "values(#{date},#{food1},#{food2},#{food3},#{food4})"})
        void makeMenu(TodayMenu todayMenu);

        @Select(value = {"insert into menu(id,food,price) values(#{id},#{food},#{price})"})
        void addMenu(Menu menu);

        @Select(value = {"update setbooktime set time=(#{time})"})
        void setBookTime(int time);

        @Select(value = {"select department,sum(price) as totalprice\n" +
                "from bookmenu left join staff on staff.staffid=bookmenu.staffid\n" +
                "group by department"})
        List<DepartmentSpendRecord> querySpendRecord();
}
