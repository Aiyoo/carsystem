package com.cars.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cars.domain.News;
import com.cars.util.BaseConnection;

public class NewsDAO {
	//删除新闻
	public boolean deleteNews(int id){
		Connection conn=BaseConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			String sql="delete from news where newsid='"+id+"'";
			ps=conn.prepareStatement(sql);
			ps.executeUpdate(sql);
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
	
	
	//添加新闻
	public boolean addNews(News news){
		Connection conn=BaseConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			String sql="insert into news(title,context,date)values(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, news.getTitle());
			ps.setString(2, news.getContext());
			ps.setString(3, news.getDate());
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
	}
	//查询新闻标题
	public ArrayList<News> queryNews(){

		ArrayList<News> news1=new ArrayList<News>();
		Connection conn=BaseConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			String sql="select * from news ";
			ps=conn.prepareStatement(sql);
			//ps.setString(1, news.getTitle());
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				News news = new News();
				news.setId(rs.getInt("newsid"));
				news.setTitle(rs.getString("title"));
				//news.setContext(rs.getString("context"));
				//news.setDate(rs.getString("date"));
				news1.add(news);
				//System.out.println(rs.getString("title"));
				
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
		return news1;
	}
	
	//返回总页数
	 public int getMaxPage(int rowsPerPage) {
	        int maxPage;
	        int maxRowCount = 0;
	        Connection conn=BaseConnection.getConnection();
			PreparedStatement ps=null;
			ResultSet rs=null;
	        try {
	            conn = BaseConnection.getConnection();  //创建数据库连接
	            String sql = "select count(*) from emp";
	            ps = conn.prepareStatement(sql);
	            rs = ps.executeQuery();
	            if (rs.next()){
	                maxRowCount = rs.getInt(1);  //总行数
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        maxPage = (maxRowCount + rowsPerPage - 1) / rowsPerPage;  //总页数
	        return maxPage;
	    }
	
	
	//查询新闻内容
	public News queryNewsContext(int id){
//		ArrayList<News> news1=new ArrayList<News>();
		News news=new News();
		Connection conn=BaseConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{
			String sql="select newsid,context from news where newsid='"+id+"'";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery(sql);
			while(rs.next()){
				news.setId(rs.getInt("newsid"));
				news.setContext(rs.getString("context"));
//				news1.add(news);
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
		return news;
		
		
	}
}
