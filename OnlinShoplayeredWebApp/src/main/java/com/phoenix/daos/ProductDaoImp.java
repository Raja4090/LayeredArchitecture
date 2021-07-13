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

public class ProductDaoImp implements ProductDao {
	
	
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
	public List<Product> getAllProducts() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from product1";
		
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		List<Product>products=new ArrayList<Product>();
		while(rs.next())
		{
			Product product=new Product();
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setPrice(rs.getFloat(3));
			
			products.add(product);
		}
		
		return products;
	}

	@Override
	public Product getProductById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from product1 where id=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1,id);
		ResultSet rs=stmt.executeQuery();
		if(rs.next())
		{
			Product product=new Product();
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setPrice(rs.getFloat(3));
			return product;
		}
		return null;
	}

	@Override
	public void insert(Product product) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into product1 values(?,?,?)";
		PreparedStatement stmt= con.prepareStatement(sql);
		stmt.setInt(1, product.getId());
		stmt.setString(2, product.getName());
		stmt.setFloat(3, product.getPrice());
		
		int updateCount=stmt.executeUpdate();
		if(updateCount>0)
			System.out.println("New product is added successfully....!");
		else
			System.out.println("Sorry! Product couldn't be added....");
	}

	@Override
	public void update(Product product) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update product1 set id=?,name=?,price=? where id=?";
		PreparedStatement stmt= con.prepareStatement(sql);
		stmt.setInt(1, product.getId());
		stmt.setString(2, product.getName());
		stmt.setFloat(3, product.getPrice());
		
		int updateCount=stmt.executeUpdate();
		if(updateCount>0)
			System.out.println("Product updated successfully....!");
		else
			System.out.println("Sorry! Product couldn't be updated....");
		
	}

	@Override
	public void delete(Product product) throws SQLException {
		// TODO Auto-generated method stub
		 
		String sql="delete from product1 where id=?";
		PreparedStatement stmt= con.prepareStatement(sql);
		stmt.setInt(1, product.getId());
		
		int updateCount=stmt.executeUpdate();
		if(updateCount>0)
			System.out.println("Product deleted successfully....!");
		else
			System.out.println("Sorry! Product couldn't be deleted....");
		
	}


}
