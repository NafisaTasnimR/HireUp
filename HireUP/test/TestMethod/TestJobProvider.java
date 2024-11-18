package TestMethod;

import HireUpMain.JobProvider;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestJobProvider {
    @Test
    public void testRegistration()
    {
        boolean expectedValue = true;
        JobProvider jobProvider = new JobProvider("redDot","www.dot");
        assertEquals(expectedValue,jobProvider.registrationJobProvider());
    }

    @Test
    public void testSeeJobList()
    {
        boolean expectedValue = true;
        JobProvider jobProvider = new JobProvider("Abcd");
        assertEquals(expectedValue,jobProvider.seeJobPosts());
    }
}
