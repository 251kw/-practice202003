package controller;

import java.io.IOException;

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
 * Servlet implementation class UserAddCofirm
 */
@WebServlet("/UserAddInput")
public class UserAddInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddInput() {
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
		String loginId = (String) request.getParameter("loginId");
		String userName = (String) request.getParameter("userName");
		String password = (String) request.getParameter("password");
		String profile = (String) request.getParameter("profile");
		String icon = (String) request.getParameter("icon");
		String message="";
		int i=9;
		DBResrchManager research=new DBResrchManager();
		UserDTO user=research.getLoginUser5(loginId);
		//以下の条件はエラー処理
		if(loginId.equals("")) {
			request.setCharacterEncoding("UTF-8");
			message="未入力があります。";
			request.setAttribute("alert", message);
			request.setAttribute("loginId", loginId);
			request.setAttribute("userName", userName);
			request.setAttribute("profile", profile);
			request.setAttribute("password", password);
			HttpSession session = request.getSession();
			session.setAttribute("icon", icon);
			RequestDispatcher rd = request.getRequestDispatcher("UserAddInputReturn.jsp");
			rd.forward(request, response);
		}else if(userName.equals("")) {
			request.setCharacterEncoding("UTF-8");
			message="未入力があります。";
			request.setAttribute("alert", message);
			request.setAttribute("loginId", loginId);
			request.setAttribute("userName", userName);
			request.setAttribute("profile", profile);
			request.setAttribute("password", password);
			HttpSession session = request.getSession();
			session.setAttribute("icon", icon);
			RequestDispatcher rd = request.getRequestDispatcher("UserAddInputReturn.jsp");
			rd.forward(request, response);
		}else if(password.equals("")) {
			request.setCharacterEncoding("UTF-8");
			message="未入力があります。";
			request.setAttribute("alert", message);
			request.setAttribute("loginId", loginId);
			request.setAttribute("userName", userName);
			request.setAttribute("profile", profile);
			request.setAttribute("password", password);
			HttpSession session = request.getSession();
			session.setAttribute("icon", icon);
			RequestDispatcher rd = request.getRequestDispatcher("UserAddInputReturn.jsp");
			rd.forward(request, response);
		}else if(icon.equals("")) {
			message="未入力があります。";
			request.setAttribute("alert", message);
			request.setAttribute("loginId", loginId);
			request.setAttribute("userName", userName);
			request.setAttribute("profile", profile);
			request.setAttribute("password", password);
			HttpSession session = request.getSession();
			session.setAttribute("icon", icon);
			RequestDispatcher rd = request.getRequestDispatcher("UserAddInputReturn.jsp");
			rd.forward(request, response);
		}else if(profile.equals("")) {
			message="未入力があります。";
			request.setAttribute("alert", message);
			request.setAttribute("loginId", loginId);
			request.setAttribute("userName", userName);
			request.setAttribute("profile", profile);
			request.setAttribute("password", password);
			HttpSession session = request.getSession();
			session.setAttribute("icon", icon);
			RequestDispatcher rd = request.getRequestDispatcher("UserAddInputReturn.jsp");
			rd.forward(request, response);
		}else if(loginId.length() > i) {
			message = "ログインIDは8文字以下で入力してください";
			HttpSession session = request.getSession();
			// エラーメッセージをリクエストオブジェクトに保存
			request.setAttribute("alert", message);
			request.setAttribute("loginId", loginId);
			request.setAttribute("userName", userName);
			session.setAttribute("icon", icon);
			request.setAttribute("password", password);
			request.setAttribute("profile", profile);
			RequestDispatcher rd = request.getRequestDispatcher("UserAddInputReturn.jsp");
			rd.forward(request, response);
		}else if(!loginId.matches("^[-@+*;:#$%&\\w]+$")) {
			message = "半角英数記号で入力してください";
			HttpSession session = request.getSession();
			// エラーメッセージをリクエストオブジェクトに保存
			request.setAttribute("alert", message);
			request.setAttribute("loginId", loginId);
			request.setAttribute("userName", userName);
			session.setAttribute("icon",icon);
			request.setAttribute("password", password);
			request.setAttribute("profile", profile);
			RequestDispatcher rd = request.getRequestDispatcher("UserAddInputReturn.jsp");
			rd.forward(request, response);
		}else if(user!=null) {
			message = "入力されたログインIDはすでに使われています";
			HttpSession session = request.getSession();
			// エラーメッセージをリクエストオブジェクトに保存
			request.setAttribute("alert", message);
			request.setAttribute("loginId", loginId);
			request.setAttribute("userName", userName);
			session.setAttribute("icon",icon);
			request.setAttribute("password", password);
			request.setAttribute("profile", profile);
			RequestDispatcher rd = request.getRequestDispatcher("UserAddInputReturn.jsp");
			rd.forward(request, response);
		}else {

			//新規登録確認画面遷移
			request.setAttribute("loginId", loginId);
			request.setAttribute("password", password);
			request.setAttribute("userName", userName);
			request.setAttribute("profile", profile);
			request.setAttribute("icon", icon);
			RequestDispatcher rd = request.getRequestDispatcher("UserAddConfirm.jsp");
			rd.forward(request, response);
		}
	}

}
