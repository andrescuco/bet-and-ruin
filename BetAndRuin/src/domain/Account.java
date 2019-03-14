package domain;

import javax.persistence.*;

@Entity
public class Account {
	private String firstname;
	private String lastname;
	private String email;
	private String date;
	private Boolean isLogged;
	private Boolean isAdmin;
	@Id
	private String username;
	
	private String password;
	
	private String gender;
	
	//For testing purpose
	/*public Account(String uname, String passw) {
		username = uname;
		password = passw;
	}*/
	public Account(String fname, String lname, String em, String d, String uname, String passw, String gend, Boolean logged, Boolean admin) {
		firstname = fname;
		lastname = lname;
		email = em;
		date = d;
		username = uname;
		password = passw;
		gender = gend;
		isLogged = logged;
		isAdmin = admin;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public Boolean isAdmin() {
		return this.isAdmin;
	}
	
	public Boolean getLoginStatus() {
		return this.isLogged;
	}

}
