package nuc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Conn {

	public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/test";
	public static final String DBUSER="root";
	public static final String DBPASS="123456";
	ResultSet rs = null;
	private Connection conn = null;
		 public Connection getConn() {
			 try {
				Class.forName(DBDRIVER) ;
				conn=DriverManager.getConnection(DBURL, DBUSER, DBPASS);
				 
			 }catch(Exception e)
			 {
				
			 }
			 return conn;
		 }
}
