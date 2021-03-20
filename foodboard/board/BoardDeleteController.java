package com.osol.foodboard.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/foodboard/delete") 
public class BoardDeleteController extends HttpServlet{
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println(request.getParameter("num")+"안녕하세요");
	
	BoardDeleteDAO dd = new BoardDeleteDAO();
	
	int num = Integer.parseInt(request.getParameter("num"));
	
	
	System.out.println(dd.delete(num));
	
	request.getRequestDispatcher("/foodboard/list").forward(request, response);
	
}

@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
