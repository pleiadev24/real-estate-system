package user;

public class Vendor extends Customer
{
    public Vendor(String userID, String firstName, String lastName, String email, 
                String address, String userType, String password) 
    {
        super(userID, firstName, lastName, email, address, userType, password);
    }
}
