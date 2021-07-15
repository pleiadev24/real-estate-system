package syslink;

import property.Property;
import user.User;

import java.io.*;
import java.util.ArrayList;

public class FileHandle
{
    public static void read() throws IOException, ClassNotFoundException
    {
        ArrayList<Property> pl = (ArrayList<Property>) deSerialization("property.txt");;
        SysLink.setPropertyList(pl);
        System.out.println(SysLink.getPropertyList());

        ArrayList<User> ul = (ArrayList<User>) deSerialization("User.txt");;
        SysLink.setUsersList(ul);
        System.out.println(SysLink.getUsersList());

        System.out.println("successfully read from file");
    }


    public static void write() throws IOException
    {
        ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream("property.txt"));
        out1.writeObject(SysLink.getPropertyList());
        out1.close();

        ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("user.txt"));
        out2.writeObject(SysLink.getUsersList());
        out2.close();

        System.out.println("successfully write into file successful");
    }


    public static Object deSerialization(String file) throws IOException, ClassNotFoundException
    {
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        return object;
    }
}
