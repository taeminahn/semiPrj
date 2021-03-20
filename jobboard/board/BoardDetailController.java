package com.osol.jobboard.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osol.jobboard.VO.BoardVO;

@WebServlet("/jobBoard/detail")
public class BoardDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bdNum = Integer.parseInt(request.getParameter("bdNum"));
		
		BoardDAO bd = new BoardDAO();
		BoardVO bv = bd.detail(bdNum);
		
		request.setAttribute("n", bv);
		request.getRequestDispatcher("/WEB-INF/JobBoard/view.jsp").forward(request, response);
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요기");
		doGet(request, response);
	}
	
	
}
