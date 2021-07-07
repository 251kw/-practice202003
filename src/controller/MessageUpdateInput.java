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
 * Servlet implementation class messageupdate
 */
@WebServlet("/MessageUpdateInput")
public class MessageUpdateInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageUpdateInput() {
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
	 * メッセージ編集　入力精査
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String writing = request.getParameter("writing");
		String icon = request.getParameter("icon");
		String userName = request.getParameter("userName");
		String back = request.getParameter("back");
		String date = request.getParameter("date");
		String number = request.getParameter("number");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		if (back != null) {
			//戻るボタン処理
			String[] user=(String[])session.getAttribute("numbers");
			request.setAttribute("numbers", user);
			dispatcher = request.getRequestDispatcher("top.jsp");
			dispatcher.forward(request, response);
		} else {
			//メッセージ編集確認画面処理
			session.setAttribute("number", number);
			session.setAttribute("writing", writing);
			session.setAttribute("userName", userName);
			session.setAttribute("date", date);
			session.setAttribute("icon", icon);
			dispatcher = request.getRequestDispatcher("MessageUpdateConfirm.jsp");
			dispatcher.forward(request, response);
		}

	}
}
