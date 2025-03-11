package TestMethod;

import HireUpMain.Resume;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestShowResume {
    @Test
    public void testShowResume() {
        Resume resume = new Resume();
        boolean result = resume.showResume("adrita8@gmail.com");
        assertEquals(true, result);
    }


}
