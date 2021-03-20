package com.osol.studyboard.board;

import com.osol.studyboard.VO.BoardVO;

public class BoardModifyService {
	
	public int BoardModify(int bbsNumSeq, String bbsTitle, String bbsContent) {
		
		BoardModifyDAO bmd = new BoardModifyDAO();
		System.out.println("그러면 여기냐!?");
		int result = bmd.BoardModify(bbsNumSeq, bbsTitle, bbsContent);
		System.out.println("여기니?");
		
		if(result != 1) {
			System.out.println("업데이트 실패...");
		}else {
			System.out.println("업데이트 성공");
		}
		
		return result;
	}
	
}
