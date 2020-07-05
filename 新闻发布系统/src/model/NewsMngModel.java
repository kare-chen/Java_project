package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import common.DBUtil;
import dao.NewsMngDao;
import javaBean.News;

public class NewsMngModel {
	
	//增加新闻
	public boolean addNews(HttpServletRequest request){
		boolean isSuccess=false;
		//获取前端参数
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		//方法2 从前端获取日期数据
		String date= request.getParameter("date");
		//前端获取用户名
		String uname=request.getParameter("userName");
		//从服务端获取数据
		//日期的第一种表示方法
		//Date date1=new Date();
		//System.out.println("date1:"+date1);
		//String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
		//日期的第2种表示方法
		//String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		//System.out.println("date:"+date);
		//根据参数构建新闻对象
		News news=new News(title,content);
		news.setPubtime(date);
//		news.setUserName(uname);
		news.setUserName((String)request.getSession().getAttribute("UserName"));
		//调用dao层处理数据相关操作	
		NewsMngDao newsMngDao=new NewsMngDao();
		isSuccess=newsMngDao.add(news);
		return isSuccess;
	}

	//查询新闻
	public List<News> querryNews(HttpServletRequest request) throws SQLException{
		List newsList = new ArrayList<>();
		//获取前端查询数据
		String title=request.getParameter("title");
		String pubname=request.getParameter("pubName");
		//获取当前登录用户名
		String longinName=(String)request.getSession().getAttribute("UserName");
		
		News news=new News();
		news.setTitle(title);
		news.setUserName(pubname);
		//dao层获取数据
		
		NewsMngDao newsMngDao = new NewsMngDao();
		//调用查询新闻fangfa
		newsList=newsMngDao.querry(news,longinName);
		//newsList =newsMngDao.querry();
		return newsList;
		
	}
	
	
	//根据ID查询新闻
	public News querryNewsById(int id) throws SQLException{
		//dao层获取数据	
		NewsMngDao newsMngDao = new NewsMngDao();
		//调用查询新闻fangfa
		News news=newsMngDao.getNewsById(id);
		return news;
		
	}
	
	//修改新闻
	public boolean updateNews(HttpServletRequest request){
		boolean isSuccess=false;
		//获取前端参数
		String title=request.getParameter("title");//必须与jsp页面name属性值一致
		String content=request.getParameter("content");
		String date= request.getParameter("date");
		String zhaiyao = request.getParameter("zhaiyao");
		int id= Integer.parseInt(request.getParameter("Id"));
		//利用参数构建一个news对象
		News news= new News(title, content);
		news.setId(id);
		news.setPubtime(date);
		news.setZhaiYao(zhaiyao);
		//调用dao层进行数据库处理
		NewsMngDao newsMngDao=new NewsMngDao();
		//调用dao对应的方法处理修改新闻
		isSuccess=newsMngDao.update(news);
				
		return isSuccess;
	}
	
	
	
	//根据ID删除新闻
	public boolean delNewsById(HttpServletRequest request){
		boolean isSuccess=false;
		//Dao层进行删除
		NewsMngDao dao=new NewsMngDao();
		int id=Integer.parseInt(request.getParameter("newsId"));
		//得到结果
		News news=new News();
		news.setId(id);
		//调用dao层处理数据相关操作	
		
		isSuccess=dao.delById(id);
		return isSuccess;	
	}
	
	

}
