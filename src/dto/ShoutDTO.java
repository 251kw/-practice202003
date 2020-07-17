package dto;

// 書き込み内容を保持するクラス
public class ShoutDTO {
	// ユーザアイコン
	private String date;		// 書き込み日時
	private String writing;
	private String shout;// 書き込み内容
	private String shoutloginId;
	public ShoutDTO() {

	}

	public ShoutDTO(String date, String writing,String shout,String shoutloginId) {
		this.date = date;
		this.writing = writing;
		this.shout=shout;
		this.shoutloginId=shoutloginId;

	}
	public String getShoutloginId() {
		return shoutloginId;
	}

	public void setShoutloginId(String shoutloginId) {
		this.shoutloginId = shoutloginId;
	}

	public String getShout() {
		return shout;
	}

	public void setShout(String shout) {
		this.shout = shout;
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
