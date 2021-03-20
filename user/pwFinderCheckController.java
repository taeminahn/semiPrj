package com.osol.user;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/pwFinderCheck")
public class pwFinderCheckController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		
		// 입력받은 아이디와 메일을 회원정보와 비교하여 존재하지 않으면 로그인 화면으로 돌아감
		String resultEmail = new MemberDAO().pwFinder(id, email);
		if(resultEmail == null || !resultEmail.equals(email)) {
			request.getRequestDispatcher("/WEB-INF/user/pwFinderError.jsp").forward(request, response);
			return;
		} 
			// mail server 설정
			String host = "smtp.naver.com";
			String user = "zordstyle"; // 자신의 네이버 아이디
			String password = "6ZMLCR8HR4K4"; // 자신의 네이버 비밀번호
			
			// mail 받을 주소
			String to_email = resultEmail;
			
			System.out.println(to_email);
			
			// SMTP 서버 정보를 설정 - properties 사용
			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", 465);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.ssl.trust", host);
			
			// 인증 번호 생성기
			StringBuffer temp = new StringBuffer();
			Random rnd = new Random();
			for(int i=0; i<10; i++) {
				int rIndex = rnd.nextInt(3);
				switch(rIndex) {
				case 0 : 
					// a-z
					temp.append((char)((int)(rnd.nextInt(26))+97));
					break;
				case 1 :
					// A-Z
					temp.append((char)((int)(rnd.nextInt(26))+65));
					break;
				case 2 : 
					// 0-9
					temp.append((rnd.nextInt(10)));
					break;
				}
			}
			
			String AuthenticationKey = temp.toString();
			System.out.println(AuthenticationKey);
			
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});
			
			// email 전송
			try {
				
				MimeMessage msg = new MimeMessage(session);				
				msg.setFrom(new InternetAddress("zordstyle@naver.com"));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));				
				
				// 메일 제목
				msg.setSubject("안녕하세요 KH Community 인증 메일입니다.");
				// 메일 내용
				msg.setText("인증 번호는 : " + temp);
				
				Transport.send(msg);
				System.out.println("이메일 전송까지 완료!");
				
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			HttpSession saveKey = request.getSession();
			saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
			
			// 패스워드 바꿀 때 뭘 바꿀지 조건에 들어가는 id
			// - DB 쿼리 작성시 where 절에 들어갈 놈
			request.setAttribute("id", id);
			request.getRequestDispatcher("/WEB-INF/user/pwFinderEnd.jsp").forward(request, response);	
		
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
