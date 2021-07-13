package com.phoenix.exceptions;

//author: raja.kumar@stltech.in
public class ServiceException extends Exception{
       
	private String message;
	 public ServiceException(String message)
	 {
		 super();
		 this.message=message;
	 }
}
