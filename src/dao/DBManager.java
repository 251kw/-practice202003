package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserDTO;


/**
 * Servlet implementation class DBmanager
 */
@WebServlet("/DBmanager")
public class DBManager extends SnsDAO {
           //ログインIDとパスワードを受け取り、登録ユーザー一覧に一致したものがあるか検索
    	public UserDTO getLoginUser(String loginId,String password) {
    		Connection conn=null;
    		PreparedStatement pstmt=null;
    		ResultSet rset=null;

    		String sql="SELECT * FROM users WHERE loginId=? AND password=?";
    		UserDTO user =null; //登録ユーザー情報

    		try {
    			//データベース接続情報
    			conn=getConnection();

    			//SELECT文の登録と実行
    			pstmt=conn.prepareStatement(sql); //セレクト文登録
    			pstmt.setString(1, loginId);
    			pstmt.setString(2, password);
    			rset=pstmt.executeQuery();

    			//検索結果があれば
    			if(rset.next()) {
    				//必要な列から値を取り出し、ユーザー情報オブジェクトを生成
    				user=new UserDTO();
    				user.setLoginId(rset.getString(2));
    				user.setPassword(rset.getString(3));
    				user.setUserName(rset.getString(4));
    				user.setIcon(rset.getString(5));
    				user.setProfile(rset.getString(3));
    			}

    		}catch(SQLException e) {
    			e.printStackTrace();
    		}finally {
    			//データベース切断処理
    			close(rset);
    			close(pstmt);
    			close(conn);
    		}
    		return user;
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
		doGet(request, response);
	}

}
