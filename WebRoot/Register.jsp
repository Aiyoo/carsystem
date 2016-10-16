<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<title>注册页面</title> 


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/style_register.css">
<script type="text/javascript" src="kindeditor/kindeditor-all-min.js"></script>
<script type="text/javascript" src="kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="/editor/lang/zh-CN.js"></script>
<style type="text/css">
body,td{
	font-family:宋体;
	font-size:12px;
	color:#000;
}
.tit{
	background-color:#00FFCC;
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

<body>
	<form action="servlet/registerUserServlet" method="post" >
     <table width="360" cellpadding="5" cellspacing="0" align="center" border="1">
	<tr>
		<td colspan="2" class="tit">用户注册</td>
	</tr>
	
	<tr>
		<td width="100" align="right">用户名：</td>
		<td width="260"><input type="text" name="username" /></td>
	</tr>
	<tr>
		<td width="100" align="right">密码：</td>
		<td width="260"><input type="password" name="password" /></td>
	</tr>
    <tr>
		<td width="100" align="right">性别：</td>
		<td width="260"><input type="radio" name="sex" value="男"  checked="checked"/>男&nbsp;
					<input type="radio" name="sex" value="女" />女&nbsp;
				</td>
	</tr>
    <tr>
		<td width="100" align="right">联系方式：</td>
		<td width="260"><input type="text" name="pnumber"  /></td>
	</tr>
	<tr>
	  <td colspan="2" align="right" ><input type="submit" value="注冊"/>
		  <label>  <input type="reset" value="重置"> </label></td>
	</tr>
</table>
		
	</form>
</body>
</html>
