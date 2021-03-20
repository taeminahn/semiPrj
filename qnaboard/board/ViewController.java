package com.osol.qnaboard.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osol.qnaboard.VO.Board;

@WebServlet("/qnaboard/view")
public class ViewController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.increaseBoardHit(num);
		
		Board board = new BoardDAO().getBoardDetail(num);
		
		request.setAttribute("b", board);
		
		// forward : 작업했던 내용을 처리하고 전이할 때 쓰는것
		request
		.getRequestDispatcher("/WEB-INF/qnaboard/view.jsp")
		.forward(request, response);	
		
	}
	
}
