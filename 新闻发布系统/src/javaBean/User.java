package javaBean;

public class User {
	
	private String name;
	private String psw;
	private int age;
	
	//无参构造方法
	public User() {
		super();
	}
	//带参构造方法 3个参数
	public User(String name, String psw,int age) {
		super();
		this.name = name;
		this.psw = psw;
		this.age = age;
	}
	//带参构造方法 2个参数
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
