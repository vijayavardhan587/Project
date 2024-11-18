package com.bean;

public class Student {
	
	int sid;
	String name;
	int age;
	String mobile;
	String address;
	String email;
	String course;
	
	public Student(String mobile) {
		super();
		this.mobile = mobile;
	}



	public Student(int sid, String name, int age, String mobile, String address, String email, String course) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.course = course;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Student(String mobile, String email) {
		super();
		this.mobile = mobile;
		this.email = email;
	}
	public Student(String name, int age, String mobile, String address, String email, String course) {
		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.course = course;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}

}
