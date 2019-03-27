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
	private int walletFunds;
	@Id
	private String username;
	
	private String password;
	
	private String gender;
	
	//For testing purpose
	/*public Account(String uname, String passw) {
		username = uname;
		password = passw;
	}*/
	public Account(String fname, String lname, String em, String d, String uname, String passw, String gend, int funds, Boolean logged, Boolean admin) {
		firstname = fname;
		lastname = lname;
		email = em;
		date = d;
		username = uname;
		password = passw;
		gender = gend;
		walletFunds = funds;
		isLogged = logged;
		isAdmin = admin;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getAddressEmail() {
		return this.email;
	}
	
	public String getBirthdayDate() {
		return this.date;
	}
	
	public String getFirstname() {
		return this.firstname;
	}
	
	public String getLastname() {
		return this.lastname;
	}
	
	public int getAccountFunds() {
		return this.walletFunds;
	}
	
	public Boolean isAdmin() {
		return this.isAdmin;
	}
	
	public Boolean getLoginStatus() {
		return this.isLogged;
	}
	
	public void changeToLogout() {
		isLogged = false;
	}
	
	


}
