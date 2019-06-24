package org.motw.user.vo;

public class UserVO {
	private String username;
	private String userPw;
	private String userEmail;
	private String regTime;

	public UserVO() {
	}

	public UserVO(String username, String userPw, String userEmail, String regTime) {
		super();
		this.username = username;
		this.userPw = userPw;
		this.userEmail = userEmail;
		this.regTime = regTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getRegTime() {
		return regTime;
	}
	
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
}
