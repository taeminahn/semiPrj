package com.osol.user;

public class LoginService {
	
	public int login(String id, String pw) {
		LoginDAO ld = new LoginDAO();
		int result = ld.login(id, pw);
		return result;
	}
}
