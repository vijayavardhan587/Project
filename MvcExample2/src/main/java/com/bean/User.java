package com.bean;

public class User {
	
	private int uid;
	private String name;
	private String email;
	private String password;
	private String mobile;
	
	public User(int uid) {
		super();
		this.uid = uid;
	}
	


	public User(String email, String mobile) {
		super();
		this.email = email;
		this.mobile = mobile;
	}



	public User(int uid, String name, String email, String password, String mobile) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}



	public User(String name, String email, String password, String mobile) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}



	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getmobile() {
		return mobile;
	}
	public void setmobile(String mobile) {
		this.mobile = mobile;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
}
