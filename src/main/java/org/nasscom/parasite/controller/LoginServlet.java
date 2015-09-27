package org.nasscom.parasite.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nasscom.parasite.base.AppUser;
import org.nasscom.parasite.beans.Document;
import org.nasscom.parasite.utils.QueryUtils;
import org.nasscom.parasite.utils.TelecomUtils;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String providedOTP = request.getParameter("inputOTP");
		HttpSession session = request.getSession(true);

		AppUser user = (AppUser) session.getAttribute("user");

		if (user != null && providedOTP.equals(user.getOTP())) {
			String mobNum = user.getMobileNumber();
			ArrayList<Document> documents = QueryUtils
					.getDocumentList(mobNum);
//			ArrayList<Document> documents = TelecomUtils
//					.getDocumentList(mobNum);
			user.setDocumentList(documents);
			session.setAttribute("user", user);
			response.sendRedirect("doclinked.jsp");
		} else {
			session.setAttribute("error", "OTP is not valid.");
			response.sendRedirect("index.jsp");
		}

	}
}
