package com.cars.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cars.dao.FixCarsDAO;
import com.cars.domain.FixCars;

public class showFixCarServlet extends HttpServlet {

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
		FixCarsDAO fcd = new FixCarsDAO();
		ArrayList<FixCars> fixcarlist=fcd.showFixCar(username);
		request.setAttribute("fixcarlist", fixcarlist);
		getServletContext().getRequestDispatcher("/showFixcar.jsp").forward(
				request, response);

	}

}
