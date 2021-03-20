package com.osol.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/idFinderCheck")
public class idFinderCheckController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phoneNum");
		String email = request.getParameter("email");
		
		String id = new MemberDAO().idFinder(name, phone, email);
				
		if(id == null) { // 찾는 아이디가 없을 시
			request.getRequestDispatcher("/WEB-INF/use	r/idFinderError.jsp").forward(request, response);
		} else { // 아이디 찾았을 시
			request.setAttribute("id", id);
			request.getRequestDispatcher("/WEB-INF/user/idFinderSuccess.jsp").forward(request, response);						
		}
		
	}
	
}
