$(document).ready(function(){
		$("#uname").blur(function(){
			let uname = this.value;
			//alert(uname);
		/* 	$.ajax({
				type:"get",
				url:"../AjaxReg?uname="+uname,
				dataType:"json",
				success:function(data){
					if(data=="true"){
						$("#userNameVilid").html("用户名已经被注册");
					}else{
						$("#userNameVilid").html("用户名可以使用");
					}
				},
				error:function(){
					alert("异步请求失败");
				}
			}); */
			/* $.ajax({
				type:"post",
				url:"../AjaxReg",
				dataType:"json",
				data:{uname:uname},
				success:function(data){
					if(data=="true"){
						$("#userNameVilid").html("用户名已经被注册2");
					}else{
						$("#userNameVilid").html("用户名可以使用2");
					}
				},
				error:function(){
					alert("异步请求失败");
				}
			}); */
			//$.get("../AjaxReg","uname="+uname,cb);
			$.post("../AjaxReg",{uname:uname},cb);
			function cb(data){
				if(data=="true"){
					$("#userNameVilid").html("用户名已经被注册4");
				}else{
					$("#userNameVilid").html("用户名可以使用4");
				}
			}
		});
		
	});