package domain;

import java.util.List;

import javax.persistence.*;

import dataAccess.DataAccess;

@Entity
public class Login {
	@Id
	private String username;
	private String password;
	
	public Login(String uname, String passw) {
		username = uname;
		password = passw;
	}
	
}