package com.cheng.lt4.serviceimpl;

import com.cheng.lt4.dao.NormalOperationDao;
import com.cheng.lt4.entity.BookMenu;
import com.cheng.lt4.entity.Menu;
import com.cheng.lt4.entity.Suggestion;
import com.cheng.lt4.service.NormalOperationService;
import com.cheng.lt4.util.Tip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @program: lt4
 * @description:
 * @class; NormolOperationServiceImpl
 * @author: SanCheng
 * @create: 2018-09-21 19:13
 **/
@Service
public class NormalOperationServiceImpl implements NormalOperationService{

    @Autowired
    private NormalOperationDao normalOperationDao;

    @Override
    public Tip submitSuggestion(Suggestion suggestion) {
        Tip tip=new Tip("创建失败");
        try {
            normalOperationDao.submit(suggestion);
        }catch (Exception e){
            return tip;
        }
        tip.setBackTip("创建成功");
        return tip;
    }

    @Override
    public List<Menu> queryMenu() {
        List<Menu> menuList=normalOperationDao.menu();
        return menuList;
    }

	@Override
	public List<BookMenu> queryMenuById(String staffId) {
    	List<BookMenu> bookMenuList=normalOperationDao.bookMenu(staffId);
		return bookMenuList;
	}

	@Override
    public Tip submitBookMenu(BookMenu bookMenu) {
        Tip tip=new Tip("订餐失败");
        try{
	        int time=queryBookTime();
	        Calendar calendar=Calendar.getInstance();
	        calendar.setTime(new Date());
	        calendar.add(Calendar.DATE,time);
	        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
	        String date1=simpleDateFormat.format(bookMenu.getBookdate());
	        String date2=simpleDateFormat.format(calendar.getTime());
	        if(bookMenu.getStaffid().equals("null")){
	        	return tip;
	        }
	        if(date1.equals(date2)){
		        tip.setBackTip("订餐成功");
		        bookMenu.setSpenddate(new Date());
		        normalOperationDao.submitBookMenu(bookMenu);
	        }
        }catch (Exception e){
        	e.printStackTrace();
        }
        return tip;
    }

    @Override
    public int queryBookTime() {
        int time=normalOperationDao.time();
        return time;
    }
}
