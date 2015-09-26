package org.nasscom.parasite.utils;

import java.util.ArrayList;

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

		numbers.add(num);
		num.setActualmobNumber("9851063353");
		num.setEncryMobNumber("9851063353");

		num = new MobileNumber();
		num.setActualmobNumber("8335881012");
		num.setEncryMobNumber("8335881012");

		num = new MobileNumber();
		num.setActualmobNumber("94101081678");
		num.setEncryMobNumber("94101081678");
		
		numbers.add(num);
		
		return numbers;
	}
	
	
	
	public static boolean isValidDocument(String type,String id){
		return true;	
	}
}
