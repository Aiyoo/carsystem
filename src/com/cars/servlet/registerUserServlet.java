package com.cars.servlet;

import java.io.IOException; //import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cars.dao.UserDAO;
import com.cars.domain.Users;

public class registerUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public registerUserServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		// Integer userid=Integer.valueOf(request.getParameter("userid"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String pnumber = request.getParameter("pnumber");
		username=new String(username.getBytes("iso8859-1"),"utf-8");
		sex=new String(sex.getBytes("iso8859-1"),"utf-8");
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(sex);
		user.setPnumber(pnumber);

		UserDAO userdao = new UserDAO();

		if (userdao.findByUserName(username,password) != null) {
			response.getWriter().write("注册失败请重新注册！");
			response.setHeader("Refresh", "1;url=" + request.getContextPath()
					+ "/Register.jsp");
		} else if (userdao.addUser(user)) {
			//request.getSession().setAttribute("username", username);
			// request.getRequestDispatcher("Register_success.jsp").forward(request,response);
			
			response.getWriter().write("恭喜您注册成功,3秒后回到登陆界面。");
			response.setHeader("Refresh", "3;url=" + request.getContextPath()
					+ "/Login.jsp");
		}
		
		/*else {
			
			 * request.getRequestDispatcher("Register_fail.jsp").forward(request,
			 * response);
			 
			response.getWriter().write("注册失败请重新注册！");
			response.setHeader("Refresh", "1;url=" + request.getContextPath()
					+ "/Register.jsp");
		}*/

	}

}
