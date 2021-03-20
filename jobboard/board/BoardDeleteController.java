package com.osol.jobboard.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jobBoard/delete")
public class BoardDeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dtNum = Integer.parseInt(request.getParameter("dtNum"));
		
		BoardDAO bd = new BoardDAO();
		int result = bd.delete(dtNum);
		
		if(result == 1) {
			request.getRequestDispatcher("list").forward(request, response);			
		} else {
			request.getRequestDispatcher("/WEB-INF/JobBoard/deleteError.jsp").forward(request, response);
		}
		
	}
	
	
	
}
