package syslink;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SysLinkTest
{
    private static SysLink syslink = new SysLink();

    @Test
    public void salePropertyPostive() throws EmptyInputException, InvalidInputException
    {
        //positive test for creating new sale property, all the input are correct.

        assertTrue(syslink.createSalePro("SP001", "VEN001", "SAL001", "2 king st", "Melbourne",
                "Victoria", "3000", "2", "2", "1", "house", null, "available",
                0, "500000", "50000", 0.05, null, null, false));
    }


    @Test
    public void rentalPropertyPostive() throws EmptyInputException, InvalidInputException
    {
        //positive test for creating new rental property, all the input are correct.

        assertTrue(syslink.createRentalPro("RP001", "LAND001", "PRO001", "1 power st", "Tarneit",
                "Victoria", "3029", "1", "2", "1", "flat", null, "available",
                0 , "700", "12", 0.05, 700, "REN001"));
    }


    @Test
    public void salePropertyNegative1() throws EmptyInputException, InvalidInputException

    {
        //negative test for creating new sale property, some inputs are empty.

        assertFalse(syslink.createSalePro("SP002", "VEN002", "SAL001", null, "southbank",
                null, "3006", "2", "1", "1", "house", null, "sold", 0,
                "450000", "45000", 0.06, "BUY001", null, false));
    }


    @Test
    public void rentalPropertyNegative() throws InvalidInputException, EmptyInputException

    {
        //negative test for creating new rental property, some input are invalid.

        assertFalse(syslink.createRentalPro("RP001", "LAND001", "PRO001", "1 power st", "Tarneit",
                "Victoria", "3029", "-1", "2", "-1", "flat", null, "available",
                0 , "700", "12", 0.05, 700, "REN001"));
    }
}