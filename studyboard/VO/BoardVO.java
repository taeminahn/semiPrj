package com.osol.studyboard.VO;

import java.util.Date;

public class BoardVO {

	private int bbsNumSeq;
	private String bbsTitle;
	private String bbsContent;
	private Date bbsPubDate;
	private int bbsHit;
	private String bbsState;
	private String bbsFiles;
	private String bbsWriter;
	
	public BoardVO() {
		
	}
	
	public BoardVO(int bbsNumSeq, String bbsTitle, String bbsContent, Date bbsPubDate, int bbsHit, String bbsState,
			String bbsFiles, String bbsWriter) {
		super();
		this.bbsNumSeq = bbsNumSeq;
		this.bbsTitle = bbsTitle;
		this.bbsContent = bbsContent;
		this.bbsPubDate = bbsPubDate;
		this.bbsHit = bbsHit;
		this.bbsState = bbsState;
		this.bbsFiles = bbsFiles;
		this.bbsWriter = bbsWriter;
	}

	public int getBbsNumSeq() {
		return bbsNumSeq;
	}

	public void setBbsNumSeq(int bbsNumSeq) {
		this.bbsNumSeq = bbsNumSeq;
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

	public Date getBbsPubDate() {
		return bbsPubDate;
	}

	public void setBbsPubDate(Date bbsPubDate) {
		this.bbsPubDate = bbsPubDate;
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

	public String getBbsFiles() {
		return bbsFiles;
	}

	public void setBbsFiles(String bbsFiles) {
		this.bbsFiles = bbsFiles;
	}

	public String getBbsWriter() {
		return bbsWriter;
	}

	public void setBbsWriter(String bbsWriter) {
		this.bbsWriter = bbsWriter;
	}

	@Override
	public String toString() {
		return "BoardVO [bbsNumSeq=" + bbsNumSeq + ", bbsTitle=" + bbsTitle + ", bbsContent=" + bbsContent
				+ ", bbsPubDate=" + bbsPubDate + ", bbsHit=" + bbsHit + ", bbsState=" + bbsState + ", bbsFiles="
				+ bbsFiles + ", bbsWriter=" + bbsWriter + "]";
	}
	
	
}
