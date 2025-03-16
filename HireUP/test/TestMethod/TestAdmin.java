package TestMethod;

import HireUpMain.Admin;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class TestAdmin {
    private Admin admin = new Admin();

    @Test
    public void testViewInformation() {
        List<String> result = admin.ViewInformation();
        assertNotNull(result, "The returned list should not be null");
        assertFalse(result.isEmpty(), "The list should not be empty");
    }

    @Test
    public void testViewApplicantInformation() {
        List<String> result = admin.ViewApplicantInformation();
        assertNotNull(result, "The returned list should not be null");
        assertFalse(result.isEmpty(), "The list should not be empty");
    }

    @Test
    public void testApproveJobProvider() {
        Admin admin = new Admin();
        List<String> jobProviderRequests = Arrays.asList(
                "1,JohnDoe,pass123,john@gmail.com,JobProvider,TechCorp,www.techcorp.com"
        );
        boolean result = admin.approveJobProvider(1, jobProviderRequests);
        assertTrue(result);
    }
    @Test
    public void testApproveApplicant() {
        Admin admin = new Admin();
        List<String> applicantRequests = Arrays.asList("1,Sneha,pass123,Sneha@gmail.com,Applicant");
        boolean result = admin.approveApplicant(1, applicantRequests);
        assertTrue(result);
    }
}
