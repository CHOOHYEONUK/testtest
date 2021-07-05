package com.tech.controller.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.controller.disp.Controller;
import com.tech.crypt.work.BCrypt;
import com.tech.crypt.work.SHA256;
import com.tech.db.DBCon;

public class FamilyMemberJoinProcController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FamilyMemberJoinProcController");
		
		//DB연결
		Connection con = DBCon.getConnection();
		
		String fname = request.getParameter("fname");
		String fpwd = request.getParameter("fpass");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		//1차암호화
		SHA256 sha = SHA256.getInsatnce();
		String shaPwd = sha.getSha256(fpwd.getBytes());
		
		//2차암호화
		String bcPwd = BCrypt.hashpw(shaPwd, BCrypt.gensalt());
		
		//인증확인
		System.out.println("인증확인 : "+BCrypt.checkpw(shaPwd, bcPwd));
		
		//insert
		String sql = "insert into familymember(fname,fpass,shpwd,bcpwd) values(?,?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, fname);
		pstmt.setString(2, fpwd);
		pstmt.setString(3, shaPwd);
		pstmt.setString(4, bcPwd);
		
		int af = pstmt.executeUpdate();
		if (af>0)
			System.out.println("삽입 완료");
		else
			System.out.println("삽입 오류");
		
		response.sendRedirect("../index.jsp");
	}

}
