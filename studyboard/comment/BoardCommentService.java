package com.osol.studyboard.comment;

import java.util.List;

import com.osol.studyboard.VO.CommentVO;

public class BoardCommentService {
	
	public int BoardCommentWrite(int bbsNumSeq, String cmtWriter,
			String cmtContent) {
		BoardCommentDAO bcd = new BoardCommentDAO();
		int result = bcd.BoardCommentWriter(bbsNumSeq, cmtWriter, cmtContent);
		
		if(result != 1) {
			System.out.println("BoardCommentService_result : 댓글작성 실패");
			System.out.println("BoardCommentService_result : "+result);
		}
		
		return result;
	}

	public List<CommentVO> BoardCommentList(int bbsNumSeq){
		
		BoardCommentDAO bcd = new BoardCommentDAO();
		List<CommentVO> cmtList = bcd.BoardCommentList(bbsNumSeq);
		
		return cmtList;
	}
	
}
