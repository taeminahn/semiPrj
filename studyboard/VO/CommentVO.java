package com.osol.studyboard.VO;

import java.util.Date;

public class CommentVO {
	private int cmtNumSeq;
	private String cmtContent;
	private String cmtState;
	private String cmtWriter;
	private Date cmtPubdate;
	private int bbsNumSeq;
	private int cmtCount;
	
	public CommentVO() {
		
	}
	
	public CommentVO(int cmtNumSeq, String cmtContent, String cmtState, String cmtWriter, Date cmtPubdate,
			int bbsNumSeq) {
		super();
		this.cmtNumSeq = cmtNumSeq;
		this.cmtContent = cmtContent;
		this.cmtState = cmtState;
		this.cmtWriter = cmtWriter;
		this.cmtPubdate = cmtPubdate;
		this.bbsNumSeq = bbsNumSeq;
	}

	public int getCmtNumSeq() {
		return cmtNumSeq;
	}

	public void setCmtNumSeq(int cmtNumSeq) {
		this.cmtNumSeq = cmtNumSeq;
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

	public int getBbsNumSeq() {
		return bbsNumSeq;
	}

	public void setBbsNumSeq(int bbsNumSeq) {
		this.bbsNumSeq = bbsNumSeq;
	}

	@Override
	public String toString() {
		return "CommentVO [cmtNumSeq=" + cmtNumSeq + ", cmtContent=" + cmtContent + ", cmtState=" + cmtState
				+ ", cmtWriter=" + cmtWriter + ", cmtPubdate=" + cmtPubdate + ", bbsNumSeq=" + bbsNumSeq + "]";
	}
	
	
}
