package TestMethod;

import HireUpMain.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestResume {

    @Test
    public void testResume()
    {
        PersonalInformation personalInformation = new PersonalInformation("nafisa","Jackson", "Mita", "2003", "bangladeshi", "Islam", "female","123456", "dhk","3465658778" );
        EducationalInformation educationalInformation = new EducationalInformation("nafisa", "DPS", "2018", "gpa5", "lps", "2020", "gpa5", "iut", "cse", "bsc", "3.5", "msc", "3.4");
        AdditionalInformation additionalInformation = new AdditionalInformation("nafisa", "5 year", "reading", "coding");

        boolean expectedValue = true;
        Resume resume = new Resume(personalInformation, educationalInformation, additionalInformation);
        assertEquals(expectedValue, resume.generateResume("nafisa23@gmail.com"));

    }
}
