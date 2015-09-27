package org.nasscom.parasite.base;

import java.io.Serializable;

public class AppUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private String mobileNumber;
	private String OTP;

	public AppUser() {

	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getOTP() {
		return OTP;
	}

	public void setOTP(String oTP) {
		OTP = oTP;
	}

}
