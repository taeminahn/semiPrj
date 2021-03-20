package com.osol.freeboard.VO;

import java.util.Date;

public class ListBoardVO {

	private int boardNum;
	private int boardId;
	private String boardTitle;
	private Date boardPubDate;
	private int boardHit;
	private String boardWriter;
	private int cmtCount;
	
	public ListBoardVO() {
	}

	public ListBoardVO(int boardNum, int boardId, String boardTitle, Date boardPubDate, int boardHit,
			String boardWriter, int cmtCount) {
		this.boardNum = boardNum;
		this.boardId = boardId;
		this.boardTitle = boardTitle;
		this.boardPubDate = boardPubDate;
		this.boardHit = boardHit;
		this.boardWriter = boardWriter;
		this.cmtCount = cmtCount;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
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

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public int getCmtCount() {
		return cmtCount;
	}

	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}

	@Override
	public String toString() {
		return "ListBoardVO [boardNum=" + boardNum + ", boardId=" + boardId + ", boardTitle=" + boardTitle
				+ ", boardPubDate=" + boardPubDate + ", boardHit=" + boardHit + ", boardWriter=" + boardWriter
				+ ", cmtCount=" + cmtCount + "]";
	}

	
	
}
