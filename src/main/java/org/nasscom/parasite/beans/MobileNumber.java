package org.nasscom.parasite.beans;

import java.io.Serializable;

public class MobileNumber implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String associatedDoc;
	
	private String associateDocId;
	
	private String actualmobNumber;
	private String encryMobNumber;

	public MobileNumber(){
		
	}
	
	public String getActualmobNumber() {
		return actualmobNumber;
	}

	public void setActualmobNumber(String actualmobNumber) {
		this.actualmobNumber = actualmobNumber;
	}

	public String getEncryMobNumber() {
		return encryMobNumber;
	}

	public void setEncryMobNumber(String encryMobNumber) {
		this.encryMobNumber = encryMobNumber;
	}

	public String getAssociatedDoc() {
		return associatedDoc;
	}

	public void setAssociatedDoc(String associatedDoc) {
		this.associatedDoc = associatedDoc;
	}

	public String getAssociateDocId() {
		return associateDocId;
	}

	public void setAssociateDocId(String associateDocId) {
		this.associateDocId = associateDocId;
	}

	
	
}
