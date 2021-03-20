package com.osol.user;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.osol.jobboard.VO.BoardVO;
import com.osol.jobboard.VO.MemberVO;

@WebServlet("/withDraw")
public class withDrawController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pw = request.getParameter("userPassword");
		String id = (String) session.getAttribute("userId");

		System.out.println(id);
		System.out.println(pw+" dgdg");

		withDrawDAO wdd = new withDrawDAO();
		withDrawDAO wdd1 = new withDrawDAO();
		MemberVO result = wdd.withDraw(id);
		System.out.println(result.getMemberId());

		if (pw.equals(result.getMemberPwd())) {
			wdd1.withDrawAction(id);
			session.invalidate();
			request.getRequestDispatcher("/WEB-INF/user/withdrawSuccess.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/user/withdrawError.jsp").forward(request, response);
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
