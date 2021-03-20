package com.osol.freeboard.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osol.freeboard.VO.BoardVO;



@WebServlet("/freeboard/detail")
public class BoardDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id_ = request.getParameter("id");
		String num_ = request.getParameter("num");
	
		BoardDAO bd = new BoardDAO();
		
		if(num_ == null && id_ != null) {
			int id = Integer.parseInt(id_);
			
			BoardVO bv = bd.getBoard(id);
			
			System.out.println(bv.getBoardId()+"겟 보드아이디");
			
			int bid = bv.getBoardId();
			
			bd.hitUpdate(bid);
			
			request.setAttribute("boardVO", bv);
			request.getRequestDispatcher("/WEB-INF/freeboard/view.jsp").forward(request, response);
		}else if(num_ != null && id_ == null) {
			int num = Integer.parseInt(num_);
			BoardVO bv = bd.getBoard(num);
			
			bv.setBoardContent(bv.getBoardContent().replace("<br>", "\r\n"));
			bv.setBoardContent(bv.getBoardContent().replace("&nbsp", " "));
			request.setAttribute("bv", bv);
			request.getRequestDispatcher("/WEB-INF/freeboard/write.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}

