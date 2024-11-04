package TestMethod;

import org.junit.Test;

import static HireUpMain.Utility.formatData;
import static org.junit.Assert.assertEquals;

public class TestUtility {
    @Test
    public void testformatData1()
    {
        String expectedValue = "Mirpur";
        String data = "Mirpur";
        assertEquals(expectedValue,formatData(data));
    }

    @Test
    public void testformatData2()
    {
        String expectedValue = "Morning";
        String data = "morning";
        assertEquals(expectedValue,formatData(data));
    }
    @Test
    public void testformatData3()
    {
        String expectedValue = "Morning";
        String data = "morNiNg";
        assertEquals(expectedValue,formatData(data));
    }

    @Test
    public void testformatData4()
    {
        String expectedValue = "12000";
        String data = "12000";
        assertEquals(expectedValue,formatData(data));
    }
}
