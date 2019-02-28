package domain;

import javax.persistence.*;

@Entity
public class Account {
	@Id
	private String username;
	private String password;
	
	public Account(String uname, String passw) {
		username = uname;
		password = passw;
	}
}
