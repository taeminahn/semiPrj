package com.osol.foodboard.board;

public class BoardWriteService {

	public int write(String title, String content, String kind, String grade, String memberID) {
		BoardWriteDAO rd = new BoardWriteDAO();
		int result = rd.write(title, content, kind, grade, memberID);
		System.out.println(memberID);
		return result;
	}
	
}
