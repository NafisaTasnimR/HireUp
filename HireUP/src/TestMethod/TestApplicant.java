package TestMethod;

import HireUpMain.Applicant;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestApplicant {

    @Test
    public void testsearchJob()
    {
        boolean expectedValue = true;
        Applicant applicant = new Applicant();
        assertEquals(expectedValue,applicant.searchJob());
    }
}
