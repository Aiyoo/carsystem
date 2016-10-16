package com.cars.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cars.dao.FixCarsDAO;
import com.cars.dao.OrderCarDAO;
import com.cars.domain.FixCars;
import com.cars.domain.OrderCar;

public class myOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;utf-8	");
		String username = (String) request.getSession()
				.getAttribute("username");
		username = new String(username.getBytes("iso8859-1"), "utf-8");
		OrderCarDAO odc=new OrderCarDAO();
		ArrayList<OrderCar> ordercarlist=odc.QueryOrderCar(username);
		request.setAttribute("ordercarlist", ordercarlist);
		getServletContext().getRequestDispatcher("/ShowMyOrder.jsp").forward(
				request, response);
		
	}

}
