package com.cheng.lt4.entity;

import java.util.Date;

/**
 * @program: lt4
 * @description:
 * @class; BookMenu
 * @author: SanCheng
 * @create: 2018-09-23 17:15
 **/
public class BookMenu {
    private String staffid;
    private String menu;
    private int price;
    private Date bookdate;
    private Date spenddate;

    public BookMenu(String staffid, String menu, int price, Date bookdate, Date spenddate) {
        this.staffid = staffid;
        this.menu = menu;
        this.price = price;
        this.bookdate = bookdate;
        this.spenddate = spenddate;
    }

    public BookMenu(String menu, int price, Date bookdate) {
        this.menu = menu;
        this.price = price;
        this.bookdate = bookdate;
    }

    public BookMenu() {
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getBookdate() {
        return bookdate;
    }

    public void setBookdate(Date bookdate) {
        this.bookdate = bookdate;
    }

    public Date getSpenddate() {
        return spenddate;
    }

    public void setSpenddate(Date spenddate) {
        this.spenddate = spenddate;
    }
}
