package com.cars.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cars.dao.UserDAO;


public class loginUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public loginUserServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		String username = request.getParameter("username");
		request.getSession().setAttribute("username",username);
		String password = request.getParameter("password");
		//Users user = new Users();
		UserDAO userdao = new UserDAO();
		if(userdao.findByUserName(username,password)!=null){
			//request.getSession().setAttribute("username", username);
			response.getWriter().write("欢迎"+request.getSession().getAttribute("username")+"登陆成功，3秒后返回主页");
			response.setHeader("Refresh", "1;url="+request.getContextPath()+"/fixcar.jsp");
			request.getSession().setAttribute("username", username);
			}else{
				response.getWriter().write("用户名或密码错误，请重新登陆");
				//response.setHeader("Refresh", "1;url="+request.getContextPath()+"/Login.jsp");
				getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
			}
		
		}
}
