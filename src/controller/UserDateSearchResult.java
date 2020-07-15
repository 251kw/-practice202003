package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * Servlet implementation class User
 */
@WebServlet("/UserDateSearchResult")
public class UserDateSearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDateSearchResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * ユーザー検索結果　編集、削除、全選択、全解除　精査
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;Charset=UTF-8");
		//loginId=userloginId
		String[] userloginId = request.getParameterValues("userloginId");
		String delete = request.getParameter("delete");
		String deleter = request.getParameter("deleter");
		String updata = request.getParameter("updata");
		String re = request.getParameter("return");
		String del = request.getParameter("del");
		String clear = request.getParameter("clear");
		RequestDispatcher dispatcher = null;
		String message = null;
		int sum = 0;
		if (delete != null) {
			//削除機能ボタン処理
			HttpSession session = request.getSession();
			session.setAttribute("userloginId", userloginId);
			if (userloginId != null) {
				//Listに変換
				ArrayList<UserDTO> list = new ArrayList<UserDTO>();
				List<String> info = Arrays.asList(userloginId);
				for (int i = 0; i < info.size(); i++) {
					String as = info.get(i);
					DBResrchManager dbm = new DBResrchManager();
					UserDTO user = dbm.getLoginUser5(as);
					list.add(user);
				}
				request.setAttribute("userloginId", userloginId);
				session.setAttribute("lists", list);
				session.setAttribute("info", info);
				session.setAttribute("del", del);
				dispatcher = request.getRequestDispatcher("UserDateDeleteConfirm.jsp");
				dispatcher.forward(request, response);
			} else {
				message = "チェックがありません。";
				request.setAttribute("alert", message);
				// index.jsp に処理を転送
				dispatcher = request.getRequestDispatcher("UserDateResearchResult.jsp");
				dispatcher.forward(request, response);
			}
		} else if (deleter != null) {
			if (clear != null) {
				deleter = null;
			}
			request.setAttribute("deleter", deleter);
			dispatcher = request.getRequestDispatcher("UserDateResearchResult.jsp");
			dispatcher.forward(request, response);
		} else if (clear != null) {
			//解除の条件をnullにセットし、解除操作
			request.setAttribute("clear", clear);
			dispatcher = request.getRequestDispatcher("UserDateResearchResult.jsp");
			dispatcher.forward(request, response);
		} else if (re != null) {
			dispatcher = request.getRequestDispatcher("UserDateResearchInput.jsp");
			dispatcher.forward(request, response);
		} else if (updata != null) {

			HttpSession session = request.getSession();
			session.setAttribute("userloginId", userloginId);
			if (userloginId != null) {
				for (int index = 0; index < userloginId.length; index++) {
					sum += index;
				}
				String loginId = String.join(",", userloginId);

				if (sum >= 1) {
					request.setAttribute("userloginId", userloginId);
					message = "変更する場合はチェックは一つです";
					request.setAttribute("alert", message);
					dispatcher = request.getRequestDispatcher("UserDateResearchResult.jsp");
					dispatcher.forward(request, response);
				}
				DBResrchManager dbr = new DBResrchManager();
				UserDTO users = dbr.getLoginUser5(loginId);
				session.setAttribute("users", users);
				dispatcher = request.getRequestDispatcher("UserDateUpdateInput.jsp");
				dispatcher.forward(request, response);
			} else {
				message = "チェックがありません。";
				request.setAttribute("alert", message);
				// index.jsp に処理を転送
				dispatcher = request.getRequestDispatcher("UserDateResearchResult.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
