package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UserDTO;

public class DEUpdetaManager extends SnsDAO {
	public UserDTO getLoginUser(String loginId, String password,String profile,String icon,String userName) {
		Connection conn = null; // データベース接続情報
		PreparedStatement pstmt = null; // SQL 管理情報
		ResultSet rset = null; // 検索結果


		String sql = "UPDATE users SET loginId=?,password=?,profile=?,icon=? WHERE userName=?";
		UserDTO user = null; // 登録ユーザ情報


		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(sql); // SELECT 構文登録
			pstmt.setString(1,loginId);
			pstmt.setString(2, password);
			pstmt.setString(3, profile);
			pstmt.setString(4,icon);
			pstmt.setString(5,userName);
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



