package com.cars.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cars.dao.FixCarsDAO;
import com.cars.domain.FixCars;

public class fixCarServlet extends HttpServlet {

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
		String username=(String)request.getSession().getAttribute("username");
		username=new String(username.getBytes("iso8859-1"),"utf-8");
		String carname=request.getParameter("carname");
		String type=request.getParameter("type");
		String fixreason=request.getParameter("reason");
		Date date=new Date(System.currentTimeMillis());
		SimpleDateFormat datefm = new SimpleDateFormat("yyyy-MM-dd");
		//String indate=request.getParameter("indate");
		carname=new String(carname.getBytes("iso8859-1"),"utf-8");;
		type=new String(type.getBytes("iso8859-1"),"utf-8");
		fixreason=new String(fixreason.getBytes("iso8859-1"),"utf-8");
		
		FixCars fixcar=new FixCars();
		FixCarsDAO fc=new FixCarsDAO();
		fixcar.setUsername(username);
		fixcar.setCarname(carname);
		fixcar.setType(type);
		fixcar.setFixreason(fixreason);
		fixcar.setIndate(datefm.format(date));
		//fixcar.setIndate(indate);
		if(fc.addFixCars(fixcar)){
			response.getWriter().write("提交成功,3秒后返回主页");
			response.setHeader("Refresh", "3;url="+request.getContextPath()+"/fixcar.jsp");
			System.out.print(datefm.format(date));
		}
		
		
		
		
	}

}
