package com.phoenix.services;
import java.util.List;
import com.phoenix.data.Product;
import com.phoenix.exceptions.ProductNotFoundException;
import com.phoenix.exceptions.ServiceException;

public interface ProductService {
	
	List<Product>findAll() throws ServiceException;
	Product findProductById(int id)throws ProductNotFoundException;
	void add(Product product) throws ServiceException;
	void edit(Product product) throws ServiceException;
	void remove(Product product) throws ServiceException;
	List<Product>findByName(String name) throws ServiceException;
	List<Product>findByPrice(float price) throws ServiceException;
	List<Product>findByPriceRange(float minPrice,float maxPrice) throws ServiceException;
	List<Product>findByNameAndPrice(String name,float price) throws ServiceException;
	List<Product>sortByName() throws ServiceException;
	List<Product>sortByPrice() throws ServiceException;
	List<Product>sortByPriceDesc() throws ServiceException;
	
	
	
	
	
}
