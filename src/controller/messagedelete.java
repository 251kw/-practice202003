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
 * Servlet implementation class messagedelete
 */
@WebServlet("/messagedelete")
public class messagedelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public messagedelete() {
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
		String[] number=request.getParameterValues("number");
		String delete=request.getParameter("delete");
		String back=request.getParameter("return");
		String message=null;
		RequestDispatcher dispatcher = null;
		if(back!=null) {
			dispatcher = request.getRequestDispatcher("top.jsp");
			dispatcher.forward(request, response);
		}else if(delete!=null) {
			if(number!=null) {
				List<String> info = Arrays.asList(number);
				ArrayList<ShoutDTO> list=new ArrayList<ShoutDTO>();
				for(int i = 0; i < info.size(); i ++){
					String as=info.get(i);
					DBManager dbm = new DBManager();
					ShoutDTO user=dbm.getShoutList1(as);
					list.add(user);
					dbm.getShoutList３(as);
					}
				message="下記の情報を削除しました";
				HttpSession session = request.getSession();
				session.setAttribute("list", list);
				dispatcher = request.getRequestDispatcher("messagedelete2.jsp");
				dispatcher.forward(request, response);
			}else {
				message="選択がありません";
				dispatcher = request.getRequestDispatcher("messagedelete.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
