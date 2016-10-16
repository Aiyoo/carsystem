package com.cars.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cars.domain.News;
import com.cars.dao.NewsDAO;
public class QueryTitleServlet extends HttpServlet {
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
		//String title=request.getParameter("title");
	//	News news=new News();
		NewsDAO newsdao = new NewsDAO();
		ArrayList<News> newstitle= newsdao.queryNews();
//		request.getSession().setAttribute("newstitle", newstitle);
//		response.setHeader("Refresh", "1;url="+request.getContextPath()+"/NewsTitleList.jsp");
		request.setAttribute("newstitle", newstitle);
		getServletContext().getRequestDispatcher("/NewsTitleList.jsp").forward(request, response);
	}

}
