package com.osol.freeboard.Comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/freeboard/comment")
public class CmtAddController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CmtService cs = new CmtService();

		String content = request.getParameter("content");
		content = content.replace("\n", "<br>");
		content = content.replace(" ", "&nbsp");
		System.out.println(content);
		String userid = request.getParameter("userid");
		String bNum = request.getParameter("bNum");
		
		try {
			int result = cs.cmtWrite(content, bNum, userid);
			response.getWriter().print(result);
		} catch (Exception e) {
			request.setAttribute("message", "댓글 등록에 실패했습니다!");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
}
