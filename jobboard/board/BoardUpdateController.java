package com.osol.jobboard.board;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osol.jobboard.VO.BoardVO;

@WebServlet("/jobBoard/update")
public class BoardUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int udNum = Integer.parseInt(request.getParameter("udNum"));
		
		BoardDAO bd = new BoardDAO();
		BoardVO bv = bd.update(udNum);
		
		request.setAttribute("n", bv);
		request.getRequestDispatcher("/WEB-INF/JobBoard/update.jsp").forward(request, response);
	}
	
}
