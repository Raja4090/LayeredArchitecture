package com.phoenix.dbconfig;

import java.sql.Connection;
//author : raja.kumar@stltech.in
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
	 
	 public static Connection getConnection(String jdbcDriver,String jdbcUrl,
        String username,String password) throws SQLException, ClassNotFoundException
        {
    	Class.forName(jdbcDriver);
    	return DriverManager.getConnection(jdbcUrl,username,password);
        }
	

}
