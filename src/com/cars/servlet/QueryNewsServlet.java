package com.cars.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cars.dao.NewsDAO;
import com.cars.domain.News;

public class QueryNewsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		String title=request.getParameter("title");
		
		NewsDAO newsdao=new NewsDAO();
		News news=new News();
		
		ArrayList<News> newslist=newsdao.queryNews();
//		request.getSession().setAttribute("newslist",newslist);
//		response.setHeader("Refresh", "1;url="+request.getContextPath()+"NewsTitle.jsp");
//		
		request.setAttribute("newslist", newslist);
		getServletContext().getRequestDispatcher("/NewsTitle.jsp").forward(request, response);
	}

}
