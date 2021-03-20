package com.osol.studyboard.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osol.studyboard.VO.BoardVO;

@WebServlet("/studyboard/update")
public class BoardUpdateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bbsNumSeq = Integer.parseInt(request.getParameter("bbsNumSeq"));
		
		BoardVO bv = new BoardVO();
		bv.setBbsNumSeq(bbsNumSeq);
		
		BoardUpdateService bus = new BoardUpdateService();
		bv = bus.BoardUpdate(bv.getBbsNumSeq());
		String content = bv.getBbsContent();
		content = content.replace("<br>", "\r\n");
		bv.setBbsContent(content);
		request.setAttribute("n", bv);
		
		request.getRequestDispatcher("/WEB-INF/studyboard/update.jsp")
		.forward(request, response);
	}
}
