<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.cars.domain.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新闻内容</title>
    
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
    <table border="1" cellspacing="0" cellpadding="0" width="100%"
            style="align:center;">
            <tr bgcolor="ff9900" style="font-weight:bold;">
                <th>新闻内容</th>
                
              
            </tr>
            <c:forEach items="${context}" var="news"> 
                <tr>
                	
                    <td>${context.context}</td>                  
                </tr>
            </c:forEach> 
        </table>
  </body>
</html>
