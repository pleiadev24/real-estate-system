package syslink;

import property.Property;
import property.SaleProperty;

import java.util.ArrayList;

public class Payroll        //Fizz
{


    private String eID;
    private double fRate; // full rate
    private double workType; // part-time, full-time calculated in percentages
    private double commission;
    private double totPay; //total weekly payment
    public static ArrayList<Payroll> payLedger = new ArrayList<Payroll>();

    public Payroll() {
    }



    public Payroll(String eID, double fRate, double workType, double commission, double totPay ){
        this.eID = eID;
        this.fRate = fRate; //calculated weekly at full time rate
        this.workType = workType;  //calculated if employee is full time part time etc
        this.commission = commission;
        this.totPay = totalpay(fRate, workType, commission);
    }

    public double totalpay(double rate, double type, double comm){
        return (rate * (type/100))+comm;
    }


    public boolean validateWage (double wage ) throws BelowWageException{
        if (wage < 740.80){
            throw new BelowWageException(wage);
        }
        return false;
    }
    public boolean validateWorkType (double workType) throws WorkTypeException {
        if (workType > 100){
            throw new WorkTypeException(workType);
        }
        return false;
    }


    public void getEmpPay(){
        System.out.println("Employee ID \t|Pay Rate \t|Work Type \t|Commission \t|Total Pay");
        System.out.println("----------------|-----------|-----------|---------------|----------");
        for (int i = 0; i < payLedger.size(); i++) {
            System.out.println(payLedger.get(i).geteID() + "\t\t\t|" + payLedger.get(i).getfRate() + "\t\t|" + payLedger.get(i).getWorkType()
                    + "\t\t|" + payLedger.get(i).getCommission()+ "\t\t\t|" + payLedger.get(i).getTotPay());
        }
    }
    public double calcCommission(String eID)
    {
        double comm = 0;
        for (int i = 0; i < SysLink.getPropertyList().size(); i++){
            Property prop = SysLink.getPropertyList().get(i);
            if ( prop.eID.equals(eID) && prop instanceof SaleProperty){
                double calc = (((SaleProperty) prop).commi)*(((SaleProperty) prop).salePri);
                comm += calc;
            }
        }
        return comm;
    }

    public double getCommission() {
        return commission;
    }

    public double getfRate() {
        return fRate;
    }

    public double getWorkType() {
        return workType;
    }

    public String geteID() {
        return eID;
    }

    public double getTotPay() { return totPay; }


}