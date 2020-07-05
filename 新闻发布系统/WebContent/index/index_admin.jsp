<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">

<title>普通用户主界面</title>
<style type="text/css">
body{margin:0;padding:0;}
div{position:absolute;width:100%;height:100%}
#iframeTop{width:100%;height:100px;}
#iframeLeft{width:15%;height:100%;float:left;}
#iframeRight{width:85%;height:100%;}

</style>
</head>
<body>
	<div>
		<iframe id="iframeTop" name="top" src="topAdmin.jsp" frameBorder="1"></iframe>
		<iframe id="iframeLeft" name="left" src="leftAdmin.jsp" frameBorder="1"></iframe>
		<iframe id="iframeRight" name="right" src="rightAdmin.jsp" frameBorder="1"></iframe>
	</div>


</body>
</html>