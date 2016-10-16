<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>预定汽车页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
 欢迎用户：<%=request.getSession().getAttribute("username") %>
 <jsp:include page="isUserLogin.jsp"></jsp:include> 
  <body>
 
    <center>
        <h1>欢迎进入汽车预订系统</h1>
        <hr>
        <table border="1" cellspacing="0" cellpadding="0" width="100%"
            style="align:center;">
            <tr bgcolor="ff9900" style="font-weight:bold;">
                <th>汽车名</th>
                <th>汽车型号</th>
                <th>汽车价格</th>
                <th>汽车介绍</th>
                
                <th width="100" colspan="2">操作</th>
            </tr>
            <c:if test="${not empty carlist}">
            <c:forEach items="${carlist}" var="cars">
                <tr>
                    <td>${cars.carname }</td>
                    <td>${cars.type }</td>
                    <td>${cars.price}</td>
                    <td>${cars.intro}</td>
                    
                    <td><a href="servlet/orderCarServlet?carname=${cars.carname }&type=${cars.type }&price=${cars.price }">购买</a></td>
                </tr>
            </c:forEach>
            </c:if>
        </table>
    </center>

  </body>
</html>
