package com.osol.studyboard.board;

import java.util.ArrayList;
import java.util.List;

import com.osol.studyboard.VO.BoardVO;

public class BoardListService {

	public List<BoardVO> getBoardList(String field, String query, int page){
		
		System.out.println("요기는?");
		BoardListDAO bld = new BoardListDAO();
		List<BoardVO> list = bld.BoardList(field, query, page);
		
		return list;
	}
	
	public int getNoticeCount(String field, String query) {
		
		int count = 0;
		BoardListDAO bld = new BoardListDAO();
		count = bld.getListCount(field, query);
		
		return count;
	}
}
