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
			out.println("<link rel=\"stylesheet\" href=\"./css/skyblue.css\">");
			out.println("<link rel=\"stylesheet\" href=\"./css/pe-icon-7-stroke.css\">");
			out.println("<link rel=\"stylesheet\" href=\"./css/helper.css\">");
			out.println("<div class=bg-success padding-y-5>");
			out.println("</div>");
			out.println("<title>新規登録ユーザー情報</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class=bg-success padding-y-5>");
			out.println("<div class=container padding-y-5 text-center>");
			out.println("<div align=center>");
			out.println("<h1>確認画面&nbsp</h1>");
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");
			out.println("<div align=center>");
			out.println("<p>登録完了</p>");
			out.println("<div class=btn>");
			out.println("<a href='index.jsp'>ログイン画面に戻る</a>");
			out.println("</div>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		}





}





