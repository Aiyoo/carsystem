package com.cars.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cars.domain.Users;
import com.cars.util.BaseConnection;

public class UserDAO {
	public Users findByUserName(String username,String password){
		Connection conn=BaseConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Users user=new Users();
		try{
			String sql="select * from user where username='"+username+"'and password='"+password+"'";
			ps=conn.prepareStatement(sql);//获取PreparedStatement
			//ps.setInt(1, user.getUserid());
			rs=ps.executeQuery();	
			if(rs.next()){
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				//user.setSex(rs.getString("sex"));
				//user.setPnumber(rs.getString("pnumber"));
				return user;
			}
			return null;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if (rs!=null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		//return true;
		return user;
		
	}
	//添加用户
	public boolean addUser(Users user){
		Connection conn=BaseConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			String sql="insert into user(username,password,sex,pnumber)values(?,?,?,?)";
			ps=conn.prepareStatement(sql);//获取PreparedStatement
			//ps.setInt(1, user.getUserid());
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getPnumber());
			ps.executeUpdate();		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if (rs!=null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return true;
	}	
		public boolean findUser(Users user){
			
			return true;	
		}
		
//		public boolean isExist(Users user){
//			Connection conn=BaseConnection.getConnection();
//			PreparedStatement ps=null;
//			ResultSet rs=null;
//			boolean isExist;
//			//Users users=new Users();
//			try{
//				String sql="select * from user where username=?";
//				ps=conn.prepareStatement(sql);
//				ps.setString(1, user.getUsername());
//				rs=ps.executeQuery();
//				if(rs!=null){
//					System.out.println("用户名已存在");
//					isExist=false;
//				}
//			}catch(Exception e){
//				e.printStackTrace();
//			}finally{
//				try {
//					if (rs != null) {
//						rs.close();
//					}
//					if (ps != null) {
//						ps.close();
//					}
//					if (conn != null) {
//						conn.close();
//					}
//				} catch (Exception e) {
//					// TODO: handle exception
//					e.printStackTrace();
//				}
//			}
//			return true;
//			
//		}
}
