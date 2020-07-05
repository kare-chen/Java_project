<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<title>发布新闻</title>
<style type="text/css">
li {
	font-size: 18px
}
</style>
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">发布新闻</h3>
		</div>

		<div class="panel-body">

			<form class="form-horizontal" action="../newsAddSvlt">
				<div class="form-group">
					<label for="title" class="col-sm-2 control-label">新闻标题</label>
					<div class="col-sm-10">
						<input name="title" class="form-control" id="title"
							placeholder="标题请简单">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">新闻正文</label>
					<div class="col-sm-10">
						<textarea name="content" class="form-control" rows="3"></textarea>
					</div>
				</div>
				<%--前端获取用户 --%>
		<%--		<input type=hidden name="userName" 
				value='<%=session.getAttribute("UserName") %>'>
		--%>
				<%--前端写日期 --%>
				<input type=hidden name="date" 
				value='<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>'>
				
				
							<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">提交</button>
						<input type="reset" name="cmdCancel" value="重置"
							class="btn btn-default">
					</div>
				</div>

			</form>


		</div>
	</div>


</body>
</html>>