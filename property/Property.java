package property;

import java.io.*;
import java.util.ArrayList;

public abstract class Property implements Serializable
{
	protected String proID;	//property ID	//modifier should set to private but have problem in constructor
	private String ownerID;	 //customer ID
	public String eID;		//employee ID
	private String address;
	private String suburb;
	private String state;
	private String postcode;
	private int bedRoom;
	private int bathRoom;
	private int carPark;
	private String proType;	//property type
	private String insTime;	 //inspection time	//should change to datetime later
	private String status;
	private int acceptNum;

	public ArrayList offerlist;


	public Property (String proID, String ownerID, String eID, String address, String suburb,
					String state, String postcode, int bedRoom, int bathRoom, int carPark,
					 String proType, String insTime, String status, int acceptNum)
	{
		this.proID = proID;
		this.ownerID = ownerID;
		this.eID = eID;
		this.address = address;
		this.suburb = suburb;
		this.state = state;
		this.postcode = postcode;
		this.bedRoom = bedRoom;
		this.bathRoom = bathRoom;
		this.carPark = carPark;
		this.proType = proType;
		this.insTime = insTime;
		this.status = status;
		this.acceptNum = acceptNum;
		offerlist = new ArrayList<>();
	}

	public Property (String proID, String ownerID, String eID,String address,String suburb,
					 String state, String postcode, int bedRoom, int bathRoom, int carPark,
					 String proType, String status, int acceptNum)
	{
		this.proID = proID;
		this.ownerID = ownerID;
		this.eID = eID;
		this.address = address;
		this.suburb = suburb;
		this.state = state;
		this.postcode = postcode;
		this.bedRoom = bedRoom;
		this.bathRoom = bathRoom;
		this.carPark = carPark;
		this.proType = proType;
		this.status = status;
		this.acceptNum = acceptNum;
		offerlist = new ArrayList<>();
	}


	public void getProDetails()
	{
		System.out.println();
		System.out.println("****** property details ******");
		System.out.println("property ID: " + proID);
		System.out.println("owner ID: " + ownerID);
		System.out.println("employee ID: " + eID);
		System.out.println("address: " + address);
		System.out.println("suburb: " + suburb);
		System.out.println("state: " + state);
		System.out.println("postcode: " + postcode);
		System.out.println("bedRoom: " + bedRoom);
		System.out.println("bathRoom :" + bathRoom);
		System.out.println("carPark :" + carPark);
		System.out.println("property type: " + proType);
		System.out.println("inspection: " + insTime);
		System.out.println("status: " + status);
		System.out.println();
	}


	public void handleOffer(Offer offer)
	{
		this.addOffer(offer);
	}


	public String getOfferDetails(int i)
	{
		String rString = ""; // returned string

		if(this.offerlist.size() == 0) {rString = "Offer list: empty";}
		else
		{
			rString = rString + " " + System.lineSeparator() + "offer " + i + System.lineSeparator() +
					"propertyID: " + this.getOfferList().get(i).getOfferProID() + System.lineSeparator() +
					"offer price: " + this.getOfferList().get(i).getOffValue() + System.lineSeparator() +
					"offerorID: " + this.getOfferList().get(i).getResponID() + " " + System.lineSeparator();

		}
		return rString;
	}


	public static Object deSerialization(String file) throws IOException, ClassNotFoundException
	{
		FileInputStream fileInputStream = new FileInputStream(file);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
		Object object = objectInputStream.readObject();
		objectInputStream.close();
		return object;
	}


	public String getProID() {return this.proID;}
	public void setProID(String proID) {this.proID = proID;}

	public String getOwnerID() {return this.ownerID;}
	public void setOwnerID(String ownerID) {this.ownerID = ownerID;}

	public String getEID() {return this.eID;}
	public void setEID(String eID) {this.eID = eID;}

	public String getAddress() {return this.address;}
	public void setAddress(String address) {this.address = address;}

	public String getSuburb() {return this.suburb;}
	public void setSuburb(String suburb) {this.suburb = suburb;}

	public String getState() {return this.state;}
	public void setState(String state) {this.state = state;}

	public String getPostcode() {return this.postcode;}
	public void setPostcode(String postcode) {this.postcode = postcode;}

	public int getbedRoom() {return this.bedRoom;}
	public void setbedRoom(int bedRoom) {this.bedRoom = bedRoom;}

	public int getBathRoom() {return this.bathRoom;}
	public void setBathRoom(int bathRoom) {this.bathRoom = bathRoom;}

	public int getCarPark() {return this.carPark;}
	public void setCarPark(int carPark) {this.carPark = carPark;}

	public String getProType() {return this.proType;}
	public void setProType(String proType) {this.proType = proType;}

	public String getInsTime() {return this.insTime;}
	public void setInsTime(String insTime) {this.insTime = insTime;}

	public String getStatus() {return this.status;}
	public void setStatus(String status) {this.status = status;}

	public ArrayList<Offer> getOfferList() {return this.offerlist;}
	public void addOffer(Offer offer) { offerlist.add(offer);}
	public void setOfferlist(ArrayList offerlist) { this.offerlist = offerlist;}
		
	public int getAcceptNum() {return this.acceptNum;}
	public void setAcceptNum(int acceptNum) {this.acceptNum = acceptNum;}
}
