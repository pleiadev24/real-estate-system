package user;

public class Buyer extends Customer
{
	private String interestSub;

	public Buyer(String userID, String firstName, String lastName, 
				 String email, String address, String userType, 
				 String password, String interestSub)
	{
		super(userID, firstName, lastName, email, address, userType, password);
		this.interestSub = interestSub;
	}

	public Buyer(String userID, String firstName, String lastName,
				 String email, String address, String userType,
				 String password)
	{
		super(userID, firstName, lastName, email, address, userType, password);
	}
	

	public String getBInterestSub() {return this.interestSub;}
	public void setBInterestSub(String interestSub) {this.interestSub = interestSub;}
}
