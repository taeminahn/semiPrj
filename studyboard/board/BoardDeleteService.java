package com.osol.studyboard.board;

public class BoardDeleteService {
	
	public int BoardDelete(int bbsNumSeq) {
		
		BoardDeleteDAO bdd = new BoardDeleteDAO();
		int result = bdd.BoardDelete(bbsNumSeq);
		return result;
	}
	
}
