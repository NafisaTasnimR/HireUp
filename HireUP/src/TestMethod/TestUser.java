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
        User user = new User("rodoshi","www.som","..com","admin");
        assertEquals(expectedValue,user.logIn());
    }
}
