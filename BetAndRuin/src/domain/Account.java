package domain;

import javax.persistence.*;

@Entity
public class Account {
	@Id
	private String firstname;
	private String lastname;
	private String email;
	private String date;
	private String username;
	
	private String password;
	
	private String gender;
	
	//For testing purpose
	public Account(String uname, String passw) {
		username = uname;
		password = passw;
	}
	public Account(String fname, String lname, String em, String d, String uname, String passw, String gend) {
		firstname = fname;
		lastname = lname;
		email = em;
		date = d;
		username = uname;
		password = passw;
		gender = gend;
	}
}
