package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBResrchManager;
import dao.DEReserarch2;
import dto.UserDTO;

/**
 * Servlet implementation class UserResearchServlet
 */
@WebServlet("/UserResearchServlet")
public class UserResearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserResearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String password=request.getParameter("password");
		String userw=request.getParameter("user");
		String usere=request.getParameter("usere");
		RequestDispatcher dispatcher = null;
		DEReserarch2 res= new DEReserarch2();
		UserDTO users=res.getLoginUser(loginId,password);
		if(loginId.equals("")||password.equals("")) {
			// ログインIDが未入力なら
						String message = "ログインIDとパスワードは必須入力です";

						// エラーメッセージをリクエストオブジェクトに保存
						request.setAttribute("alert", message);
						request.setAttribute("userw", userw);
						request.setAttribute(loginId, loginId);
						request.setAttribute(password, password);
						// index.jsp に処理を転送
						dispatcher = request.getRequestDispatcher("UserResearch2.jsp");
						dispatcher.forward(request, response);
		}
		else if(users==null) {
			String message = "データがありません";

			// エラーメッセージをリクエストオブジェクトに保存
			request.setAttribute("alert", message);
			request.setAttribute(loginId, loginId);
			request.setAttribute(password, password);
			request.setAttribute("userw", userw);
			// index.jsp に処理を転送
			dispatcher = request.getRequestDispatcher("UserResearch2.jsp");
			dispatcher.forward(request, response);
		}else {


			// ログイン認証を行い、ユーザ情報を取得
			DBResrchManager dbr = new DBResrchManager();
			ArrayList<UserDTO> user = dbr.getLoginUser(loginId,password);

			if (user != null) {
				// ユーザ情報を取得できたら、書き込み内容リストを取得
				HttpSession session = request.getSession();


				// ログインユーザ情報、書き込み内容リストとしてセッションに保存

				session.setAttribute("list", user);
				request.setAttribute("usere", usere);
				request.setAttribute("del", userw);

				dispatcher = request.getRequestDispatcher("Research.jsp");


			} else {
				// ユーザ情報が取得できない場合
				// エラーメッセージをリクエストオブジェクトに保存
				String message = "該当データがありません";
				request.setAttribute("alert", message);

				// 処理の転送先を index.jsp に指定
				dispatcher = request.getRequestDispatcher("UserResearch.jsp");
			}

			// 処理を転送
			dispatcher.forward(request, response);
		}
	}
}
