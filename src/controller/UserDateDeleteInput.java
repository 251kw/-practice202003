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

import dao.DEUpdetaManager;



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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;Charset=UTF-8");
		String shin=null;
		HttpSession session = request.getSession();
	    String  myName = (String) session.getAttribute("name");
		List<String> info = (List<String>) session.getAttribute("info");
		String re=request.getParameter("re");
		if(re!=null) {
			//戻るボタン処理（検索確認画面へ戻る）
			RequestDispatcher dispatcher = null;
			dispatcher = request.getRequestDispatcher("UserDateResearchResult.jsp");
			dispatcher.forward(request, response);
		}
		else {
			for(int i = 0; i < info.size(); i ++){
				//削除複数を回しdelete処理
				String as=info.get(i);
				//DBResrchManager users=new DBResrchManager();
				//users.getLoginUser6(as);
				DEUpdetaManager users=new DEUpdetaManager();
				users.dateupdate(as);
				if(myName.equals(as)) {
					//削除top画面処理
					shin="del";
				}
		}
			RequestDispatcher dispatcher = null;
			if(shin!=null) {
				//ログイン時のログイン情報と一致の場合index.jsp
				session.setAttribute("shin", shin);
				dispatcher = request.getRequestDispatcher("UserDateDeleteResultindex.jsp");
				dispatcher.forward(request, response);

	}else {
		//ログイン時のログイン情報と不一致の場合top.jsp
		dispatcher = request.getRequestDispatcher("UserDateDeleteResultTop.jsp");
		dispatcher.forward(request, response);
	}
		}

}
}
