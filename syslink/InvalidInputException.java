package syslink;

public class InvalidInputException extends Exception 
{
    public InvalidInputException(String e)
    {
        System.err.println(e);
    }
}
