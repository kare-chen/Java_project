package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.glass.ui.CommonDialogs.Type;

import common.DBUtil;
import model.LoginModel;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//璋冪敤model灞�
		LoginModel loginModel = new LoginModel();
		//寰楀埌model鍋氫簨缁撴灉
		int type = loginModel.yanZheng(request);
		//鏍规嵁缁撴灉鍐冲畾椤甸潰鐨勮烦杞�
		//鍒ゆ柇鐢ㄦ埛绫诲瀷
		//鏅�氱敤鎴穒ndex_user.jsp
		//绠＄悊鍛� index_admin.jsp
		System.out.println("type:"+type);
		if (type==1) {
			response.sendRedirect("index/index_user.jsp");
		}else if(type==0) {
			request.getRequestDispatcher("index/index_admin.jsp").forward(request, response);
		}else {
			response.sendRedirect("reg/register.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
