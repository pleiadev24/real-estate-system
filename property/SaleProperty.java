package property;

public class SaleProperty extends Property
{
	public double salePri;		//sale price
	private double deposit;		
	public double commi;		//commission rate
	private String buyerID;
	private String auctionTime;
	private boolean section32;
	
	static int sharedCounter = 0;


	public SaleProperty(String proID, String ownerID, String eID, String address, String suburb, 
						String state, String postcode, int bedRoom, int bathRoom, int carPark,
						String proType, String insTime, String status, int acceptNum, double salePri,
						double deposit, double commi, String buyerID, String auctionTime, boolean section32)

	{
		super(proID, ownerID, eID, address, suburb, state, postcode, 
			bedRoom, bathRoom, carPark, proType, insTime, status, acceptNum);

		this.salePri = salePri;
		this.deposit = deposit;
		this.commi = commi;
		this.buyerID = buyerID;
		this.auctionTime = auctionTime;
		this.section32 = section32;
	}

	public SaleProperty(String proID, String ownerID, String eID, String address, String suburb,
						String state, String postcode, int bedRoom, int bathRoom, int carPark,
						String proType, String status, int acceptNum, double salePri,
						double deposit, double commi, String buyerID, String auctionTime, boolean section32)
	{
		super(proID, ownerID, eID, address, suburb, state, postcode,
				bedRoom, bathRoom, carPark, proType, status, acceptNum);

		this.salePri = salePri;
		this.deposit = deposit;
		this.commi = commi;
		this.buyerID = buyerID;
		this.auctionTime = auctionTime;
		this.section32 = section32;
	}

	public SaleProperty(String proID, String ownerID, String eID, String address, String suburb,
						String state, String postcode, int bedRoom, int bathRoom, int carPark,
						String proType, String status, int acceptNum, double salePri,
						double deposit, double commi, String buyerID)
	{
		super(proID, ownerID, eID, address, suburb, state, postcode,
				bedRoom, bathRoom, carPark, proType, status, acceptNum);

		this.salePri = salePri;
		this.deposit = deposit;
		this.commi = commi;
		this.buyerID = buyerID;
	}
	public SaleProperty(String proID, String ownerID, String eID, String address, String suburb,
						String state, String postcode, int bedRoom, int bathRoom, int carPark,
						String proType, String status, int acceptNum, double salePri,
						double deposit, double commi)
	{
		super(proID, ownerID, eID, address, suburb, state, postcode,
				bedRoom, bathRoom, carPark, proType, status, acceptNum);

		this.salePri = salePri;
		this.deposit = deposit;
		this.commi = commi;
	}



	public void handleOffer(Offer offer)
	{
		super.handleOffer(offer);
	}


	public String getOfferDetails(int i)
	{
		return super.getOfferDetails(i);
	}

	
	public double getSalePri() {return this.salePri;}
	public void setSalePri(double salePri) {this.salePri = salePri;}

	public double getDeposit() {return this.deposit;}
	public void setDeposit(double deposit) {this.deposit = deposit;}

	public double getCommi() {return this.commi;}
	public void setCommi(double commi) {this.commi = commi;}

	public String getBuyerID() {return this.buyerID;}
	public void setBuyerID(String buyerID) {this.buyerID = buyerID;}

	public String getAuctionTime() {return this.auctionTime;}
	public void setAuctionTime(String auctionTime) {this.auctionTime = auctionTime;}

	// public ArrayList<Offer> getOfferList() {return this.offerList;}
	// public void setOfferList(ArrayList<Offer> offerList) {this.offerList = offerList;}

	public boolean getSection32() {return this.section32;}
	public void setSection32(boolean section32) {this.section32 = section32;}
}
