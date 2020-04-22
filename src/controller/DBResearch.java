package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBResearch
 */
@WebServlet("/DBResearch")
public class DBResearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBResearch() {
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
		response.setContentType("text/html;charset=UTF-8");

		//HTML出力準備
		PrintWriter out=response.getWriter();

		//データベースに接続
		final String DSN="jdbc;mysql://localhost:3306/sns?useSSL=false";
		final String USER="root";
		final String PASSWORD="root";
		String loginId = request.getParameter("loginId");

		//データーベース情報管理
		Connection conn=null;

		//SQL 情報管理
		PreparedStatement pstmt1=null;

		//SELECT 文の実行結果管理
		ResultSet rset1=null;

		out.println("<html lang='ja'>");
		out.println("<head>");
		out.println("<title>検索</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<名前検索>");
		try {
			//JDBC ドライバのロード
			Class.forName("com.mysql.jdbc.Driver");

			//データベース接続
			conn=DriverManager.getConnection(DSN,USER,PASSWORD);

			String sql="SELECT * FROM users WHERE loginId=?";
			pstmt1=conn.prepareStatement(sql);
			pstmt1.setString(1, loginId);

			rset1=pstmt1.executeQuery();;
			out.println("<pre>");
			//検索結果があるか
		//問い合わせ結果の行数繰り返し
		while(rset1.next()) {
			out.print(rset1.getString(1)+":");
			out.print(rset1.getString(2)+":");
			out.print(rset1.getString(3));
		}
		out.println("</pre");

		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e) {

		} finally {
			try {
				rset1.close();
			}catch (SQLException e) {

			}try {
				pstmt1.close();
			}catch(SQLException e) {

			}
		}
		out.println("</body>");
		out.println("</html>");




	}


	}


