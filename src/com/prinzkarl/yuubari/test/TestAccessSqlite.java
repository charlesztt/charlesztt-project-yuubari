package com.prinzkarl.yuubari.test;

import java.sql.SQLException;

import com.prinzkarl.yuubari.access_sqlite.StringOperation;

public class TestAccessSqlite {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
			// This is only a test.
			String[] columns = { "userID", "maxID", "LastID" };
			String[] values = { "110", "001", "011" };
			StringOperation.insert(columns, values, "test.db", "tweetInfo");
			System.out.println(StringOperation.select("maxID", "userID", "110", "test.db",
					"tweetInfo"));
			System.out.println(StringOperation.does_not_exist("maxID", "userID", "110", "test.db",
					"tweetInfo"));
			StringOperation.update("maxID", "2333222", "userID", "110", "test.db", "tweetInfo");
			System.out.println(StringOperation.select("maxID", "userID", "110", "test.db",
					"tweetInfo"));
			StringOperation.delete("userID", "110", "test.db", "tweetInfo");
			try {
				System.out.println(StringOperation.does_not_exist("maxID", "userID", "110",
						"test.db", "tweetInfo"));
			} catch (SQLException e) {
				System.err.println("Failed");
			}
	}
}
