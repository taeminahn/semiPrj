package com.osol.studyboard.board;

import com.osol.studyboard.VO.BoardVO;

public class BoardUpdateService {

	public BoardVO BoardUpdate(int bbsNumSeq) {
		BoardUpdateDAO bud = new BoardUpdateDAO();
		BoardVO bv = bud.BoardUpdate(bbsNumSeq);
		return bv;
	}
	
}
