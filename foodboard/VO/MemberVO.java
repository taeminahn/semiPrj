package com.osol.foodboard.VO;

import java.util.Date;

public class MemberVO {
	
	private String memberId;
	private int memberNum;
	private String memberPwd;
	private String memberName;
	private Date memberBirthday;
	private String memberGender;
	private String memberEmail;
	private String memberPhone;
	private String memberAddress;
	private Date memberRegdate;
	private String memberGrade;
	
	public MemberVO() {}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	
	public String getmemberName() {
		return memberName;
	}
	
	public void setmemberName(String mbName) {
		this.memberName = mbName;
	}

	public Date getMemberBirthday() {
		return memberBirthday;
	}

	public void setMemberBirthday(Date memberBirthday) {
		this.memberBirthday = memberBirthday;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public Date getMemberRegdate() {
		return memberRegdate;
	}

	public void setMemberRegdate(Date memberRegdate) {
		this.memberRegdate = memberRegdate;
	}

	public String getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}

	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", memberNum=" + memberNum + ", memberPwd=" + memberPwd
				+ ", memberBirthday=" + memberBirthday + ", memberGender=" + memberGender + ", memberEmail="
				+ memberEmail + ", memberPhone=" + memberPhone + ", memberAddress=" + memberAddress + ", memberRegdate="
				+ memberRegdate + ", memberGrade=" + memberGrade + "]";
	}

	
	
	

}
