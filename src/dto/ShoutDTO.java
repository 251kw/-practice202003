package dto;

// 書き込み内容を保持するクラス
public class ShoutDTO {
	private String userName;	// ユーザ名
	private String icon;		// ユーザアイコン
	private String date;		// 書き込み日時
	private String writing;
	private String shout;// 書き込み内容
	private int plug;



	public ShoutDTO() {

	}

	public ShoutDTO(String userName, String icon, String date, String writing,String shout,int plug) {
		this.userName = userName;
		this.icon = icon;
		this.date = date;
		this.writing = writing;
		this.shout=shout;
		this.plug=plug;

	}



	public int getPlug() {
		return plug;
	}

	public void setPlug(int plug) {
		this.plug = plug;
	}

	public String getShout() {
		return shout;
	}

	public void setShout(String shout) {
		this.shout = shout;
	}

	// 各メンバ変数の getter および setter
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
