package dao;

import common.DBUtil;
import javaBean.User;

public class RegDao {

	//存入数据库
	DBUtil dbUtil = new DBUtil();//获取操作数据库类
	
	public boolean insertUser(User user){
		boolean isSuccsess=false;
		//正确书写sql语句
		String sql = "insert into newsusers(name,psw,age) VALUES('"+user.getName()+"','"+user.getPsw()+"','"+user.getAge()+"')";
		//调用executeUpdate执行插入操作
		int resulte = dbUtil.executeUpdate(sql);
		if (resulte>0) {
			isSuccsess=true;
		}
		dbUtil.close();
		return isSuccsess;
	}
	
	
	
}
