package com.cars.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cars.domain.FixCars;
import com.cars.util.BaseConnection;

public class FixCarsDAO {
	//添加维修汽车
	public boolean addFixCars(FixCars fixcar){
		Connection conn=BaseConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="insert into fixcar(username,carname,type,fixreason,indate)values(?,?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			//ps.setInt(1, fixcar.getCarid());
			ps.setString(1, fixcar.getUsername());
			ps.setString(2, fixcar.getCarname());
			ps.setString(3, fixcar.getType());
			ps.setString(4, fixcar.getFixreason());
			ps.setString(5, fixcar.getIndate());
			//ps.setString(7, fixcar.getOutdate());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
	//查询维修情况
	public ArrayList<FixCars> showFixCar(String username){
		ArrayList<FixCars> fcs=new ArrayList<FixCars>();
		Connection conn=BaseConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			String sql="select * from fixcar where username='"+username+"'";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				FixCars fc=new FixCars();//应该每次都创建一个对象
				fc.setCarname(rs.getString("carname"));
				fc.setFixreason(rs.getString("fixreason"));
				fc.setType(rs.getString("type"));
				fc.setIndate(rs.getString("indate"));
				fcs.add(fc);
				
			}
		}catch(Exception e){
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
		return fcs;
		
		
	}
}
