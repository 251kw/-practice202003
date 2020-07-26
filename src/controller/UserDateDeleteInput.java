package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBManager;
import dao.DBResrchManager;
import dto.UserDTO;

/**
 * Servlet implementation class UserDelete
 */
@WebServlet("/UserDateDeleteInput")
public class UserDateDeleteInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDateDeleteInput() {
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
	 * ユーザー削除確認画面　画面遷移　精査
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;Charset=UTF-8");
		String shin = null;
		String shine = null;
		HttpSession session = request.getSession();
		String myName = (String) session.getAttribute("name");
		String[] userloginId = (String[]) session.getAttribute("userloginId");
		List<String> info = (List<String>) session.getAttribute("info");
		String re = request.getParameter("re");
		RequestDispatcher dispatcher = null;
		if (re != null) {
			//戻るボタン処理（検索確認画面へ戻る）
			request.setAttribute("userloginId", userloginId);
			dispatcher = request.getRequestDispatcher("UserDateResearchResult.jsp");
			dispatcher.forward(request, response);
		} else {
			for (int i = 0; i < info.size(); i++) {
				//削除複数を回しdelete処理
				String as = info.get(i);
				DBManager dbm = new DBManager();
				UserDTO message = dbm.getLoginUser4(as);
				if (message != null) {
					//削除top画面処理
					shine = "message";
				} else if (myName.equals(as)) {
					shin = "del";
				}
			}
			if (shine != null) {
				shine = null;
				request.setAttribute("userloginId", userloginId);
				String messages = "叫ぶメッセージが残っているのでデータを削除できません、メッセージを削除してください";
				request.setAttribute("alert", messages);
				dispatcher = request.getRequestDispatcher("UserDateResearchResult.jsp");
				dispatcher.forward(request, response);
			} else if (shin != null) {
				//ログイン時のログイン情報と一致の場合index.jsp
				for (int i = 0; i < info.size(); i++) {
					//削除複数を回しdelete処理
					String as = info.get(i);
					DBResrchManager user = new DBResrchManager();
					user.getLoginUser6(as);
				}
				session.setAttribute("shin", shin);
				dispatcher = request.getRequestDispatcher("UserDateDeleteResultindex.jsp");
				dispatcher.forward(request, response);

			} else {
				for (int i = 0; i < info.size(); i++) {
					//削除複数を回しdelete処理
					String as = info.get(i);
					DBResrchManager user = new DBResrchManager();
					user.getLoginUser6(as);
				}
				//ログイン時のログイン情報と不一致の場合top.jsp
				dispatcher = request.getRequestDispatcher("UserDateDeleteResultTop.jsp");
				dispatcher.forward(request, response);
			}
		}

	}
}
