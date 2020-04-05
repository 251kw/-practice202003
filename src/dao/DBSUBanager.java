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
	public UserDTO getLoginUser(String loginId, String password) {
		Connection conn = null; // データベース接続情報
		PreparedStatement pstmt = null; // SQL 管理情報
		ResultSet rset = null; // 検索結果

		String sql = "UPDATE users SET loginId=?,password=? WHERE userId=1";
		UserDTO user = null; // 登録ユーザ情報

		try {
			// データベース接続情報取得
			conn = getConnection();

			pstmt = conn.prepareStatement(sql); // SELECT 構文登録
			pstmt.setString(1,loginId);
			pstmt.setString(2, password);
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
