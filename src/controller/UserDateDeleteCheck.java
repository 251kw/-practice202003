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

import dao.DBManager;
import dto.ShoutDTO;

/**
 * Servlet implementation class UserDateDeleteCheck
 */
@WebServlet("/UserDateDeleteCheck")
public class UserDateDeleteCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDateDeleteCheck() {
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
	 * ユーザーを消した場合の
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String index = request.getParameter("index");
		RequestDispatcher dispatcher = null;
		if (index != null) {
			dispatcher = request.getRequestDispatcher("index.jsp");
		} else {
			DBManager meseage = new DBManager();
			ArrayList<ShoutDTO> list = meseage.getShoutList();
			HttpSession session = request.getSession();
			session.setAttribute("shouts", list);
			dispatcher = request.getRequestDispatcher("top.jsp");
		}
		dispatcher.forward(request, response);
	}
}
