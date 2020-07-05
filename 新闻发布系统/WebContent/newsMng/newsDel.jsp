<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/new01/css/bootstrap.min.css" rel="stylesheet">
<title>删除新闻</title>
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">删除新闻</h3>
		</div>
		<div class="panel-body">
			<form class="form-inline" action="/new01/NewsQuerrySvlt">
				<div class="form-group">
					<label>新闻标题</label> <input type="text" class="form-control"
						name="title" placeholder="请输入标题关键字">
				</div>
				<div class="form-group">
					<label>摘要</label> <input type="text" class="form-control"
						name="pubName">
				</div>
				<%--页面识别参数 --%>
				<input type=hidden name="myflag" value='del'>
				<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon glyphicon-search"> 查询 
				</button>
			</form>

			<c:if test="${fn:length(allNews)>0}">
				<table class="table table-hover">
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
							<td class="active">${news.getContent() }</td>

							<td class="success">${news.getTitle() }</td>
							<td class="warning">${news.getUserName() }</td>
							<td class="danger">${news.getPubtime() }</td>
							<td class="info">
								
				  <a href="#" class="btn btn-primary btn-sm active" role="button"
				  data-toggle="modal" data-target="#myModal" type="button"
				  onclick="delNews(${news.getId()})">删除</a>
				  <!-- 删除的弹框 -->
								
							</td>
						</tr>
					</c:forEach>

					<c:if test="${fn:length(allNews)==0}">没有数据</c:if>
				</table>
			</c:if>
			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">删除新闻</h4>
						</div>
						<div class="modal-body">你确定要删除吗？</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">返回</button>
							<!--  <button type="button" class="btn btn-primary">删除</button>  -->
							<a href="#" 
							class="btn btn-primary btn-sm active" id="delA" role="button"
				  			type="button">删除</a>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>



</body>

<script type="text/javascript" src="/new01/js/jquery.js"></script>
<script type="text/javascript" src="/new01/js/bootstrap.min.js"></script>

<script type="text/javascript" >
	function delNews(NewsId){
		alert(NewsId)
		$("#delA").attr("href","/new01/NewsDelSvlt?newsId="+NewsId);
	}
</script>
</html>