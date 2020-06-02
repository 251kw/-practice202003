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
import dto.UserDTO;

/**
 * Servlet implementation class UserUpdeta4
 */
@WebServlet("/UserUpdeta4")
public class UserUpdeta4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdeta4() {
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
		String profile=request.getParameter("profile");
		String userName=request.getParameter("userName");
		String del=request.getParameter("del");
		RequestDispatcher dispatcher = null;
		String message = null;
		DEUpdetaManager dbm=new DEUpdetaManager();
		UserDTO user=dbm.getLoginUser7(userName);

		if(userName!=del) {

			// 処理の転送先を top.jsp に指定
			dispatcher = request.getRequestDispatcher("top.jsp");

		} else {
			HttpSession session = request.getSession();

			// ログインユーザ情報、書き込み内容リストとしてセッションに保存
			session.setAttribute("user", user);

			// 処理の転送先を top.jsp に指定
			dispatcher = request.getRequestDispatcher("top.jsp");

		}

		// 処理を転送
		dispatcher.forward(request, response);

		}
	}
