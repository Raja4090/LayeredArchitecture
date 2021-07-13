package com.phoenix.daos;

import java.sql.SQLException;
import java.util.List;

import com.phoenix.data.Product;
import com.phoenix.data.User;
//author: raja.kumar@stltech.in

public interface ProductDao {
	List<Product>getAllProducts() throws SQLException;
	Product getProductById(int id)throws SQLException;
	
	void insert(Product product)throws SQLException;
	void update(Product product)throws SQLException;
	void delete(Product product)throws SQLException;
}
