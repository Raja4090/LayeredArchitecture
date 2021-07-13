package com.phoenix.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.phoenix.data.Product;
import com.phoenix.data.User;
import com.phoenix.dbconfig.OracleConnection;
//author:raja.kumar@stltech.in

public class LoginDaoImp implements LoginDao {

	
	private static Connection con;
	static {
		
		try {
			con=OracleConnection.getOracleConnection();
			System.out.println("Oracle Connection is established....!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<User> getAllUser() throws SQLException {
		// TODO Auto-generated method stub
		
        String sql="select * from login";
		
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		List<User>users=new ArrayList<User>();
		if(rs.next())
		{
			User user=new User();
		    user.setUsername(rs.getString(1));
		    user.setPassword(rs.getString(2));
			users.add(user);
		}
		
		return users;
	}

	@Override
	public User getUserById(String username) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql="select username,password from login where username=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1, username);
		ResultSet rs=stmt.executeQuery();
		if(rs.next())
		{
			User user=new User();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			return user;
		}
		return null;
	}

	@Override
	public void insert(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into login values(?,?)";
		PreparedStatement stmt= con.prepareStatement(sql);
		
		stmt.setString(1, user.getUsername());
		stmt.setString(2, user.getPassword());
		
		int updateCount=stmt.executeUpdate();
		if(updateCount>0)
			System.out.println("New user is added successfully....!");
		else
			System.out.println("Sorry! user couldn't be added....");
		
		
	}

	@Override
	public void update(User user) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update login set username=? where password=?";
		PreparedStatement stmt= con.prepareStatement(sql);
		
		stmt.setString(1, user.getUsername());
		stmt.setString(2, user.getPassword());
		
		int updateCount=stmt.executeUpdate();
		if(updateCount>0)
			System.out.println("User is updated successfully....!");
		else
			System.out.println("Sorry! user couldn't be updated....");
		
	}

	@Override
	public void delete(User user) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql="delete from login where username=? ";
		PreparedStatement stmt= con.prepareStatement(sql);
		
		stmt.setString(1, user.getUsername());
		
		int updateCount=stmt.executeUpdate();
		if(updateCount>0)
			System.out.println("User is deleted successfully....!");
		else
			System.out.println("Sorry! user couldn't be deleted....");
		
	}
	
}
