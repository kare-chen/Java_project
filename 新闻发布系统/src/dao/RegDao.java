package dao;

import common.DBUtil;
import javaBean.User;

public class RegDao {

	//�������ݿ�
	DBUtil dbUtil = new DBUtil();//��ȡ�������ݿ���
	
	public boolean insertUser(User user){
		boolean isSuccsess=false;
		//��ȷ��дsql���
		String sql = "insert into newsusers(name,psw,age) VALUES('"+user.getName()+"','"+user.getPsw()+"','"+user.getAge()+"')";
		//����executeUpdateִ�в������
		int resulte = dbUtil.executeUpdate(sql);
		if (resulte>0) {
			isSuccsess=true;
		}
		dbUtil.close();
		return isSuccsess;
	}
	
	
	
}
