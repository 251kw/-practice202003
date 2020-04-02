package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Updeta
 */
@WebServlet("/Updeta")
public class Updeta extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updeta() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;Charset=UTF-8");
		String message1 = request.getParameter("shin");
		String  message2= request.getParameter("kawafuchi");


		//HTML 出力準備
		PrintWriter out=response.getWriter();

		out.println("<html lang='ja'>");
		out.println("<head>");
		out.println("<title>ユーザー情報変更</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Name:+message1+<br>");
		out.println("password:+message2+<br>");
		out.println("<body>");
		out.println("</html>");
	}

}
