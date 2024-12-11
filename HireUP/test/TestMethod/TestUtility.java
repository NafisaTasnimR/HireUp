package TestMethod;

import HireUpMain.Utility;
import org.junit.Test;

import static HireUpMain.Utility.formatData;
import static org.junit.Assert.assertEquals;

public class TestUtility {
    @Test
    public void testFormatData1()
    {
        String expectedValue = "Mirpur";
        String data = "Mirpur";
        assertEquals(expectedValue,formatData(data));
    }

    @Test
    public void testFormatData2()
    {
        String expectedValue = "Morning";
        String data = "morning";
        assertEquals(expectedValue,formatData(data));
    }
    @Test
    public void testFormatData3()
    {
        String expectedValue = "Morning";
        String data = "morNiNg";
        assertEquals(expectedValue,formatData(data));
    }

    @Test
    public void testFormatData4()
    {
        String expectedValue = "12000";
        String data = "12000";
        assertEquals(expectedValue,formatData(data));
    }

    @Test
    public void testFormatData5()
    {
        String expectedValue = "Job Provider";
        String data = "job provider";
        assertEquals(expectedValue,formatData(data));
    }
    @Test
    public void testEmailValidity()
    {
        boolean expectedValue = true;
        assertEquals(expectedValue, Utility.isValidEmail("mrittika210@gmail.com"));
    }

    @Test
    public void testPasswordValidity(){
        boolean expectedValue = true;
        assertEquals(expectedValue,Utility.isValidPassword("pasS@word"));
    }
    @Test
    public void testPhoneValidity(){
        boolean expectedValue = true;
        assertEquals(expectedValue,Utility.isValidPhoneNumber("01846007106"));
    }

    @Test
    public void testExtractYear()
    {
        String experience = "3 years";
        String expectedValue = "3";
        assertEquals(expectedValue,Utility.extractYear(experience));
    }
}
