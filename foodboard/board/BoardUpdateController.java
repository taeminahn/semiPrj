package com.osol.foodboard.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/foodboard/update")
public class BoardUpdateController extends HttpServlet {
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	System.out.println("수정완료 눌러짐");
	
	String title = request.getParameter("bbsTitle");
	String content = request.getParameter("bbsContent");
	content = content.replace("\n", "<br>");
	content = content.replace(" ", "&nbsp;");
	
	String kind = request.getParameter("RtKind");
	String grade = request.getParameter("RtGrade");
	
	
	
	int num = Integer.parseInt(request.getParameter("bbsNum"));
	
	
	BoardUpdateDAO ud = new BoardUpdateDAO();
	
	String result = Integer.toString(ud.update(kind, grade, title, content, num));
	
	System.out.println(result);
	
	response.getWriter().append(result);


}


	
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}

}
