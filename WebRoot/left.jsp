<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<style type="text/css">
body,td{
	font-family:宋体;
	font-size:20px;
	color:#000;
}
</style>
<body>
 <%
   		String url=request.getContextPath()+"/servlet/DeleteNewsTitleServlet";
  %>


<p><a href="Managerindex.jsp" target="main">添加新闻</a></p>
<p><a href="<%=url %>" target="main">删除新闻</a></p>
<p><a href="addcar.jsp" target="main">添加汽车</a></p>
<p><a href="MgUpdateCarcount.jsp" target="main">更新库存量</a></p>


</body>
</html>