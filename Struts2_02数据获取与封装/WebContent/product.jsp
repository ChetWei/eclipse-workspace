<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Struts2复杂数据类型的封装  -- 封装到List集合</h2>
	<form action="productAction1.action" method="post">
		商品名称:<input type="text" name="product_list[0].name"><br/>
		商品价格:<input type="text" name="product_list[0].price"></br>
		商品名称:<input type="text" name="product_list[1].name"><br/>
		商品价格:<input type="text" name="product_list[1].price"></br>
		商品名称:<input type="text" name="product_list[2].name"><br/>
		商品价格:<input type="text" name="product_list[2].price"></br>
		<input type="submit" value="提交">
	</form>
	<h2>Struts2复杂数据类型的封装  -- 封装到Map集合</h2>
	<form action="productAction2.action" method="post">
		商品名称:<input type="text" name="product_map['0'].name"><br/>
		商品价格:<input type="text" name="product_map['0'].price"></br>
		商品名称:<input type="text" name="product_map['1'].name"><br/>
		商品价格:<input type="text" name="product_map['1'].price"></br>
		商品名称:<input type="text" name="product_map['2'].name"><br/>
		商品价格:<input type="text" name="product_map['2'].price"></br>
		<input type="submit" value="提交">
	</form>
</body>
</html>