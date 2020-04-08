package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBSUBanager;








/**
 * Servlet implementation class UserAddServlet
 */
@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;Charset=UTF-8");



		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String userName=request.getParameter("userName");
		String icon=request.getParameter("icon");
		String profile=request.getParameter("profile");
		DBSUBanager add=new DBSUBanager();
		add.getLoginUser(loginId, password, userName, icon, profile);




		PrintWriter out=response.getWriter();

		out.println("<html lang='ja'>");
		out.println("<head>");
		out.println("<title>新規登録ユーザー情報</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("登録完了");
		out.println("<body>");
		out.println("</html>");









	}

}
