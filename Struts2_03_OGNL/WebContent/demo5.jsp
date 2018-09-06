<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ONGL获取数据</h1>

<h3>获取保存在值栈的对象中的数据</h3>
姓名:<s:property value="name"/><br/>
密码:<s:property value="password"/><br/>

<h3>获取保存在值栈的集合中的数据</h3>
<s:iterator value="list">
	<s:property value="name"/>
	<s:property value="password"/>
</s:iterator>
<hr/>
姓名:<s:property value="list[0].name"/><br/>
密码:<s:property value="list[0].password"/><br/>
姓名:<s:property value="list[1].name"/><br/>
密码:<s:property value="list[1].password"/><br/>
姓名:<s:property value="list[2].name"/><br/>
密码:<s:property value="list[2].password"/><br/>

<h3>获取保存在context中的数据</h3>
request域中的数据:<s:property value="#request.reqName"/><br/>
session域中的数据:<s:property value="#session.sessionName"/><br/>
application域中的数据:<s:property value="#application.appName"/><br/>
attr中的数据(#attr可以获取request,session,application中的数据):<s:property value="#attr.appName"/><br/>
parameters中的数据:<s:property value="#parameters.id"/><br/>

<hr>
<h3>EL获取值栈中的数据</h3>
${reqName}
</body>
</html>