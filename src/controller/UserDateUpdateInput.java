package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DEUpdetaManager;

/**
 * Servlet implementation class Updeta
 */
@WebServlet("/UserDateUpdateInput")
public class UserDateUpdateInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDateUpdateInput() {
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
	 * ユーザー編集入力　精査　遷移
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;Charset=UTF-8");
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String profile = request.getParameter("profile");
		String icon = request.getParameter("icon");
		String userName = request.getParameter("userName");
		String del = request.getParameter("del");
		String back = request.getParameter("return");
		RequestDispatcher dispatcher = null;
		int i = 9;
		if(back!=null) {
			HttpSession session = request.getSession();
			request.setAttribute("loginId", loginId);
			request.setAttribute("userName", userName);
			session.setAttribute("icon", icon);
			request.setAttribute("password", password);
			request.setAttribute("profile", profile);
			//戻るボタン処理（検索確認画面へ戻る）
			dispatcher = request.getRequestDispatcher("UserDateUpdateInputCheck.jsp");
			dispatcher.forward(request, response);
		}
		else if (userName.equals("") || password.equals("")) {
			//ユーザー名、ログインIDどちらかが空白の場合エラーメッセージ
			HttpSession session = request.getSession();
			String message = "ユーザ名とパスワードは必須入力です";
			request.setAttribute("alert", message);
			request.setAttribute("loginId", loginId);
			request.setAttribute("userName", userName);
			session.setAttribute("icon", icon);
			request.setAttribute("password", password);
			request.setAttribute("profile", profile);
			dispatcher = request.getRequestDispatcher("UserDateUpdateInputCheck.jsp");
			dispatcher.forward(request, response);
		} else if (loginId.length() > i) {
			//ログインIDが9文字以上の場合エラーメッセージ
			String message = "ログインIDは8文字以下で入力してください";
			// エラーメッセージをリクエストオブジェクトに保存
			request.setAttribute("alert", message);
			request.setAttribute(loginId, loginId);
			request.setAttribute(userName, userName);
			request.setAttribute(icon, icon);
			request.setAttribute(password, password);
			request.setAttribute(profile, profile);
			request.setAttribute(del, del);
			dispatcher = request.getRequestDispatcher("UserDateUpdateInputCheck.jsp");
			dispatcher.forward(request, response);
		} else if (!loginId.matches("^[-@+*;:#$%&\\w]+$")) {
			//ログインIDが全角の場合エラーメッセージ
			String message = "半角英数記号で入力してください";
			request.setAttribute("alert", message);
			request.setAttribute(loginId, loginId);
			request.setAttribute(userName, userName);
			request.setAttribute(icon, icon);
			request.setAttribute(password, password);
			request.setAttribute(profile, profile);
			request.setAttribute(del, del);
			dispatcher = request.getRequestDispatcher("UserDateUpdateInputCheck.jsp");
			dispatcher.forward(request, response);
		} else if (back != null) {
			//戻るボタン処置
			HttpSession session = request.getSession();
			request.setAttribute("loginId", loginId);
			request.setAttribute("userName", userName);
			session.setAttribute("icon", icon);
			request.setAttribute("password", password);
			request.setAttribute("profile", profile);
			RequestDispatcher rd = request.getRequestDispatcher("UserDateUpdateInputReturn.jsp");
			rd.forward(request, response);
		} else {
			//削除確認画面ボタン処理
			DEUpdetaManager dbm = new DEUpdetaManager();
			dbm.getLoginUser(loginId, password, profile, icon, userName);
			request.setAttribute(loginId, loginId);
			request.setAttribute(userName, userName);
			request.setAttribute(password, password);
			request.setAttribute(profile, profile);
			dispatcher = request.getRequestDispatcher("UserDateUpdateResult.jsp");
			dispatcher.forward(request, response);
		}

	}

}
