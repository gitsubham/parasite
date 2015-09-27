package org.nasscom.parasite.utils;

import org.apache.commons.lang.StringUtils;

public class MobileUtils {

	public static boolean isValidMobileNumber(String num) {
		if (StringUtils.isNotBlank(num) && num.length() == 10 ) {
			return true;
		}
		return false;
	}

	public static String generateOTP() {
		return "270915";
	}

	
	public static String encryptNumber(String mob){
		
		if(StringUtils.isBlank(mob)){
			return null;
		}
		
		StringBuilder ecyNumber = new StringBuilder("XXXXX");
		ecyNumber.append(mob.substring(5));
		return ecyNumber.toString();
	}
	
	
}
