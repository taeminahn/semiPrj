package com.osol.studyboard.board;

public class BoardWriteService {
	
	public int BoardWrite(String bbstitle, String bbsContent, 
			String bbsWriter) {
		
		BoardWriteDAO bwd = new BoardWriteDAO();
		int result = bwd.BoardWrite(bbstitle, bbsContent, bbsWriter);
		return result;
	}


}
