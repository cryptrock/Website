package com.killerSoft.Login;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

@Entity
@Table(name="Login")
public class UserBean {
	 private long user_id;
	 private String user_password;
	 private String user_status;
	 
	 public UserBean()
	 {
	 }
	 public UserBean(long user_id, String user_password, String user_status)
	 {
	 this.user_id = user_id;
	 this.user_password = user_password;
	 this.user_status = user_status;
	 }
	 
	 public long getUser_id() {
	 return user_id;
	 }
	 
	 public void setUser_id(long user_id) {
	 this.user_id = user_id;
	 }
	 
	 public String getUser_password() {
	 return user_password;
	 }
	 
	 public void setUser_password(String user_password) {
	 this.user_password = user_password;
	 }
	 
	 public String getUser_status() {
	 return user_status;
	 }
	 
	 public void setUser_status(String user_status) {
	 this.user_status = user_status;
	 }
	}