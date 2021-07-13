package com.phoenix.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

import com.phoenix.daos.ProductDao;
import com.phoenix.daos.ProductDaoImp;
import com.phoenix.data.Product;
import com.phoenix.exceptions.ProductNotFoundException;
import com.phoenix.exceptions.ServiceException;

public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao;
	
	
	
	
	public ProductServiceImpl()
	{
		productDao=new ProductDaoImp();
	}
	@Override
	public List<Product> findAll() throws ServiceException {
		// TODO Auto-generated method stub
		
	     try {
			return productDao.getAllProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public Product findProductById(int id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		try {
			return productDao.getProductById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ProductNotFoundException(e.getMessage());
		}
	}

	@Override
	public void add(Product product) throws ServiceException {
		// TODO Auto-generated method stub
	       try {
			productDao.insert(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void edit(Product product) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			productDao.update(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public void remove(Product product) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			productDao.delete(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public List<Product> findByName(String name) throws ServiceException {
		// TODO Auto-generated method stub
		List<Product>dbProducts=findAll();
		List<Product> productsByName=new ArrayList<Product>();
		
		for(Product product:dbProducts)
		{
			if(product.getName().equals(name))
				 productsByName.add(product);
			
		}
		return  productsByName;
		
	}

	@Override
	public List<Product> findByPrice(float price) throws ServiceException {
		// TODO Auto-generated method stub
		List<Product> dbPrice=findAll();
		List<Product> byPrice=new ArrayList<Product>();
		for(Product product:dbPrice)
		{
			if(product.getPrice()==price)
				byPrice.add(product);
		}
		
		return byPrice;
	}

	@Override
	public List<Product> findByPriceRange(float minPrice, float maxPrice) throws ServiceException {
		// TODO Auto-generated method stub
		List<Product> dbPrice=findAll();
		List<Product> byPrice=new ArrayList<Product>();
		
		for(Product product:dbPrice)
		{
			if(product.getPrice()>=minPrice && product.getPrice()<=maxPrice)
				byPrice.add(product);
		}
		return byPrice;
	}

	@Override
	public List<Product> findByNameAndPrice(String name, float price) throws ServiceException {
		// TODO Auto-generated method stub
		List<Product> dbPrice=findAll();
		List<Product> byNameAndPrice=new ArrayList<Product>();
		
		for(Product product:dbPrice)
		{
			if(product.getName().equals(name) && product.getPrice()==price)
				byNameAndPrice.add(product);
		}
		
		return byNameAndPrice;
	}

	@Override
	public List<Product> sortByName() throws ServiceException {
		// TODO Auto-generated method stub
		List<Product>products=findAll();
		products.sort((Comparator<? super Product>) products.get(2));
		
		return products;
	}

	@Override
	public List<Product> sortByPrice() throws ServiceException {
		// TODO Auto-generated method stub
		List<Product>products=findAll();
		products.sort((Comparator<? super Product>) products.get(3));
		return null;
	}

	@Override
	public List<Product> sortByPriceDesc() throws ServiceException {
		// TODO Auto-generated method stub

		return null;
	}


}
