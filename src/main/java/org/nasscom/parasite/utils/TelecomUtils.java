package org.nasscom.parasite.utils;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.nasscom.parasite.beans.Document;
import org.nasscom.parasite.beans.MobileNumber;



public class TelecomUtils {

	
	public static ArrayList<Document> getDocumentList(String mob){
		
		ArrayList <Document> documents = new ArrayList<Document> ();
		
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
	
	
	public static ArrayList<MobileNumber> findAssociateNumbers(String cardType,String cardId){
		
		ArrayList <MobileNumber> numbers = new ArrayList<MobileNumber> ();
		
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
	
	
	
	public static boolean isValidDocument(String type,String id){		
		if(StringUtils.isNotBlank(type) && StringUtils.isNotBlank(id))
			return true;
		else
			return false;
	}
}
