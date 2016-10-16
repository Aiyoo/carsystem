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

public class QureyContextServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		NewsDAO newsdao=new NewsDAO();
		News news=new News();
		int id=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("title");
//		String newstitle=request.getParameter("title");
		
		//String context= request.getParameter("context");
		
	
		News context;
			try {
				context = newsdao.queryNewsContext(id);
				System.out.println(context.getContext());
				request.setAttribute("context", context);
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			getServletContext().getRequestDispatcher("/ShowNews.jsp").forward(request, response);
			
//			ArrayList<News> newstitle= newsdao.queryNews();
//			request.setAttribute("newstitle", newstitle);
//			getServletContext().getRequestDispatcher("/MgDeleteNews.jsp").forward(request, response);
		
		
		
		
		
		
		
	}

}
