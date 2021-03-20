package com.osol.user;

import java.util.Date;

public class MemberVO {
	
	private String mbId;
	private int mbNum;
	private String mbPwd;
	private String mbName;
	private String mbBirthday;
	private String mbGender;
	private String mbEmail;
	private String mbPhone;
	private String mbAddress;
	private Date mbRegdate;
	private String mbGrade;
	
	public MemberVO() {
		
	}
	
	public MemberVO(String mbId, int mbNum, String mbPwd, String mbName, String mbBirthday, String mbGender,
			String mbEmail, String mbPhone, String mbAddress, Date mbRegdate, String mbGrade) {
		this.mbId = mbId;
		this.mbNum = mbNum;
		this.mbPwd = mbPwd;
		this.mbName = mbName;
		this.mbBirthday = mbBirthday;
		this.mbGender = mbGender;
		this.mbEmail = mbEmail;
		this.mbPhone = mbPhone;
		this.mbAddress = mbAddress;
		this.mbRegdate = mbRegdate;
		this.mbGrade = mbGrade;
	}

	public MemberVO(String mbId, String mbPwd, String mbName, String mbBirthday, String mbGender,
			String mbEmail, String mbPhone, String mbAddress) {
		this.mbId = mbId;
		this.mbPwd = mbPwd;
		this.mbName = mbName;
		this.mbBirthday = mbBirthday;
		this.mbGender = mbGender;
		this.mbEmail = mbEmail;
		this.mbPhone = mbPhone;
		this.mbAddress = mbAddress;
	}
	
	public String getMbId() {
		return mbId;
	}

	public void setMbId(String mbId) {
		this.mbId = mbId;
	}

	public int getMbNum() {
		return mbNum;
	}

	public void setMbNum(int mbNum) {
		this.mbNum = mbNum;
	}

	public String getMbPwd() {
		return mbPwd;
	}

	public void setMbPwd(String mbPwd) {
		this.mbPwd = mbPwd;
	}

	public String getMbName() {
		return mbName;
	}

	public void setMbName(String mbName) {
		this.mbName = mbName;
	}

	public String getMbBirthday() {
		return mbBirthday;
	}

	public void setMbBirthday(String mbBirthday) {
		this.mbBirthday = mbBirthday;
	}

	public String getMbGender() {
		return mbGender;
	}

	public void setMbGender(String mbGender) {
		this.mbGender = mbGender;
	}

	public String getMbEmail() {
		return mbEmail;
	}

	public void setMbEmail(String mbEmail) {
		this.mbEmail = mbEmail;
	}

	public String getMbPhone() {
		return mbPhone;
	}

	public void setMbPhone(String mbPhone) {
		this.mbPhone = mbPhone;
	}

	public String getMbAddress() {
		return mbAddress;
	}

	public void setMbAddress(String mbAddress) {
		this.mbAddress = mbAddress;
	}

	public Date getMbRegdate() {
		return mbRegdate;
	}

	public void setMbRegdate(Date mbRegdate) {
		this.mbRegdate = mbRegdate;
	}

	public String getMbGrade() {
		return mbGrade;
	}

	public void setMbGrade(String mbGrade) {
		this.mbGrade = mbGrade;
	}

	@Override
	public String toString() {
		return "MemberVO [mbId=" + mbId + ", mbNum=" + mbNum + ", mbPwd=" + mbPwd + ", mbName=" + mbName
				+ ", mbBirthday=" + mbBirthday + ", mbGender=" + mbGender + ", mbEmail=" + mbEmail + ", mbPhone="
				+ mbPhone + ", mbAddress=" + mbAddress + ", mbRegdate=" + mbRegdate + ", mbGrade=" + mbGrade + "]";
	}
	
	
	

}
