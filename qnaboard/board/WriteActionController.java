package com.osol.qnaboard.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/qnaboard/writeAction")
public class WriteActionController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String title = request.getParameter("bbsTitle");
		String content = request.getParameter("bbsContent");
		content = content.replace("\r\n", "<br>");
		content = content.replace(" ", "&nbsp;");
		String writer = (String)session.getAttribute("userId");
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(title, content, writer);
		
		response.sendRedirect("/qnaboard/board");
		
	}
	
}
