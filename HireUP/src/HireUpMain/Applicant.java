package HireUpMain;

import java.io.*;
import java.util.*;

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
        try(BufferedReader reader = new BufferedReader(new FileReader("E:\\HireUp\\HireUp\\HireUP\\Job_info.txt")))
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


    public void showInformation(String query, List<String> jobs) {
        List<String> matchingJobs = new ArrayList<>();
        for (String job : jobs) {
            String[] jobInfo = job.split(",");
            if (jobInfo[0].equals(query)) {
                System.out.println("Company Name: " + jobInfo[1] + "\n");
                System.out.println("Job Position: " + jobInfo[2] + "\n");
                System.out.println("Skill: " + jobInfo[3] + "\n");
                System.out.println("Experience: " + jobInfo[4] + "\n");
                System.out.println("Salary: " + jobInfo[5] + "\n");
                System.out.println("Location: " + jobInfo[6] + "\n");
                System.out.println("Time: " + jobInfo[7] + "\n");
                System.out.println("Website Link: " + jobInfo[8] + "\n");
                System.out.println("Additional: " + jobInfo[9] + "\n");
            }

            return;
        }


    }



    public void createResume()
    {
        resume.generateResume(this.getEmail());

    }

    public static List<String> findApplicant(String email) {
        List<String> resumeList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("\\HireUp\\HireUp\\HireUP\\Applicant_info.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 26) {
                    String name = parts[0];
                    String phoneNumber = parts[7];
                    String fileEmail = parts[10];

                    String resumeInfo = name + "," + phoneNumber + "," + fileEmail;


                    if (fileEmail.equalsIgnoreCase(email)) {
                        resumeList.add(resumeInfo);
                        return resumeList;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading the resume file: " + e.getMessage());
        }

        return resumeList;
    }

    public List<String> jobApplication( String email) {
        List<String> jobDetailsList = new ArrayList<>();
        List<String> applicationResults = new ArrayList<>();

        try (BufferedReader jobReader = new BufferedReader(new FileReader("\\HireUp\\HireUp\\HireUP\\Job_info.txt"))) {
            String line;
            while ((line = jobReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 10) {
                    String jobPostNo = parts[0];
                    String companyName = parts[1];
                    String position = parts[3];
                    String jobDetails = jobPostNo + "," + companyName + "," + position;
                    jobDetailsList.add(jobDetails);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading job file: " + e.getMessage());

        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("\\HireUp\\HireUp\\HireUP\\Application.txt", true))) {
            List<String> resumeFiles = this.findApplicant(email);

        } catch (IOException e) {
            System.err.println("Error writing to output file: " + e.getMessage());
        }

        return applicationResults;

    }

}
