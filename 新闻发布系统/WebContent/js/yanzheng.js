$(document).ready(function(){
	//添加失去焦点事件
	$("#uname").blur(function(){
		//1 获取用户名
		let name =this.value;
		//2 发送异步请求
		//$.get("../AjaxReg","uname="+name,callback);//方法1
		$.post("../AjaxReg",{uname:name},callback);//方法2
		function callback(data){
			if(data=="true"){
				$("#yz").html("用户名已经被注册4");
			}else{
				$("#yz").html("用户名可以使用4");
			}
		}
		
		
	});
	
});

