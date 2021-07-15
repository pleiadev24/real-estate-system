package user;

public class Customer extends User 
{
    public Customer(String userID, String firstName, String lastName,
                    String email, String address, String userType, String password) 
    {
        super(userID, firstName, lastName, email, address, userType, password);
    }
}
