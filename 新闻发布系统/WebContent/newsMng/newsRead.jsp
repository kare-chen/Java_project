<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="/new01/css/bootstrap.min.css" rel="stylesheet">
<title>新闻详情</title>
</head>
<body>
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">新闻详情</h3>
  </div>
  
  <div class="panel-body">
    <form class="form-horizontal">
	  <div class="form-group">
	    <label  class="col-sm-2 control-label">新闻标题</label>
	    <div class="col-sm-10">
	      <input type="text" value="${news.getTitle() }" readonly="readonly" class="form-control" >
	    </div>
	  </div>
	  <div class="form-group">
	    <label  class="col-sm-2 control-label">新闻正文</label>
	    <div class="col-sm-10">
	     	<textarea class="form-control" rows="10" >${news.getContent() }</textarea>
	    </div>
	  </div>  
	  <div class="form-group">
	    <label  class="col-sm-2 control-label">发布人</label>
	    <div class="col-sm-10">
	     	 <input type="text" value="${news.getUserName() }" readonly="readonly" class="form-control" >
	    </div>
	  </div>
	  <div class="form-group">
	    <label  class="col-sm-2 control-label">发布时间</label>
	    <div class="col-sm-10">
	     	 <input type="text" value="${news.getPubtime() }" readonly="readonly" class="form-control" >
	    </div>
	  </div>
	
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="button" class="btn btn-info" onclick="history.back();">返回</button>
	    </div>
	  </div>
</form>
  </div>
</div>
</body>
</html>