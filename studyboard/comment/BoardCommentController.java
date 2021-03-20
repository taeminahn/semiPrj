package com.osol.studyboard.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.osol.studyboard.VO.CommentVO;

@WebServlet("/studyboard/comment")
public class BoardCommentController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String cmtWriter = (String)session.getAttribute("userId");
		String cmtContent = request.getParameter("cmtContent");
		int bbsNumSeq = Integer.parseInt(request.getParameter("bbsNumSeq"));
		cmtContent = cmtContent.replace("\r\n", "<br>");
		cmtContent = cmtContent.replace(" ", "&nbsp");
		
		
		System.out.println("cmtWriter : "+cmtWriter);
		System.out.println("cmtConten : "+cmtContent);
		System.out.println("bbsNumSeq : "+bbsNumSeq);
		
		CommentVO cv = new CommentVO();
		cv.setBbsNumSeq(bbsNumSeq);
		cv.setCmtWriter(cmtWriter);
		cv.setCmtContent(cmtContent);
		
		BoardCommentService bcs = new BoardCommentService();
		int result = bcs.BoardCommentWrite(bbsNumSeq, cmtWriter, cmtContent);
		
		request.getRequestDispatcher("/studyboard/detail")
		.forward(request, response);
		
	}
}
