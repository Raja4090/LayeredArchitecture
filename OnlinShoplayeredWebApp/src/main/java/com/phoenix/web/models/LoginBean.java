package com.phoenix.web.models;

import com.phoenix.data.User;
import com.phoenix.exceptions.UserNotFoundException;
import com.phoenix.services.LoginService;
import com.phoenix.services.LoginServiceImpl;

public class LoginBean {
	//declared private datamembers
   private String username;
   private String password;
   
   //setter method
   
   public void setUsername(String username)
   {
	   this.username=username;
   }
   
   public void setPassword(String password)
   {
	   this.password=password;
   }
   
   
    //getter method
   public String getUsername()
   {
	   return username;
   }
   
   public String getPassword()
   {
	   return password;
   }
   
   //member method
   
   public boolean isValid() throws UserNotFoundException
   {
	   LoginService loginService=new LoginServiceImpl();
	   User dbUser=loginService.findByUserId(username);
	   
	   if(username!=null && password!=null && 
			   dbUser!=null&&password.equals(dbUser.getPassword()))
		   return true;
	   else
		   return false;
   }
}
