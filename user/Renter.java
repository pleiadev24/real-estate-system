package user;

public class Renter extends Customer
{
    private String interestSub;

    public Renter(String userID, String firstName, String lastName, 
                  String email, String address, String userType, 
                  String password, String interestSub)
    {
        super(userID, firstName, lastName, email, address, userType, password);
        this.interestSub = interestSub;
    }

    public Renter(String userID, String firstName, String lastName,
                  String email, String address, String userType,
                  String password)
    {
        super(userID, firstName, lastName, email, address, userType, password);
    }
    
    
    public String getRInterestSub() {return this.interestSub;}
	public void setRInterestSub(String interestSub) {this.interestSub = interestSub;}
}
