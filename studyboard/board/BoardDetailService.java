package com.osol.studyboard.board;

import com.osol.studyboard.VO.BoardVO;

public class BoardDetailService {

	public BoardVO getBoardDetail(int bbsNumSeq) {
		
		BoardDetailDAO bdd = new BoardDetailDAO();
		BoardVO bv = bdd.getBoardDetail(bbsNumSeq);
		BoardDetailDAO bdd_ = new BoardDetailDAO();
		bdd_.hitUp(bbsNumSeq);
		return bv;
	}
	
}
