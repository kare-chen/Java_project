package model;

import javax.servlet.http.HttpServletRequest;

import dao.LoginDao;
import javaBean.User;

public class LoginModel {
	
	public int yanZheng(HttpServletRequest request){
		int type;
		//获取前端传递过来的参数
		String uname = request.getParameter("uname");
		String psw = request.getParameter("psw");
		
		
		//构建一个用户
		//第一种方法
//		User user = new User();
//		user.setName(uname);
//		user.setPsw(psw);
		//第二种方法
		User user = new  User(uname, psw);
		//调用数据库
		LoginDao loginDao = new LoginDao();
		type = loginDao.isUserExist(user);
		if (type!=2) {
			//将用户名保存到session中
			request.getSession().setAttribute("UserName", uname);
			
		}
		return type;
	}
}
