package org.nasscom.parasite.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nasscom.parasite.base.AppUser;
import org.nasscom.parasite.beans.MobileNumber;
import org.nasscom.parasite.utils.QueryUtils;
import org.nasscom.parasite.utils.TelecomUtils;

public class DocumentDetailServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		
		String docType = request.getParameter("docType");
		String actualDocId = request.getParameter("actualDocId");

		HttpSession session = request.getSession(true);
		AppUser user = (AppUser) session.getAttribute("user");
		actualDocId = user.findDocId(docType);		
		
		if (user != null && TelecomUtils.isValidDocument(docType, actualDocId)) {

			ArrayList<MobileNumber> mobileNumbers = QueryUtils
					.findAssociateNumbers(docType,actualDocId);
			user.setAltMobileList(mobileNumbers);
			session.setAttribute("user", user);
			response.sendRedirect("viewNumbers.jsp");
		} else {
			session.setAttribute("error", "Document is not valid");
			response.sendRedirect("doclinked.jsp");
		}


	
	
	
	}


}
