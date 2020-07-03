package dto;

// ユーザ情報を保持するクラス
public class UserDTO {
	private String loginId;		// ログインID
	private String password;	// パスワード
	private String userName;	// ユーザ名
	private String icon;		// ユーザアイコン
	private String profile;		// プロフィール
	private int date;

	public UserDTO(){

	}

	public UserDTO(String loginId, String password, String userName, String icon, String profile,int date) {

		this.loginId = loginId;
		this.password = password;
		this.userName = userName;
		this.icon = icon;
		this.profile = profile;
		this.date=date;
	}
	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	// 各メンバ変数の getter および setter
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
}
