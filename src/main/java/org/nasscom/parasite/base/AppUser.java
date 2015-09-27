package org.nasscom.parasite.base;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.nasscom.parasite.beans.Document;
import org.nasscom.parasite.beans.MobileNumber;
import org.nasscom.parasite.beans.VfcationRequestForm;

public class AppUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private String mobileNumber;
	private String OTP;

	private boolean isValidUser;
	
	ArrayList <Document> documentList = null;
	ArrayList <VfcationRequestForm> verifyReqList = null;
	ArrayList <MobileNumber> altMobileList = null;
	
	public AppUser(){
		mobileNumber = null;
		OTP = null;
		isValidUser = false;
		documentList = new ArrayList<Document>();
		verifyReqList = new ArrayList<VfcationRequestForm>();
		altMobileList = new ArrayList<MobileNumber>();

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

	
	public boolean isValidUser(){
		return isValidUser;
	}
	
	public void setValidUser(boolean userStatus){
		isValidUser = userStatus;
	}
	
	
	public ArrayList<Document> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(ArrayList<Document> documentList) {
		this.documentList = documentList;
	}

	public ArrayList<VfcationRequestForm> getVerifyReqList() {
		return verifyReqList;
	}

	public void setVerifyReqList(ArrayList<VfcationRequestForm> verifyReqList) {
		this.verifyReqList = verifyReqList;
	}

	public ArrayList<MobileNumber> getAltMobileList() {
		return altMobileList;
	}

	public void setAltMobileList(ArrayList<MobileNumber> altMobileList) {
		this.altMobileList = altMobileList;
	}

	public void reset(){
		mobileNumber = null;
		OTP = null;
		isValidUser = false;
		documentList.clear();
		verifyReqList.clear();
		altMobileList.clear();
	}

	
	public String findDocId(String docType){
		for( Document doc : documentList ){
			if(StringUtils.equals(docType, doc.getDocType())){
				return doc.getActualDocId();
			}			
		}
		return null;		
	}
	

}
