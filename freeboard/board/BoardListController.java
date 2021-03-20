package com.osol.freeboard.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osol.freeboard.VO.BoardVO;
import com.osol.freeboard.VO.ListBoardVO;


@WebServlet("/freeboard/list")
public class BoardListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");
		
		
		BoardDAO bd = new BoardDAO();
		BoardService bs = new BoardService();
		
		List <ListBoardVO> list = bs.getBoardList(field_,query_,page_);
		int count = bs.getBoardCount(field_, query_);
		
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
		request.getRequestDispatcher("/WEB-INF/freeboard/board.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
