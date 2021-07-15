package property;


import java.io.Serializable;

public class Offer implements Serializable
{
    private String offerProID;
    private double offValue;
    private String responID ;

    public Offer(String offerProID, double offValue, String responID)
    {
        this.offerProID = offerProID;
        this.offValue = offValue;
        this.responID = responID;
    }

    public String getOfferProID() { return this.offerProID; }
    public void setOfferProID(String offerProID) { this.offerProID = offerProID; }

    public double getOffValue() { return this.offValue; }
    public void setOffValue(double offValue) { this.offValue = offValue; }

    public String getResponID() { return this.responID; }
    public void setResponID(String responID) { this.responID = responID; }

}