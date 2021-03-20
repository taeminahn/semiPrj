package com.osol.qnaboard.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/qnaboard/updateAction")
public class UpdateActionController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("bbsTitle");
		String content = request.getParameter("bbsContent");
		content = content.replace("\r\n", "<br>");
		content = content.replace(" ", "&nbsp;");
		int num = Integer.parseInt(request.getParameter("num"));
		
		// redirect : 아예 다른 페이지로 가버리는 것	
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.UpdateBoard(num, title, content);
		
		response.sendRedirect("/qnaboard/board");
		
	}
	
}
