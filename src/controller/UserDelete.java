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
		String dele=request.getParameter("del");
		String loginId=request.getParameter("loginId");
		String delete=request.getParameter("delete");

		if(dele.equals(loginId)||delete.equals(loginId)) {
			DEDelete del = new DEDelete();
			del.getLoginUser(loginId,password,profile);
			//HTML 出力準備
					PrintWriter out=response.getWriter();

					out.println("<html lang='ja'>");
					out.println("<head>");
					out.println("<meta http-equiv=\"Content=Type\" content=\"text/html; charset=UTF-8\">");
					out.println("<link rel=\"stylesheet\" href=\"./css/skyblue.css\">");
					out.println("<link rel=\"stylesheet\" href=\"./css/pe-icon-7-stroke.css\">");
					out.println("<link rel=\"stylesheet\" href=\"./css/helper.css\">");
					out.println("<div class=bg-success padding-y-5>");
					out.println("</div>");
					out.println("<title>削除完了</title>");
					out.println("</head>");
					out.println("<body>");
					out.println("<div class=bg-success padding-y-5>");
					out.println("<div class=container padding-y-5 text-center>");
					out.println("<div align=center>");
					out.println("<h1>削除完了</h1>");
					out.println("</div>");
					out.println("</div>");
					out.println("</div>");
					out.println("<div align=center>");
					out.println("<p>削除完了</p>");
					out.println("<div class=btn>");
					out.println("<a href='index.jsp'　>トップ画面に戻る</a>");
					out.println("</div>");
					out.println("</div>");
					out.println("<body>");
					out.println("</html>");
		}else {
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
					out.println("<div class=bg-success padding-y-5>");
					out.println("<div class=container padding-y-5 text-center>");
					out.println("<div align=center>");
					out.println("<h1>削除完了&nbsp</h1>");
					out.println("</div>");
					out.println("</div>");
					out.println("</div>");
					out.println("<div align=center>");
					out.println("<p>削除完了</p>");
					out.println("<div class=btn>");
					out.println("<a href='top.jsp'　>ログイン画面に戻る</a>");
					out.println("</div>");
					out.println("</div>");
					out.println("<body>");
					out.println("</html>");
		}

	}

}
