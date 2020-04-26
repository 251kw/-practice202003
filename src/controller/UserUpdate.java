package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DEUpdetaManager;
import dto.UserDTO;

/**
 * Servlet implementation class Updeta
 */
@WebServlet("/Updeta")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;Charset=UTF-8");

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String userName=request.getParameter("userName");
		DEUpdetaManager dbm = new DEUpdetaManager();
		UserDTO user = dbm.getLoginUser(loginId, password,userName);


		//HTML 出力準備
		PrintWriter out=response.getWriter();

		out.println("<html lang='ja'>");
		out.println("<head>");
		out.println("<title>ユーザー情報変更</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("loginId:"+loginId+"<br>");
		out.println("password:"+password+"<br>");
		out.println("変更完了");
		out.println("<body>");
		out.println("</html>");

	}


}
