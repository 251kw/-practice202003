package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBReserch;
import dao.DBSUBanager;
import dto.UserDTO;
/**
 * Servlet implementation class UserAddServlet
 */
@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddServlet() {
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
			RequestDispatcher dispatcher = null;
			DBReserch dbm = new DBReserch();
			UserDTO users = dbm.getLoginUser(loginId);

			if(users!=null) {
				String message = "ログインIDは既に使われております";

				// エラーメッセージをリクエストオブジェクトに保存
				request.setAttribute("alert", message);
				dispatcher = request.getRequestDispatcher("UserAddInput2.jsp");
				dispatcher.forward(request, response);
			}else {
				DBSUBanager add=new DBSUBanager();
				UserDTO user=add.getLoginUser(loginId, password, userName, icon, profile);
				dispatcher = request.getRequestDispatcher("newfuser.jsp");
				dispatcher.forward(request, response);
			}




		}





}





