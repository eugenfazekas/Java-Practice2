package firstConecction;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

	final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	final String URL = "jdbc:derby:sampleFirstconnection;create=true";
	final String USERNAME = "";
	final String PASSWORD = "";
	
	public DB () {
		
		try {
			Connection db = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println(" " + e );
			e.printStackTrace();
		}
		
	}
	
}
