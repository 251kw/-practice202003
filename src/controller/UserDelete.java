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

import dao.DBResrchManager;



/**
 * Servlet implementation class UserDelete
 */
@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDelete() {
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
		for(int i = 0; i < info.size(); i ++){
			String as=info.get(i);
			DBResrchManager users=new DBResrchManager();
			users.getLoginUser6(as);
			if(myName.equals(as)) {
				shin="del";
			}
	}
		RequestDispatcher dispatcher = null;
		if(shin!=null) {
			session.setAttribute("shin", shin);
			dispatcher = request.getRequestDispatcher("last2.jsp");
			dispatcher.forward(request, response);

}else {
	dispatcher = request.getRequestDispatcher("last.jsp");
	dispatcher.forward(request, response);
}
}
}
