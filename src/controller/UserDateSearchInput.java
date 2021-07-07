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
import dto.UserDTO;

/**
 * Servlet implementation class UserResearchServlet
 */
@WebServlet("/UserDatesearchInput")
public class UserDateSearchInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDateSearchInput() {
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
	 * ユーザー検索入力精査
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String userName = request.getParameter("userName");
		String icon = request.getParameter("icon");
		String userw = request.getParameter("user");
		String usere = request.getParameter("usere");
		String back = request.getParameter("return");
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		if (loginId.equals("") && userName.equals("")) {
			// ログインIDが未入力なら
			DBResrchManager dbr = new DBResrchManager();
			ArrayList<UserDTO> user = dbr.getLoginUser4(icon);
			if (user == null || user.size() == 0) {
				// ユーザ情報が取得できない場合
				// エラーメッセージをリクエストオブジェクトに保存
				String message = "該当データがありません";
				request.setAttribute("alert", message);
				request.setAttribute(icon, icon);
				// 処理の転送先を index.jsp に指定
				dispatcher = request.getRequestDispatcher("UserDateResearchInputReturn.jsp");
			} else {
				// ユーザ情報を取得できたら、書き込み内容リストを取得
				// ログインユーザ情報、書き込み内容リストとしてセッションに保存

				session.setAttribute("list", user);
				request.setAttribute("usere", usere);
				session.setAttribute("userw", userw);
				dispatcher = request.getRequestDispatcher("UserDateResearchResult.jsp");
			}
			// 処理を転送
			dispatcher.forward(request, response);
		} else if (loginId.equals("")) {
			// ログインIDが未入力なら
			DBResrchManager dbr = new DBResrchManager();
			ArrayList<UserDTO> user = dbr.getLoginUser2(userName, icon);
			if (user == null || user.size() == 0) {
				// エラーメッセージをリクエストオブジェクトに保存
				String message = "該当データがありません";
				request.setAttribute("alert", message);
				request.setAttribute(icon, icon);
				request.setAttribute(userName, userName);
				// 処理の転送先を index.jsp に指定
				dispatcher = request.getRequestDispatcher("UserDateResearchInputReturn.jsp");
			} else {
				// ユーザ情報を取得できたら、書き込み内容リストを取得
				// ログインユーザ情報、書き込み内容リストとしてセッションに保存
				session.setAttribute("list", user);
				request.setAttribute("usere", usere);
				request.setAttribute(userw, userw);
				dispatcher = request.getRequestDispatcher("UserDateResearchResult.jsp");
			}

			// 処理を転送
			dispatcher.forward(request, response);
		} else if (userName.equals("")) {
			// ログインIDが未入力なら
			DBResrchManager dbr = new DBResrchManager();
			ArrayList<UserDTO> user = dbr.getLoginUser1(loginId, icon);
			if (user == null || user.size() == 0) {
				// エラーメッセージをリクエストオブジェクトに保存
				String message = "該当データがありません";
				request.setAttribute("alert", message);
				request.setAttribute(icon, icon);
				request.setAttribute(loginId, loginId);
				// 処理の転送先を index.jsp に指定
				dispatcher = request.getRequestDispatcher("UserDateResearchInputReturn.jsp");
			} else {// ユーザ情報を取得できたら、書き込み内容リストを取得

				// ログインユーザ情報、書き込み内容リストとしてセッションに保存
				session.setAttribute("list", user);
				request.setAttribute("usere", usere);
				request.setAttribute("del", userw);

				dispatcher = request.getRequestDispatcher("UserDateResearchResult.jsp");
			}

			// 処理を転送
			dispatcher.forward(request, response);
		} else {
			// ログインIDが未入力なら
			DBResrchManager dbr = new DBResrchManager();
			ArrayList<UserDTO> user = dbr.getLoginUser(loginId, userName, icon);
			if (user == null || user.size() == 0) {
				// ユーザ情報が取得できない場合
				// エラーメッセージをリクエストオブジェクトに保存
				String message = "該当データがありません";
				request.setAttribute("alert", message);
				request.setAttribute(icon, icon);
				request.setAttribute(userName, userName);
				request.setAttribute(loginId, loginId);
				// 処理の転送先を index.jsp に指定
				dispatcher = request.getRequestDispatcher("UserDateResearchInputReturn.jsp");
			} else {
				// ユーザ情報を取得できたら、書き込み内容リストを取得
				// ログインユーザ情報、書き込み内容リストとしてセッションに保存
				session.setAttribute("list", user);
				request.setAttribute("usere", usere);
				request.setAttribute("del", userw);

				dispatcher = request.getRequestDispatcher("UserDateResearchResult.jsp");

			}

			// 処理を転送
			dispatcher.forward(request, response);
		}
	}

}
