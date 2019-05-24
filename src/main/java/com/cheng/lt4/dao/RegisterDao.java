package com.cheng.lt4.dao;

import com.cheng.lt4.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: lt4
 * @description:
 * @class; RegisterService
 * @author: SanCheng
 * @create: 2018-09-19 09:30
 **/
@Mapper
public interface RegisterDao {

	@Select(value = "insert into staff(staffid,password,staffname,age,department)" +
			"values(#{staffId},#{passWord},#{staffName},#{age},#{department})")
	void insert(User user);

	@Select(value = "select staffid from staff")
	List<String> idList();

}
