package com.phoenix.services;

import java.sql.SQLException;
import java.util.List;

import com.phoenix.daos.LoginDao;
import com.phoenix.daos.LoginDaoImp;
import com.phoenix.data.User;
import com.phoenix.exceptions.ServiceException;
import com.phoenix.exceptions.UserAlreadyExistException;
import com.phoenix.exceptions.UserNotFoundException;

//author:raja.kumar@stltech.in
public class LoginServiceImpl implements LoginService {
    private LoginDao loginDao;
	
    public LoginServiceImpl()
    {
    	loginDao =new LoginDaoImp();
    	
    }
    
	@Override
	public List<User> getAllUser() throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return loginDao.getAllUser();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
		  throw new ServiceException(e.getMessage());
		}
		
	}

	@Override
	public User findByUserId(String username) throws UserNotFoundException {
		// TODO Auto-generated method stub
		
		try {
			return loginDao.getUserById(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UserNotFoundException(e.getMessage());
		}
	}

	@Override
	public void add(User user) throws UserAlreadyExistException {
		// TODO Auto-generated method stub
		try {
			loginDao.insert(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UserAlreadyExistException(e.getMessage());
		}
		
	}

	@Override
	public void edit(User user) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			loginDao.update(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage()); 
		}
		
	}

	@Override
	public void remove(User user) throws ServiceException {
		// TODO Auto-generated method stub
		
		try {
			loginDao.delete(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage()); 
		}
	}

	@Override
	public String changePassword(String password) throws ServiceException {
		// TODO Auto-generated method stub
		User user=new User();
		user.setPassword(password);
		try {
			loginDao.update(user);
			return "Password is updated successfully....!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		  throw new ServiceException(e.getMessage());
		}
		
		
	}

}
