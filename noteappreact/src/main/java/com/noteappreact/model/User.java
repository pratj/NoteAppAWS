package com.noteappreact.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="user")
public class User {
	
	@NotBlank(message = "FirstName is mandatory")
	private String firstName;
	private String lastName;
	
	@Id
	@NotBlank(message = "UserName is mandatory")
	private String userName;
	
	@NotBlank(message = "Password is mandatory")
	private String password;
	
	@Email(message = "Enter a Valid EmailId!")
	@NotBlank(message = "Email is mandatory")
	private String emailId;
	
	public User(){}

	public User(String firstName, String lastName, String userName, String password, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}

