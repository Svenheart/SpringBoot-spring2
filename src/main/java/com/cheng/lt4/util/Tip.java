package com.cheng.lt4.util;

import java.util.Date;

/**
 * @program: lt4
 * @description:
 * @class; Tip
 * @author: SanCheng
 * @create: 2018-09-19 20:55
 **/
public class Tip {

	private String userName;
	private String passWord;
	private String staffName;
	private boolean isManager;
	private String backTip;
	private int time;

	public Tip(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}

	public Tip(String staffName, boolean isManager) {
		this.staffName = staffName;
		this.isManager = isManager;
	}

	public Tip(int day) {
		this.time = day;
	}

	public Tip(String backTip) {
		this.backTip = backTip;
	}

	public int getDay() {
		return time;
	}

	public void setDay(int day) {
		this.time = day;
	}


	public String getBackTip() {
		return backTip;
	}

	public void setBackTip(String backTip) {
		this.backTip = backTip;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean manager) {
		isManager = manager;
	}
}
