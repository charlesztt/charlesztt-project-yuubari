package com.prinzkarl.yuubari.access_sqlite;

/*
 * Please download sqlite-jdbc from https://bitbucket.org/xerial/sqlite-jdbc/downloads.
 */

import java.sql.*;

public class StringOperation {
	public static void insert(String[] columns, String[] values,
			String db_file, String table_name) throws SQLException {
		Connection c = null;
		Statement stmt = null;
		c = DriverManager.getConnection("jdbc:sqlite:" + db_file);
		c.setAutoCommit(false);
		stmt = c.createStatement();
		String sql = "INSERT INTO " + table_name + " (";
		for (int i = 0; i < columns.length; i++) {
			sql = sql + columns[i];
			if (i < columns.length - 1) {
				sql = sql + ", ";
			}
		}
		sql = sql + ") VALUES (";
		for (int i = 0; i < values.length; i++) {
			sql = sql + "'" + values[i] + "'";
			if (i < columns.length - 1) {
				sql = sql + ", ";
			}
		}
		sql = sql + ");";
		// System.out.println(sql);
		stmt.executeUpdate(sql);
		stmt.close();
		c.commit();
		c.close();
		return;
	}

	public static String select(String target_column, String index_id_key,
			String index_id_value, String db_file, String table_name)
			throws SQLException {
		Connection c = null;
		Statement stmt = null;
		c = DriverManager.getConnection("jdbc:sqlite:" + db_file);
		c.setAutoCommit(false);
		stmt = c.createStatement();
		String sql = "SELECT " + target_column + " FROM " + table_name
				+ " WHERE " + index_id_key + "='" + index_id_value + "';";
		// System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		String target_value = rs.getString(target_column);
		stmt.close();
		c.close();
		return target_value;
	}

	public static boolean does_not_exist(String target_column,
			String index_id_key, String index_id_value, String db_file,
			String table_name) throws SQLException {
		Connection c = null;
		Statement stmt = null;
		c = DriverManager.getConnection("jdbc:sqlite:" + db_file);
		c.setAutoCommit(false);
		stmt = c.createStatement();
		String sql = "SELECT " + target_column + " FROM " + table_name
				+ " WHERE " + index_id_key + "='" + index_id_value + "';";
		// System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		boolean target_value = rs.isAfterLast();
		stmt.close();
		c.close();
		return target_value;
	}

	public static void update(String target_column, String new_value,
			String index_id_key, String index_id_value, String db_file,
			String table_name) throws SQLException {
		Connection c = null;
		Statement stmt = null;
		c = DriverManager.getConnection("jdbc:sqlite:" + db_file);
		c.setAutoCommit(false);
		stmt = c.createStatement();
		String sql = "UPDATE " + table_name + " set " + target_column + " = '"
				+ new_value + "' WHERE " + index_id_key + "='" + index_id_value
				+ "';";
		// System.out.println(sql);
		stmt.executeUpdate(sql);
		stmt.close();
		c.commit();
		c.close();
	}

	public static void delete(String index_id_key, String index_id_value,
			String db_file, String table_name) throws SQLException {
		Connection c = null;
		Statement stmt = null;
		c = DriverManager.getConnection("jdbc:sqlite:" + db_file);
		c.setAutoCommit(false);
		stmt = c.createStatement();
		String sql = "DELETE from " + table_name + " WHERE " + index_id_key
				+ "='" + index_id_value + "';";
		// System.out.println(sql);
		stmt.executeUpdate(sql);
		stmt.close();
		c.commit();
		c.close();
	}


}
