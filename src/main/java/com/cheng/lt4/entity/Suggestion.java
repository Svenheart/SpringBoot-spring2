package com.cheng.lt4.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: lt4
 * @description:
 * @class; Suggestion
 * @author: SanCheng
 * @create: 2018-09-22 09:23
 **/
public class Suggestion {
    private String staffid;
    private String suggestion;
    private String date;
    public Suggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public Suggestion() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        this.date = simpleDateFormat.format(new Date());
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
