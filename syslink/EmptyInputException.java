package syslink;

public class EmptyInputException extends Exception 
{
    public EmptyInputException(String e)
    {
        System.err.println(e);
    }
}