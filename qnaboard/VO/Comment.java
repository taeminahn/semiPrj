package com.osol.qnaboard.VO;

import java.util.Date;

public class Comment {

	private int cmtNumber;
	private String cmtContent;
	private String cmtState;
	private String cmtWriter;
	private Date cmtPubDate;
	private int cmtBoardNumber;
	
	public Comment() {}
	
	public Comment(int cmtNumber, String cmtContent, String cmtState, String cmtWriter, Date cmtPubDate,
			int cmtBoardNumber) {
		super();
		this.cmtNumber = cmtNumber;
		this.cmtContent = cmtContent;
		this.cmtState = cmtState;
		this.cmtWriter = cmtWriter;
		this.cmtPubDate = cmtPubDate;
		this.cmtBoardNumber = cmtBoardNumber;
	}

	public int getCmtNumber() {
		return cmtNumber;
	}

	public void setCmtNumber(int cmtNumber) {
		this.cmtNumber = cmtNumber;
	}

	public String getCmtContent() {
		return cmtContent;
	}

	public void setCmtContent(String cmtContent) {
		this.cmtContent = cmtContent;
	}

	public String getCmtState() {
		return cmtState;
	}

	public void setCmtState(String cmtState) {
		this.cmtState = cmtState;
	}

	public String getCmtWriter() {
		return cmtWriter;
	}

	public void setCmtWriter(String cmtWriter) {
		this.cmtWriter = cmtWriter;
	}

	public Date getCmtPubDate() {
		return cmtPubDate;
	}

	public void setCmtPubDate(Date cmtPubDate) {
		this.cmtPubDate = cmtPubDate;
	}

	public int getCmtBoardNumber() {
		return cmtBoardNumber;
	}

	public void setCmtBoardNumber(int cmtBoardNumber) {
		this.cmtBoardNumber = cmtBoardNumber;
	}

	@Override
	public String toString() {
		return "Comment [cmtNumber=" + cmtNumber + ", cmtContent=" + cmtContent + ", cmtState=" + cmtState
				+ ", cmtWriter=" + cmtWriter + ", cmtPubDate=" + cmtPubDate + ", cmtBoardNumber=" + cmtBoardNumber
				+ "]";
	}
	
}
