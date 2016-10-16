<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
    
    <title>汽车申请维修信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body> 
 欢迎用户：<%=request.getSession().getAttribute("username") %><br>

  <center>
        <h1>我的预约</h1>
        <hr>
        <table border="1" cellspacing="0" cellpadding="0" width="100%"
            style="align:center;">
            <tr bgcolor="ff9900" style="font-weight:bold;">
                <th>预约信息</th>
            </tr>
            <c:if test="${not empty ordercarlist}">
            <c:forEach items="${ordercarlist}" var="ordercarlist">
                <tr> 
                    <td>车名：${ordercarlist.carname}</td>                                     
                </tr>
                 <tr> 
                    <td>车型：${ordercarlist.type}</td>                                     
                </tr>
                 <tr> 
                    <td>价格：${ordercarlist.price}</td>                                     
                </tr>
                 <tr> 
                    <td>预约日期：${ordercarlist.indate}</td>                                     
                </tr>
            </c:forEach>
            </c:if>
        </table>
    </center>
	</body>
</html>
