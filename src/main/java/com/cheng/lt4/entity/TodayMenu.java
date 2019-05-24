package com.cheng.lt4.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: lt4
 * @description:
 * @class; TodayMenu
 * @author: SanCheng
 * @create: 2018-09-22 09:44
 **/
public class TodayMenu {
    private String date;
    private String food1;
    private String food2;
    private String food3;
    private String food4;

    public TodayMenu(String date, String food1, String food2, String food3, String food4) {
        this.date = date;
        this.food1 = food1;
        this.food2 = food2;
        this.food3 = food3;
        this.food4 = food4;
    }

    public TodayMenu() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        this.date=simpleDateFormat.format(new Date());
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFood1() {
        return food1;
    }

    public void setFood1(String food1) {
        this.food1 = food1;
    }

    public String getFood2() {
        return food2;
    }

    public void setFood2(String food2) {
        this.food2 = food2;
    }

    public String getFood3() {
        return food3;
    }

    public void setFood3(String food3) {
        this.food3 = food3;
    }

    public String getFood4() {
        return food4;
    }

    public void setFood4(String food4) {
        this.food4 = food4;
    }
}
