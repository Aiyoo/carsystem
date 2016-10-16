package com.cars.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cars.domain.CarsAndUsers;
import com.cars.util.BaseConnection;

public class CarsAndUsersDAO {
	public boolean addCU(CarsAndUsers cau) {
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "insert into caranduser(userid,username,carid,carname)values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cau.getUserid());
			ps.setString(2, cau.getUsername());
			ps.setInt(3, cau.getCarid());
			ps.setString(4, cau.getCarname());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return true;
	}
}
