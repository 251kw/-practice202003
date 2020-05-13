package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UserDTO;
public class DEDelete extends SnsDAO{
	public UserDTO getLoginUser(String loginId) {
		Connection conn = null; // データベース接続情報
		PreparedStatement pstmt = null; // SQL 管理情報
		ResultSet rset = null; // 検索結果


		String sql = "DELETE FROM users WHERE loginId=?";
		UserDTO user = null; // 登録ユーザ情報

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(sql); // SELECT 構文登録
			pstmt.setString(1,loginId);
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


