package dto;

// 書き込み内容を保持するクラス
public class ShoutDTO {
	// ユーザアイコン
	public  String date;		// 書き込み日時
	public  String writing;
	public String shout_id;// 書き込み内容
	public String loginId;
	public  String userName;
	public  String icon;
	public ShoutDTO() {

	}

	public ShoutDTO(String date, String writing,String shout_id,String loginId,String userName,String icon) {
		this.date = date;
		this.writing = writing;
		this.userName=userName;
		this.shout_id=shout_id;
		this.loginId=loginId;
		this.icon=icon;

	}
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getShout_id() {
		return shout_id;
	}

	public void setShout_id(String shout_id) {
		this.shout_id = shout_id;
	}

	public String getWriting() {
		return writing;
	}

	public void setWriting(String writing) {
		this.writing = writing;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


}
