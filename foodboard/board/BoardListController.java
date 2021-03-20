package com.osol.foodboard.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osol.foodboard.VO.BoardVO;



@WebServlet("/foodboard/list")
public class BoardListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");
		
		String field = "B_TITLE";
		if(field_ !=null && !field_.equals("")) {
			field = field_;
		}
		
		String query = "";
		if(query_ !=null && !query_.equals("")) {
			query = query_;
		}
		
		
		int page = 1;
		if(page_ !=null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		System.out.println(field);
		System.out.println(query);
		System.out.println(page);
		
		System.out.println("gD");
		BoardListDAO vd = new BoardListDAO();
		List<BoardVO> viewList = vd.list(field, query, page);
		
		
		request.setAttribute("viewList", viewList);
		request.getRequestDispatcher("/WEB-INF/foodboard/BoardView.jsp").forward(request, response);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
