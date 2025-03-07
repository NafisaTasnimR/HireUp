package HireUpMain;

import java.util.ArrayList;
import java.util.List;
import static HireUpMain.Utility.formatData;

public class EducationalInformation {
    private List<String[]> educationRecords;

    public EducationalInformation() {
        this.educationRecords = new ArrayList<>();
    }

    public void addEducation(String degree, String institution, String subject, String result, String year) {
        if (educationRecords.size() < 6) {
            educationRecords.add(new String[]{degree, institution, subject, result, year});
        } else {
            System.out.println("Maximum 6 educational entries allowed.");
        }
    }

    public String toFileString() {
        StringBuilder sb = new StringBuilder();

        // Convert existing education records to CSV format
        for (String[] record : educationRecords) {
            for (String field : record) {
                sb.append(formatData(field)).append(",");
            }
        }

        // Fill remaining empty slots with "n/a" to ensure 30 fields
        while (sb.toString().split(",").length < 30) {
            sb.append("n/a,");
        }

        return sb.toString().replaceAll(",$", ""); // Remove trailing comma
    }

    public List<String[]> getEducationRecords() {
        return educationRecords;
    }
}