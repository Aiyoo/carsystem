package com.cars.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cars.dao.CarDAO;
import com.cars.domain.Cars;


public class addCarServlet extends HttpServlet {

	
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
		String carname=request.getParameter("carname");
		carname=new String(carname.getBytes("iso8859-1"),"utf-8");
		String type=request.getParameter("type");
		type=new String(type.getBytes("iso8859-1"),"utf-8");
		Double price=Double.parseDouble(request.getParameter("price"));
		String intro=request.getParameter("intro");
		intro=new String(intro.getBytes("iso8859-1"),"utf-8");
		int carcount=Integer.parseInt(request.getParameter("carcount")) ;
		
		
		//--------分割线-------
		//上传图片路径

		//--------分割线-------
		
		
		
		Cars cars=new Cars();//创建CarsBean对象cars
		CarDAO cardao=new CarDAO();//创建DAO对象
		cars.setCarname(carname);//cars调用set方法将从JSP页面获取的参数封装起来
		cars.setType(type);
		cars.setPrice(price);
		cars.setIntro(intro);
		cars.setCarcount(carcount);
		
		
		
		if(cardao.queryCarByCarname(carname, type)!=null)
			cardao.addCar(cars);//调用添加汽车的方法		
		getServletContext().getRequestDispatcher("/addcar.jsp").forward(request, response);
		
		
	}

}
