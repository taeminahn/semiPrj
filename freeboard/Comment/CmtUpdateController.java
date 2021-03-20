package com.osol.freeboard.Comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/freeboard/comment/update")
public class CmtUpdateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comment = request.getParameter("comment");
		comment = comment.replace("\n", "<br>");
		comment = comment.replace(" ", "&nbsp");
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(comment+" "+num);
		
		CommentDAO cd = new CommentDAO();
		
		try {
			int result = cd.cmtUpdate(comment, num);
			System.out.println(result);
			response.getWriter().print(result);
		} catch (Exception e) {
			request.setAttribute("message", "댓글 수정에 실패했습니다!");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
