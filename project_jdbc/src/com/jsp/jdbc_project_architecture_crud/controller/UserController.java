package com.jsp.jdbc_project_architecture_crud.controller;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Scanner;

import com.jsp.jdbc_project_architecture_crud.connection.UserConnection;
import com.jsp.jdbc_project_architecture_crud.dao.UserDao;
import com.jsp.jdbc_project_architecture_crud.dto.User;
import com.jsp.jdbc_project_architecture_crud.service.UserService;

public class UserController {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		UserDao dao = new UserDao();
		
		UserService service = new UserService();
		
		Connection connection = UserConnection.getUserConnection();
		while (true) {
			System.out.println("1.INSERT\n2.DELETE\n3.DISPLAYBYID\n4.UpdateUserName\n5INSERTMULTIPLEUSER");

			System.out.println("enter your option");

			int option = scanner.nextInt();

			switch (option) {

				case 1: {
					System.out.println("enter user id");
					int id = scanner.nextInt();
					scanner.nextLine();
					System.out.println("enter user name");
					String name = scanner.nextLine();
					System.out.println("enter user email");
					String email = scanner.nextLine();
					System.out.println("enter user address");
					String address = scanner.nextLine();
					//pass dob in this format "yyyy-MM-dd"
					System.out.println("enter user dob");
					String dob = scanner.next();

					LocalDate dob1 = LocalDate.parse(dob);

					User user = new User(id, name, email, address, dob1);

					User saveUser = service.saveUserService(user);

					if (saveUser != null) {
						System.out.println("user data inserted");
					} else {
						System.out.println("user data not inserted ....something went wrong");
					}

				}
				break;
				case 2: {
					System.out.println("enter id to delete");
					int id=scanner.nextInt();
					boolean b = dao.deleteUserById(id);
					if(b){
						System.out.println("data deleted succesfully");

					}else {
						System.out.println("data not found");
					}

				}
				case 3:{
					System.out.println("enter id to show user detail");
					int id=scanner.nextInt();
					User userbyIdDao = dao.getUserbyIdDao(id);
					if(userbyIdDao==null){
						System.out.println("data fetch sucessfully");
					}

				}
			}
		}

	}

}
