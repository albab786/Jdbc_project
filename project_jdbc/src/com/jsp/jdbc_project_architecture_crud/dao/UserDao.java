package com.jsp.jdbc_project_architecture_crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jsp.jdbc_project_architecture_crud.connection.UserConnection;
import com.jsp.jdbc_project_architecture_crud.dto.User;

/**
 * this is userDao class which will communicate with db(MySQL)
 * @author Mo Masood Ansari
 */
public class UserDao {

	/**
	 * below line will connect this class with MySQL DB
	 * @see UserConnection
	 * @see //getUserConnection()
	 */
	Connection connection=UserConnection.getUserConnection();
	
	public final String INSERTUSERQUERY = "insert into user(id,name,email,address,dob) values(?,?,?,?,?)";
	
	public final String DELETEUSERBYIDQUERY="delete from user where id=?";
	public final String SELECTUSERBYID="select user from user where id=?";
	
	public User saveUserDao(User user) {
		
		try {
			PreparedStatement ps=connection.prepareStatement(INSERTUSERQUERY);
			ps.setInt(1,user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getAddress());
			ps.setObject(5, user.getDob());
			
			ps.execute();
			
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public boolean deleteUserById(int userId){
		try{
			PreparedStatement ps = connection.prepareStatement(DELETEUSERBYIDQUERY);
			ps.setInt(1,userId);
			int a=ps.executeUpdate();
			if(a!=0){
				return true;
			}else{
				return false;
			}
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	public User getUserbyIdDao(int userId){
		try{
			PreparedStatement ps=connection.prepareStatement(SELECTUSERBYID);
			ps.setInt(1,userId);
			ResultSet set = ps.executeQuery();
			if(set.next()){
				return new User(set.getInt("Id"),set.getString("name"),
						set.getString("email"), set.getString("address"), set.getDate("dob").toLocalDate());
			}else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
            return null;
        }
    }
	public List<User> saveMultipleUserDao(List<User> users){
     try{
		 PreparedStatement ps= connection.prepareStatement(INSERTUSERQUERY);
		 for (User user: users){
			 ps.setInt(1,user.getId());
			 ps.setString(2, user.getName());
			 ps.setString(3, user.getEmail());
			 ps.setString(4, user.getAddress());
			 ps.setObject(5, user.getDob());

			 ps.addBatch();

		 }
		 int a[]=ps.executeBatch();
		 System.out.println(a.length+"  row effected");
		 return users;
	 } catch (SQLException e) {
         e.printStackTrace();
		 return null;
     }
    }
	
}
