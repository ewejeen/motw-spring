package org.motw.user.vo;

public class UserVO {
	private String username;
	private String password;
	private String email;
	private String regTime;

	public UserVO() {
	}

	public UserVO(String username, String password, String email, String regTime) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.regTime = regTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

}
