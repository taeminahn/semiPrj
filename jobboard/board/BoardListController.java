package com.osol.jobboard.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.SetAllPropertiesRule;

import com.osol.jobboard.VO.BoardVO;

@WebServlet("/jobBoard/list")
public class BoardListController extends HttpServlet {
	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("2");
		String field_ = request.getParameter("f");
		String query_ = request.getParameter("q");
		String page_ = request.getParameter("p");
		
		String field = "B_TITLE";
		if(field_ != null && !field_.equals("")) {
			field = field_;
		}
		
		String query = "";
		if(query_ != null && !query_.equals("")) {
			query = query_;
		}
		
		int page = 1;
		if(page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		System.out.println(field);
		System.out.println(query);
		System.out.println(page);
		
		List<BoardVO> listBV = new ArrayList<>();
		BoardDAO bd = new BoardDAO();
		listBV = bd.list(field, query, page);
		
		request.setAttribute("listBV", listBV);
		
		request.getRequestDispatcher("/WEB-INF/JobBoard/board.jsp").forward(request, response);
		
		
	}
	
}
