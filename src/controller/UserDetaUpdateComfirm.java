package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserDetaUpdateComfirm
 */
@WebServlet("/UserDetaUpdateComfirm")
public class UserDetaUpdateComfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDetaUpdateComfirm() {
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
	 * 戻る遷移の処理、変更画面遷移処理
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;Charset=UTF-8");
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String profile = request.getParameter("profile");
		String icon = request.getParameter("icon");
		String userName = request.getParameter("userName");
		String back = request.getParameter("return");
		RequestDispatcher dispatcher = null;
		if (back != null) {
			HttpSession session = request.getSession();
			String[] userloginId = (String[]) session.getAttribute("userloginId");
			//戻るボタン処理（検索確認画面へ戻る）
			request.setAttribute("userloginId", userloginId);
			dispatcher = request.getRequestDispatcher("UserDateResearchResult.jsp");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("loginId", loginId);
			request.setAttribute("userName", userName);
			request.setAttribute("icon", icon);
			request.setAttribute("password", password);
			request.setAttribute("profile", profile);
			dispatcher = request.getRequestDispatcher("UserDateUpdateConfirm.jsp");
			dispatcher.forward(request, response);

		}
	}

}
