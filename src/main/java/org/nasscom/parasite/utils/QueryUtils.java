package org.nasscom.parasite.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.nasscom.parasite.base.DbFactory;
import org.nasscom.parasite.beans.Document;

public class QueryUtils {

	public static ArrayList<Document> getTelecomDetails(String mob) {

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

		}

		return result;
	}

}
