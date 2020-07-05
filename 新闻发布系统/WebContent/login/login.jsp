<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">

<title>登陆页面</title>
</head>
<body>
	
	<form class="form-horizontal" action="../login" style="margin-top:30px;">
		  <div class="form-group">
		    <label  class="col-sm-2 control-label">用户名：</label>
		    <div class="col-sm-4">
		      <input type="text" name="uname" class="form-control"  placeholder="用户名">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
		    <div class="col-sm-4">
		      <input type="password" name="psw" class="form-control" id="inputPassword3" placeholder="Password">
		    </div>
		  </div>
		 
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-success">登录</button>
		      <button type="reset" class="btn btn-info">重置</button>
		    </div>
		  </div>
	</form>
	
</body>

</html>