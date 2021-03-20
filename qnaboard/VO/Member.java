package com.osol.qnaboard.VO;

import java.util.Date;

public class Member {
	
	private String mbId;
	private int mbNumber;
	private String mbPassword;
	private String mbName;
	private Date mbBirthday;
	private String mbGender;
	private String mbEmail;
	private String mbPhone;
	private String mbAddress;
	private Date mbRegdate;
	private String mbGrade;
	
	public Member() {};
	
	public Member(String mbId, int mbNumber, String mbPassword, String mbName, Date mbBirthday, String mbGender,
			String mbEmail, String mbPhone, String mbAddress, Date mbRegdate, String mbGrade) {
		super();
		this.mbId = mbId;
		this.mbNumber = mbNumber;
		this.mbPassword = mbPassword;
		this.mbName = mbName;
		this.mbBirthday = mbBirthday;
		this.mbGender = mbGender;
		this.mbEmail = mbEmail;
		this.mbPhone = mbPhone;
		this.mbAddress = mbAddress;
		this.mbRegdate = mbRegdate;
		this.mbGrade = mbGrade;
	}

	public String getMbId() {
		return mbId;
	}

	public void setMbId(String mbId) {
		this.mbId = mbId;
	}

	public int getMbNumber() {
		return mbNumber;
	}

	public void setMbNumber(int mbNumber) {
		this.mbNumber = mbNumber;
	}

	public String getMbPassword() {
		return mbPassword;
	}

	public void setMbPassword(String mbPassword) {
		this.mbPassword = mbPassword;
	}

	public String getMbName() {
		return mbName;
	}

	public void setMbName(String mbName) {
		this.mbName = mbName;
	}

	public Date getMbBirthday() {
		return mbBirthday;
	}

	public void setMbBirthday(Date mbBirthday) {
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
		return "Member [mbId=" + mbId + ", mbNumber=" + mbNumber + ", mbPassword=" + mbPassword + ", mbName=" + mbName
				+ ", mbBirthday=" + mbBirthday + ", mbGender=" + mbGender + ", mbEmail=" + mbEmail + ", mbPhone="
				+ mbPhone + ", mbAddress=" + mbAddress + ", mbRegdate=" + mbRegdate + ", mbGrade=" + mbGrade + "]";
	}	
}
