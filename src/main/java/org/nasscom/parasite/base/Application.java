package org.nasscom.parasite.base;

public class Application {
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost/parasite";
	public static final String DB_USER = "root";
	public static final String DB_PWD = "neeraj";

	
	public static final String STATUS_STARTED_BY_USER = "Verification Started by User";
	public static final String STATUS_STARTED_BY_ORG = "Verification Started by Org.";
	public static final String STATUS_UNDER_PROCESS = "Verification is Under Progress";
	public static final String STATUS_APPROVE = "Verification is Complete.And Found Genuine";
	public static final String STATUS_REJECT = "Verification is Complete.And found Fake";
	public static final String STATUS_TERMINATE = "COngratulation !! Service is terminated to this number.";
	
	public static final String DOCS_VOTER_CARD="Voter Card";
	public static final String DOCS_DRIVING_LIC="Driving Lic";
	public static final String DOCS_PAN_CARD="PAN Card";
	public static final String DOCS_PASSPORT="Passport";
	public static final String DOCS_OTHER="Other";


}
