package com.osol.freeboard.board;

import java.util.List;

import com.osol.freeboard.VO.BoardVO;
import com.osol.freeboard.VO.ListBoardVO;


public class BoardService {

	public List<ListBoardVO> getBoardList(){
		
		return getBoardList("title","","1");
	}
	
	public List<ListBoardVO> getBoardList(String page){
		
		return getBoardList("title","",page);
	}
	
	public List<ListBoardVO> getBoardList(String field, String query, String page){
		
		String field_ = "B_TITLE";
		if(field != null && !field.equals("")) {
			field_ = field;	
		}
		
		String query_ = "";
		if(query != null && !query.equals("")) {
			query_ = query;
		}
		
		int page_ = 1;
		if(page != null && !page.equals("")) {
			page_ = Integer.parseInt(page);
		}
		
		BoardDAO bd = new BoardDAO();
		List <ListBoardVO> list = bd.getBoardList(field_,query_,page_);
		
		return list;
		
	}
	
	
	public int getBoardCount(String field, String query) {
		
		String field_ = "B_TITLE";
		if(field != null && !field.equals("")) {
			field_ = field;	
		}
		
		String query_ = "";
		if(query != null && !query.equals("")) {
			query_ = query;
		}
		
		BoardDAO bd = new BoardDAO();
		int count = bd.getBoardCount(field_, query_);
		System.out.println(count);
		
		return count;
		
	}
	
	
	public BoardVO getBoard(int id) {
		
		return null;
	}
	
	public BoardVO getNextBoard(int id) {
		
		return null;
	}
	
	public BoardVO getPrevBoard(int id) {
		
		return null;
	}
	
	
	
	
	
}
