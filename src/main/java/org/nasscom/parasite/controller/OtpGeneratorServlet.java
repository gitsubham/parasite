package org.nasscom.parasite.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nasscom.parasite.base.AppUser;
import org.nasscom.parasite.utils.MobileUtils;

public class OtpGeneratorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String num = request.getParameter("inputPhone");
		HttpSession session = request.getSession(true);
		if (MobileUtils.isValidMobileNumber(num)) {
			AppUser user = (AppUser) session.getAttribute("user");
			user.setMobileNumber(num);
			user.setOTP(MobileUtils.generateOTP());
			session.setAttribute("user", user);
			session.removeAttribute("error");
		} else {
			session.setAttribute("error", "Invalid Mobile Number");
		}

		response.sendRedirect("index.jsp");

	}

}
