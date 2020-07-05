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

@WebServlet("/NewsDelSvlt")
public class NewsDelSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsDelSvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决中文乱码
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=UTF-8");
				
				System.out.println("进入到后台了");
				System.out.println("Id:"+request.getParameter("newsId"));

				// 1调用model层
				NewsMngModel newsMngModel = new NewsMngModel();
				// 2得到model做事
				boolean isSuss=newsMngModel.delNewsById(request);
				// 3 根据结果判断页面跳转
				request.getRequestDispatcher("newsMng/newsDel.jsp").forward(request, response);
				// 从定向
				//response.sendRedirect("newsMng/newsDel.jsp");

				
				
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
