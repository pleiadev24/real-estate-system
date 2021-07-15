package syslink;

import java.io.IOException;

public class StartUp
{
    public static void main(String[] args) throws InvalidInputException, EmptyInputException, IOException, ClassNotFoundException {
        SysLink syslink = new SysLink();
        syslink.main();
    }
}
