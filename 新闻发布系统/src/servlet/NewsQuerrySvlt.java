package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.News;
import model.NewsMngModel;

/**
 * Servlet implementation class NewsQuerrySvlt
 */
@WebServlet("/NewsQuerrySvlt")
public class NewsQuerrySvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsQuerrySvlt() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 解决中文乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("进入到后台");

		// 1调用model层
		NewsMngModel newsMngModel = new NewsMngModel();
		// 2得到model做事

		try {
			List newslist = newsMngModel.querryNews(request);
			System.out.println("查询的数据为" + newslist.size());
			//获取前端页面标识符
			String myflag=request.getParameter("myflag");
			// 3 根据结果判断跳转
			if (newslist.size() >= 0) {
				// 回到查询的界面
				request.setAttribute("allNews", newslist);
				// 3 根据结果判断跳转
				//
				request.setAttribute("a", "你好我是服务器");
				News ns = new News("新闻标题设置", "新闻类容");
				request.setAttribute("b", ns);
				//带参数跳转用转发
				if (myflag.equals("del")) {
					request.getRequestDispatcher("newsMng/newsDel.jsp").forward(request, response);
				}else if (myflag.equals("query")) {
					request.getRequestDispatcher("newsMng/newsQuerry.jsp").forward(request, response);
				}
				
			} else {
				//
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
