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
    public void testDeleteJobProvider() {
        Admin admin = new Admin();

        // Print job providers before deletion
        List<String> jobProviders = admin.ViewInformation();
        System.out.println("Before Deletion: " + jobProviders);

        int serialToDelete = 2; // Set the serial number to delete

        boolean serialExists = jobProviders.stream()
                .anyMatch(job -> Integer.parseInt(job.split(",")[0]) == serialToDelete);

        if (serialExists) {
            // Perform deletion
            assertTrue("Deletion method failed to return true", admin.delete(serialToDelete, jobProviders));

            // ✅ Fix: Force a short wait to ensure file write completes
            try {
                Thread.sleep(1000); // Give time for the OS to update the file
            } catch (InterruptedException ignored) {}

            // Fetch updated job provider list
            List<String> updatedJobProviders = admin.ViewInformation();
            System.out.println("After Deletion: " + updatedJobProviders);

            // Ensure the deleted serial is NOT in the updated list
            boolean stillExists = updatedJobProviders.stream()
                    .anyMatch(job -> Integer.parseInt(job.split(",")[0]) == serialToDelete);

            assertFalse(stillExists, "Serial number " + serialToDelete + " was not deleted successfully.");
        } else {
            fail("Serial number " + serialToDelete + " not found in JobProvider_info.txt");
        }
    }
    
}
