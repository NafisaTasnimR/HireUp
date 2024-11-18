package HireUpMain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static HireUpMain.Utility.formatData;

public class Applicant extends User{
    private Resume resume;
    public Applicant(String userName, String password, String email, String role) {
        super(userName, password, email, role);
        this.resume = new Resume();
    }

    public Applicant()
    {
        super();

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
                if (data.length == 10) {
                    String companyName = data[1];
                    String jobPosition = data[2];
                    String skill = data[3];
                    String experience = data[4];
                    String salary = data[5];
                    String location = data[6];
                    String time = data[7];
                    String websiteLink = data[8];
                    String additional = data[9];

                    if (Objects.equals(formatData(preference),companyName) || Objects.equals(formatData(preference),location) ||
                            Objects.equals(formatData(preference),jobPosition) || Objects.equals(preference,experience)
                    || Objects.equals(preference,salary) || Objects.equals(formatData(preference),skill)
                            || Objects.equals(preference,time))
                    {
                        serial++;
                        System.out.println(serial+ "." + "Company Name: " + data[1] + " "
                                + "Job Position: " + data[2] + " " + "WebSite Address: " + data[8] + '\n');
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
    public void createResume()
    {
        resume.generateResume(this.getEmail());

    }
}
