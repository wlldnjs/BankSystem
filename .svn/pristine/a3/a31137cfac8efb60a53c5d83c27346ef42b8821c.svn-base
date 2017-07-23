package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static DBConnection instance;
	public Connection conn;
	public DBConnection(){
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:myoracle";
		String user = "hr";
		String user_pw = "hr";
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, user_pw);
			System.out.println("데이터베이스 연결 성공");
		} catch(ClassNotFoundException e){
			System.out.println("Error : " + e.getMessage());
		} catch(SQLException ex){
			System.out.println("SQLError : " +ex.getMessage());
		}
	}
	
	public static DBConnection getInstance(){
		if(instance == null) instance = new DBConnection();
		return instance;
	}
	
	public Connection getConnection(){
		return this.conn;
	}
}
