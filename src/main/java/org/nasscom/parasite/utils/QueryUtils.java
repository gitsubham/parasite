package org.nasscom.parasite.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.nasscom.parasite.base.Application;
import org.nasscom.parasite.base.DbFactory;
import org.nasscom.parasite.beans.Document;
import org.nasscom.parasite.beans.MobileNumber;
import org.nasscom.parasite.beans.VfcationRequestForm;

public class QueryUtils {

	
	
	/**
	 * @return
	 */
	public static boolean isVerifiedRecently(String mob,String type){
		
		if(StringUtils.isBlank(mob)){
			return false;
		}
		
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		StringBuilder selectSql = new StringBuilder();
	
		selectSql = selectSql.append(" select verification_ref from parasite_details ")
		.append("where reguested_against = ? and card_type =? ");
		
		try {
			conn = DbFactory.getInstance().getConnection();
			preparedStatement = conn.prepareStatement(selectSql.toString());
			preparedStatement.setString(1, mob);
			preparedStatement.setString(2, type);
			
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
			}

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		
		return false;
	}
	
	/**
	 * @return
	 */
	public static ArrayList<VfcationRequestForm> getVerificationReq(String mob){
		
	/*	
		ArrayList<VfcationRequestForm> list = new ArrayList<VfcationRequestForm>();

		VfcationRequestForm vrf = new VfcationRequestForm();
		vrf.setReferenceNum(TelecomUtils.getVerificationRefNum());
		vrf.setRequestBy("1234");
		vrf.setAgstNumber("4567");
		vrf.setAgstCardType("PAN Card");
		vrf.setReqStatus(Application.STATUS_STARTED_BY_USER);

		list.add(vrf);
		vrf = new VfcationRequestForm();
		vrf.setReferenceNum(TelecomUtils.getVerificationRefNum());
		vrf.setRequestBy("1234");
		vrf.setAgstNumber("866456");
		vrf.setAgstCardType("PAN Card");
		vrf.setReqStatus(Application.STATUS_TERMINATE);
		
		list.add(vrf);
		*/
		
		ArrayList<VfcationRequestForm> result = new ArrayList<VfcationRequestForm>();
		if(StringUtils.isBlank(mob)){
			return result;
		}
		
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		StringBuilder selectSql = new StringBuilder();
	
		selectSql = selectSql.append(" select verification_ref,requested_by,reguested_against,")
		.append("card_type,status from parasite_details where requested_by= ?");
		

		try {
			conn = DbFactory.getInstance().getConnection();
			preparedStatement = conn.prepareStatement(selectSql.toString());
			preparedStatement.setString(1, mob);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				VfcationRequestForm tmp = new VfcationRequestForm();
				tmp.setReferenceNum(rs.getString("verification_ref"));
				tmp.setRequestBy(rs.getString("requested_by"));
				tmp.setAgstNumber(rs.getString("reguested_against"));
				tmp.setAgstCardType(rs.getString("card_type"));
				tmp.setReqStatus(rs.getString("status"));
				result.add(tmp);
			}

		} catch (Exception e) {

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
			}

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}
	
	
	/**
	 * @param vrf
	 * @return
	 */
	public static boolean enterVerificationReq(VfcationRequestForm vrf){

		if (vrf == null){
			return false;
		}
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		StringBuilder selectSql = new StringBuilder();
		
		selectSql = selectSql.append("insert into parasite_details")
		.append("(verification_ref,requested_by,reguested_against,card_type,status) values(?,?,?,?,?)");

		try {
			conn = DbFactory.getInstance().getConnection();
			preparedStatement = conn.prepareStatement(selectSql.toString());
			preparedStatement.setString(1, vrf.getReferenceNum());
			preparedStatement.setString(2, vrf.getRequestBy());
			preparedStatement.setString(3, vrf.getAgstNumber());
			preparedStatement.setString(4, vrf.getAgstCardType());
			preparedStatement.setString(5, vrf.getReqStatus());
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {

			System.out.println(e);
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
			}

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
	
		return false;
	}
	
	/**
	 * @param mob
	 * @return
	 */
	public static ArrayList<Document> getDocumentList(String mob) {

		ArrayList<Document> result = new ArrayList<Document>();
		if (StringUtils.isBlank(mob)){
			return result;
		}
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		StringBuilder selectSql = new StringBuilder();
		selectSql = selectSql.append(" Select card_type,card_id")
				.append(" from").append(" telcom_details").append(" where")
				.append(" mobile_num =").append("  ? ");

		try {
			conn = DbFactory.getInstance().getConnection();
			preparedStatement = conn.prepareStatement(selectSql.toString());
			preparedStatement.setString(1, mob);
			rs = preparedStatement.executeQuery();
		
			while (rs.next()) {
				Document dc = new Document();
				dc.setDocType(rs.getString("card_type"));
				dc.setActualDocId(rs.getString("card_id"));
				dc.setEncryptedDocId(rs.getString("card_id"));
				result.add(dc);
			}

		} catch (Exception e) {

			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
			}

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}

		return result;
	}

	/**
	 * @param cardType
	 * @param cardId
	 * @return
	 */
	public static ArrayList<MobileNumber> findAssociateNumbers(String cardType,
			String cardId) {

		ArrayList<MobileNumber> result = new ArrayList<MobileNumber>();
		if(StringUtils.isBlank(cardType) || StringUtils.isBlank(cardId)){
			return result;
		}
		
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		StringBuilder selectSql = new StringBuilder();
		selectSql = selectSql.append(" Select mobile_num").append(" from")
				.append(" telcom_details").append(" where")
				.append(" card_type =").append("  ? ").append(" And")
				.append(" card_id =").append("  ? ");

		try {
			conn = DbFactory.getInstance().getConnection();
			preparedStatement = conn.prepareStatement(selectSql.toString());
			preparedStatement.setString(1, cardType);
			preparedStatement.setString(2, cardId);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				MobileNumber num = new MobileNumber();
				num.setActualmobNumber(rs.getString("mobile_num"));
				num.setEncryMobNumber(MobileUtils.encryptNumber(rs.getString("mobile_num")));
				num.setAssociatedDoc(cardType);
				num.setAssociateDocId(cardId);
				result.add(num);
			}

		} catch (Exception e) {

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
			}

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}

}
