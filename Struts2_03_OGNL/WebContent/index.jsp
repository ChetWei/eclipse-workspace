<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>OGNL在Struts2使用</h3>
<h4>调用对象方法</h4>
<s:property value="'hello'.length()"/>
<h4>调用对象的静态方法,默认是关闭的需要开启常量</h4>
<s:property value="@java.lang.Math@random()"/>
<h4>获取存入值栈中的值,利用action在值栈中的特性</h4>
<%-- <s:property value="user.name"/> --%>

<h4>获取存入值栈中的值,利用ValueStack本身的方法,默认取栈顶的对象</h4>
<s:property value="name"/>
<s:property value="password"/>
<s:property value="keyname"/>

</body>
</html>