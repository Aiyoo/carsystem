package com.cars.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cars.dao.CarDAO;
import com.cars.domain.Cars;

public class buyCarServlet extends HttpServlet {

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
		//Integer carid=Integer.valueOf(request.getParameter("carid"));
		String carname=request.getParameter("carname");
		String type=request.getParameter("type");
		//double price=(double)request.getParameter("price");
		CarDAO cardao=new CarDAO();
		Cars car=new Cars();
		if(cardao.subUsercount(carname, type)){
			request.getSession().setAttribute("carname", carname);
			request.getRequestDispatcher("PayCar.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("PayCar_err.jsp").forward(request, response);
		}
		
	}

}
