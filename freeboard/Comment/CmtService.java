package com.osol.freeboard.Comment;

public class CmtService {

	public int cmtWrite(String content, String bNum, String id) throws Exception {
		
		int result = 0;
		CommentDAO cd = new CommentDAO();
		int num = Integer.parseInt(bNum);
		result = cd.cmtWrite(id, num, content);
		return result;
		
	}
}
