package com.cheng.lt4.dao;

import com.cheng.lt4.entity.BookMenu;
import com.cheng.lt4.entity.Menu;
import com.cheng.lt4.entity.Suggestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: lt4
 * @description:
 * @class; NormalOperationDao
 * @author: SanCheng
 * @create: 2018-09-23 14:28
 **/
@Mapper
public interface NormalOperationDao {

    @Select(value = {"insert into staffsuggestion(staffid,suggestion,date) values(#{staffid},#{suggestion},#{date})"})
    void submit(Suggestion suggestion);

    @Select(value = {"select * from menu"})
    List<Menu> menu() ;

    @Select(value = {"select * from bookmenu where staffid=(#{staffId})"})
    List<BookMenu> bookMenu(String staffId);

    @Select(value = {"insert into bookmenu(staffid,menu,price,bookdate,spenddate) values(#{staffid},#{menu},#{price},#{bookdate},#{spenddate})"})
    void submitBookMenu(BookMenu bookMenu);

    @Select(value = {"select * from setbooktime"})
    int time();
}
