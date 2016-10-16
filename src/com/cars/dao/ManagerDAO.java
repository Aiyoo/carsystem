package com.cars.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cars.domain.Manager;
import com.cars.util.BaseConnection;
public class ManagerDAO {
	public Manager findByManagerName(String name,String password){
		Connection conn=BaseConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Manager mg=new Manager();
		try{
			String sql="select * from manager where name='"+name+"'and password='"+password+"'";
			ps=conn.prepareStatement(sql);//获取PreparedStatement			
			rs=ps.executeQuery();	
			if(rs.next()){
				mg.setName(rs.getString("name"));
				mg.setPassword(rs.getString("password"));				
				return mg;
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
		return mg;
		
	}
}
