package com.cars.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//import java.util.ArrayList;

import com.cars.domain.Cars;
import com.cars.util.BaseConnection;

public class CarDAO {
	//更新汽车库存量
	public Cars updateCarCount(String carname,String type,int carcount){
		Cars cars=new Cars();
		Connection conn=BaseConnection.getConnection();
		PreparedStatement ps=null;
		//ResultSet rs=null;
		
		try{
			String sql="update car set carcount = carcount + '"+carcount+"' where carname='"+carname+"' and type='"+type+"'" ;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate(sql);
			/*if(rs.next()){
				cars.setCarname(rs.getString("carname"));
				cars.setType(rs.getString("type"));
				
				cars.setCarcount(rs.getInt("carcount"));
				
				return cars;
			}*/
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				/*if (rs!=null) {
					rs.close();
				}*/
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
		
		return cars;
		
	}
	
	//查询汽车库存量的方法
	public Cars queryCarcount(String carname,String type){
		Cars cars=new Cars();
		Connection conn=BaseConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			String sql="select carcount from car where carname='"+cars.getCarname()+"' and type='"+cars.getType()+"'";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()){
				cars.setCarname(rs.getString("carname"));
				cars.setType(rs.getString("type"));
				cars.setCarcount(rs.getInt("carcount"));
				return cars;
			}
			
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
		return cars;
		
		
		
	}
	
	//添加汽车的方法
	public Cars  addCar(Cars cars){
		//Cars car=new Cars();
		Connection conn=BaseConnection.getConnection();//注册驱动
		PreparedStatement ps=null;//获取连接器
		ResultSet rs=null;//返回结果集
		
		try{
			String sql="insert into car(carname,type,images,price,intro,carcount)values(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,cars.getCarname());
			ps.setString(2, cars.getType());
			ps.setString(3, cars.getImages());
			ps.setDouble(4, cars.getPrice());	
			ps.setString(5, cars.getIntro());
			ps.setInt(6, cars.getCarcount());
			ps.executeUpdate();		
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
		return cars;
	}
	//查询汽车 
	public Cars queryCarByCarname(String carname,String type){
		//ArrayList<Cars> cars=new ArrayList<Cars>();//实例化一个ArrayList对象。
		Cars cars=new Cars();
		Connection conn=BaseConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			String sql="select * from car where carname='"+carname+"' and type='"+type+"'";
			ps=conn.prepareStatement(sql);
			//ps.setString(1, car.getCarname());
			rs=ps.executeQuery();
			while(rs.next()){
				cars.setCarid(rs.getInt("carid"));
				cars.setCarname(rs.getString("carname"));
				cars.setType(rs.getString("type"));
				//cars.setPrice(rs.getDouble("price"));
				//cars.setIntro(rs.getString("intro"));
				//cars.setCarcount(rs.getInt("carcount"));
				//cars.add(car);//将查询的结果存储到结果集中
				return cars;
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
		return cars;
		
	}
/*	//汽车数量的增加；
	public boolean addUsercount(Cars car){
		Connection conn=BaseConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			String sql="update car set carcount=carcount+1 where carid=? ";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, car.getCarid());
			ps.executeUpdate();
			
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
		return true;
		}*/
	//汽车数量的减少；
	public boolean subUsercount(String carname,String type){
		Cars cars=new Cars();
		Connection conn=BaseConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			String sql="update car set carcount=carcount-1 where carname='"+carname+"' and type='"+type+"' ";
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();	
			return true;
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
		return true;
		}
	
	//用户查询汽车信息，将汽车信息显示到预定界面。
	public ArrayList<Cars> queryCarMessage(String carname){
		ArrayList<Cars> carlist=new ArrayList();
		
		Connection conn=BaseConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			String sql="select * from car where carname='"+carname+"'";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery(sql);
			while(rs.next()){
				Cars cars=new Cars();
				cars.setCarid(rs.getInt("carid"));
				cars.setCarname(rs.getString("carname"));
				cars.setType(rs.getString("type"));
				cars.setPrice(rs.getDouble("price"));
				cars.setIntro(rs.getString("intro"));
				cars.setCarcount(rs.getInt("carcount"));
				carlist.add(cars);
				
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
		return carlist;
		
	}
	
}
