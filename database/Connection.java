package database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * class Connection
 * 
 * @author David Sajdl 
 * @version 7
 */
public class Connection {
	
	private static final String url = "jdbc:mysql://mysqlsrv.dcs.bbk.ac.uk/dsajdl01dbm";
    private static final String user = "myUserName";
    private static final String password = "qyPasswordToMySQL";
    private java.sql.Connection con;
    
    public Connection(){
		
    	try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				con = DriverManager.getConnection(url, user, password);
			} catch(SQLException sqle){
					System.out.println("SQL exception: " + sqle.toString());
			} catch(InstantiationException ie){
				System.out.println("Instance Exception: " + ie.toString());
			} catch(IllegalAccessException iae){
				System.out.println("Illegal Access Exception: " + iae.toString());
			} catch(ClassNotFoundException cne){
				System.out.println("Class not found Exception: " + cne.toString());
			}
    
    }
    public Statement getConnection() throws SQLException{
    	return con.createStatement();
    }
    
}
