package javaBean;

public class News {
	String title;
	String content;
	String userName;
	String pubtime;
	String zhaiYao;
	int Id;
	boolean isSelf;//判断新闻是否是登陆者自己发布的
	
	
	





	//无参数构造方法
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	//俩个参数构造方法
	public News(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	//4个参数构造函数方法
	public News(String title, String content, String userName, String pubtime) {
		super();
		this.title = title;
		this.content = content;
		this.userName = userName;
		this.pubtime = pubtime;
	}	
	
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPubtime() {
		return pubtime;
	}
	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}





	public String getZhaiYao() {
		return zhaiYao;
	}
	public void setZhaiYao(String zhaiYao) {
		this.zhaiYao = zhaiYao;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}


	public boolean isSelf() {
		return isSelf;
	}
	public void setSelf(boolean isSelf) {
		this.isSelf = isSelf;
	}
	
	







	
}
