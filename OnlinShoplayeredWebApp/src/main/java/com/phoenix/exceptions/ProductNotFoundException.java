package com.phoenix.exceptions;
//author: raja.kumar@stltech.in
public class ProductNotFoundException extends Exception{
      
	 private String message;
	 public  ProductNotFoundException(String message)
	 {
		 super();
		 this.message=message;
	 }
}
