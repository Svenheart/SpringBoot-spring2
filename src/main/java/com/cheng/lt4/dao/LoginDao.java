package com.cheng.lt4.dao;

import com.cheng.lt4.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: lt4
 * @description:
 * @class; Login
 * @author: SanCheng
 * @create: 2018-09-17 20:50
 **/
@Mapper
public interface LoginDao {

    @Select(value = {"select * from staff where staffid = #{staffid}"})//默认映射
    User getUserInfo(String staffId);
    /*@Select(value = {"select * from staff"})
    @Results({@Result(column = "staffid", property = "staffId"),
            @Result(column = "password", property = "passWord"),
            @Result(column = "staffname", property = "staffName"),
            @Result(column = "age", property = "age"),
            @Result(column = "department", property = "department")})//设置映射*/

}
