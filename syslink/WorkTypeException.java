package syslink;

public class WorkTypeException extends Exception {
    double workType;

    public WorkTypeException (double x){
        workType = x;
    }
    public String toString() {
        return  workType + " is over maximum";
    }
}