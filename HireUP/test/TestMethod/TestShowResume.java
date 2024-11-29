package TestMethod;

import HireUpMain.Resume;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestShowResume {
    @Test
    public void testShowResume()
    {

        boolean expectedValue = true;
        Resume resume = new Resume();
        assertEquals(expectedValue, resume.showResume("ar.com"));
    }



}
