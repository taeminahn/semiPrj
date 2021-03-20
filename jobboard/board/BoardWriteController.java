package com.osol.jobboard.board;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/jobBoard/write")
public class BoardWriteController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String title = request.getParameter("bbsTitle");
		String content = request.getParameter("bbsContent");
		content = content.replace("\r\n", "<br>");
		content = content.replace(" ", "&nbsp");
		String id = (String)session.getAttribute("userId");

		BoardDAO bd = new BoardDAO();
		bd.write(title, content, id);

		response.sendRedirect("/jobBoard/list");
		//		request.getRequestDispatcher("/WEB-INF/JobBoard/board.jsp").forward(request, response);
		//		request.getRequestDispatcher("BoardListController").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
