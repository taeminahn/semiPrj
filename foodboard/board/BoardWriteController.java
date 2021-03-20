package com.osol.foodboard.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/foodboard/write")
public class BoardWriteController extends HttpServlet{
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("writeController로 넘어옴");
	
		HttpSession session = request.getSession();
		String memberID = (String)session.getAttribute("userId");
		
		String title = request.getParameter("bbsTitle");
		String content = request.getParameter("bbsContent");
		content = content.replace("\n", "<br>");
		content = content.replace(" ", "&nbsp;");
		
		String kind = request.getParameter("RtKind");
		String grade = request.getParameter("RtGrade");
		
		System.out.println(memberID);
		
		BoardWriteService ws = new BoardWriteService();
		String result = Integer.toString(ws.write(title, content, kind, grade, memberID));
		
		response.getWriter().append(result);
}

@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
