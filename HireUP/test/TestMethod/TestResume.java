package TestMethod;

import HireUpMain.AdditionalInformation;
import HireUpMain.EducationalInformation;
import HireUpMain.PersonalInformation;
import HireUpMain.Resume;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestResume {

    @Test
    public void testResume()
    {
        PersonalInformation personalInformation = new PersonalInformation("Mira","Jack", "Mita", "2003", "bangladeshi", "Islam", "female","123456", "dhk","3465658778" );
        EducationalInformation educationalInformation = new EducationalInformation("Mira", "DPS", 2005, 5.0, "DPS", 2007, 5.0, "IUT", "CSE", "BSc", 3.5, "CSE", 3.5);
        AdditionalInformation additionalInformation = new AdditionalInformation("Mira", "5", "gardening", "coding");

        boolean expactedValue = true;
        Resume resume = new Resume(personalInformation, educationalInformation, additionalInformation);
        assertEquals(expactedValue, resume.generateResume("mira1234@gmail.com"));

    }
}
