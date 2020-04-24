
package phonebook;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DB {
    
    	final String URL = "jdbc:derby:sampleFirstconnection;create=true";
	final String USERNAME = "";
	final String PASSWORD = "";
	Connection conn = null;
	Statement createStatement = null;
        
        
public DB() {
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("A Hid Letrejott ");
		} 
		catch (SQLException e) {
			System.out.println(" Valami baj van" + e );
			e.printStackTrace();
		}
		
		// Ha eletre kelt csinalunk egy megpakolhato teherautot
		
		if(conn != null) {
			try {
		createStatement = conn.createStatement();
			}
			catch(SQLException e) {
				System.out.println(" Valami baj van" + e );
			}
	}
		
		// Megnezzuk h ures e az adatabzi
		DatabaseMetaData dbmd = null;
		try {
			 dbmd = conn.getMetaData();
		} catch (SQLException e) {
			System.out.println(" Valami baj van" + e );
		}
		
		try { 
			ResultSet rs1 = dbmd.getTables(null,"APP","CONTACTS",null);
		if(!rs1.next()) 
		{
		createStatement.execute("create table contacts (id INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), lastname varchar (20), firstname varchar (20), email varchar(30))");
		}
		} catch (SQLException e) {
			System.out.println(" Valami baj van a tabla letrehozasakor" + e );
		}
	}

 public ArrayList<Person> getAllContacts() {
		 String sql = "select * from contacts";
		 ArrayList<Person> users = null; 
           
                 try {
                    ResultSet rs = createStatement.executeQuery(sql);
                    users = new ArrayList<>();
                    
                while (rs.next()) {
                    
                    Person actualPerson = new Person(rs.getInt("id"),rs.getString("lastName"),rs.getString("firstName"),rs.getString("email"));
                    users.add(actualPerson); 
					
				}
			} catch (SQLException e) {
			
				System.out.println("Valami baj van a userek kiolvasasakor" + e);
			}
		return users; 
}
 
 public void addContact (Person person) {
		try {
			//String sql = "insert into users values ('"+ name +"','"+ address +"' )";
			//createStatement.execute(sql);
			String sql = "insert into contacts (lastname,firstname,email) values (?,?,?)";
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setString(1,person.getLastName());
			preparedstatement.setString(2,person.getFirstName());
                        preparedstatement.setString(3,person.getEmail());
			preparedstatement.execute();
		} catch (SQLException e) {
			System.out.println(" Valami baj van a Kontakt hozzaadasakor" + e );
	}
		
	}
public void updateContact (Person person) {
		try {
			//String sql = "insert into users values ('"+ name +"','"+ address +"' )";
			//createStatement.execute(sql);
			String sql = "update contacts set lastname = ? , firstname = ? , email = ? where id = ?";
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setString(1,person.getLastName());
			preparedstatement.setString(2,person.getFirstName());
                        preparedstatement.setString(3,person.getEmail());
                        preparedstatement.setInt(4,Integer.parseInt(person.getId()));
			preparedstatement.execute();
		} catch (SQLException e) {
			System.out.println(" Valami baj van a Kontakt frisitesekor" + e );
	}
		
	}
public void removeContact (Person person) {
		try {
			//String sql = "insert into users values ('"+ name +"','"+ address +"' )";
			//createStatement.execute(sql);
			String sql = "delete from contacts where id = ?";
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setInt(1,Integer.parseInt(person.getId()));
			preparedstatement.execute();
		} catch (SQLException e) {
			System.out.println(" Valami baj van a Kontakt torlesekor" + e );
	}
		
	}
}
