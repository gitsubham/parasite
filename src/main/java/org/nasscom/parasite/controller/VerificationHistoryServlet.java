package org.nasscom.parasite.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nasscom.parasite.base.AppUser;
import org.nasscom.parasite.beans.VfcationRequestForm;
import org.nasscom.parasite.utils.QueryUtils;

public class VerificationHistoryServlet  extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException {

		HttpSession session = request.getSession(true);
		AppUser user = (AppUser) session.getAttribute("user");
		
		if(user != null){
			ArrayList<VfcationRequestForm> vfcationReqList = new ArrayList<VfcationRequestForm>();
			vfcationReqList = QueryUtils.getVerificationReq();
			user.setVerifyReqList(vfcationReqList);
			session.setAttribute("user", user);
			response.sendRedirect("queryReqStatus.jsp");
		}else{
			response.sendRedirect("error.jsp");
		}
		
	}
	
	
}
