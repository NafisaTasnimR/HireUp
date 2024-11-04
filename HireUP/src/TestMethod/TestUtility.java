package TestMethod;

import org.junit.Test;

import static HireUpMain.Utility.formatData;
import static org.junit.Assert.assertEquals;

public class TestUtility {
    @Test
    public void testformatData1()
    {
        String expectedValue = "Mirpur";
        String data = "mirpur";
        assertEquals(expectedValue,formatData(data));
    }

    @Test
    public void testformatData2()
    {
        String expectedValue = "Morning";
        String data = "morning";
        assertEquals(expectedValue,formatData(data));
    }
    
}
