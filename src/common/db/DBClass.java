package common.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBClass {//연결만 하는 역할
	public static Connection conn;

	public DBClass() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.221.253.215:1521:xe", "team1", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
