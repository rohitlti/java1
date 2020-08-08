package com.lti.dao.util;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnManager {
public static Connection connect() {
	try {
		Properties dbProps = new Properties();
	  // dbProps.load(new FileReader("dev-db.properties"));
		dbProps.load(ConnManager.class.getClassLoader().getResourceAsStream("dev-db.properties"));
		Class.forName(dbProps.getProperty("driverName"));
		
		return  DriverManager.getConnection(dbProps.getProperty("url"), dbProps.getProperty("user"), dbProps.getProperty("pass"));
	}
	catch(ClassNotFoundException | IOException | SQLException e) {
		e.printStackTrace();
		return null;
}
}

/*public static Connection connect() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:ORCL"; // ORCLDB.localdomain or OSE or //32118:ORCL
		String user = "system";
		String pass = "oracle"; //Oracle18
		return  DriverManager.getConnection(url, user, pass);
	}
	catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		return null;
}
}*/

}
/*
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class ConnManager {

	
	public static Connection connect() {
		try {
			Properties dbProps=new Properties();
		//	dbProps.load(ConnManager.class.getResourceAsStream("dev-db.properties"));
			dbProps.load(new FileReader("dev-db.properties"));
			
			Class.forName(dbProps.getProperty("driverName"));
			return DriverManager.getConnection(dbProps.getProperty("url"),dbProps.getProperty("user"),dbProps.getProperty("pass"));//"jdbc:oracle:thin:@localhost:1521:OSE","system","Rohit_8683");
	}
		catch(ClassNotFoundException | IOException| SQLException e) {
			e.printStackTrace();
			return null;
			
		}
		
		
		/*public static Connection connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:OSE","system","Rohit_8683");
	}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
			
		}*/
//		}
//}
