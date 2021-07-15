package syslink;

import java.util.Scanner;

public class PayrollMenu
{

    private String eID;
    private double fRate; // weekly rate
    private double workType; // hours worked
    private double commission;


    public void main() {
        Boolean okay = false;
        Payroll pay = new Payroll();
        Scanner scan = new Scanner(System.in);
        System.out.println("enterEID:"); //need to scan employee array
        eID = scan.nextLine();
        String temp = null;
        for (int i = 0; i < SysLink.getUsersList().size(); i++) {
            if (eID.equals(SysLink.getUsersList().get(i).userID)) {
                temp = eID;
            }
        }
        if (temp == null)
            System.out.println("user not found");

        else {
            while (okay == false) {
                try {
                    System.out.println("enter weekly Rate:");
                    fRate = scan.nextDouble();
                    scan.nextLine();

                    if (pay.validateWage(fRate)) {
                        throw new BelowWageException(fRate);
                    }

                    System.out.println("Enter employee type in terms of percentage \nI.e Full-time = 100, half-time = 50:");
                    workType = scan.nextDouble();
                    scan.nextLine();

                    if (pay.validateWorkType(workType)) {
                        throw new WorkTypeException(workType);
                    }

                    okay = true;
                } catch (WorkTypeException mHE) {
                    System.err.println(mHE);
                    scan.nextLine();
                } catch (BelowWageException bWE) {
                    System.err.println(bWE);
                    System.err.println(bWE.getStackTrace());
                    scan.nextLine();
                }

                commission = pay.calcCommission(eID);
                Payroll pay1 = new Payroll(eID, fRate, workType, commission,0);
                pay.payLedger.add(pay1);
                pay.getEmpPay();
            }
        }
    }
}