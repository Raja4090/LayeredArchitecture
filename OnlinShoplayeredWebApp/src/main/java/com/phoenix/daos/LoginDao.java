package com.phoenix.daos;
import java.sql.SQLException;
//author: raja.kumar@stltech.in
import java.util.List;
import com.phoenix.data.User;

public interface LoginDao {
     
	List<User>getAllUser() throws SQLException;
	User getUserById(String username)throws SQLException;
	
	void insert(User user)throws SQLException;
	void update(User user)throws SQLException;
	void delete(User user)throws SQLException;
}
