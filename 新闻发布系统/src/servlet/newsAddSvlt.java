package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NewsMngModel;
import model.RegModel;

/**
 * Servlet implementation class newsAddSvlt
 */
@WebServlet("/newsAddSvlt")
public class newsAddSvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public newsAddSvlt() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1调用model层
		NewsMngModel newsMngModel=new NewsMngModel();
		//2得到model做事
		boolean isSuccess=newsMngModel.addNews(request);
		//3 根据结果判断跳转
		if (isSuccess) {
			
			//插入成功跳转到查看新闻页面
			response.sendRedirect("cg.jsp");
		}else {
			//插入失败跳转到查看新闻页面
			response.sendRedirect("sb.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
