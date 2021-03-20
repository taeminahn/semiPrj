package com.osol.qnaboard.VO;

import java.util.Date;

public class Board {
	
	private int bbsNumber;
	private String bbsTitle;
	private String bbsWriter;
	private String bbsContent;
	private Date bbsPubdate;
	private int bbsHit;
	private String bbsState;
	private String bbsAttachedFile;
	
	public Board() {}
	
	public Board(int bbsNumber, String bbsTitle, String bbsWriter, String bbsContent, Date bbsPubdate, int bbsHit, String bbsState,
			String bbsAttachedFile) {
		this.bbsNumber = bbsNumber;
		this.bbsTitle = bbsTitle;
		this.bbsContent = bbsContent;
		this.bbsPubdate = bbsPubdate;
		this.bbsHit = bbsHit;
		this.bbsState = bbsState;
		this.bbsAttachedFile = bbsAttachedFile;
		this.bbsWriter = bbsWriter;
	}
	
	public int getBbsNumber() {
		return bbsNumber;
	}
	
	public void setBbsNumber(int bbsNumber) {
		this.bbsNumber = bbsNumber;
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

	public Date getBbsPubdate() {
		return bbsPubdate;
	}

	public void setBbsPubdate(Date bbsPubdate) {
		this.bbsPubdate = bbsPubdate;
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

	public String getBbsAttachedFile() {
		return bbsAttachedFile;
	}

	public void setBbsAttachedFile(String bbsAttachedFile) {
		this.bbsAttachedFile = bbsAttachedFile;
	}

	public String getBbsWriter() {
		return bbsWriter;
	}

	public void setBbsWriter(String bbsWriter) {
		this.bbsWriter = bbsWriter;
	}

	@Override
	public String toString() {
		return "Board [bbsNumber=" + bbsNumber + ", bbsTitle=" + bbsTitle + ", bbsWriter=" + bbsWriter + ", bbsContent="
				+ bbsContent + ", bbsPubdate=" + bbsPubdate + ", bbsHit=" + bbsHit + ", bbsState=" + bbsState
				+ ", bbsAttachedFile=" + bbsAttachedFile + "]";
	}	
	
}
