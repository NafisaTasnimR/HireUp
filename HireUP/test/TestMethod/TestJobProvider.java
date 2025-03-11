package TestMethod;

import HireUpMain.JobProvider;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestJobProvider {

    @Test
    public void testSeeJobList() {
        JobProvider jobProvider = new JobProvider("Nafisa Tasnim", "6six", "sixyardsstory@gmail.com", "Job Provider", "Six Yard's Story", "www.sixyardsstory.com");

        List<String> jobPosts = jobProvider.seeJobPosts();
        assertNotNull("Job posts should not be null", jobPosts);
        assertFalse("Job posts should not be empty", jobPosts.isEmpty());

        assertTrue("First job post should contain expected data", jobPosts.get(0).contains("Six Yard's Story"));
    }
}
