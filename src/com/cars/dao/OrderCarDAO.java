package com.cars.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cars.domain.OrderCar;
import com.cars.util.BaseConnection;

public class OrderCarDAO {
	
	//预定汽车
	public boolean orderCar(OrderCar oc){
		Connection conn=BaseConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="insert into ordercar(carname,type,username,price,indate)values(?,?,?,?,?)";
		try{
			ps=conn.prepareStatement(sql);
			ps.setString(1, oc.getCarname());
			ps.setString(2, oc.getType());
			ps.setString(3, oc.getUsername());
			ps.setDouble(4, oc.getPrice());
			ps.setString(5, oc.getIndate());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	//查询预定汽车
	public ArrayList<OrderCar> QueryOrderCar(String username){
		ArrayList<OrderCar> ordercarlist=new ArrayList<OrderCar>();
		Connection conn=BaseConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			String sql="select * from ordercar where username='"+username+"'";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				OrderCar oc=new OrderCar();
				oc.setCarname(rs.getString("carname"));
				oc.setType(rs.getString("type"));
				//oc.setUsername(rs.getString("username"));
				oc.setPrice(rs.getDouble("price"));
				oc.setIndate(rs.getString("indate"));
				ordercarlist.add(oc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		
		return ordercarlist;
		
	}
}
