package org.nasscom.parasite.beans;

import java.io.Serializable;
import java.util.Date;

public class VfcationRequestForm implements Serializable{


	private static final long serialVersionUID = 1L;

	private String referenceNum;
	
	private String requestBy;
	
	private String agstNumber;
	
	private String agstCardType;
	
	private String reqStatus;
	
	private Date reqDate;
	
	public VfcationRequestForm(){
		
	}

	public String getAgstNumber() {
		return agstNumber;
	}

	public void setAgstNumber(String agstNumber) {
		this.agstNumber = agstNumber;
	}

	public String getAgstCardType() {
		return agstCardType;
	}

	public void setAgstCardType(String agstCardType) {
		this.agstCardType = agstCardType;
	}

	public String getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public String getReferenceNum() {
		return referenceNum;
	}

	public void setReferenceNum(String referenceNum) {
		this.referenceNum = referenceNum;
	}

	public String getRequestBy() {
		return requestBy;
	}

	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}
	
	
}
