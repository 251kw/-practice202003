package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UserDTO;

public class DBReserch extends SnsDAO {
	   //ログインIDとパスワードを受け取り、登録ユーザー一覧に一致したものがあるか検索
	public UserDTO getLoginUser(String loginId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;

		String sql="SELECT * FROM users WHERE loginId=?";
		UserDTO users =null; //登録ユーザー情報

		try {
			//データベース接続情報
			conn=getConnection();

			//SELECT文の登録と実行
			pstmt=conn.prepareStatement(sql); //セレクト文登録
			pstmt.setString(1, loginId);
			rset=pstmt.executeQuery();

			//検索結果があれば
			if(rset.next()) {
				//必要な列から値を取り出し、ユーザー情報オブジェクトを生成
				users=new UserDTO();
				users.setLoginId(rset.getString(2));
				users.setPassword(rset.getString(3));
				users.setUserName(rset.getString(4));
				users.setIcon(rset.getString(5));
				users.setProfile(rset.getString(3));
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//データベース切断処理
			close(rset);
			close(pstmt);
			close(conn);
		}
		return users;
	}
}
