<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.cars.domain.News;"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员删除新闻处理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <jsp:include page="isLogin.jsp"></jsp:include> 
  
  <body>
  欢迎管理员<%=request.getSession().getAttribute("mgname") %><br>
<a href="/Cars/servlet/MgloginoutServlet">注销</a> 
	
	
	<center>
        <h1>删除汽车新闻</h1>
        <hr>
        <table border="1" cellspacing="0" cellpadding="0" width="100%"
            style="align:center;">
            <tr bgcolor="ff9900" style="font-weight:bold;">
                <th>新闻标题</th>
                
                <th width="100" colspan="2">操作</th>
            </tr>
            <c:forEach items="${newstitle}" var="news">
                <tr>
                    <td>${news.title}</td>
                    <td><a href="servlet/MgDeleteServlet?id=${news.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </center>
	
	</body>
</html>
