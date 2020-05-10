package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DEUpdetaManager;

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
		String profile=request.getParameter("profile");
		String icon=request.getParameter("icon");
		String userName=request.getParameter("userName");
		DEUpdetaManager dbm = new DEUpdetaManager();
		dbm.getLoginUser(loginId, password,profile,icon,userName);
		RequestDispatcher dispatcher = null;
		int i=9;
		if(loginId.equals("") || password.equals("")) {
			String message = "ログインIDとパスワードは必須入力です";

			// エラーメッセージをリクエストオブジェクトに保存
			request.setAttribute("alert", message);
			dispatcher = request.getRequestDispatcher("NewFile.jsp");
			dispatcher.forward(request, response);
		}else if(loginId.length() > i){
			String message = "ログインIDは8文字以下で入力してください";

			// エラーメッセージをリクエストオブジェクトに保存
			request.setAttribute("alert", message);

			// index.jsp に処理を転送
			dispatcher = request.getRequestDispatcher("NewFile.jsp");
			dispatcher.forward(request, response);
		}else if(!loginId.matches("^[-@+*;:#$%&\\w]+$")) {
String message = "半角英数記号で入力してください";

			request.setAttribute("alert", message);

			// index.jsp に処理を転送
			dispatcher = request.getRequestDispatcher("NewFile.jsp");
			dispatcher.forward(request, response);
		}else {
			//HTML 出力準備
			PrintWriter out=response.getWriter();

			out.println("<html lang='ja'>");
			out.println("<head>");
			out.println("<title>ユーザー情報変更</title>");
			out.println("<link rel=\"stylesheet\" href=\"./css/skyblue.css\">");
			out.println("<link rel=\"stylesheet\" href=\"./css/pe-icon-7-stroke.css\">");
			out.println("<link rel=\"stylesheet\" href=\"./css/helper.css\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class=bg-success padding-y-5>");
			out.println("<div class=container padding-y-5 text-center>");
			out.println("<div align=center>");
			out.println("<h1>変更完了</h1>");
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");
			out.println("<div align=center>");
			out.println("<p>変更完了</P>");
			out.println("<a href='top.jsp' class='btn'>トップに戻る</a>");
			out.println("</div>");
			out.println("<body>");
			out.println("</html>");
		}

	}


}
