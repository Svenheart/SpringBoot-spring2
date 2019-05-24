package com.cheng.lt4.service;

import com.cheng.lt4.entity.*;
import com.cheng.lt4.util.Tip;
import org.apache.poi.hssf.usermodel.HSSFAnchor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

/**
 * @program: lt4
 * @description:
 * @class; ManagerOperationService
 * @author: SanCheng
 * @create: 2018-09-21 19:11
 **/

public interface ManagerOperationService {
    Tip makeMenu(TodayMenu todayMenu);
    Tip addMenu(Menu menu);
    List<Suggestion> querySuggestion();
    List<BookMenu> queryBookMenu();
    HSSFWorkbook queryDeptSpendRecord();
    Tip setBookTime(int time);

}
