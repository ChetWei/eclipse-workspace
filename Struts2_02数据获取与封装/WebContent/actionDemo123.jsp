<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<h1>Struts2数据封装-属性驱动提供set方法</h1>
	<form action="actionDemo1.action" method="post">
		用户名:<input type="text" name="username"/><br/>
		密码:<input type="password" name="password"/><br/>
		年龄:<input type="text" name="age"/> <br/>
		生日:<input type="text" name="birthday"/> <br/>
		工资:<input type="text" name="salary"/> <br/>
		<s:fielderror />
		<input type="submit" value="提交">
	</form>
	
	<h1>Struts2数据封装-属性驱动页面中提供表达式方式</h1>
	<form action="actionDemo2.action" method="post">
		用户名:<input type="text" name="user.username"/><br/>
		密码:<input type="password" name="user.password"/><br/>
		年龄:<input type="text" name="user.age"/> <br/>
		生日:<input type="text" name="user.birthday"/> <br/>
		工资:<input type="text" name="user.salary"/> <br/>
		<input type="submit" value="提交">
	</form>
	
	<h1>Struts2数据封装-模型驱动</h1>
	<form action="actionDemo3.action" method="post">
		用户名:<input type="text" name="username"/><br/>
		密码:<input type="password" name="password"/><br/>
		年龄:<input type="text" name="age"/> <br/>
		生日:<input type="text" name="birthday"/> <br/>
		工资:<input type="text" name="salary"/> <br/>
		<input type="submit" value="提交">
	</form>
</body>
</html>