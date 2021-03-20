package com.osol.studyboard.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osol.studyboard.VO.BoardVO;

@WebServlet("/studyboard/delete")
public class BoardDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
		
	};
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		
		int bbsNumSeq = Integer.parseInt(request.getParameter("bbsNumSeq"));
		System.out.println(bbsNumSeq);
		
		
		BoardVO bv = new BoardVO();
		bv.setBbsNumSeq(bbsNumSeq);
		
		BoardDeleteService bds = new BoardDeleteService();
		int result = bds.BoardDelete(bv.getBbsNumSeq());
		
		if(result == 1) {
			System.out.println("게시판 글 삭제 완료!!");
		}else {
			System.out.println("실패.. 문제점을 찾아보시오..ㅗㅗ");
		}
		
		request.getRequestDispatcher("/studyboard/list")
		.forward(request, response);
	};

		
	
}
