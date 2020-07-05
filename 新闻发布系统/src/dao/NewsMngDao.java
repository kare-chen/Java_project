package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.omg.Messaging.SyncScopeHelper;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import common.DBUtil;
import javaBean.News;

public class NewsMngDao {
	DBUtil dbUtil=new DBUtil();//鑾峰彇鐐掍綔鏁版嵁搴�
			//鏂板鏂伴椈
	public boolean add(News news){
		boolean isSuccess=false;
		String sql="insert into addnews(title,content,pubtime,userName)"
				+"values('"+news.getTitle()+"','"+news.getContent()+"','"+news.getPubtime()+"','"+news.getUserName()+"')";
		System.out.println("sql:"+sql);
		int result =dbUtil.executeUpdate(sql);
		if(result!=0){
			isSuccess=true;
		}
		return isSuccess;
	}
	
	
	//淇敼鏂伴椈
		public boolean update(News news){
			boolean isSuccess=false;
			String sql="update addnews set title='"
			+news.getTitle()+"',pubtime='"+news.getPubtime()+"',abstract='"+news.getZhaiYao()
			+"',content='"+news.getContent()+"'"
			+"where Id="+news.getId();
			System.out.println("sql:"+sql);
			int result=dbUtil.executeUpdate(sql);
			
			if(result!=0){
				isSuccess=true;
			}
			return isSuccess;
		}
	//鏌ヨ鏂伴椈
	//鏌ョ湅鎵�鏈夋柊闂�
	public List<News> querry() throws SQLException{
		List newsList=new ArrayList<>();
		String sql="select * from addnews";
		ResultSet rSet=dbUtil.executeQuery(sql);
		while (rSet.next()) {
			String title=rSet.getString("title");
			String content=rSet.getString("content");
			String uname=rSet.getString("userName");
			String pubTime=rSet.getString("pubtime");
			//News news =new
			News news  = new News(title, content, uname, pubTime);
			newsList.add(news);
			//newsList.add(news);
			
		}
		return newsList;
	}
	
	
	//鍒犻櫎鏂伴椈
	
	
	
	
	
	//閲嶈浇 閲嶅啓
	public List<News> querry(News news,String loginName) throws SQLException{
		List newsList=new ArrayList<>();
		String sql="select * from addnews where 1=1";
		String t=news.getTitle();
		String pubName=news.getUserName();
		//sql鏁版嵁鐨勬嫾鎺�
//		t.equals("")
		if (!"".equals(t)) {
			sql+=" and title like '%"+t+"%'";
			
		}
		if (!"".equals(pubName)) {
			sql+=" and userName like '%"+pubName+"%'";
			
		}
		
		//if () { }
		System.out.println("sql:"+sql);
		ResultSet rSet=dbUtil.executeQuery(sql);
		while (rSet.next()) {
			String title=rSet.getString("title");
			String content=rSet.getString("content");
			String uname=rSet.getString("userName");
			String pubTime=rSet.getString("pubtime");
			//News news =new
			
			int id=rSet.getInt("Id");
			//鍒ゆ柇杩欐潯鏂伴椈鏄惁鏄彂甯冭�呯殑鏂伴椈
			if (uname.equals(loginName)) {
				news.setSelf(true);
				
			}else {news.setSelf(false);
				
			}
			News news1  = new News(title, content, uname, pubTime);
			news1.setId(id);
			newsList.add(news1);
			
			//newsList.add(news1);
			//newsList.add(news);
			
		}
		return newsList;
	}
	
	
	//鏍规嵁ID鑾峰彇鏂伴椈
	public News getNewsById(int id)throws SQLException{
		News news=new News();
		//鏋勫缓sql
		String sql="select * from addnews where id="+id;
		ResultSet rSet =dbUtil.executeQuery(sql);
		System.out.println("sql:+"+sql);
		//澶勭悊缁撴灉
		if (rSet.next()) {
			String title=rSet.getString("title");
			String content=rSet.getString("content");
			String uname=rSet.getString("userName");
			String pubTime=rSet.getString("pubtime");
			
			String zhaiyao=rSet.getString("abstract");
			int Id=rSet.getInt("Id");
			//缁存姢鍐嶈瀛楁
			news=new News(title,content,uname,pubTime);
			//浠庢柊澶勭悊鏂扮殑淇╀釜瀛楁
			news.setZhaiYao(zhaiyao);

			news.setId(Id);
			
	}
	
	return news;
	}
	
	//鏍规嵁ID鍒犻櫎鏂伴椈
	public boolean delById(int id){
		boolean isSucc=false;
		String sql="delete from addnews where Id="+id;
		System.out.println("鍒犻櫎SQL:"+sql);
		int result = dbUtil.executeUpdate(sql);
		if(result > 0){
			isSucc = true;
		}
		return isSucc;
	}
	
	
}
