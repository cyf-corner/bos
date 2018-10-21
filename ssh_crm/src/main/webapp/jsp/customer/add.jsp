<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- 引入JSTL核心标签库 -->
<%@ taglib uri="/struts-tags" prefix="s" %><!-- 引入struts2标签 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加客户</title> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<link href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/LoadSelect.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		loadSelect("002","source","cust_source.dict_id",6);
		loadSelect("003","level","cust_level.dict_id",10);
		loadSelect("001","industry","cust_industry.dict_id",2);
	});
</script>
<meta content="MSHTML 6.00.2900.3492" name=GENERATOR>
</head>
<body>
	<!-- 此处有文件上传时，表单提交类型必须为多段式enctype -->
	<form id=form1 name=form1 action="${pageContext.request.contextPath }/CustomerAction_add" method=post enctype="multipart/form-data">
		<table cellSpacing=0 cellPadding=0 width="98%" border=0>
			<tbody>
				<tr>
					<td width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg" border=0></td>
					<td width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg" height=20></td>
					<td width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg" border=0></td>
				</tr>
			</tbody>
		</table>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg">
						<img src="${pageContext.request.contextPath }/images/new_022.jpg" border=0>
					</TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<table cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 添加客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</table>
						
						<table cellSpacing=0 cellPadding=5  border=0>
						  
						    
							<tr>
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="cust_name">
								</td>
								<td>客户级别 ：</td>
								<td id="level">
								</td>
							</tr>
							
							<tr>
								<td>信息来源 ：</td>
								<td id="source">
								</td>
								<td>客户行业 ：</td>
								<td id="industry">
								</td>
								<td>联系人：</td>
								<td>
								<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="cust_linkman">
								</td>
							</tr>
							
							<tr>
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="cust_phone">
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="cust_mobile">
								</td>
							</tr>
							
							<tr>
								<td>图片上传</td>
								<td>
									<input type="file" name="file" />
								</td>
							</tr>
							
							<tr>
								<td rowspan=2>
								<input class=button id=sButton2 type=submit value="保存 " name=sButton2>
								</td>
							</tr>
						</table>
						
						
					</td>
					<td width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
						<img src="${pageContext.request.contextPath }/images/new_023.jpg" border=0>
					</td>
				</tr>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg" border=0></TD>
					<TD align="center" width="100%" background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
