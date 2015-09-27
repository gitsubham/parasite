package org.nasscom.parasite.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.nasscom.parasite.base.Application;
import org.nasscom.parasite.beans.Document;
import org.nasscom.parasite.beans.MobileNumber;

public class TelecomUtils {

	/**
	 * @param mob
	 * @return
	 */
	public static ArrayList<Document> getDocumentList(String mob) {

		ArrayList<Document> documents = new ArrayList<Document>();

		Document dc = new Document();
		dc.setDocType("PanCard");
		dc.setActualDocId("12345678");
		dc.setEncryptedDocId("12345678");
		documents.add(dc);

		dc = new Document();
		dc.setDocType("VoterCard");
		dc.setActualDocId("2317");
		dc.setEncryptedDocId("2317");
		documents.add(dc);

		return documents;
	}

	/**
	 * @param cardType
	 * @param cardId
	 * @return
	 */
	public static ArrayList<MobileNumber> findAssociateNumbers(String cardType,
			String cardId) {

		ArrayList<MobileNumber> numbers = new ArrayList<MobileNumber>();

		MobileNumber num = new MobileNumber();
		num.setActualmobNumber("9851063353");
		num.setEncryMobNumber(MobileUtils.encryptNumber("9851063353"));
		numbers.add(num);

		num = new MobileNumber();
		num.setActualmobNumber("8335881012");
		num.setEncryMobNumber(MobileUtils.encryptNumber("8335881012"));
		numbers.add(num);

		num = new MobileNumber();
		num.setActualmobNumber("94101081678");
		num.setEncryMobNumber(MobileUtils.encryptNumber("94101081678"));

		numbers.add(num);

		return numbers;
	}

	/**
	 * @param type
	 * @param id
	 * @return
	 */
	public static boolean isValidDocument(String type, String id) {
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(id))
			return true;
		else
			return false;
	}

	/**
	 * @return
	 */
	public static String getVerificationRefNum() {
		String code = new BigInteger(130, new SecureRandom()).toString(32);
		return code;
	}

	/**
	 * @param num
	 * @param cardType
	 * @return
	 */
	public static boolean isEligibleForVerification(String num, String cardType) {

		if (StringUtils.isNotBlank(num) && StringUtils.isNotBlank(cardType)) {
			if (!QueryUtils.isVerifiedRecently(num,cardType)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param docType
	 * @param docId
	 * @return
	 */
	public static String encryptDocs(String docType, String docId) {

		if (StringUtils.isNotBlank(docType) && StringUtils.isNotBlank(docId)) {

			StringBuilder encyId = new StringBuilder();
			int len = docId.length();
			String encyChar = "XXXXXXXXXXXXXXXXXXXXXXXX";

			if(StringUtils.equals(docType,Application.DOCS_DRIVING_LIC)){
				encyId.append(encyChar.substring(0, len/2))
				.append(docId.substring(len/2, len-1));
			}

			if(StringUtils.equals(docType,Application.DOCS_VOTER_CARD)){
				encyId.append(encyChar.substring(0, len/2))
				.append(docId.substring(len/2, len-1));
			}

			if(StringUtils.equals(docType,Application.DOCS_PASSPORT)){
				encyId.append(encyChar.substring(0, len/2))
				.append(docId.substring(len/2, len-1));				
			}

			
			if(StringUtils.equals(docType,Application.DOCS_PAN_CARD)){
				encyId.append(encyChar.substring(0, len/2))
				.append(docId.substring(len/2, len-1));
			}

			
			if(StringUtils.equals(docType,Application.DOCS_OTHER)){
				encyId.append(encyChar.substring(0, len/2))
				.append(docId.substring(len/2, len-1));
			}

			
			return encyId.toString();
		}
		return null;
	}

}
