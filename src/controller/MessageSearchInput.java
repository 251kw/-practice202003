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

import dao.DBManager;
import dto.ShoutDTO;

/**
 * Servlet implementation class message
 */
@WebServlet("/MessageSearchInput")
public class MessageSearchInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageSearchInput() {
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
	 * メッセージ条件精査　編集、削除、全選択、全解除
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//叫ぶボタン　受け取り
		String update = request.getParameter("update");
		String full = request.getParameter("full");
		String delete = request.getParameter("delete");
		String[] number = request.getParameterValues("number");
		String[] shins = request.getParameterValues("shin");
		String[] shin=number;
		String clear = request.getParameter("clear");
		int sum = 0;
		HttpSession session = request.getSession();
		session.setAttribute("numbers", number);
		String message = null;
		RequestDispatcher dispatcher = null;
		if (full != null) {
			//全選択処理
			request.setAttribute("full", full);
			dispatcher = request.getRequestDispatcher("top.jsp");
			dispatcher.forward(request, response);
		} else if (clear != null) {
			//全選択処理
			request.setAttribute("clear", clear);
			dispatcher = request.getRequestDispatcher("top.jsp");
			dispatcher.forward(request, response);
		} else if (update != null) {
			if (number != null) {
				//編集で複数選択の場合エラーメッセージを送る
				List<String> info = Arrays.asList(number);
				//編集の場合は選択は一個
				for (int index = 0; index < info.size(); index++) {
					sum += index;
				}
				//配列から文字列に変換
				String numbares = String.join(",", number);
				if (sum >= 1) {
					session.removeAttribute("full");
					request.setAttribute("numbers", number);
					message = "変更する場合はチェックは一つです";
					request.setAttribute("alert", message);
					dispatcher = request.getRequestDispatcher("top.jsp");
					dispatcher.forward(request, response);
				}
				message = "コメントを編集してくだい。（そのほかはできません。）";
				request.setAttribute("alert", message);
				DBManager dbm = new DBManager();
				ShoutDTO up = dbm.getShoutList1(numbares);
				session.setAttribute("up", up);
				dispatcher = request.getRequestDispatcher("MessageUpdateInput.jsp");
				dispatcher.forward(request, response);
			} else {
				//チェックボックスが選択されてない場合エラーメッセージ送信
				message = "選択されてません";
				request.setAttribute("alert", message);
				dispatcher = request.getRequestDispatcher("top.jsp");
				dispatcher.forward(request, response);
			}
		} else if (delete != null) {
			if (number != null) {
				List<String> info = Arrays.asList(number);
				ArrayList<ShoutDTO> list = new ArrayList<ShoutDTO>();
				//削除の場合リストに置く
				for (int i = 0; i < info.size(); i++) {
					String as = info.get(i);
					DBManager dbm = new DBManager();
					ShoutDTO user = dbm.getShoutList1(as);
					request.setAttribute("user", user);
					list.add(user);
				}
				//削除画面に遷移
				session.setAttribute("list", list);
				dispatcher = request.getRequestDispatcher("MessageDateDeleteComfirm.jsp");
				dispatcher.forward(request, response);
			} else {
				message = "選択されてません";
				request.setAttribute("alert", message);
				dispatcher = request.getRequestDispatcher("top.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
