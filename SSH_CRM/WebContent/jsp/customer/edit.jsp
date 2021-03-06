﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="true"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="css/Style.css"
	type=text/css rel=stylesheet>
<LINK href="css/Manage.css"
	type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>

<script type="text/javascript"
	src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.post("${pageContext.request.contextPath }/baseDict_findByTypeCode.action",
						{
							"dict_type_code" : "003"
						}, 
						function(data) {
							$(data).each(function(i, n) {
										$("#cust_source").append(
										"<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>"
										);
									});
							//使用EL获取值栈的数据
							$("#cust_source option[value='${model.baseDictSource.dict_id}']").prop("selected","selected");
						},"json");
	});
	$(function() {
		$.post("${pageContext.request.contextPath }/baseDict_findByTypeCode.action",
						{
							"dict_type_code" : "001"
						}, 
						function(data) {
							$(data).each(
									function(i, n) {
										$("#cust_industry").append(
										"<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>"
										);
									});
							//使用EL获取值栈的数据
							$("#cust_industry option[value='${model.baseDictIndustry.dict_id}']").prop("selected","selected");
						},"json");
					
	});
	$(function() {
		$.post("${pageContext.request.contextPath }/baseDict_findByTypeCode.action",
						{
							"dict_type_code" : "005"
						}, 
						function(data) {
							$(data).each(
									function(i, n) {
										$("#cust_level").append(
										"<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>"
										);
									});
							//使用EL获取值栈的数据
							$("#cust_level option[value='${model.baseDictSource.dict_id}']").prop("selected","selected");
						
						},"json");
	});
</script>

</HEAD>
<BODY>
	<s:actionerror />
	<s:fielderror />
	<s:form name="form1" id="form1"
		action="customer_save.action"
		method="post" enctype="multipart/form-data" theme="simple">

		<s:textfield id="sChannel2" cssClass="textbox" cssStyle="WIDTH: 180px"
									maxLength="50" name="cust_id" value="%{model.cust_id}" 
									type="hidden" 
									/>
									
			

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG
						src="images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background=images/new_020.jpg height=20></TD>
					<TD width=15><IMG
						src="images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=images/new_022.jpg><IMG
						src="images/new_022.jpg"
						border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 修改客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5 border=0>
							<TR>
							
								<td>客户名称：</td>
								<td>
								<s:textfield id="sChannel2" cssClass="textbox" cssStyle="WIDTH: 180px"
									maxLength="50" name="cust_name" value="%{model.cust_name}" />
	
								</td>
								
								<td>客户级别 ：</td>
								<td>
									<select id="cust_level" name="baseDictLevel.dict_id">
										<option value="">--客户级别--</option>
									</select>
								</td>
							
							</TR>

							<TR>
								<td>信息来源：</td>
								<td>
									<select id="cust_source" name="baseDictSource.dict_id">
										<option value="">--信息来源--</option>
									</select>
								</td>
								
								
								<td>所属行业：</td>
								<td>
									<select id="cust_industry" name="baseDictIndustry.dict_id">
										<option value="">--所属行业--</option>
									</select>
								</td>
							</TR>
							<TR>


								<td>固定电话 ：</td>
								<td>
								<s:textfield id="sChannel2" cssClass="textbox" cssStyle="WIDTH: 180px"
									maxLength="50" name="custPhone" value="%{model.cust_phone}" />
								</td>
								
								<td>移动电话 ：</td>
								<td>
								<s:textfield id="sChannel2" cssClass="textbox" cssStyle="WIDTH: 180px"
									maxLength="50" name="custMobile" value="%{model.cust_mobile}" />
								</td>				
							</TR>

							<TR>
								<td>客户资质 ：</td>
								<td colspan="3"><input type="file" name="upload"></td>

							</TR>
				
							<tr>
								<td rowspan=2><INPUT class=button id=sButton2 type=submit
									value=" 保存 " name=sButton2></td>
							</tr>
						</TABLE>


					</TD>
					<TD width=15
						background="images/new_023.jpg">
						<IMG src="images/new_023.jpg"
						border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG
						src="images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="images/new_025.jpg"
						height=15></TD>
					<TD width=15><IMG
						src="images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>

	</s:form>
</BODY>
</HTML>
