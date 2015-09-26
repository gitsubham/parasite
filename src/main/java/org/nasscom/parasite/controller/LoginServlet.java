package org.nasscom.parasite.controller;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nasscom.parasite.base.AppUser;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException {

		String providedOTP = request.getParameter("inputOTP");
		HttpSession session = request.getSession(true);

		AppUser user = (AppUser) session.getAttribute("user");

		if(providedOTP.equals(user.getOTP())){
			
			
			
		}else{
			
			
			
		}
		
			
	}
}
