package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.ShoutDTO;
import dto.UserDTO;

public class DBResrchManager extends SnsDAO {
	public ArrayList<UserDTO> getLoginUser(String loginId,String userName,String icon) {
		Connection conn = null;            // データベース接続情報
		PreparedStatement pstmt = null;    // SQL 管理情報
		ResultSet rset = null;
		// 検索結果
		ArrayList<UserDTO> list=new ArrayList<UserDTO>();
		String sql = "SELECT * FROM users WHERE loginId LIKE ? AND userName LIKE ? AND icon=?";
		UserDTO user = null;    // 登録ユーザ情報

		try {
			// データベース接続情報取得
			conn = getConnection();
			// SELECT 文の登録と実行
			pstmt = conn.prepareStatement(sql);	// SELECT 構文登録
			pstmt.setString(1, "%"+loginId+"%");
			pstmt.setString(2, "%"+userName+"%");
			pstmt.setString(3, icon);
			rset = pstmt.executeQuery();
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
	}public ArrayList<UserDTO> getLoginUser1(String loginId,String icon) {
		Connection conn = null;            // データベース接続情報
		PreparedStatement pstmt = null;    // SQL 管理情報
		ResultSet rset = null;
		// 検索結果
		ArrayList<UserDTO> list=new ArrayList<UserDTO>();
		String sql = "SELECT * FROM users WHERE loginId LIKE ? AND icon=?";
		UserDTO user = null;    // 登録ユーザ情報

		try {
			// データベース接続情報取得
			conn = getConnection();

			// SELECT 文の登録と実行
			pstmt = conn.prepareStatement(sql);	// SELECT 構文登録
			pstmt.setString(1, "%"+loginId+"%");
			pstmt.setString(2, icon);;
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
	public ArrayList<UserDTO> getLoginUser2(String userName,String icon) {
		Connection conn = null;            // データベース接続情報
		PreparedStatement pstmt = null;    // SQL 管理情報
		ResultSet rset = null;
		// 検索結果
		ArrayList<UserDTO> list=new ArrayList<UserDTO>();
		String sql = "SELECT * FROM users WHERE userName LIKE ? AND icon=?";
		UserDTO user = null;    // 登録ユーザ情報

		try {
			// データベース接続情報取得
			conn = getConnection();

			// SELECT 文の登録と実行
			pstmt = conn.prepareStatement(sql);	// SELECT 構文登録
			pstmt.setString(1, "%"+userName+"%");
			pstmt.setString(2, icon);;
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
	public ArrayList<UserDTO> getLoginUser3(String loginId,String icon) {
		Connection conn = null;            // データベース接続情報
		PreparedStatement pstmt = null;    // SQL 管理情報
		ResultSet rset = null;
		// 検索結果
		ArrayList<UserDTO> list=new ArrayList<UserDTO>();
		String sql = "SELECT * FROM users WHERE loginId LIKE ? AND icon=?";
		UserDTO user = null;    // 登録ユーザ情報

		try {
			// データベース接続情報取得
			conn = getConnection();

			// SELECT 文の登録と実行
			pstmt = conn.prepareStatement(sql);	// SELECT 構文登録
			pstmt.setString(1, "%"+loginId+"%");
			pstmt.setString(2, icon);;
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
	public ArrayList<UserDTO> getLoginUser4(String icon) {
		Connection conn = null;            // データベース接続情報
		PreparedStatement pstmt = null;    // SQL 管理情報
		ResultSet rset = null;
		// 検索結果
		ArrayList<UserDTO> list=new ArrayList<UserDTO>();
		String sql = "SELECT * FROM users WHERE icon=?";
		UserDTO user = null;    // 登録ユーザ情報

		try {
			// データベース接続情報取得
			conn = getConnection();

			// SELECT 文の登録と実行
			pstmt = conn.prepareStatement(sql);	// SELECT 構文登録
			pstmt.setString(1, icon);;
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
	public UserDTO getLoginUser5(String loginId){
		Connection conn = null;            // データベース接続情報
		PreparedStatement pstmt = null;    // SQL 管理情報
		ResultSet rset = null;
		// 検索結果
		String sql = "SELECT * FROM users WHERE loginId=?";
		UserDTO user = null;    // 登録ユーザ情報

		try {
			// データベース接続情報取得
			conn = getConnection();

			// SELECT 文の登録と実行
			pstmt = conn.prepareStatement(sql);	// SELECT 構文登録
			pstmt.setString(1, loginId);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				// 必要な列から値を取り出し、ユーザ情報オブジェクトを生成
				user = new UserDTO();
				user.setLoginId(rset.getString(2));
				user.setPassword(rset.getString(3));
				user.setUserName(rset.getString(4));
				user.setIcon(rset.getString(5));
				user.setProfile(rset.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベース切断処理
			close(rset);
			close(pstmt);
			close(conn);
		}
		return user;
	}
	public int getLoginUser6(String loginId){
		Connection conn = null;            // データベース接続情報
		PreparedStatement pstmt = null;    // SQL 管理情報
		ResultSet rset = null;
		int cnd = 0; // 検索結果
		String sql = "DELETE FROM users WHERE  loginId in (?)";

		 // 登録ユーザ情報
		try {
			// データベース接続情報取得
			conn = getConnection();

			// SELECT 文の登録と実行
			pstmt = conn.prepareStatement(sql);	// SELECT 構文登録
			pstmt.setString(1, loginId);
			cnd=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベース切断処理
			close(rset);
			close(pstmt);
			close(conn);
		}
		return cnd;
	}
	public ShoutDTO getLoginUser7(String shouts) {
		Connection conn = null;            // データベース接続情報
		PreparedStatement pstmt = null;    // SQL 管理情報
		ResultSet rset = null;
		// 検索結果
		String sql = "SELECT * FROM shouts WHERE shouts=?";
		ShoutDTO user = null;    // 登録ユーザ情報

		try {
			// データベース接続情報取得
			conn = getConnection();
			// SELECT 文の登録と実行
			pstmt = conn.prepareStatement(sql);	// SELECT 構文登録
			pstmt.setString(1, shouts);
			rset = pstmt.executeQuery();
			// 検索結果があれば
			if (rset.next()) {
				// 必要な列から値を取り出し、ユーザ情報オブジェクトを生成
				ShoutDTO shout=new ShoutDTO();
				shout.setShout(rset.getString(1));
				shout.setUserName(rset.getString(2));
				shout.setIcon(rset.getString(3));
				shout.setDate(rset.getString(4));
				shout.setWriting(rset.getString(5));
			}
		} catch (SQLException e) {
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
