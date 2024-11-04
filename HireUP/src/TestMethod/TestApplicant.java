package TestMethod;

import HireUpMain.Applicant;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestApplicant {

    @Test
    public void testsearchJob()
    {
        boolean expectedValue = true;
        String location = "Uttora";
        //List<String>
        Applicant applicant = new Applicant();

        assertEquals(expectedValue,applicant.searchJob(location));
    }

    @Test
    public void testsearchJob2()
    {
        boolean expectedValue = true;
        String location = "Uttora";
        Applicant applicant = new Applicant();
        assertEquals(expectedValue,applicant.searchJob(location));
    }
}
