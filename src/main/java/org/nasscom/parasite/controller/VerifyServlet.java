package org.nasscom.parasite.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nasscom.parasite.base.AppUser;
import org.nasscom.parasite.base.Application;
import org.nasscom.parasite.beans.VfcationRequestForm;
import org.nasscom.parasite.utils.QueryUtils;
import org.nasscom.parasite.utils.TelecomUtils;

public class VerifyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String mobNum = request.getParameter("actualMobNumber");
		String cardType = request.getParameter("associatedDoc");
		HttpSession session = request.getSession(true);

		
		
		if (TelecomUtils.isEligibleForVerification(mobNum, cardType)) {
			AppUser user = (AppUser) session.getAttribute("user");

			if (user != null) {
				VfcationRequestForm vfr = new VfcationRequestForm();
				vfr.setReferenceNum(TelecomUtils.getVerificationRefNum());
				vfr.setRequestBy(user.getMobileNumber());
				vfr.setAgstNumber(mobNum);
				vfr.setAgstCardType(cardType);
				vfr.setReqStatus(Application.STATUS_STARTED_BY_USER);

				if(QueryUtils.enterVerificationReq(vfr)){
					session.setAttribute("result", vfr.getReferenceNum() );
				}else{
					session.setAttribute("error", "Error While inserting in database.");
				}
			}else{
				session.setAttribute("error", "Session Expired");

			}
		}else{
			session.setAttribute("error", "Mobile Number is Requested to verified Recently. Please Try After Some Time");
		}
	response.sendRedirect("viewNumbers.jsp");
	}

}
