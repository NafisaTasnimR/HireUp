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

        for (String[] record : educationRecords) {
            for (String field : record) {
                sb.append(formatData(field)).append(",");
            }
        }

        while (sb.toString().split(",").length < 30) {
            sb.append("n/a,");
        }

        return sb.toString().replaceAll(",$", "");
    }

    public List<String[]> getEducationRecords() {
        return educationRecords;
    }
}