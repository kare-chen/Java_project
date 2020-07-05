package common;

import java.sql.*;

public class DBUtil{
	private static final String URL = "jdbc:mysql://localhost:3306/web_java"+"?characterEncoding=utf-8";//���ݿ����ӵĵ�ַ
	private static final String LOGIN = "root";//��¼���ݿ���û���
	private static final String PASSWORD = "123456";//��¼���ݿ������
	//��Ա��������
	Connection conn=null;//���Ӷ���
	Statement st=null;//ִ��sql���Ķ���
	private ResultSet rs=null;//���������Ų�ѯ�Ľ��
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	///��Ҫ�ĳ�Ա����4��
	void getConnection(){//1.���ݿ�����
		try {
			//��һ����������������
			Class.forName("com.mysql.jdbc.Driver");
			//�ڶ������������ݿ�
			conn=DriverManager.getConnection(URL,LOGIN,PASSWORD);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ����ӳ����������������Ƿ���ڣ��������Ƿ���ȷ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ����ӳ��������¼���û��������Ƿ���ȷ�����ݿ�������Ƿ�����");
		}
		
	}
	//2.���ݿ�Ĳ�ѯ
	public ResultSet executeQuery(String sql){
		try {
			//����������������ִ��sql���Ķ���
			if(st==null){
				getConnection();//�����˵�һ���͵ڶ���
				st=conn.createStatement();
			}
			//���Ĳ���ִ��sql���
			rs=st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ��ѯִ�г�������sql��"+sql);
		}
		return rs;
	}
	//3.���ݿ����ɾ��
	public int executeUpdate(String sql){
		int ret=0;
		try {
			//����������������ִ��sql���Ķ���
			if(st==null){
				getConnection();//�����˵�һ���͵ڶ���
				st=conn.createStatement();
			}
			//���Ĳ���ִ��sql���
			ret=st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret=-1;//ʧ�ܵ�ʱ���趨Ϊ-1
			System.out.println("���ݿ���ɾ��ִ�г�������sql��"+sql);
		}
		return ret;
	}
	//4.���ݿ�Ĺر�
	public void close(){
		try {
			if (rs!=null) {
				rs.close();
			}
			if (st!=null) {
				st.close();
			}
			if (conn!=null) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}