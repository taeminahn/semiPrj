package com.osol.qnaboard.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osol.qnaboard.VO.Board;

@WebServlet("/qnaboard/board")
public class BoardController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 *  검색시 url : board?f=title&query=a
		 *  검색은 필수가 아니라 옵션이기 때문에 null로 올 수 있다
		 *  이렇게 옵션으로 오는 값들에 대해서는
		 *  default 값을 지정해주는 것이 좋다.
		 */
		
		
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");
		
		
		String field = "B_TITLE";
		if(field_ != null && !field_.equals("")) field = field_;
		
		String query = "";
		if(query_ != null && !query_.equals("")) query = query_;
		
		int page = 1;
		if(page_ != null && !page_.equals("")) page = Integer.parseInt(page_);
		
		List<Board> list = new BoardDAO().getBoardList(field, query, page);
		int count = new BoardDAO().getBoardCount(field, query);
		System.out.println(count);
		request.setAttribute("list", list);
		request.setAttribute("count", count);
		
		// forward
		request
		.getRequestDispatcher("/WEB-INF/qnaboard/board.jsp")
		.forward(request, response);
	}
	
}
