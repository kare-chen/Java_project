package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxReg
 */
@WebServlet("/AjaxReg")
public class AjaxReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AjaxReg() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("uname");
		System.out.println("用户名："+name);
		boolean isUsed=false;
		//人为规定：除了hlg以外  其他用户名均可使用
		if("hlg".equals(name)){
			isUsed=true;
		}
		PrintWriter out = response.getWriter();
		out.print(isUsed);
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
