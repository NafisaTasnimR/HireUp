package TestMethod;

import HireUpMain.Applicant;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static HireUpMain.Utility.formatData;
import static org.junit.Assert.assertEquals;

public class TestApplicant {

    @Test
    public void testsearchJob()
    {
        String location = "uttora";
        int count=0,listCount = 0;
        List<String> filteredJobList = new ArrayList<>();
        Applicant applicant = new Applicant();
        filteredJobList = applicant.searchJob(location);
        for (String line: filteredJobList)
        {
            String[] data = line.split(",");
            if(Objects.equals(data[6], formatData(location)))
            {
                count++;
            }
            listCount++;
        }

        assertEquals(listCount,count);
    }

    @Test
    public void testsearchJob2()
    {
        String companyName = "abcd";
        int count=0,listCount = 0;
        List<String> filteredJobList = new ArrayList<>();
        Applicant applicant = new Applicant();
        filteredJobList = applicant.searchJob(companyName);
        for (String line: filteredJobList)
        {
            String[] data = line.split(",");
            if(Objects.equals(data[1],formatData(companyName)))
            {
                count++;
            }
            listCount++;
        }

        assertEquals(listCount,count);
    }

}
