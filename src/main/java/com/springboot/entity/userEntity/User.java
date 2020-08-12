package com.springboot.entity.userEntity;

import java.sql.Date;

public class User {
	private int userid;
	private String username;
	private String password;
	private String studentId;
	private String telephone;
	private String user_code;
	private String e_mail;
	private String birthday;
	private String sex;
	private String grade;
	private String interest;
	private String introduce;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	@Override
	public String toString() {
		return "User{" +
				"userid='" + userid + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", studentId='" + studentId + '\'' +
				", telephone='" + telephone + '\'' +
				", user_code='" + user_code + '\'' +
				", e_mail='" + e_mail + '\'' +
				", birthday=" + birthday +
				", sex='" + sex + '\'' +
				", grade=" + grade +
				", interest='" + interest + '\'' +
				", introduce='" + introduce + '\'' +
				'}';
	}
}
