package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBUtil;
import javaBean.User;

public class LoginDao {
	DBUtil dbUtil = new DBUtil();//鑾峰彇鐐掍綔鏁版嵁搴�
	//鏌ヨ鐢ㄦ埛鏄惁瀛樺湪
	public int isUserExist(User user){
		boolean iue=false;
		int type=2;
		//鏌ヨ鐢ㄦ埛鏄惁瀛樺湪
		String sql ="SELECT * from newsusers WHERE name='"+user.getName()+"'and psw='"+user.getPsw()+"'";
		ResultSet rSet = dbUtil.executeQuery(sql);
		
		System.out.println("sql:"+sql);
		
		//鍒ゆ柇鏄惁鏌ヨ鍒扮粨鏋�
		try {
			if (rSet.next()) {
				String name=rSet.getString(2);
				String psw=rSet.getString("psw");
				type=rSet.getInt("type");
				
				iue= true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
	}
}
