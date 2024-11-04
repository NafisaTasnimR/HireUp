package HireUpMain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static HireUpMain.Utility.formatData;

public class Applicant {
    public Applicant()
    {

    }
    public List<String> searchJob(String preference)
    {
        List<String> jobList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("Job_info.txt")))
        {
            String line;
            int serial=0;
            while((line = reader.readLine()) != null)
            {
                String[] data = line.split(",");
                if (data.length == 9) {
                    String companyName = data[0];
                    String jobPosition = data[1];
                    String skill = data[2];
                    String experience = data[3];
                    String salary = data[4];
                    String location = data[5];
                    String time = data[6];
                    String websiteLink = data[7];
                    String additional = data[8];

                    if (Objects.equals(formatData(preference),companyName) || Objects.equals(formatData(preference),location) ||
                            Objects.equals(formatData(preference),jobPosition) || Objects.equals(preference,experience)
                    || Objects.equals(preference,salary) || Objects.equals(formatData(preference),skill)
                            || Objects.equals(preference,time))
                    {
                        serial++;
                        System.out.println(serial+ "." + "Company Name: " + data[0] + " "
                                + "Job Position: " + data[1] + " " + "WebSite Address: " + data[7] + '\n');
                        jobList.add(serial+","+line);
                    }
                }
                else {
                    System.out.println("Invalid data format.");
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return jobList;
    }
}
