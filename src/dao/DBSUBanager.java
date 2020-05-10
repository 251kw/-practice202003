package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UserDTO;

/**
 * Servlet implementation class DBSUBanager
 */
public class DBSUBanager extends SnsDAO {
	public UserDTO getLoginUser(String loginId, String password,String userName,String icon,String profile) {
		Connection conn = null; // データベース接続情報
		PreparedStatement pstmt = null; // SQL 管理情報
		ResultSet rset = null; // 検索結果

		String sql = "INSERT INTO users(loginId,password,userName,icon,profile) VALUES(?,?,?,?,?)";
		UserDTO user=null;;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(sql); // SELECT 構文登録
			pstmt.setString(1,loginId);
			pstmt.setString(2, password);
			pstmt.setString(3,userName);
			pstmt.setString(4,icon);
			pstmt.setString(5,profile);
			pstmt.executeUpdate();

		}

		catch (SQLException e) {
			e.printStackTrace();

		} finally {
			// データベース切断処理
			close(rset);
			close(pstmt);
			close(conn);
		}
		return user;
	}

}
