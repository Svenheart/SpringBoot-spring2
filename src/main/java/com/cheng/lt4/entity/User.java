package com.cheng.lt4.entity;

/**
 * @program: lt4
 * @description: 存放用户信息
 * @class; User
 * @author: SanCheng
 * @create: 2018-09-17 20:29
 **/
public class User {
    private String staffId;
    private String passWord;
    private String staffName;
    private int age;
    private String department;

    public User(String staffId, String passWord, String staffName, int age, String department) {
        this.staffId = staffId;
        this.passWord = passWord;
        this.staffName = staffName;
        this.age = age;
        this.department = department;
    }

    public User(){}

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
