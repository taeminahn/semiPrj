package com.osol.qnaboard.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osol.qnaboard.VO.Board;

@WebServlet("/qnaboard/update")
public class UpdateController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		Board board = new BoardDAO().getBoardDetail(num);
		String content = board.getBbsContent();
		content = content.replace("<br>", "\r\n");
		content = content.replace(" ", "&nbsp;");
		board.setBbsContent(content);
		request.setAttribute("b", board);
		
		// forward : 작업했던 내용을 처리하고 전이할 때 쓰는것
		request
		.getRequestDispatcher("/WEB-INF/qnaboard/update.jsp")
		.forward(request, response);
	}
	
}
