package com.osol.freeboard.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.osol.freeboard.VO.BoardVO;


@WebServlet("/freeboard/write")
public class BoardWriteController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		BoardDAO bd = new BoardDAO();
		
		String title = request.getParameter("bbsTitle");
		String content = request.getParameter("bbsContent");
		content = content.replace("\r\n", "<br>");
		content = content.replace(" ", "&nbsp");
		String id = (String)session.getAttribute("userId");
		String num = request.getParameter("num");
		String bid_ = request.getParameter("bid");
		
	
		if(num==null) {
			int result = bd.write(title, content, id);
			
			if(result > 0) {
			response.sendRedirect("/freeboard/list");
			} else {
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
			
		}else {
			int bid = Integer.parseInt(bid_);
			int result = bd.boardUpdate(bid, title, content);
			if(result == 1) {
				int num1 = Integer.parseInt(num);
				BoardVO bv = bd.getBoard(num1);
				
				request.setAttribute("boardVO", bv);
				request.getRequestDispatcher("/WEB-INF/freeboard/view.jsp").forward(request, response);
			}
		}								
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
