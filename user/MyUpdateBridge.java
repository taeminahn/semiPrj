package com.osol.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mypage/bidge")
public class MyUpdateBridge extends HttpServlet {

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	System.out.println("마이페이지업데이트 들름");
	request.getRequestDispatcher("/mypage").forward(request, response);
		
}

@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	
}

}
