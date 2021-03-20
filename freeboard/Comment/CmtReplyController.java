package com.osol.freeboard.Comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/freeboard/reply")
public class CmtReplyController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String originId = request.getParameter("originid");
		int cmtNum = Integer.parseInt(request.getParameter("cmtnum"));
		int boardNum = Integer.parseInt(request.getParameter("boardnum"));
		String uId = request.getParameter("uId");
		String comment = request.getParameter("comment");
		comment = comment.replace("\n", "<br>");
		comment = comment.replace(" ", "&nbsp");
		
		CommentDAO cd = new CommentDAO();
		try {
			int result = cd.replyAdd(originId, cmtNum, boardNum, uId, comment);
			response.getWriter().print(result);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "답글 드록에 실패했습니다!");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
}
