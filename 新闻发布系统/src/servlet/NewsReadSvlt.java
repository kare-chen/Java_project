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
@WebServlet("/NewsReadSvlt")
public class NewsReadSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsReadSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入到后台");
		//解决中文乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		//1调用model层
		NewsMngModel newsMngModel = new NewsMngModel();
		//2得到model做事
		int id=Integer.parseInt(request.getParameter("newsId"));
		//1详情2修改
		int flag=Integer.parseInt(request.getParameter("flag"));
		System.out.println("flag:"+flag);
		try {
			News n = newsMngModel.querryNewsById(id);
			request.setAttribute("news", n);
			//3 根据结果判断跳转
			if (flag==1) {
				request.getRequestDispatcher("/newsMng/newsRead.jsp").forward(request, response);
				
			}
			
				request.getRequestDispatcher("/newsMng/newsUpdate.jsp").forward(request, response);
			
		} catch (SQLException e) {
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
