package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.UserDTO;

public class DBResrchManager extends SnsDAO {
	public ArrayList<UserDTO> getLoginUser(String loginId,String userName,String icon,String profile) {
		Connection conn = null;            // データベース接続情報
		PreparedStatement pstmt = null;    // SQL 管理情報
		ResultSet rset = null;
		// 検索結果
		ArrayList<UserDTO> list=new ArrayList<UserDTO>();
		String sql = "SELECT * FROM users WHERE loginId LIKE ? AND userName LIKE ? AND icon=? AND profile LIKE ?";
		UserDTO user = null;    // 登録ユーザ情報

		try {
			// データベース接続情報取得
			conn = getConnection();

			// SELECT 文の登録と実行
			pstmt = conn.prepareStatement(sql);	// SELECT 構文登録
			pstmt.setString(1, "%"+loginId+"%");
			pstmt.setString(2, "%"+userName+"%");
			pstmt.setString(3, icon);
			pstmt.setString(4, "%"+profile+"%");
			rset = pstmt.executeQuery();//

			// 検索結果があれば
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
		} catch (SQLException e) {
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
