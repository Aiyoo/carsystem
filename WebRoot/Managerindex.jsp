<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fixcar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body,td{
	font-family:宋体;
	font-size:15px;
	color:#000;
}
.tit{
	background-color:#03f;
	color:#fff;
	font-size:14px;
	font-weight:bold;
	font-family:宋体;
	padding:10px;
}

.inputtxt{
	border:1px solid #03f;
	width:200px;
	height:20px;
}
</style>
  </head>
  <jsp:include page="isLogin.jsp"></jsp:include> 
  <body>
 
    欢迎管理员<%=request.getSession().getAttribute("mgname") %><br>
<a href="/Cars/servlet/MgloginoutServlet">注销</a>
    <form action="servlet/addNewsServlet" method="post" >
      <table width="320" cellpadding="5" cellspacing="0" align="center" border="1" bgcolor="#00FFCC">
	<tr>
		<td width="120" align="center">新闻标题：</td>
		<td width="200"><input type="text" name="title"  /></td>
	</tr>
	<tr>
		<td width="120" align="center">新闻内容：</td>
		<td width="200"><textarea name="context" rows="5" cols="0"></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="center" ><input type="submit" value="添加新闻"/></td>
        
	</tr>
    <tr>
		<td colspan="2" align="center" ><input type="reset" value="重置"/></td>
        
	</tr>
</table>
	
	</form>
  </body>
</html>
