package com.osol.foodboard.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osol.foodboard.VO.BoardVO;


@WebServlet("/foodboard/detail")
public class BoardDetailController extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	// 수정하기
	
	String number = request.getParameter("number");

	
	if(number != null) {
		BoardDetailDAO dd = new BoardDetailDAO();
		int numb = Integer.parseInt(request.getParameter("number"));
		BoardVO dv = dd.detail(numb);
		String content = dv.getBbsContent();
		content = content.replace("<br>", "\n");
		content = content.replace("&nbsp;", " ");
		dv.setBbsContent(content);
		request.setAttribute("dv", dv);
		request.getRequestDispatcher("/WEB-INF/foodboard/BoardWrite.jsp")
		.forward(request, response);
	}

	
	
	// 목록보기
	else {
	BoardDetailDAO dd = new BoardDetailDAO();
	int num = Integer.parseInt(request.getParameter("num"));
	System.out.println(num);
	BoardVO dv = dd.detail(num);
	request.setAttribute("dv", dv);
	request.getRequestDispatcher("/WEB-INF/foodboard/BoardDetail.jsp").forward(request, response);
	}
	
	
	
}


@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
