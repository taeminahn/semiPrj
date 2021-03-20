package com.osol.freeboard.VO;

import java.util.Date;

public class CommentVO {
	private int cmtNum;
	private String cmtContent;
	private String cmtState;
	private String cmtWriter;
	private Date cmtPubdate;
	private int boardNum;
	private int cmtReplyNum;
	
	public CommentVO() {}
	
	public CommentVO(int cmtNum, String cmtContent, String cmtState, String cmtWriter, Date cmtPubdate, int boardNum,
			int cmtReplyNum) {
		this.cmtNum = cmtNum;
		this.cmtContent = cmtContent;
		this.cmtState = cmtState;
		this.cmtWriter = cmtWriter;
		this.cmtPubdate = cmtPubdate;
		this.boardNum = boardNum;
		this.cmtReplyNum = cmtReplyNum;
	}

	public int getCmtNum() {
		return cmtNum;
	}

	public void setCmtNum(int cmtNum) {
		this.cmtNum = cmtNum;
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

	public Date getCmtPubdate() {
		return cmtPubdate;
	}

	public void setCmtPubdate(Date cmtPubdate) {
		this.cmtPubdate = cmtPubdate;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public int getCmtReplyNum() {
		return cmtReplyNum;
	}

	public void setCmtReplyNum(int cmtReplyNum) {
		this.cmtReplyNum = cmtReplyNum;
	}
	
	
	
}
