package com.phoenix.services;

import java.sql.SQLException;
import java.util.List;

import com.phoenix.data.User;
import com.phoenix.exceptions.ServiceException;
import com.phoenix.exceptions.UserAlreadyExistException;
import com.phoenix.exceptions.UserNotFoundException;
//author:raja.kumar@stltech.in
public interface LoginService {
	List<User>getAllUser() throws ServiceException;
	User findByUserId(String username)throws UserNotFoundException;
	
	void add(User user)throws UserAlreadyExistException;
	void edit(User user)throws ServiceException;
	void remove(User user)throws ServiceException;
	String changePassword(String password) throws ServiceException;
}
