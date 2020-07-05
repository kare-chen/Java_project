package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.News;
import model.NewsMngModel;

/**
 * Servlet implementation class NewsUpdateSvlt
 */
@WebServlet("/NewsUpdateSvlt")
public class NewsUpdateSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsUpdateSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//参考新闻发布代码
		//调用model层
		NewsMngModel newsMngModel=new NewsMngModel();
		
		//获取结果
		boolean isSuccess=newsMngModel.updateNews(request);
		//查看所有新闻
		List<News> allnews=new ArrayList<News>();
		try {
			newsMngModel.querryNews(request);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//页面跳转
		if (isSuccess) {
			request.setAttribute("allnews", allnews);//key 必须同newsQuerry.jsp页面的同名
			request.getRequestDispatcher("newsMng/newsQuerry.jsp").forward(request, response);
		}
		
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
