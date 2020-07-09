package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBSUBanager;
/**
 * Servlet implementation class UserAddServlet
 */
@WebServlet("/UserAddServletResult")
public class UserAddResult extends HttpServlet {
	private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddResult() {
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
		String userName=request.getParameter("userName");
		String icon=request.getParameter("icon");
		String profile=request.getParameter("profile");
		String back=request.getParameter("return");
		RequestDispatcher dispatcher = null;
		int date=0;

			if(back!=null) {
				//戻るボタン処理（1つ前の画面に戻る）
				HttpSession session = request.getSession();
				request.setAttribute("loginId", loginId);
				request.setAttribute("userName", userName);
				request.setAttribute("profile", profile);
				request.setAttribute("password", password);
				session.setAttribute("icon", icon);
				RequestDispatcher rd = request.getRequestDispatcher("UserAddInputReturn.jsp");
				rd.forward(request, response);
			}else {
				//新規登録処理
				request.setAttribute("loginId", loginId);
				request.setAttribute("userName", userName);
				request.setAttribute("profile", profile);
				request.setAttribute("icon", icon);
				request.setAttribute("password", password);
				DBSUBanager add=new DBSUBanager();
				add.getLoginUser(loginId, password, userName, icon, profile,date);
				//新規登録完了画面へ遷移
				dispatcher = request.getRequestDispatcher("UserAddResult.jsp");
				dispatcher.forward(request, response);
			}




		}





}





