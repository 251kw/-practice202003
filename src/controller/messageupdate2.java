package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBManager;

/**
 * Servlet implementation class messageupdate2
 */
@WebServlet("/messageupdate2")
public class messageupdate2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public messageupdate2() {
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
		String writing=request.getParameter("writing");
		String icon=request.getParameter("icon");
		String userName=request.getParameter("userName");
		String back=request.getParameter("back");
		String date=request.getParameter("date");
		String number=request.getParameter("number");
		RequestDispatcher dispatcher = null;
		if(back!=null) {
			String message="コメントを編集してくだい。（そのほかはできません。）";
			request.setAttribute("alert", message);
			HttpSession session=request.getSession();
			session.setAttribute("writing", writing);
			dispatcher = request.getRequestDispatcher("messageupdate4.jsp");
			dispatcher.forward(request, response);

	}else {
		HttpSession session=request.getSession();
		session.setAttribute("writing", writing);
		session.setAttribute("userName", userName);
		session.setAttribute("date", date);
		session.setAttribute("icon", icon);
		session.setAttribute("number", number);
		DBManager dbm = new DBManager();
		dbm.getShoutList2(writing,number);
		dispatcher = request.getRequestDispatcher("messageupdate3.jsp");
		dispatcher.forward(request, response);
	}
	}

}
