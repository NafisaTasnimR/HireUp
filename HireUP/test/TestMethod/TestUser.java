package TestMethod;

import HireUpMain.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.Assert.assertNotNull;

public class TestUser {

    @Test
    public void testLogin()
    {
        boolean expectedValue = true;
        User user = new User("nafisa","www",".com","job provider");
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
    public void testLogin3()
    {
        boolean expectedValue = true;
        User user = new User("rodoshi","www.som","..com","admin");
        assertEquals(expectedValue,user.logIn());
    }

    @Test
    public void testRegistration()
    {
        boolean expectedValue = true;
        User user1 = new User("Mrittika","www//","m.com","admin");
        assertEquals(expectedValue,user1.registration(user1));

    }

    @Test
    public void testRegistration2()
    {
        boolean expectedValue = true;
        User user1 = new User("Nishat","wwwmm","n.com","admin");
        assertEquals(expectedValue,user1.registration(user1));

    }
    @Test
    public void testRegistration3()
    {
        boolean expectedValue = true;
        User user1 = new User("AR","hjhfrg","ar.com","applicant");
        assertEquals(expectedValue,user1.registration(user1));
    }
    @Test
    public void testAdminRequest(){
        boolean expectedValue = true;
        User user1 = new User("Sanjana","snake","n.com","admin");
        assertEquals(expectedValue, user1.adminRegistrationRequest(user1));
    }


    @Test
    public void testUserObject() {

        String password = "mira";
        String email = "mira.com";
        String role = "applicant";
        Object result = User.userObject(password, email, role);

        boolean expectedValue = true;
        User user = (User) result;
        assertEquals(expectedValue, user.userObject(password, email, role));
    }
}
