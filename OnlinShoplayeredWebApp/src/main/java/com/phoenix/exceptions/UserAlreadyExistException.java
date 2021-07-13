package com.phoenix.exceptions;

//author: raja.kumar@stltech.in
public class UserAlreadyExistException extends Exception {
	 private String message;
	 public UserAlreadyExistException (String message)
	 {
		 super();
		 this.message=message;
	 }
}
