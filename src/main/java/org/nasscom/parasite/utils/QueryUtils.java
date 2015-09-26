package org.nasscom.parasite.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.nasscom.parasite.base.DbFactory;
import org.nasscom.parasite.beans.Document;
import org.nasscom.parasite.beans.MobileNumber;

public class QueryUtils {

	
	
	
	
	
	
	public static ArrayList<Document> getDocumentList(String mob) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		StringBuilder selectSql = new StringBuilder();
		selectSql = selectSql.append(" Select card_type,card_id")
				.append(" from").append(" telcom_details").append(" where")
				.append(" mobile_num=").append(" '?'");

		ArrayList<Document> result = new ArrayList<Document>();
		try {
			conn = DbFactory.getInstance().getConnection();
			preparedStatement = conn.prepareStatement(selectSql.toString());
			preparedStatement.setString(1, mob);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSql.toString());

			while (rs.next()) {
				Document dc = new Document();
				dc.setDocType(rs.getString("card_type"));
				dc.setActualDocId(rs.getString("card_id"));
				dc.setEncryptedDocId(rs.getString("card_id"));
				result.add(dc);
			}

		} catch (Exception e) {

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			try {
				if (stmt != null)
					stmt.close();
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

	public static ArrayList<MobileNumber> findAssociateNumbers(String cardType,
			String cardId) {

		ArrayList<MobileNumber> result = new ArrayList<MobileNumber>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		StringBuilder selectSql = new StringBuilder();
		selectSql = selectSql.append(" Select mobile_num").append(" from")
				.append(" telcom_details").append(" where")
				.append(" card_type =").append(" '?'").append(" And")
				.append(" card_id =").append(" '?'");

		try {
			conn = DbFactory.getInstance().getConnection();
			preparedStatement = conn.prepareStatement(selectSql.toString());
			preparedStatement.setString(1, cardType);
			preparedStatement.setString(2, cardId);

			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSql.toString());

			while (rs.next()) {
				MobileNumber num = new MobileNumber();
				num.setActualmobNumber(rs.getString("mobile_num"));
				num.setEncryMobNumber(rs.getString("mobile_num"));
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
				if (stmt != null)
					stmt.close();
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
