package javaBean;

public class User {
	
	private String name;
	private String psw;
	private int age;
	
	//�޲ι��췽��
	public User() {
		super();
	}
	//���ι��췽�� 3������
	public User(String name, String psw,int age) {
		super();
		this.name = name;
		this.psw = psw;
		this.age = age;
	}
	//���ι��췽�� 2������
		public User(String name, String psw) {
			super();
			this.name = name;
			this.psw = psw;
		}
	

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	
	
}
