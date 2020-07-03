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


		String sql = "UPDATE users SET userName=?,password=?,profile=?,icon=? WHERE loginId=?";
		UserDTO user = null; // 登録ユーザ情報


		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(sql); // SELECT 構文登録
			pstmt.setString(1,userName);
			pstmt.setString(2, password);
			pstmt.setString(3, profile);
			pstmt.setString(4,icon);
			pstmt.setString(5,loginId);
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
	public UserDTO getLoginUser7(String loginId) {
		Connection conn = null; // データベース接続情報
		PreparedStatement pstmt = null; // SQL 管理情報
		ResultSet rset = null; // 検索結果


		String sql = "SELECT * FROM users WHERE loginId=?";
		UserDTO user = null; // 登録ユーザ情報

		//検索結果があれば
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(sql); // SELECT 構文登録
			pstmt.setString(1,loginId);
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
	}public UserDTO dateupdate(String loginId) {
		Connection conn = null; // データベース接続情報
		PreparedStatement pstmt = null; // SQL 管理情報
		ResultSet rset = null; // 検索結果


		String sql = "UPDATE users SET date=1 WHERE loginId=?";
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



