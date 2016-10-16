package com.cars.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.cars.dao.ManagerDAO;
import com.cars.dao.NewsDAO;
//import com.cars.domain.Manager;
import com.cars.domain.News;

public class addNewsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		String title=request.getParameter("title");
		String context=request.getParameter("context");
		title=new String(title.getBytes("iso8859-1"),"utf-8");
		context=new String(context.getBytes("iso8859-1"),"utf-8");
		java.util.Date date = new java.util.Date(); 
		SimpleDateFormat datefm = new SimpleDateFormat("yyyy-MM-dd");
		String date1=datefm.format(date);
		NewsDAO newsdao=new NewsDAO();
		News news=new News();
		news.setTitle(title);
		news.setContext(context);
		news.setDate(date1);
		
		if(newsdao.addNews(news)){
			response.getWriter().write("添加成功，1秒后返回管理页面");
			getServletContext().getRequestDispatcher("/Managerindex.jsp").forward(request, response);
		}else{
			response.getWriter().write("添加失败，请重新添加");
			getServletContext().getRequestDispatcher("/Managerindex.jsp").forward(request, response);
		}
	}

}
