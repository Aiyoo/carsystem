package com.cars.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cars.dao.CarDAO;
import com.cars.domain.Cars;

public class QueryCarMessageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setHeader("Content-Type", "text/html;charset=utf-8");
		String carname=request.getParameter("carname");
		carname=new String(carname.getBytes("iso8859-1"),"utf-8");
		CarDAO cardao=new CarDAO();
		ArrayList<Cars> carlist=cardao.queryCarMessage(carname);
//		request.getSession().setAttribute("carlist", carlist);
//		response.setHeader("Refresh", "1;url="+request.getContextPath()+"/CarMessage.jsp");
		request.setAttribute("carlist", carlist);
		getServletContext().getRequestDispatcher("/CarMessage.jsp").forward(request, response);
	}
	

}
