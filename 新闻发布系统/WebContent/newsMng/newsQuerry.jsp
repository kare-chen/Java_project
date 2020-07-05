<%@page import="javaBean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/new01/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
table{padding:20px}
</style>
<title>查看新闻</title>
</head>
<body>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">查看新闻</h3>
		</div>
		<div class="panel-body">
			<form class="form-inline" action="/new01/NewsQuerrySvlt">
				<div class="form-group">
					<label>新闻标题</label>
					<input type="text" class="form-control" name="title"
						placeholder="请输入标题关键字">
				</div>
				<div class="form-group">
					<label>发布人</label> 
					<input type="text" class="form-control" name="pubName">
				</div>
				<input type=hidden name="myflag" value='query'>
				<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon glyphicon-search"> 查询
				</button>
			</form>
			
<c:if test="${fn:length(allNews)>0}">
			<table class="table table-hover table-striped" >
				<tr>
				  <td class="active">新闻标题</td>
				  <td class="success">新闻摘要</td>
				  <td class="warning">发布人</td>
				  <td class="danger">发布时间</td>
				  <td class="info">操作</td>
				</tr>
				
				<%-- <tr>
				  <td class="active">${a }</td>
				  <td class="success">${b.getTitle() }</td>
				  <td class="warning">${b.getContent() }</td>
				  <td class="danger"></td>
				  <td class="info"></td>
				</tr> --%>
		
		
			<c:forEach var="news" items="${allNews }">
				<tr>
				  <td >${news.getContent() }</td>
				  
				  <td>${news.getTitle() }</td>
				  <td>${news.getUserName() }</td>
				  <td>${news.getPubtime() }</td>
				  <td>
				  <a href="/new01/NewsReadSvlt?newsId=${news.getId() }&flag=1" class="btn btn-primary btn-sm active" role="button">详情</a>
				  
				  <a href="/new01/NewsReadSvlt?newsId=${news.getId() }&flag=2" class="btn btn-primary btn-sm active" role="button">修改</a>
				  <c:if test="${news.isSelf() }">
				  <a href="/new01/NewsReadSvlt?newsId=${news.getId() }&flag=2" class="btn btn-primary btn-sm active" role="button">删除</a>
				  
				  </c:if>
				  </td>
				</tr>	
			</c:forEach>
			</c:if>
			<c:if test="${fn:length(allNews)==0}">没有相关新闻数据</c:if>
			</table>
			<%--
			<c:choose>
					<c:when test="${fn:length(allNews)>0 }">
						<c:forEach var="news" items="${allNews }">
							<tr>
								<td class="active">${news.getTitle() }</td>

								<td class="success">${news.getContent() }</td>
								<td class="warning">${news.getUserName() }</td>
								<td class="danger">${news.getPubtime() }</td>
								<td class="info"></td>
							</tr>
						</c:forEach>
					</c:when>

					<c:otherwise>  没有数据
  					 </c:otherwise>
				</c:choose> --%>
		</div>
	</div>



</body>
<script type="text/javascript" src="/new01/js/jquery.js"></script>
<script type="text/javascript" src="/new01/js/bootstrap.min.js"></script>
</html>