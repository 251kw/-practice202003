package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.UserDTO;
public class DEDelete extends SnsDAO{
	public ArrayList<UserDTO>getLoginUser(String loginId) {
		Connection conn = null; // データベース接続情報
		PreparedStatement pstmt = null; // SQL 管理情報
		ResultSet rset = null; // 検索結果

		ArrayList<UserDTO> list=new ArrayList<UserDTO>();
		String sql = "DELETE FROM users WHERE loginId=?";
		UserDTO user = null; // 登録ユーザ情報

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(sql); // SELECT 構文登録
			pstmt.setString(1,loginId);
			pstmt.executeUpdate();
			while (rset.next()) {
				// 必要な列から値を取り出し、ユーザ情報オブジェクトを生成
				user = new UserDTO();
				user.setLoginId(rset.getString(2));
				user.setPassword(rset.getString(3));
				user.setUserName(rset.getString(4));
				user.setIcon(rset.getString(5));
				user.setProfile(rset.getString(6));
				list.add(user);
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

		return list;
	}

}


