package com.cars.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cars.dao.ManagerDAO;
import com.cars.dao.UserDAO;

public class loginManagerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		String name = request.getParameter("managername");
		request.getSession().setAttribute("mgname", name);
		String password = request.getParameter("password");
		ManagerDAO mgdao=new ManagerDAO();
		if(mgdao.findByManagerName(name, password)!=null){
			response.setHeader("Refresh", "1;url="+request.getContextPath()+"/shouye.jsp");
			
			}else{
				response.getWriter().write("管理员用户或密码错误，请重新登陆");
				response.setHeader("Refresh", "1;url="+request.getContextPath()+"/ManagerLogin.jsp");
			}
		
		}
	}


