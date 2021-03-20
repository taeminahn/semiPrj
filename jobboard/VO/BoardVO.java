package com.osol.jobboard.VO;

import java.util.Date;

public class BoardVO {

	private int boardNum;
	private String boardTitle;
	private String boardContent;
	private Date boardPubDate;
	private int boardHit;
	private String boardState;
	private String boardFiles;
	private String boardWriter;
	
	public BoardVO() {}

	public BoardVO(int boardNum, String boardTitle, String boardContent, Date boardPubDate, int boardHit,
			String boardState, String boardFiles, String boardWriter) {
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardPubDate = boardPubDate;
		this.boardHit = boardHit;
		this.boardState = boardState;
		this.boardFiles = boardFiles;
		this.boardWriter = boardWriter;
	}

	@Override
	public String toString() {
		return "BoardVO [boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardPubDate=" + boardPubDate + ", boardHit=" + boardHit + ", boardState=" + boardState
				+ ", boardFiles=" + boardFiles + ", boardWriter=" + boardWriter + "]";
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getBoardPubDate() {
		return boardPubDate;
	}

	public void setBoardPubDate(Date boardPubDate) {
		this.boardPubDate = boardPubDate;
	}

	public int getBoardHit() {
		return boardHit;
	}

	public void setBoardHit(int boardHit) {
		this.boardHit = boardHit;
	}

	public String getBoardState() {
		return boardState;
	}

	public void setBoardState(String boardState) {
		this.boardState = boardState;
	}

	public String getBoardFiles() {
		return boardFiles;
	}

	public void setBoardFiles(String boardFiles) {
		this.boardFiles = boardFiles;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	} 
	
	
}
