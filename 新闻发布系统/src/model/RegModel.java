package model;

import javax.servlet.http.HttpServletRequest;

import dao.RegDao;
import javaBean.User;

public class RegModel {

	//完成注册功能
	public boolean saveUser(HttpServletRequest request){
		boolean isSuccsess = false;
		//获取参数
		String name = request.getParameter("uname");
		String psw = request.getParameter("psw");
		int age = Integer.parseInt(request.getParameter("age"));
		//构建用户
		User user = new User(name, psw,age);
		
		//调用Dao做事
		RegDao regDao = new RegDao();
		isSuccsess = regDao.insertUser(user);
		return isSuccsess;
	}
}
