package com.osol.studyboard.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osol.studyboard.VO.BoardVO;

@WebServlet("/studyboard/modify")
public class BoardModifyController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * System.out.println(request.getParameter("cancel"));
		 * 
		 * if(request.getParameter("cancel")=="취소") {
		 * request.getRequestDispatcher("boardDeail.kh").forward(request, response);
		 * return; }
		 */
		int bbsNumSeq = Integer.parseInt(request.getParameter("bbsNumSeq"));
		String bbsTitle = request.getParameter("bbsTitle");
		String bbsContent = request.getParameter("bbsContent");
		bbsContent = bbsContent.replace("\r\n", "<br>");
		bbsContent = bbsContent.replace(" ", "&nbsp");
		
		String page_ = request.getParameter("p");
		System.out.println(page_);
		
		int page = 1;
		if(page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		
		System.out.println(bbsNumSeq);
		System.out.println(bbsTitle);
		System.out.println(bbsContent);
		
		
		/*BoardVO bv = new BoardVO();
		bv.setBbsTitle(bbsTitle);
		bv.setBbsContent(bbsContent);*/
		
		BoardModifyService bms = new BoardModifyService();
		System.out.println("여긴!!!?");
		int result = bms.BoardModify(bbsNumSeq, bbsTitle, bbsContent);
		System.out.println("여기냐...");
		
		request.setAttribute("p", page);
		request.getRequestDispatcher("/studyboard/detail")
		.forward(request, response);
		
		
	}
	
}
