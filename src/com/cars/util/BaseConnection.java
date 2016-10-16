package com.cars.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseConnection {
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull", "root", "root");
			/*if(conn!=null){
				System.out.println("success");
			}else{
				System.out.println("faild");
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return conn;
	}

	
	public static void main(String[] args) {
		Connection conn = BaseConnection.getConnection();
		System.out.println(conn);
		
	}
}
