package user;

public class Landlord extends Customer 
{
    public Landlord(String userID, String firstName, String lastName, 
                    String email, String address, String userType, String password) 
    {
        super(userID, firstName, lastName, email, address, userType, password);
    }
}
