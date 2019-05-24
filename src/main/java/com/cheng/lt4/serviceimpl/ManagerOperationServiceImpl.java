package com.cheng.lt4.serviceimpl;

import com.cheng.lt4.dao.ManagerOperationDao;
import com.cheng.lt4.entity.*;
import com.cheng.lt4.service.ManagerOperationService;
import com.cheng.lt4.util.Tip;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: lt4
 * @description:
 * @class; ManagerOperationServiceImpl
 * @author: SanCheng
 * @create: 2018-09-21 19:12
 **/
@Service
public class ManagerOperationServiceImpl implements ManagerOperationService{

    @Autowired
    private ManagerOperationDao managerOperationDao;

    @Override
    public Tip makeMenu(TodayMenu todayMenu) {
        Tip tip=new Tip("创建失败");
        try {
            managerOperationDao.makeMenu(todayMenu);
        }catch (Exception e){
            return tip;
        }
        tip.setBackTip("创建成功");
        return tip;
    }

    @Override
    public Tip addMenu(Menu menu) {
        Tip tip=new Tip("创建失败");
        try {
            managerOperationDao.addMenu(menu);
        }catch (Exception e){
            return tip;
        }
        tip.setBackTip("创建成功");
        return tip;
    }

    @Override
    public List<Suggestion> querySuggestion() {
        List<Suggestion> suggestionList=managerOperationDao.querySuggestion();
        return suggestionList;
    }

    @Override
    public List<BookMenu> queryBookMenu() {
        List<BookMenu> bookMenuList=managerOperationDao.bookMenu();
        return bookMenuList;
    }

    @Override
    public HSSFWorkbook queryDeptSpendRecord() {
        List<DepartmentSpendRecord> departmentSpendRecordList=managerOperationDao.querySpendRecord();
        HSSFWorkbook wb=new HSSFWorkbook();//生成Excel
        HSSFSheet sheet=wb.createSheet("部门消费情况");//新建工作簿
        HSSFRow row=sheet.createRow(0);
        HSSFCellStyle style=wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        HSSFCell cell=row.createCell(0);
        cell.setCellValue("部门");
        cell.setCellStyle(style);
        cell=row.createCell(1);
        cell.setCellValue("总支出");
        cell.setCellStyle(style);
        for (int i=0;i<departmentSpendRecordList.size();i++){
            row=sheet.createRow(i+1);
            DepartmentSpendRecord departmentSpendRecord=departmentSpendRecordList.get(i);
            row.createCell(0).setCellValue(departmentSpendRecord.getDepartment());
            row.createCell(1).setCellValue(departmentSpendRecord.getTotalprice());
        }
        return wb;
    }

    @Override
    public Tip setBookTime(int time) {
        Tip tip=new Tip("设置失败");
        try {
            tip.setDay(time);
            managerOperationDao.setBookTime(time);
        }catch (Exception e){
            return tip;
        }
        tip.setBackTip("设置成功");
        return tip;
    }


}
