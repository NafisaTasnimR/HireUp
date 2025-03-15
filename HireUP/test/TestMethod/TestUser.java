package TestMethod;

import HireUpMain.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestUser {

    @Test
    public void testLogin()
    {
        boolean expectedValue = true;
        User user = new User("nafisa","mlk8*","nafisa@milkyway.com","Job Provider");
        assertEquals(expectedValue,user.logIn());
    }
    @Test
    public void testLogin2()
    {
        boolean expectedValue = true;
        User user1 = new User("Mrittika","mri150","mrittika@gmail.com","Admin");
        assertEquals(expectedValue,user1.logIn());
    }
  @Test
    public void testLogin3()
    {
        boolean expectedValue = true;
        User user = new User("Mira","mira@44","mira44@gmail.com","Applicant");
        assertEquals(expectedValue,user.logIn());
    }

    @Test
    public void testApplicantRequest(){
        boolean expectedValue = true;
        User user = new User("Mysha","Hjkjlj&&7","mysha@gmail.com","Applicant");
        assertEquals(expectedValue,user.NewApplicantRequest(user));
    }




}
