package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ShoutDTO;
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
    				user.setProfile(rset.getString(6));
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
    	public ArrayList<ShoutDTO> getShoutList(){
    		Connection conn =null;
    		java.sql.Statement pstmt=null;
    		ResultSet rset=null;

    		ArrayList<ShoutDTO> list=new ArrayList<ShoutDTO>();
    			try {
    				conn=getConnection();
    				pstmt=conn.createStatement();

    				//SELECT文の実行
    				String sql="SELECT*FROM shouts ORDER BY date DESC";
    				rset=pstmt.executeQuery(sql);
    			while (rset.next()) {
    				ShoutDTO shout=new ShoutDTO();
    				shout.setShout(rset.getString(1));
    				shout.setUserName(rset.getString(2));
    				shout.setIcon(rset.getString(3));
    				shout.setDate(rset.getString(4));
    				shout.setWriting(rset.getString(5));
    				list.add(shout);
    			}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}finally {
    		close(rset);
    		close(pstmt);
    		close(conn);
    	}
    			return list;
    	}

    	// ログインユーザー情報と書き込み内容受け取り、リストに追加する
    	public boolean setWriting(UserDTO user,String writing) {
    		Connection conn =null;
    		PreparedStatement pstmt=null;
    		boolean result=false;
    		try {
    			conn=getConnection();

    			//INSERT文の実行と登録
    			String sql="INSERT INTO shouts(userName,icon,date,writing) VALUES(?,?,?,?)";
    			pstmt=conn.prepareStatement(sql);
    			pstmt.setString(1, user.getUserName());
    			pstmt.setString(2, user.getIcon());
    			//現在日時の取得と日付の書式指定
    			Calendar calender=Calendar.getInstance();
    			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd- hh:mm:ss");

    			pstmt.setString(3, sdf.format(calender.getTime()));
    			pstmt.setString(4 ,writing);

    			int cnt=pstmt.executeUpdate();
    			if(cnt==1) {
    				//INSERT文の実行結果が１なら登録成功
    				result=true;
    			}
    		}catch(SQLException e){
    			e.printStackTrace();
    		}finally {
    			//データベース切断処理
    			close(pstmt);
    			close(conn);    		}
    		return result;
    	}
    	public ShoutDTO getShoutList1(String shouts) {
    		Connection conn=null;
    		PreparedStatement pstmt=null;
    		ResultSet rset=null;
    		ShoutDTO shout=null;
    		String sql="SELECT*FROM shouts WHERE shouts=?";
    		try {
    			//データベース接続情報
    			conn=getConnection();
    			//SELECT文の登録と実行
    			pstmt=conn.prepareStatement(sql); //セレクト文登録
    			pstmt.setString(1, shouts);
    			rset=pstmt.executeQuery();

    			//検索結果があれば
    			while(rset.next()) {
    				//必要な列から値を取り出し、ユーザー情報オブジェクトを生成
    				shout=new ShoutDTO();
    				shout.setShout(rset.getString(1));
    				shout.setUserName(rset.getString(2));
    				shout.setIcon(rset.getString(3));
    				shout.setDate(rset.getString(4));
    				shout.setWriting(rset.getString(5));
    			}
    }catch(SQLException e) {
    	e.printStackTrace();
    }finally {
    	close(rset);
    	close(pstmt);
    	close(conn);
    }
    		return shout;
    	}
    	public ShoutDTO getShoutList2(String writing,String shouts) {
    		Connection conn = null; // データベース接続情報
    		PreparedStatement pstmt = null; // SQL 管理情報
    		ResultSet rset = null; // 検索結果
    		String sql="UPDATE shouts SET writing=? WHERE shouts=?";
    		ShoutDTO shout=null;
    		try {
    			//データベース接続情報
    			conn=getConnection();
    			//SELECT文の登録と実行
    			pstmt=conn.prepareStatement(sql); //セレクト文登録
    			pstmt.setString(1, writing);
    			pstmt.setString(2, shouts);
    			pstmt.executeUpdate();
    }catch(SQLException e) {
    	e.printStackTrace();
    }finally {
    	close(rset);
    	close(pstmt);
    	close(conn);
    }
    		return shout;
    	}
    	public void getShoutList３(String shouts) {
    		Connection conn = null; // データベース接続情報
    		PreparedStatement pstmt = null; // SQL 管理情報
    		ResultSet rset = null; // 検索結果
    		String sql="DELETE FROM shouts WHERE shouts=?";
    		try {
    			//データベース接続情報
    			conn=getConnection();
    			//SELECT文の登録と実行
    			pstmt=conn.prepareStatement(sql); //セレクト文登録
    			pstmt.setString(1, shouts);
    			pstmt.executeUpdate();
    }catch(SQLException e) {
    	e.printStackTrace();
    }finally {
    	close(rset);
    	close(pstmt);
    	close(conn);
    }

    	}
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
