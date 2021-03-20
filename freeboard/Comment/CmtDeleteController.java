package com.osol.freeboard.Comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/freeboard/comment/delete")
public class CmtDeleteController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int num = Integer.parseInt(request.getParameter("num"));
		int depth = Integer.parseInt(request.getParameter("depth"));
		
		CommentDAO cd = new CommentDAO();
		int result = cd.getReplyNum(num);
		if(depth == 1) {
			try {
				int delete = cd.cmtDelete(2, num);
				response.getWriter().print(delete);
			} catch (Exception e) {
				request.setAttribute("message", "댓글 삭제에 실패했습니다!");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
				e.printStackTrace();
			}
		}else {
			try {
				int delete = cd.cmtDelete(1, num);
				response.getWriter().print(delete);
			} catch (Exception e) {
				request.setAttribute("message", "댓글 삭제에 실패했습니다!");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
				e.printStackTrace();
			}
		}
	
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
