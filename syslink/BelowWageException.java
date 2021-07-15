package syslink;

public class BelowWageException extends Exception {

    double wage;

    public BelowWageException (double x){
        wage = x;
    }
    public String toString() {
        return  wage + " is below legal minimum wage";
    }

}