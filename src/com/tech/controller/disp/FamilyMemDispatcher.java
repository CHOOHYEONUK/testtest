package com.tech.controller.disp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.controller.controllers.FamilyMemberLoginController;
import com.tech.controller.controllers.FamilyMemberLoginProcController;
import com.tech.controller.controllers.FamilyMemberLogoutProcController;
import com.tech.controller.controllers.FamilyMemberJoinController;
import com.tech.controller.controllers.FamilyMemberJoinProcController;

public class FamilyMemDispatcher extends HttpServlet {
	
	private void doService(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("doService 신호받음");
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		System.out.println("uri : "+uri);
		System.out.println("conPath : "+conPath);
		System.out.println("com : "+com);
		
		Controller controller = null;
		try {
			if (com.equals("/join/familymemberjoin.do")) {
				controller = new FamilyMemberJoinController();
			}else if (com.equals("/join/familymemberjoinproc.do")) {
				controller = new FamilyMemberJoinProcController();
			}else if (com.equals("/login/familymemberlogin.do")) {
				controller = new FamilyMemberLoginController();
			}else if (com.equals("/login/familymemberloginproc.do")) {
				controller = new FamilyMemberLoginProcController();
			}else if (com.equals("/login/familymemberlogoutproc.do")) {
				controller = new FamilyMemberLogoutProcController();
			}
			controller.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
}
