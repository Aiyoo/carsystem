<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>汽车显示列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equ
	iv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  欢迎用户：<%=request.getSession().getAttribute("username") %>
  <body>

 	<a href="servlet/QueryCarMessageServlet?carname=宝马">宝马</a><br>
 	<a href="servlet/QueryCarMessageServlet?carname=奔驰">奔驰</a><br>
 	<a href="servlet/QueryCarMessageServlet?carname=凯迪拉克">凯迪拉克</a><br>
 	<a href="servlet/QueryCarMessageServlet?carname=丰田">丰田</a><br>
 	<a href="servlet/QueryCarMessageServlet?carname=大众">大众</a><br>
 	
  </body>
</html>
