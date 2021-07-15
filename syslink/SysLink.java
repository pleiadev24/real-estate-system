package syslink;

import property.Offer;
import property.Property;
import property.RentalProperty;
import property.SaleProperty;
import user.*;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SysLink
{
    public static Scanner scan = new Scanner(System.in);
    private String loginID;
    private static ArrayList<User> usersList = new ArrayList<>();
    private static ArrayList<Property> propertyList = new ArrayList<>();
    PayrollMenu payroll = new PayrollMenu();


    public void main() throws InvalidInputException, EmptyInputException, IOException, ClassNotFoundException        //Shawn
    {
        FileHandle.read();
        loginMenu();
    }


    public void loginMenu() throws InvalidInputException, EmptyInputException, IOException     //Shawn
    {
        char MenuStatus = 'N'; // login status set to 'N'
        do {
            String act1;

            System.out.println(" ");
            System.out.println("***** User Menu *****");
            System.out.println("1. Log in");
            System.out.println("2. Create new account");
            System.out.println("3. Search property");
            System.out.println("4. Display all available properties");
            System.out.println("5. Quit");
            System.out.println("6. Generate Objects (for demo)");
            System.out.println("Enter your choice: ");

            act1 = scan.nextLine();

            if (act1.compareTo("1") == 0) { existUserMenu() ; }

            else if (act1.compareTo("2") == 0) { newUserMenu() ; }

            else if (act1.compareTo("3") == 0) { searchProperty();}

            else if (act1.compareTo("4") == 0) { displayAvailable();}

            else if (act1.compareTo("5") == 0)
            {
                System.out.println("You have successfully logged out!");
                FileHandle.write();
                MenuStatus = 'Q';
            }

            else if (act1.compareTo("6") == 0) { generateObj(); }

        } while (MenuStatus != 'Q');
    }


    public void existUserMenu() throws InvalidInputException, EmptyInputException, IOException     //Shawn
    {
        char MenuStatus = 'N'; // login status set to 'N'
        boolean okay = false;

        do {

            do {
                System.out.println(" ");
                System.out.println("***** Existing User *****");
                System.out.println("enter your UserID and password");
                System.out.println("or 'R' to return");

                System.out.println("your UserID: ");
                loginID = scan.nextLine();

                if (loginID.compareTo("R") == 0 || loginID.compareTo("r") == 0)
                {
                    okay = true;
                    MenuStatus = 'Q';
                    break;
                }

                int uArrayInt = findUserID(loginID);

                if (findUserID(loginID) != -1)
                {
                    System.out.println("your password: ");
                    String password = scan.nextLine();

                    if (password.compareTo(usersList.get(uArrayInt).getPassword()) == 0)
                    {
                        System.out.println("log in successful!");

                        if (usersList.get(uArrayInt) instanceof Customer)
                        {customerMenu() ;}    //call Menu in CustMenu

                        else {employeeMenu() ;}     //call Menu in EmpMenu
                    }
                    else{System.out.println("wrong password!");}
                }
            } while (okay == true);
        } while (MenuStatus != 'Q');
    }


    public void newUserMenu() throws InvalidInputException, EmptyInputException, IOException // Shawn
    {
        char MenuStatus = 'N';    //login status set to 'N'

        do
        {
            String act2;

            System.out.println(" ");
            System.out.println("***** Create New User *****");
            System.out.println("choose your action");
            System.out.println("1. create a vendor");
            System.out.println("2. create a landlord");
            System.out.println("3. create a buyer");
            System.out.println("4. create a renter");
            System.out.println("5. Return");
            System.out.println("Enter your choice: ");

            act2 = scan.nextLine();

            if (act2.compareTo("1") == 0) {addVendor();}

            else if (act2.compareTo("2") == 0) {addLandlord();}

            else if (act2.compareTo("3") == 0) {addBuyer();}

            else if (act2.compareTo("4") == 0) {addRenter();}

            else if (act2.compareTo("5") == 0) {MenuStatus = 'Q';}

        } while (MenuStatus != 'Q');
    }


    public void employeeMenu() throws InvalidInputException, EmptyInputException, IOException      //Shawn
    {
        char MenuStatus = 'N';    //login status set to 'N'
        String act3;

        do {
            int uArrayInt = findUserID(loginID);

            if (usersList.get(uArrayInt) instanceof SaleConsultant)
            {
                System.out.println(" ");
                System.out.println("***** SaleConsultant Menu *****");
                System.out.println("choose your action");
                System.out.println("1. display sale property");
                System.out.println("2. search property");
                System.out.println("3. set inspection");
                System.out.println("4. change property status");
                System.out.println("5. section 32");
                System.out.println("6. Return");
                System.out.println("Enter your choice: ");

                act3 = scan.nextLine();

                if (act3.compareTo("1") == 0) {getSaleProDetails();}

                else if (act3.compareTo("2") == 0) {searchProperty();}

                else if (act3.compareTo("3") == 0) {setInspection();}

                else if (act3.compareTo("4") == 0) {changeProStatus();}

                else if (act3.compareTo("5") == 0) {section32();}

                else if (act3.compareTo("6") == 0) {MenuStatus = 'Q';}
            }

            else if (usersList.get(uArrayInt) instanceof PropertyManager)
            {
                System.out.println(" ");
                System.out.println("***** PropertyManager Menu *****");
                System.out.println("choose your action");
                System.out.println("1. display rental property");
                System.out.println("2. search property");
                System.out.println("3. set inspection");
                System.out.println("4. change property status");
                System.out.println("5. Return");
                System.out.println("Enter your choice: ");

                act3 = scan.nextLine();

                if (act3.compareTo("1") == 0) {getRentalProDetails();}

                else if (act3.compareTo("2") == 0) {searchProperty();}

                else if (act3.compareTo("3") == 0) {setInspection();}

                else if (act3.compareTo("4") == 0) {changeProStatus();}

                else if (act3.compareTo("5") == 0) {MenuStatus = 'Q';}
            }

            else if (usersList.get(uArrayInt) instanceof BranchManager)
            {
                System.out.println(" ");
                System.out.println("***** BranchManager Menu *****");
                System.out.println("choose your action");
                System.out.println("1. display all users");
                System.out.println("2. display all property");
                System.out.println("3. assign employee to property");
                System.out.println("4. search property");
                System.out.println("5. run payroll");
                System.out.println("6. print out payroll");
                System.out.println("7. Return");
                System.out.println("Enter your choice: ");

                act3 = scan.nextLine();

                if (act3.compareTo("1") == 0) { getUserDetails(); }

                else if (act3.compareTo("2") == 0)
                {
                    getSaleProDetails();
                    getRentalProDetails();
                }

                else if (act3.compareTo("3") == 0) { assignToPro(); }

                else if (act3.compareTo("4") == 0) { searchProperty(); }

                else if (act3.compareTo("5") == 0) { payroll.main(); }

                else if (act3.compareTo("6") == 0)
                {
                    Payroll pay = new Payroll();
                    pay.getEmpPay();
                }
                else if (act3.compareTo("7") == 0) {MenuStatus = 'Q';}
            }
        } while (MenuStatus != 'Q');
    }


    public void customerMenu() throws InvalidInputException, EmptyInputException, IOException // Shawn
    {
        char MenuStatus = 'N'; // login status set to 'N'
        String act3 = "";
        int uArrayInt = findUserID(loginID);

        do {

            if (usersList.get(uArrayInt) instanceof Vendor)
            {
                System.out.println(" ");
                System.out.println("***** Vendor Menu *****");
                System.out.println("choose your action");
                System.out.println("1. search property");
                System.out.println("2. add property");
                System.out.println("3. check offer list");
                System.out.println("4. book an auction");
                System.out.println("5. Return");
                System.out.println("Enter your choice: ");

                act3 = scan.nextLine();

                if (act3.compareTo("1") == 0) {searchProperty();}

                else if (act3.compareTo("2") == 0) {initSalePro();}

                else if (act3.compareTo("3") == 0) {CheckOffer();}

                else if (act3.compareTo("4") == 0) {bookAuction();}

                else if (act3.compareTo("5") == 0) {MenuStatus = 'Q';}
            }

            else if (usersList.get(uArrayInt) instanceof Landlord)
            {
                System.out.println(" ");
                System.out.println("***** Landlord Menu *****");
                System.out.println("choose your action");
                System.out.println("1. search property");
                System.out.println("2. add property");
                System.out.println("3. check offer list");
                System.out.println("4. Return");
                System.out.println("Enter your choice: ");

                act3 = scan.nextLine();

                if (act3.compareTo("1") == 0) {searchProperty();}

                else if (act3.compareTo("2") == 0) {initRentalPro();}

                else if (act3.compareTo("3") == 0) {CheckOffer();}

                else if (act3.compareTo("4") == 0) {loginMenu(); MenuStatus = 'Q';}
            }

            else if (usersList.get(uArrayInt) instanceof Buyer)
            {
                System.out.println(" ");
                System.out.println("***** Buyer Menu *****");
                System.out.println("choose your action");
                System.out.println("1. search property");
                System.out.println("2. make an offer");
                System.out.println("3. add suburbs");
                System.out.println("4. Return");
                System.out.println("Enter your choice: ");

                act3 = scan.nextLine();

                if (act3.compareTo("1") == 0) {searchProperty();}

                else if (act3.compareTo("2") == 0) {makeOffer();}

                else if (act3.compareTo("3") == 0) {addSuburb();}

                else if (act3.compareTo("4") == 0) {MenuStatus = 'Q';}
            }

            else if (usersList.get(uArrayInt) instanceof Renter)
            {
                System.out.println(" ");
                System.out.println("***** Renter Menu *****");
                System.out.println("choose your action");
                System.out.println("1. search property");
                System.out.println("2. apply rental property");
                System.out.println("3. register for inspection");
                System.out.println("4. Return");
                System.out.println("Enter your choice: ");

                if (act3.compareTo("1") == 0) {searchProperty();}

                else if (act3.compareTo("2") == 0) {applyRental();}

                else if (act3.compareTo("3") == 0) {addSuburb();}

                else if (act3.compareTo("4") == 0) {MenuStatus = 'Q';}
            }

        } while (MenuStatus != 'Q');
    }


    public void addVendor() throws InvalidInputException, EmptyInputException, IOException // Mia
    {
        System.out.println("create new vendor");
        Vendor vendor = (Vendor)initUser("vendor");
        if(null != vendor){
            usersList.add(vendor);
            System.out.println("new vendor created");
            loginMenu();
        }
    }


    public void addLandlord() throws InvalidInputException, EmptyInputException, IOException // Mia
    {

        Landlord landlord = (Landlord)initUser("landlord");
        if(null != landlord){
            usersList.add(landlord);
            System.out.println("new landlord created");
            loginMenu();
        }
    }


    public void addBuyer() throws InvalidInputException, EmptyInputException, IOException // Mia
    {
        System.out.println("create new buyer");
        Buyer buyer = (Buyer)initUser("buyer");
        if(null != buyer){
            usersList.add(buyer);
            System.out.println("new buyer created");
            loginMenu();
        }
    }


    public void addRenter() throws InvalidInputException, EmptyInputException, IOException // Mia
    {
        System.out.println("create new renter");
        Renter renter = (Renter) initUser("renter");
        if(null != renter){
            usersList.add(renter);
            System.out.println("new renter created");
            loginMenu();
        }
    }


    private User initUser(String type)      //Mia
    {
        System.out.print("firstName:");
        String firstName = scan.nextLine();

        System.out.print("lastName:");
        String lastName = scan.nextLine();

        System.out.print("email:");
        String email = scan.nextLine();

        System.out.print("address:");
        String address = scan.nextLine();

        System.out.print("password:");
        String password = scan.nextLine();

        User user = createUser(firstName, lastName, email, address, password, type);

        return user;
    }


    public User createUser(String firstName, String lastName,      //Mia
                           String email, String address, String password, String type)
    {
        User newUser;
        boolean isValid = checkParam(firstName, lastName, email, address, password);

        if(!isValid)
        {
            System.out.println("create user failed, please try again");
            return null;
        }
        else
            System.out.println("Success! your id is "+ genUserId(type));

        String userId = genUserId(type);

        switch (type)
        {
            case "vendor":
                newUser = new Vendor(userId, firstName, lastName, email, address, type, password);
                break;
            case "landlord":
                newUser = new Landlord(userId, firstName, lastName, email, address, type, password);
                break;
            case "buyer":
                newUser = new Buyer(userId, firstName, lastName, email, address, type, password);
                break;
            case "renter":
                newUser = new Renter(userId, firstName, lastName, email, address, type, password);
                break;
            default:
                newUser = new User(userId, firstName, lastName, email, address, type, password);
        }
        return newUser;
    }


    public boolean checkParam(String firstName, String lastName,    //Mia
                              String email, String address, String password)
    {

        boolean flag = true;
        if("".equals(firstName.trim())){
            System.out.println("firstName cant be empty");
            flag = false;
        }

        if("".equals(lastName.trim())){
            System.out.println("lastName cant be empty");
            flag = false;
        }

        if("".equals(email.trim())){
            System.out.println("email cant be empty");
            flag = false;
        }
        if(!checkEmail(email.trim())){
            System.out.println("invalid email");
            flag = false;
        }

        if("".equals(address.trim())){
            System.out.println("address cant be empty");
            flag = false;
        }

        if("".equals(password.trim())){
            System.out.println("password cant be empty");
            flag = false;
        }
        // check exists
        for(User user : usersList){
            if(user.getEmail().equals(email.trim())){
                System.out.println("user already exists !");
                flag = false;
            }
        }

        return flag;
    }


    public boolean checkEmail(String email)     //Mia
    {
        boolean tag = true;
        if (!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+"))
        {
            tag = false;
        }
        return tag;
    }


    public String genUserId(String type)        //Mia
    {
        int maxVendorId = 1;
        int maxLandlordId = 1;
        int maxBuyerId = 1;
        int maxRenterId = 1;
        String id = "";

        DecimalFormat df = new DecimalFormat("000");
        switch (type){
            case "vendor":
                id = "vendor" + df.format(maxVendorId);
                maxVendorId++;
                break;
            case "landlord":
                id = "landlord" + df.format(maxLandlordId);
                maxLandlordId++;
                break;
            case "buyer":
                id = "buyer" + df.format(maxBuyerId);
                maxBuyerId++;
                break;
            case "renter":
                id = "renter" + df.format(maxRenterId);
                maxRenterId++;
                break;
            default:
                System.out.println("invalid user type");
        }
        return id;
    }


    public void assignToPro()  throws InvalidInputException      //Roh
    {
        try {
                System.out.println("Enter Property ID to assign ");
                String proID = scan.nextLine();

                if (proID.isEmpty()) { throw new EmptyInputException("Empty Input Exception"); }

            for (Property str : propertyList)
            {

                if (str.getProID().contains(proID) && str instanceof SaleProperty)
                {

                    SaleProperty saleObj = (SaleProperty) str;
                    System.out.println("Enter employee ID to assign: ");
                    String employeeId = scan.nextLine();
                    System.out.println(employeeId);


                    System.out.println("Enter commission: ");
                    double commission = scan.nextDouble();
                    if (commission == -1)
                    {throw new EmptyInputException("");}

                    saleObj.setEID(employeeId);
                    saleObj.setStatus("available");
                    saleObj.setCommi(commission);
                    System.out.println("Assigned successfully");
                }
            }
        }
        catch (EmptyInputException e)
        {
            System.err.println("error, can not accept empty input");
            System.err.println();
        }
        catch (InputMismatchException e)
        {
            System.err.println("Invalid input, please try again");

        }
        catch(Exception e )
        {
            System.err.println();
        }
    }


    public void setInspection()      //Roh
    {
        System.out.println("Enter Property ID to set inspection ");
        String proID = scan.nextLine();

        for(Property str : propertyList)
        {
            if (str.getProID().contains(proID) )
            {
                System.out.println("Enter Inspection time: ");
                String inspectionDetails = scan.nextLine();
                str.setInsTime(inspectionDetails);
                System.out.println("Inspection added successfully ");
            }
        }
    }


    public void changeProStatus()      //Roh
    {
        System.out.println("Enter Property ID to change property status ");
        String proID = scan.nextLine();
        for(Property str : propertyList)
        {
            if (str.getProID().contains(proID) )
            {
                System.out.println("Enter property status: ");
                String propertyStatus = scan.nextLine();
                str.setStatus(propertyStatus);
                System.out.println("Property status changed successfully");
            }
        }
    }


    public void section32()      //Roh
    {
        System.out.println("Enter Property ID to set Section 32 status ");
        String proID = scan.nextLine();
        for(Property str : propertyList)
        {
            if (str.getProID().contains(proID) && str instanceof SaleProperty) {

                SaleProperty saleObj = (SaleProperty) str;
                saleObj.setSection32(true);
                System.out.println("Successfully set Section 32 status");
            }
        }
    }


    public void searchProperty() //fizz // TO DO: should have a fliter function
    {
        System.out.println("Enter Suburb: ");
        String srch = scan.nextLine();

        System.out.println("1.Properties for rent" + "\n2.Properties for sale" + "\nPlease enter choice: ");
        int choice = scan.nextInt();
        scan.nextLine();

        if (choice == 1) {
            for (Property str : propertyList) {
                if (str.getSuburb().contains(srch) && str instanceof RentalProperty) {
                    System.out.println("please enter min range: ");
                    double min = scan.nextDouble();
                    System.out.println("please enter max range: ");
                    double max = scan.nextDouble();
                    double wlyrent = ((RentalProperty) str).getWlyRent();

                    if (max >= wlyrent && wlyrent >= min) {
                        str.getProDetails();
                    }
                }
            }
        } else if (choice == 2) {
            for (Property str : propertyList) {
                if (str.getSuburb().contains(srch) && str instanceof SaleProperty) {
                    System.out.println("please enter min range: ");
                    double min = scan.nextDouble();
                    System.out.println("please enter max range: ");
                    double max = scan.nextDouble();
                    double price = ((SaleProperty) str).getSalePri();

                    if (max >= price && price >= min) {
                        str.getProDetails();
                    }
                }
            }
        }else{
            System.out.println("Choice not valid");
        }
    }


    public void getUserDetails()       //Shawn
	{
        for (User user : usersList)
        {
            System.out.println();
            System.out.println("user ID: " + user.getUserID());
            System.out.println("first name: " + user.getFName());
            System.out.println("last name: " + user.getLName());
            System.out.println("e-mail address: " + user.getEmail());
            System.out.println("address: " + user.getAddress());
            System.out.println("user type: " + user.getUserType());
            System.out.println();

            if (user instanceof Renter) {
                System.out.println("interested suburb: " + ((Renter) user).getRInterestSub());
            }

            if (user instanceof Buyer) {
                System.out.println("interested suburb: " + ((Buyer) user).getBInterestSub());
            }
        }
    }
    

    public void getSaleProDetails()     //Shawn
    {
        for (int i = 0; i < propertyList.size(); i++)
        {
            if (propertyList.get(i) instanceof SaleProperty)
            {
                System.out.println();
                System.out.println("****** sale property details ******");
                getProDetails(i);
                System.out.println("sale price: " + ((SaleProperty)propertyList.get(i)).getSalePri());
                System.out.println("deposit: " + ((SaleProperty)propertyList.get(i)).getDeposit());
                System.out.println("sale commission: " + ((SaleProperty)propertyList.get(i)).getCommi());
                System.out.println("buyer ID: " + ((SaleProperty)propertyList.get(i)).getBuyerID());
                System.out.println("auction time: " + ((SaleProperty)propertyList.get(i)).getAuctionTime());
                System.out.println("section 32 status: " + ((SaleProperty)propertyList.get(i)).getSection32());
                System.out.println();
                System.out.println("*** offer history ***");
//                System.out.println(propertyList.get(i).getOfferDetails());
            }
        }
    }


    public void getRentalProDetails()     //Shawn
    {
        for (int i = 0; i < propertyList.size(); i++)
        {
            if (propertyList.get(i) instanceof RentalProperty)
            {
                System.out.println();
                System.out.println("****** sale property details ******");
                getProDetails(i);
                System.out.println("weekly rent: " + ((RentalProperty)propertyList.get(i)).getWlyRent());
                System.out.println("contract duration: " + ((RentalProperty)propertyList.get(i)).getConDu());
                System.out.println("management fee: " + ((RentalProperty)propertyList.get(i)).getMgFee());
                System.out.println("bond: " + ((RentalProperty)propertyList.get(i)).getBond());
                System.out.println("renter ID: " + ((RentalProperty)propertyList.get(i)).getRenterID());
                System.out.println();
                System.out.println("*** offer history ***");
//                System.out.println(propertyList.get(i).getOfferDetails());
            }
        }
    }


    public void displayAvailable()      //Shawn
    {
        for (int i = 0; i < propertyList.size(); i++)
        {
            if (propertyList.get(i).getStatus().equals("available"))
            {
                if (propertyList.get(i) instanceof SaleProperty)
                {
                    System.out.println();
                    System.out.println("****** sale property details ******");
                    getProDetails(i);
                    System.out.println("sale price: " + ((SaleProperty)propertyList.get(i)).getSalePri());
                    System.out.println("deposit: " + ((SaleProperty)propertyList.get(i)).getDeposit());
                    System.out.println("auction time: " + ((SaleProperty)propertyList.get(i)).getAuctionTime());
                    System.out.println();
                }

                if (propertyList.get(i) instanceof RentalProperty)
                {
                    System.out.println();
                    System.out.println("****** rental property details ******");
                    getProDetails(i);
                    System.out.println("weekly rent: " + ((RentalProperty)propertyList.get(i)).getWlyRent());
                    System.out.println("contract duration: " + ((RentalProperty)propertyList.get(i)).getConDu());
                    System.out.println("bond: " + ((RentalProperty)propertyList.get(i)).getBond());
                    System.out.println();
                }
            }
        }
    }


    public void getProDetails(int i)        //Shawn
    {
        System.out.println("property ID: " + propertyList.get(i).getProID());
        System.out.println("owner ID: " + propertyList.get(i).getOwnerID());
        System.out.println("employee ID: " + propertyList.get(i).getEID());
        System.out.println("address: " + propertyList.get(i).getAddress());
        System.out.println("suburb: " + propertyList.get(i).getSuburb());
        System.out.println("state: " + propertyList.get(i).getState());
        System.out.println("postcode: " + propertyList.get(i).getPostcode());
        System.out.println("bedRoom: " + propertyList.get(i).getbedRoom());
        System.out.println("bathRoom :" + propertyList.get(i).getBathRoom());
        System.out.println("carPark :" + propertyList.get(i).getCarPark());
        System.out.println("property type: " + propertyList.get(i).getProType());
        System.out.println("inspection: " + propertyList.get(i).getInsTime());
        System.out.println("status: " + propertyList.get(i).getStatus());
    }


    public void initSalePro() throws EmptyInputException, InvalidInputException     //Shawn
    {

        System.out.println();
        System.out.println("*** add a new sale property ***");
        System.out.println("Enter details of your property: ");
                                
        System.out.println("Address: ");
        String address = scan.nextLine();

        System.out.println("Suburb: ");
        String suburb = scan.nextLine();

        System.out.println("State: ");
        String state = scan.nextLine();

        System.out.println("Postcode: ");
        String postcode = scan.nextLine();

        System.out.println("Bedroom: ");
        String bedRoom = scan.nextLine();

        System.out.println("Bathroom: ");
        String bathRoom = scan.nextLine();

        System.out.println("Car park: ");
        String carPark = scan.nextLine();

        System.out.println("Property Type: ");
        System.out.println("house, unit, flat, townhouse, or studio");
        String proType = scan.nextLine();

        System.out.println("Sale Price: ");
        String salePrice = scan.nextLine();
             
        int idCount = 0;

        for (Property property : propertyList)
        {
            if (property.getProID().contains("SP"))
            {idCount++;}
        }

        String proID = "SP00" + idCount;

        createSalePro(proID, loginID, null, address, suburb,
                        state, postcode, bedRoom, bathRoom, carPark, proType, null, 
                        "pending", 0, salePrice, null, 0, null, null, false);
    }


    public boolean createSalePro(String proID, String ownerID, String eID, String address, String suburb,
                                    String state, String postcode, String bedRoom, String bathRoom, String carPark,
                                 String proType, String insTime, String status, int acceptNum, String salePri,
                                    String deposit, double commi, String buyerID, String auctionTime, boolean section32)
            throws EmptyInputException, InvalidInputException       //Shawn
    {
        boolean flag = true;
        int intBed = -1;
        int intBath = -1;
        int intCar = -1;
        double doubleSale = -1;
        int intConDu = -1;

        try 
        {
            if (address == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }

            if (suburb == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }

            if (state == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }

            if (postcode == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }

            if (bedRoom == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }
            else {
                intBed = Integer.parseInt(bedRoom);

                if (intBed < 0)
                {
                    flag = false;
                    throw new InvalidInputException("");
                }
            }
            
            if (bathRoom == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }
            else
            { intBath = Integer.parseInt(bathRoom);

                if (intBath < 0)
                {
                    flag = false;
                    throw new InvalidInputException("");
                }
            }

            if (carPark == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }
            else {
                intCar = Integer.parseInt(carPark);

                if (intCar < 0)
                {
                    flag = false;
                    throw new InvalidInputException("");
                }
            }

            if (proType == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }

            if (salePri == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }
            else {
                doubleSale = Double.parseDouble(salePri);

                if (doubleSale < 0)
                {
                    flag = false;
                    throw new InvalidInputException("");
                }
            }
        } 
        catch (EmptyInputException e) 
        {
            System.err.println("error, can not accept empty input");
            System.err.println();
        } catch(Exception e)
        {
            System.err.println("Invalid input, please try again");
            System.err.println();
        }

        if (flag)
        {
            SaleProperty newsale = new SaleProperty(proID, loginID, null, address, suburb,
                    state, postcode, intBed, intBath, intCar, proType, null,
                    "pending", 0, doubleSale, doubleSale * 0.1, 0, null, null, false);

            propertyList.add(newsale);
            System.out.println("your property will be assigned to a sale consultant soon");

//        customerMenu();
            return true;
        }
        else return false;
    }


    public void initRentalPro() throws EmptyInputException, InvalidInputException       //Shawn
    {

        System.out.println();
        System.out.println("*** add a new rental property ***");
        System.out.println("Enter details of your property: ");

        System.out.println("Address: ");
        String address = scan.nextLine();

        System.out.println("Suburb: ");
        String suburb = scan.nextLine();

        System.out.println("State: ");
        String state = scan.nextLine();

        System.out.println("Postcode: ");
        String postcode = scan.nextLine();

        System.out.println("Bedroom: ");
        String bedRoom = scan.nextLine();

        System.out.println("Bathroom: ");
        String bathRoom = scan.nextLine();

        System.out.println("Carpark: ");
        String carPark = scan.nextLine();

        System.out.println("Property Type: ");
        System.out.println("house, unit, flat, townhouse, or studio");
        String proType = scan.nextLine();

        System.out.println("Weekly Rent: ");
        String wlyRent = scan.nextLine();

        System.out.println("Contract Duration: ");
        System.out.println("6, 12 or 24");
        String contractDur = scan.nextLine();
        
        int idCount = 0;

        for (Property property : propertyList)
        {
            if (property.getProID().contains("RP"))
            {idCount++;}
        }

        String proID = "RP00" + idCount;

        createRentalPro(proID, loginID, null, address, suburb, 
                                    state, postcode,bedRoom, bathRoom, carPark, proType, null, 
                                            "pending", 0, wlyRent, contractDur, 0, 0, null);
    }


    public boolean createRentalPro(String proID, String ownerID, String eID, String address, String suburb, 
                                    String state, String postcode, String bedRoom, String bathRoom, String carPark,
                                   String proType, String insTime, String status, int acceptNum, String wlyRent,
                                    String conDu, double mgFee, double bond, String renterID)       //Shawn
                throws EmptyInputException, InvalidInputException  
    {
        boolean flag = true;
        int intBed = -1;
        int intBath = -1;
        int intCar = -1;
        double doubleRent = -1;
        int intConDu = -1;

        try 
        {
            if (address == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }

            if (suburb == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }

            if (state == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }

            if (postcode == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }


            if (bedRoom == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }
            else {
                intBed = Integer.parseInt(bedRoom);

                if (intBed < 0)
                {
                    flag = false;
                    throw new InvalidInputException("");
                }
            }
            
            if (bathRoom == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }
            else {
                intBath = Integer.parseInt(bathRoom);

                if (intBath < 0)
                {
                    flag = false;
                    throw new InvalidInputException("");
                }
            }

            if (carPark == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }
            else {
                intCar = Integer.parseInt(carPark);

                if (intCar < 0)
                {
                    flag = false;
                    throw new InvalidInputException("");
                }
            }

            if (proType == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }

            if (wlyRent == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }
            else {
                doubleRent = Double.parseDouble(wlyRent);

                if (doubleRent < 0)
                {
                    flag = false;
                    throw new InvalidInputException("");
                }
            }

            if (conDu == null)
            {
                flag = false;
                throw new EmptyInputException("");
            }
            else {
                intConDu = Integer.parseInt(conDu);

                if (intConDu < 0)
                {
                    flag = false;
                    throw new InvalidInputException("");
                }
            }
        } 
        catch (EmptyInputException e) 
        {
            System.err.println("error, can not accept empty input");
            System.err.println();
        } catch(Exception e)
        {
            System.err.println("Invalid input, please try again");
            System.err.println();
        }

        if (flag)
        {
            RentalProperty newrental = new RentalProperty(proID, loginID, null, address, suburb,
                    state, postcode, intBed, intBath, intCar, proType, null,
                    "pending", 0, doubleRent, intConDu, 0, doubleRent * 52 / 12, null);

            propertyList.add(newrental);
            System.out.println("your property will be assigned to a property manager soon");

//            customerMenu();
            return true;
        }
        else
        {
//            initRentalPro();
            return false;
        }     
    }


    public void makeOffer()      //Shawn
	{
		System.out.println("enter the ID of the property you would like to make offer: ");
        String proID = scan.nextLine();
        String value;
        boolean pass = false;

        do 
        {
            try 
            {
                if (findProID(proID) < 0)
                {
                    System.err.println("invalid propertyID");
                    customerMenu();
                }
                else
                {
                    for (int i = 0; i < propertyList.size(); i++)
                    {
                        if (propertyList.get(findProID(proID)).getStatus().compareTo("available") == 0
                                || propertyList.get(findProID(proID)).getStatus().compareTo("auctioning") == 0
                                & propertyList.get(findProID(proID)) instanceof SaleProperty)
                        {
                            System.out.println("enter the amount you would like to offer: ");
                            value = scan.nextLine();

                            double dValue = 0;

                            try {dValue = Double.parseDouble(value);} 
                            catch(InputMismatchException e)
                            {
                                System.err.println("Invalid input, please try again");
                                System.err.println();
                            }
                            
                            if (dValue == 0 || dValue < 0)
                            {throw new InvalidInputException("Invalid input, please try again");}
        
                            Offer offer = new Offer(proID, dValue, loginID);
        
                            propertyList.get(findProID(proID)).handleOffer(offer);
                            System.out.println("your offer has been sent");
                            pass = true;
                        }
                        else
                        {
                            System.err.println("this property is not available");
                        }
                        customerMenu();
                    }
                }    
            } 
            catch (EmptyInputException e) 
            {
                System.err.println("error, can not accept empty input");
                System.err.println();
            } catch(Exception e)
            {
                System.err.println("Invalid input, please try again");
                System.err.println();
            }
        } while (!pass);
    }

   
    public void applyRental()    //Shawn
    {
        System.out.println("enter the ID of the property you would like to apply: ");
        String proID = scan.nextLine();
        String value;
        boolean pass = false;

        do
        {
            try
            {
                if (findProID(proID) < 0)
                {
                    System.err.println("invalid propertyID");
                    customerMenu();
                }
                else
                {
                    for (int i = 0; i < propertyList.size(); i++)
                    {
                        if (propertyList.get(findProID(proID)).getStatus().compareTo("available") == 0
                                || propertyList.get(findProID(proID)) instanceof RentalProperty)
                        {
                            System.out.println("enter the amount you would like to offer: ");
                            value = scan.nextLine();

                            double dValue = 0;

                            try {dValue = Double.parseDouble(value);}
                            catch(InputMismatchException e)
                            {
                                System.err.println("Invalid input, please try again");
                                System.err.println();
                            }

                            if (dValue == 0 || dValue < 0)
                            {throw new InvalidInputException("Invalid input, please try again");}

                            Offer offer = new Offer(proID, dValue, loginID);

                            propertyList.get(findProID(proID)).handleOffer(offer);
                            System.out.println("your offer has been sent");
                            pass = true;
                        }
                        else
                        {
                            System.err.println("this property is not available");
                        }
                        customerMenu();
                    }
                }
            }
            catch (EmptyInputException e)
            {
                System.err.println("error, can not accept empty input");
                System.err.println();
            } catch(Exception e)
            {
                System.err.println("Invalid input, please try again");
                System.err.println();
            }
        } while (!pass);
    }

    
    public void addSuburb()     //Shawn
    {
        try 
        {
            System.out.println("enter the suburb you're interested in: ");
            String res = scan.nextLine();
            if (res.isEmpty())
                {throw new InvalidInputException("Invalid input, please try again");}
            
            int uArrayInt = findUserID(loginID);

            if (usersList.get(uArrayInt) instanceof Buyer)
            {((Buyer)usersList.get(uArrayInt)).setBInterestSub(res);}

            else 
            {((Renter)usersList.get(uArrayInt)).setRInterestSub(res);}

            System.out.println("the suburb has been added"); 
        } 
        catch (InvalidInputException e) 
        {
            System.err.println("Invalid input, please try again");
        }
        
    }


    public void bookAuction()   //Shawn
    {
        System.out.println("enter the ID of the property you would like to book auction: ");
        String proID = scan.nextLine();
        boolean pass = false;

        do
        {
            try
            {
                if (findProID(proID) < 0)
                {
                    System.err.println("invalid propertyID");
                    customerMenu();
                }
                else
                {
                    for (int i = 0; i < propertyList.size(); i++)
                    {
                        if (propertyList.get(findProID(proID)).getOwnerID().equals(loginID))
                        {
                            propertyList.get(findProID(proID)).setStatus("auction");
                            System.out.println("your property is on auction");
                        }
                        else
                        {
                            System.err.println("you are not the own of the property");
                        }
                        customerMenu();
                    }
                }
            }
            catch (EmptyInputException e)
            {
                System.err.println("error, can not accept empty input");
                System.err.println();
            } catch(Exception e)
            {
                System.err.println("Invalid input, please try again");
                System.err.println();
            }
        } while (!pass);
    }


    public void CheckOffer()    //Shawn
    {
        System.out.println("enter the ID of the property you would like to check: ");
        String proID = scan.nextLine();
        boolean pass = false;

        do
        {
            try 
            {
                if (findProID(proID) < 0) 
                {
                    System.out.println("invalid propertyID");
                    customerMenu();
                    break;
                } 
                else 
                {
                    int num = findProID(proID);

                    for (int i = 0; i < propertyList.get(num).getOfferList().size(); i++)
                    {
                        if (propertyList.get(num).getOfferList().get(i).getOfferProID().equals(proID) )
                        {
                            System.out.println(propertyList.get(num).getOfferDetails(i));
                        }
                    }

                    System.out.println("enter the number of offer or '0' to quit");
                    int res = scan.nextInt();

                    if (res != 0) {
                        propertyList.get(num).setStatus("offer accepted");
                        propertyList.get(num).setAcceptNum(res);
                        System.out.println("you have accepted offer number: " + res);
                    }
                    customerMenu();
                }    
            } 
            catch (EmptyInputException e)
            {
                System.err.println("error, can not accept empty input");
                System.err.println();
            } catch(Exception e)
            {
                System.err.println("Invalid input, please try again");
                System.err.println();
            }
        } while (!pass); 
    }


    public int findUserID(String res)	   //Shawn
	{   //find UserID in userList
		int foundNum = -1;

		for (int i = 0; i < usersList.size(); i++)
		{
            if (res.compareTo(usersList.get(i).getUserID()) == 0)
            {
                foundNum = i;
            }
        }
		return foundNum;
	}


    public int findProID(String res)        //Shawn
    {//find UserID in userList
		int foundNum = -1;

		for (int i = 0; i < propertyList.size(); i++)
		{
            if (res.compareTo(propertyList.get(i).getProID()) == 0)
            {
                foundNum = i;
            }
        }
		return foundNum; 
    }


    public void generateObj()       //Shawn
    {
        SaleProperty p1 = new SaleProperty("SP000", "vendor000", "SAL001", "2 king st", "southbank",
                "Victoria", "3006", 2, 2, 1, "house", "available", 0, 500000, 50000, 0.05);
        SaleProperty p2 = new SaleProperty("SP001", "vendor001", "SAL001", "1240/183 city rd", "southbank",
                "Victoria", "3006", 2, 1, 1, "flat", "sold", 2, 450000, 45000, 0.06, "buyer001");
        RentalProperty p3 = new RentalProperty("RP000", "landlord000", "PRO001", "1 power st", "southbank",
                "Victoria", "3006", 3, 2, 1, "house", "rented", 1 , 700, 12, 0.05, 2800, "renter001");
        RentalProperty p4 = new RentalProperty("RP001", "landlord001", "PRO001", "1201/122 city rd", "southbank",
                "Victoria", "3006", 1, 1, 1, "studio", "available", 0, 450, 12, 0.05, 1800);

        propertyList.add(p1);
        propertyList.add(p2);
        propertyList.add(p3);
        propertyList.add(p4);

        Vendor user1 = new Vendor("vendor000", "Harry", "Potter", "hp@gmail.com", "his home", "vendor", "123");
        Landlord user2 = new Landlord("landlord000", "Happy", "Billy", "hp@gmail.com", "his home", "landlord", "123");
        Buyer user3 = new Buyer("buyer000", "Harry", "Potter", "hp@gmail.com", "home", "buyer", "123");
        Buyer user4 = new Buyer("buyer001", "Billy", "Sam", "billyS@gmail.com", "home", "buyer", "123");
        Renter user5 = new Renter("renter000", "Harry", "Potter", "hp@gmail.com", "home", "renter", "123");
        Renter user6 = new Renter("renter001", "Jones", "Wong", "JonesW@gmail.com", "home", "renter", "123");
        SaleConsultant user7 = new SaleConsultant ("SAL000", "John", "Snow", "js@gmail.com", "North Melbourne", "sale", "123");
        PropertyManager user8 = new PropertyManager("PRO000", "Shaw", "Lee", "js@gmail.com", "South Melbourne", "prop", "123");
        BranchManager user9 = new BranchManager("BRA000", "Tim","Cook", "apple@gmail.com", "North Sydney", "branch", "123" );

        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);
        usersList.add(user4);
        usersList.add(user5);
        usersList.add(user6);
        usersList.add(user7);
        usersList.add(user8);
        usersList.add(user9);

        Offer Offer1 = new Offer("SP000", 480000, "buyer000");
        Offer Offer2 = new Offer("SP001", 440000, "buyer000");
        Offer Offer3 = new Offer("SP000", 500000, "buyer001");
        Offer Offer4 = new Offer("SP001", 460000, "buyer001");
        Offer Offer5 = new Offer("RP000", 700, "renter000");
        Offer Offer6 = new Offer("RP001", 450, "renter000");
        Offer Offer7 = new Offer("RP000", 710, "renter001");
        Offer Offer8 = new Offer("RP001", 460, "renter001");

        propertyList.get(0).handleOffer(Offer1);
        propertyList.get(1).handleOffer(Offer2);
        propertyList.get(0).handleOffer(Offer3);
        propertyList.get(1).handleOffer(Offer4);
        propertyList.get(2).handleOffer(Offer5);
        propertyList.get(3).handleOffer(Offer6);
        propertyList.get(2).handleOffer(Offer7);
        propertyList.get(3).handleOffer(Offer8);
    }


    public static ArrayList<User> getUsersList() {return SysLink.usersList;}
    public static void setUsersList(ArrayList usersList) { SysLink.usersList = usersList;}
    public static ArrayList<Property> getPropertyList() {return SysLink.propertyList;}
    public static void addPropertyList(Property property) {SysLink.propertyList.add(property); }
    public static void setPropertyList(ArrayList propertyList) { SysLink.propertyList = propertyList;}
}