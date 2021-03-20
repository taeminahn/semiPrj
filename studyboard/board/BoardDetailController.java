package com.osol.studyboard.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osol.studyboard.VO.BoardVO;
import com.osol.studyboard.VO.CommentVO;
import com.osol.studyboard.comment.BoardCommentService;

@WebServlet("/studyboard/detail")
public class BoardDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bbsNumSeq = Integer.parseInt(request.getParameter("bbsNumSeq"));
		String page_ = request.getParameter("p");
		System.out.println("BoardDetail_pageNum : "+page_);
		
		int page = 1;
		if(page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		
		BoardDetailService bds = new BoardDetailService();
		BoardVO bv = bds.getBoardDetail(bbsNumSeq);
		BoardCommentService bcs = new BoardCommentService();
		List<CommentVO> cmtList = bcs.BoardCommentList(bbsNumSeq);
		
		request.setAttribute("cmtList", cmtList);
		request.setAttribute("n", bv);
		request.setAttribute("p", page);
		request.getRequestDispatcher("/WEB-INF/studyboard/view.jsp")
		.forward(request, response);
		
		
	}
}
