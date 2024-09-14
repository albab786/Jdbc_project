package com.jsp.jdbc_project_architecture_crud.service;

import com.jsp.jdbc_project_architecture_crud.dao.UserDao;
import com.jsp.jdbc_project_architecture_crud.dto.User;

public class UserService {

	UserDao dao = new UserDao();
	
	public User saveUserService(User user) {
		int year=user.getDob().getYear();
		if(year>=2000) {
			return dao.saveUserDao(user);
		}else {
			System.out.println("dob year must be greator than 1999");
			return null;
		}
	}
}
