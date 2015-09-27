package org.nasscom.parasite.beans;

import java.io.Serializable;

public class Document implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String docType;
	private String actualDocId;
	private String encryptedDocId;

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getActualDocId() {
		return actualDocId;
	}

	public void setActualDocId(String actualDocId) {
		this.actualDocId = actualDocId;
	}

	public String getEncryptedDocId() {
		return encryptedDocId;
	}

	public void setEncryptedDocId(String encryptedDocId) {
		this.encryptedDocId = encryptedDocId;
	}

}
