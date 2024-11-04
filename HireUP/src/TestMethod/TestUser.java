package TestMethod;

import HireUpMain.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestUser {

    @Test
    public void testLogin()
    {
        boolean expectedValue = true;
        User user = new User("nafisa","www",".com","applicant");
        assertEquals(expectedValue,user.logIn());
    }
    @Test
    public void testLogin2()
    {
        boolean expectedValue = true;
        User user1 = new User("Mrittika","www//","m.com","admin");
        assertEquals(expectedValue,user1.logIn());
    }
    @Test
    public void testRegistration(){

        boolean expectedValue = true;
        User user1 = new User("Mrittika","www//","m.com","admin");
        assertEquals(expectedValue,user1.registration(user1));

    }
    @Test
    public void testRegistration2(){

        boolean expectedValue = true;
        User user1 = new User("Nishat","wwwmm","n.com","admin");
        assertEquals(expectedValue,user1.registration(user1));

    }
    @Test
    public void testRegistration3(){

        boolean expectedValue = true;
        User user1 = new User("AR","hjhfrg","ar.com","applicant");
        assertEquals(expectedValue,user1.registration(user1));

    }
}
