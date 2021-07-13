package com.phoenix.dbconfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//author : raja.kumar@stltech.in
public class OracleConnection {
    
	 public static Connection getOracleConnection() throws ClassNotFoundException, SQLException
	   {
	   String jdbcDriver="oracle.jdbc.driver.OracleDriver";
	   String jdbcUrl="jdbc:oracle:thin:@localhost:1521:xe";
	   String username="hr";
	   String password="hr";
	  
	   return DBConfig.getConnection(jdbcDriver, jdbcUrl, username, password);       
       }
}
