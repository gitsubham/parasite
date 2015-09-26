package org.nasscom.parasite.utils;

import java.util.ArrayList;

import org.nasscom.parasite.beans.Document;



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
	
}
