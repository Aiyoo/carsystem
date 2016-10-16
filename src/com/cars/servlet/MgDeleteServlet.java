package com.cars.servlet;

import java.io.IOException;
import java.util.ArrayList;
//import java.io.PrintWriter;

//import javax.ejb.Remove;
//import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cars.dao.NewsDAO;
import com.cars.domain.News;

public class MgDeleteServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;charset=utf-8");

		int id =Integer.parseInt(request.getParameter("id"));
		//News news=new News();
		NewsDAO newsdao=new NewsDAO();
		if(newsdao.deleteNews(id)){
			ArrayList<News> newstitle= newsdao.queryNews();
			request.setAttribute("newstitle", newstitle);
			getServletContext().getRequestDispatcher("/MgDeleteNews.jsp").forward(request, response);
		}
		else {
			response.setHeader("Refresh", "1;url="+request.getContextPath()+"/MgDeleteNews.jsp");
		}
		
	}

}
