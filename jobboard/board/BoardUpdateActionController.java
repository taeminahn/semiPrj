package com.osol.jobboard.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osol.jobboard.VO.BoardVO;

@WebServlet("/jobBoard/updateAction")
public class BoardUpdateActionController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("bbsTitle");
		String content = request.getParameter("bbsContent");
		content = content.replace("\r\n", "<br>");
		content = content.replace(" ", "&nbsp");
		
		
		int num = Integer.parseInt(request.getParameter("bbsNum"));
				System.out.println(num);
		BoardDAO bd = new BoardDAO();
		bd.reWrite(title, content, num);
		System.out.println("여기까지는 되니?");
		
		request.getRequestDispatcher("/jobBoard/list").forward(request, response);
		
	}
}
