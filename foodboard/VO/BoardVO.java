package com.osol.foodboard.VO;

import java.util.Date;


public class BoardVO {

	private int bbsNum;
	private String kind;
	private String grade;
	private String bbsTitle;
	private String bbsContent;
	private Date bbsTime;
	private int bbsHit;
	private String bbsState;
	private String bbsFile;
	private String bbsWriter;
	
	public BoardVO() {}
	
	
	public BoardVO(int bbsNum, String kind, String grade, String bbsTitle, String bbsContent, Date bbsTime, int bbsHit,
			String bbsState, String bbsFile, String bbsWriter) {
		this.bbsNum = bbsNum;
		this.kind = kind;
		this.grade = grade;
		this.bbsTitle = bbsTitle;
		this.bbsContent = bbsContent;
		this.bbsTime = bbsTime;
		this.bbsHit = bbsHit;
		this.bbsState = bbsState;
		this.bbsFile = bbsFile;
		this.bbsWriter = bbsWriter;
	}
	
	
	public int getBbsNum() {
		return bbsNum;
	}
	public void setBbsNum(int bbsNum) {
		this.bbsNum = bbsNum;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	public Date getBbsTime() {
		return bbsTime;
	}
	public void setBbsTime(Date bbsTime) {
		this.bbsTime = bbsTime;
	}
	public int getBbsHit() {
		return bbsHit;
	}
	public void setBbsHit(int bbsHit) {
		this.bbsHit = bbsHit;
	}
	public String getBbsState() {
		return bbsState;
	}
	public void setBbsState(String bbsState) {
		this.bbsState = bbsState;
	}
	public String getBbsFile() {
		return bbsFile;
	}

	public String getBbsWriter() {
		return bbsWriter;
	}
	public void setBbsWriter(String bbsWriter) {
		this.bbsWriter = bbsWriter;
	}
	public void setBbsFile(String bbsFile) {
		this.bbsFile = bbsFile;
		
	}
	
	
	
}
