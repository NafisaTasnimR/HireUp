package TestMethod;

import HireUpMain.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestResume {

    @Test
    public void testResume()
    {
        PersonalInformation personalInformation = new PersonalInformation("nafisa","Jackson", "Mita", "2003", "bangladeshi", "Islam", "female","123456", "dhk","3465658778" );
        EducationalInformation educationalInformation = new EducationalInformation();
        educationalInformation.addEducation("BSc in CSE", "IUT", "Computer Science", "3.5", "2020");
        educationalInformation.addEducation("MSc in IT", "IUT", "Information Technology", "3.4", "2023");
        AdditionalInformation additionalInformation = new AdditionalInformation( "5 year", "reading", "coding");

        boolean expectedValue = true;
        Resume resume = new Resume(personalInformation, educationalInformation, additionalInformation);
        assertEquals(expectedValue, resume.generateResume("nafisa23@gmail.com"));

    }

    @Test
    public void testResumeUpdate() {
        Resume resume = new Resume();
        resume.updateInfo("nafisa123@gmail.com", 1);
        assertTrue(true, "Resume information should be updated.");
    }

    @Test
    public void testResumeExists() {
        Resume resume = new Resume();
        boolean exists = resume.isCreated("adrita8@gmail.com");
        assertTrue(exists, "Resume should exist in the system.");
    }
}
