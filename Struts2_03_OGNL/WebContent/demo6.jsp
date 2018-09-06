<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ONGL #号的应用</title>
</head>
<body>
<h1>OGNL表达式#号的使用</h1>
<h4>构建list集合</h4>
	<s:iterator var="i"  value="{'a','b','c'}">
		<s:property value="i"/>	-- <s:property value="#i"/> </br>
	</s:iterator>
<h4>构建Map集合</h4>
	<s:iterator var="map" value="#{'姓名':'张三','年龄','18'}">
		<s:property value="key"/>--<s:property value="value"/> <br/>
		<s:property value="#map.key"/>--<s:property value="#map.value"/> <hr/>
	</s:iterator>
	
<h4>使用radio</h4>
<s:radio list="#{'1':'男','2':'女'}" name="sex" label="性别">
</s:radio>
</body>
</html>