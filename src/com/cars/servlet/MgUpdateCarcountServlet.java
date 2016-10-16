package com.cars.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cars.dao.CarDAO;
import com.cars.domain.Cars;

public class MgUpdateCarcountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		CarDAO cardao = new CarDAO();
		Cars cars = new Cars();
		String carname = request.getParameter("carname");
		carname = new String(carname.getBytes("iso8859-1"), "utf-8");// 手动编码
		String type = request.getParameter("type");
		int carcount = Integer.parseInt(request.getParameter("carcount"));
		type = new String(type.getBytes("iso8859-1"), "utf-8");
		cars.setCarname(carname);
		cars.setType(type);
		cars.setCarcount(carcount);
		//cars = cardao.updateCarCount(carname, type, carcount);
		cars = cardao.updateCarCount(carname, type, carcount);
		response.getWriter().write("更新库存成功");
//		response.setHeader("Refresh", "1;url=" + request.getContextPath()
//				+ "/MgUpdateCarcount.jsp");
		getServletContext().getRequestDispatcher("/MgUpdateCarcount.jsp").forward(request, response);
/*
		int carcount = Integer.parseInt(request.getParameter("carcount"));
		carcount = cars.getCarcount() + carcount;
		cars.setCarcount(carcount);

		if (cardao.updateCarCount(carname, type, carcount) != null) {
		}*/
	}
}
