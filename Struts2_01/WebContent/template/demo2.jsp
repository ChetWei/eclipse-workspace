<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Action的访问</h1>
<h3>通过method的方式</h3>
<a href="${pageContext.request.contextPath }/userFind.action">用户查询</a>
<a href="${pageContext.request.contextPath }/userUpdate.action">用户修改</a>
<a href="${pageContext.request.contextPath }/userDelete.action">用户删除</a>
<a href="${pageContext.request.contextPath }/userSave.action">用户保存</a>

<h3>通过通配符的方式（实际开发中常用）</h3>
<a href="${pageContext.request.contextPath }/product_find.action">商品查询</a>
<a href="${pageContext.request.contextPath }/product_update.action">商品修改</a>
<a href="${pageContext.request.contextPath }/product_delete.action">商品删除</a>
<a href="${pageContext.request.contextPath }/product_save.action">商品保存</a>

<h3>通过动态方法访问</h3>
<a href="${pageContext.request.contextPath }/customer!find.action">商品查询</a>
<a href="${pageContext.request.contextPath }/customer!update.action">商品修改</a>
<a href="${pageContext.request.contextPath }/customer!delete.action">商品删除</a>
<a href="${pageContext.request.contextPath }/customer!save.action">商品保存</a>


</body>
</html>