package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DEDelete;

/**
 * Servlet implementation class UserDelete
 */
@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDelete() {
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

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String profile=request.getParameter("profile");

		DEDelete del = new DEDelete();
		del.getLoginUser(userName,password,profile);
		//HTML 出力準備
				PrintWriter out=response.getWriter();

				out.println("<html lang='ja'>");
				out.println("<head>");
				out.println("<title>削除完了</title>");
				out.println("<link rel=\"stylesheet\" href=\"./css/skyblue.css\">");
				out.println("<link rel=\"stylesheet\" href=\"./css/pe-icon-7-stroke.css\">");
				out.println("<link rel=\"stylesheet\" href=\"./css/helper.css\">");
				out.println("</head>");
				out.println("<body>");
				out.println("削除完了");
				out.println("<a href='top.jsp'>トップに戻る</a>");
				out.println("<body>");
				out.println("</html>");
	}

}
