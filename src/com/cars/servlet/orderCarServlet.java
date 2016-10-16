package com.cars.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cars.dao.CarDAO;
import com.cars.dao.OrderCarDAO;
import com.cars.domain.OrderCar;

public class orderCarServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "utf-8");
		String carname=(String)request.getParameter("carname");
		carname=new String(carname.getBytes("iso8859-1"),"utf-8");
		String type=(String)request.getParameter("type");
		type=new String(type.getBytes("iso8859-1"),"utf-8");
		String username=(String)request.getSession().getAttribute("username");
		Double price=Double.parseDouble(request.getParameter("price"));
		Date date=new Date(System.currentTimeMillis());
		SimpleDateFormat datefm = new SimpleDateFormat("yyyy-MM-dd");
		CarDAO cd= new CarDAO();
		OrderCarDAO ocd=new OrderCarDAO();
		OrderCar oc=new OrderCar();
		oc.setCarname(carname);
		oc.setType(type);
		oc.setUsername(username);
		oc.setPrice(price);
		oc.setIndate(datefm.format(date));		
		
		if(ocd.orderCar(oc))
		cd.subUsercount(carname, type);
		response.getWriter().write("order success");
//		CarDAO cardao= new CarDAO();
		
		
		
		
		
	}

}
