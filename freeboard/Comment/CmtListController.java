package com.osol.freeboard.Comment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;


@WebServlet("/freeboard/comment/list")
public class CmtListController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommentDAO cd = new CommentDAO();
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		System.out.println(boardNum +"왔냐?");
		
		JsonArray json = cd.getCommentList(boardNum);
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("cache-control", "no-cache,no-store");
		PrintWriter out = response.getWriter();
		out.print(json);
		System.out.println(json);
	}
}
