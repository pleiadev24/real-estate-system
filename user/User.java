package user;

import java.io.Serializable;

public class User implements Serializable
{
	public String userID;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String userType;
	private String password;


	public User(String userID, String firstName, String lastName, 
				String email, String address, String userType, String password) 
	{
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.userType = userType;
		this.password = password;
	}


	public String getUserID() {return this.userID;}
	public void setUserID(String userID) {this.userID = userID;}

	public String getFName() {return this.firstName;}
	public void setFName(String firstName) {this.firstName = firstName;}

	public String getLName() {return this.lastName;}
	public void setLName(String lastName) {this.lastName = lastName;}

	public String getEmail() {return this.email;}
	public void setEmail(String email) {this.email = email;}

	public String getAddress() {return this.address;}
	public void setAddress(String address) {this.address = address;}
	
	public String getUserType() {return this.userType;}
	public void setUserType(String userType) {this.userType = userType;}
	
	public String getPassword() {return this.password;}
	public void setPassword(String password) {this.password = password;}
}
