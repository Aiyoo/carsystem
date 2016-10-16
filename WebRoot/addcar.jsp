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

		<title>管理员添加汽车界面</title>

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
<jsp:include page="isLogin.jsp"></jsp:include> 
	<body>
欢迎管理员<%=request.getSession().getAttribute("mgname") %><br>
<a href="/Cars/servlet/MgloginoutServlet">注销</a>
<form name="addcar" action="servlet/addCarServlet" method="POST" enctype="multipart/form-data">
	<script language="javascript" type="text/javascript">
	var type=[
     ["M1","M2","M3","M4","i3","i8","X1","X3","X4","X5","X6","Z4"],
     ["GLA","GLC","GLE","GLS","G","SLK","SL","AMG GT","R"],
     ["速腾","途观","高尔夫","宝来","迈腾","帕萨特","Polo","朗行","朗逸"],
     ["ATS-L","XTS","CTS","CT6","SRX","XT5","ESCALADE"],
     ["卡罗拉","雷凌","凯美瑞","86","普锐斯","普拉多","锐志","RAV4"],
     ];

     function getType(){      
         var sltCarname=document.addcar.carname;    
         var sltType=document.addcar.type;             
         var carType=type[sltCarname.selectedIndex - 1];
         sltType.length=1;
         for(var i=0;i<carType.length;i++){
             sltType[i+1]=new Option(carType[i],carType[i]);
         }
     }

    </script>
     <table width="350" cellpadding="5" cellspacing="0" align="center" border="1" bgcolor="#00FFCC">
      <tr>
		<td colspan="2" class="tit" align="center">管理员添加汽车</td>
	</tr>
	<tr>
		<td width="150" align="center">汽车名：</td>
		<td width="200">
		<select name="carname"  size="1" id="carname" onChange="getType()">
				<option value="0">
					-选择车名-
				</option>
				<option value="宝马">
					-宝马系列-
				</option>
				<option value="奔驰">
					-奔驰系列-
				</option>
				<option value="大众">
					-大众系列-
				</option>
				<option value="凯迪拉克">
					-凯迪拉克-
				</option>
				<option value="丰田">
					-丰田系列-
				</option>
			</select>
			</td>
	</tr>
    <tr>
		<td width="150" align="center">汽车类型：</td>
		<td width="200"> 
		   <select name="type"  size="1" id="cartype">
              <option value="1"> -选择车型- </option>
            </select>
            </td>
	</tr>
     <tr>
		<td width="150" align="center">汽车价格：</td>
		<td width="200"><input type="text" name="price"  /></td>
	</tr>
	
    <tr>
		<td width="150" align="center">汽车数量：</td>
		<td width="200"><input type="text" name="carcount"  /></td>
	</tr>
	<tr>
		<td width="150" align="center">上传图片：</td>
		<td width="200"> <INPUT type="file" name="imgname"></td>
	</tr>
	<tr>
		<td width="150" align="center">汽车简介：</td>
		<td width="200">  <textarea name="intro" rows="5" ></textarea>
				  </td>
	</tr>
	<tr>
		<td colspan="2" align="center" ><input type="submit" value="更新汽车库存" style="margin: auto;" /></td>     
	</tr>
</table>
		</form>
	</body>
</html>
