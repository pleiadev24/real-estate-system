package property;

public class RentalProperty extends Property
{
	private double wlyRent;		//weekly rent
	private int conDu;		//contract duration
	private double mgFee;		//management fee rate
	private String renterID;
	private double bond;
	static int sharedCounter = 0;
	

	public RentalProperty(String proID, String ownerID, String eID, String address, String suburb, 
						String state, String postcode, int bedRoom, int bathRoom, int carPark,
						  String proType, String insTime, String status, int acceptNum, double wlyRent,
						int conDu, double mgFee, double bond, String renterID) 
	{
		super(proID, ownerID, eID, address, suburb, state, postcode, 
			bedRoom, bathRoom, carPark, proType, insTime, status, acceptNum);
		
		this.wlyRent = wlyRent;
		this.conDu = conDu;
		this.mgFee = mgFee;
		this.bond = bond;
		this.renterID = renterID;
	}

	public RentalProperty(String proID, String ownerID, String eID, String address, String suburb,
						  String state, String postcode, int bedRoom, int bathRoom, int carPark,
						  String proType, String status, int acceptNum, double wlyRent,
						  int conDu, double mgFee, double bond, String renterID)
	{
		super(proID, ownerID, eID, address, suburb, state, postcode,
				bedRoom, bathRoom, carPark, proType, status, acceptNum);

		this.wlyRent = wlyRent;
		this.conDu = conDu;
		this.mgFee = mgFee;
		this.bond = bond;
		this.renterID = renterID;
	}

	public RentalProperty(String proID, String ownerID, String eID, String address, String suburb,
						  String state, String postcode, int bedRoom, int bathRoom, int carPark,
						  String proType, String status, int acceptNum, double wlyRent,
						  int conDu, double mgFee, double bond)
	{
		super(proID, ownerID, eID, address, suburb, state, postcode,
				bedRoom, bathRoom, carPark, proType, status, acceptNum);

		this.wlyRent = wlyRent;
		this.conDu = conDu;
		this.mgFee = mgFee;
		this.bond = bond;
	}



	public void handleOffer(Offer offer)
	{
		super.handleOffer(offer);
	}


	public String getOfferDetails(int i)
	{
		return super.getOfferDetails(i);
	}


	public double getWlyRent() {return this.wlyRent;}
	public void setWlyRent(double wlyRent) {this.wlyRent = wlyRent;}

	public int getConDu() {return this.conDu;}
	public void setConDu(int conDu) {this.conDu = conDu;}

	public double getMgFee() {return this.mgFee;}
	public void setMgFee(double mgFee) {this.mgFee = mgFee;}

	public String getRenterID() {return this.renterID;}
	public void setRenterID(String renterID) {this.renterID = renterID;}

	public double getBond() {return this.bond;}
	public void setBond(double bond) {this.bond = bond;}

	// public ArrayList<Offer> getOfferList() {return this.offerList;}
	// public void setOfferList(ArrayList<Offer> offerList) {this.offerList = offerList;}
}
