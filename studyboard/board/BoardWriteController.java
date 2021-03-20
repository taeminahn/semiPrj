package com.osol.studyboard.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.osol.studyboard.VO.BoardVO;

@WebServlet("/studyboard/write")
public class BoardWriteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String title = request.getParameter("bbsTitle");
		String content = request.getParameter("bbsContent");
		String id = (String)session.getAttribute("userId");
		content = content.replace("\r\n", "<br>");
		content = content.replace(" ", "&nbsp");
		
		System.out.println(title);
		System.out.println(content);
		System.out.println(id);
		
		BoardVO bbsVO = new BoardVO();
		bbsVO.setBbsTitle(title);
		bbsVO.setBbsContent(content);
		bbsVO.setBbsWriter(id);
		
		BoardWriteService bws = new BoardWriteService();
		int result = bws.BoardWrite(title, content, id);

		System.out.println("컨트롤러 result : " + result);
		
		if(result == 1) {
			System.out.println("게시판 글 작성 완료!!");
			
		}
		request.getRequestDispatcher("/studyboard/list").forward(request, response);
//		response.sendRedirect("/studyboard/list");
//		request.getRequestDispatcher("boardList.kh")
//		.forward(request, response);
		
	}
}
