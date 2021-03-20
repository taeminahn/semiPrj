package com.osol.user;


public class JoinMemberService {
	
	public int join(MemberVO mv) {
		
		JoinMemberDAO jmDAO = new JoinMemberDAO();
		int result = jmDAO.join(mv);
		if(result == 1) {
			System.out.println("회원가입 성공!");
		}else {
			System.out.println("회원가입 실패!");
		}
		return result;
	}
}

