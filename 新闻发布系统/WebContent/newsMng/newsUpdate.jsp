<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/new01/css/bootstrap.min.css" rel="stylesheet">
<title>修改新闻</title>
</head>
<body>
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">新闻修改</h3>
  </div>
  
  <div class="panel-body">
    <form class="form-horizontal" action="/new01/NewsUpdateSvlt">
	  <div class="form-group">
	    <label  class="col-sm-2 control-label">新闻标题</label>
	    <div class="col-sm-10">
	      <input type="text" value="${news.getTitle() }" name="title" class="form-control" >
	    </div>
	  </div>
	  <div class="form-group">
	    <label  class="col-sm-2 control-label">新闻正文</label>
	    <div class="col-sm-10">
	     	<textarea class="form-control" rows="10" name="content">${news.getContent() }</textarea>
	    </div>
	  </div>  
	  <div class="form-group">
	    <label  class="col-sm-2 control-label">发布人</label>
	    <div class="col-sm-10">
	     	 <input type="text" value="${news.getUserName() }" readonly="readonly" class="form-control" >
	    </div>
	  </div>
	  <div class="form-group">
	    <label  class="col-sm-2 control-label">摘要</label>
	    <div class="col-sm-10">
	     	 <input type="text" value="${news.getZhaiYao() }" name="zhaiyao" class="form-control" >
	    </div>
	  </div>
	  <!-- 系统时间 -->
	  <input type=hidden name="date" 
				value='<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()) %>'>
	<!-- 新闻ID -->  
	  <input type=hidden name="Id" value="${news.getId() }">
	  <!-- 发布人 -->
	   <input type=hidden name="Id" value="${news.getUserName() }">
	
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="button" class="btn btn-info" onclick="history.back();">返回</button>
	      <button type="submit" class="btn btn-info" >提交</button>
	   
	    </div>
	  </div>
</form>
  </div>
</div>



</body>
</html>