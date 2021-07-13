package com.phoenix.exceptions;
//author: raja.kumar@stltech.in

public class UserNotFoundException extends Exception{
	 private String message;
	 public UserNotFoundException (String message)
	 {
		 super();
		 this.message=message;
	 }
}
