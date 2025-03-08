package HireUpMain;

import java.io.*;
import java.util.*;

import static HireUpMain.Utility.formatData;

public class Applicant extends User {
    private Resume resume;

    public Applicant(String userName, String password, String email, String role) {
        super(userName, password, email, role);
        this.resume = new Resume();
    }

    public Applicant(String userName, String password, String email, String role, Resume resume) {
        super(userName, password, email, role);
        this.resume = resume;
    }
    public Applicant() {
        super();

    }

    public List<String> searchJob(String preference) {
        List<String> jobList = new ArrayList<>();
        Set<String> uniqueJobs = new HashSet<>();
        int outputSerial = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("E:\\HireUp\\HireUp\\HireUP\\Job_info.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 11) {
                    String jobPostNo = data[0];
                    String companyName = data[1];
                    String jobPosition = data[2];
                    String skill = data[3];
                    String experience = data[4].trim();
                    String salary = data[5].trim();
                    String location = data[6];
                    String time = data[7];
                    String websiteLink = data[8];
                    String additional = data[9];

                    boolean matchFound = false;

                    if (Objects.equals(formatData(preference), companyName) ||
                            Objects.equals(formatData(preference), location) ||
                            Objects.equals(formatData(preference), jobPosition) ||
                            Objects.equals(preference, experience) ||
                            Objects.equals(preference, salary) ||
                            Objects.equals(formatData(preference), skill) ||
                            Objects.equals(preference, time)) {
                        matchFound = true;
                    }

                    try {
                        if (preference.matches("\\d+")) {
                            int input = Integer.parseInt(preference);
                            if (input >= 1000) { // Salary input
                                int lowerRange = Math.max(input - 10000, 0);
                                int upperRange = input + 10000;
                                int jobSalary = Integer.parseInt(salary);
                                if (jobSalary >= lowerRange && jobSalary <= upperRange) {
                                    matchFound = true;
                                }
                            } else {
                                int lowerRange = Math.max(input - 2, 0);
                                int upperRange = input + 2;
                                int jobExperience = Integer.parseInt(experience);
                                if (jobExperience >= lowerRange && jobExperience <= upperRange) {
                                    matchFound = true;
                                }
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number format: " + e.getMessage());
                    }

                    if (matchFound) {
                        String jobInfo = line;
                        if (uniqueJobs.add(jobInfo)) {
                            outputSerial++;
                            jobList.add(outputSerial + "," + line);
                        }
                    }
                } else {
                    System.out.println("Invalid data format.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jobList;
    }


    public void showInformation(String query, List<String> jobs) {
        for (String job : jobs) {

            String[] jobInfo = job.split(",");
            if (Objects.equals(jobInfo[0],query) ) {
                System.out.println("Company Name : " + jobInfo[2] + "\n");
                System.out.println("Job Position : " + jobInfo[3] + "\n");
                System.out.println("Skill        : " + jobInfo[4] + "\n");
                System.out.println("Experience   : " + jobInfo[5] + "\n");
                System.out.println("Salary       : " + jobInfo[6] + "\n");
                System.out.println("Location     : " + jobInfo[7] + "\n");
                System.out.println("Time         : " + jobInfo[8] + "\n");
                System.out.println("Website Link : " + jobInfo[9] + "\n");
                System.out.println("Additional   : " + jobInfo[10] + "\n");
            }

        }

    }


    public void createResume() {
        resume.generateResume(this.getEmail());

    }

    public void showResume() {
        resume.showResume(this.getEmail());
    }

    public void updateInfo(int choiceNo)
    {
        resume.updateInfo(this.getEmail(),choiceNo);
    }

    private String findApplicant(String email) {
        String resumeInfo = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("E:\\HireUp\\HireUp\\HireUP\\Applicant_info.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 44 && parts[10].equals(email) ) {
                    String name = parts[0];
                    String phoneNumber = parts[7];
                    String fileEmail = parts[10];
                    resumeInfo = name + "," + phoneNumber + "," + fileEmail;

                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file ");
            e.printStackTrace();
        }

        return resumeInfo;
    }

    private String findJob(String serialNo, List<String> jobList) {
        String jobDetails = "";
        for (String job : jobList) {
            String[] jobInfo = job.split(",");
            if (jobInfo[0].equals(serialNo)) {
                jobDetails = jobInfo[1] + "," + jobInfo[2] + "," + jobInfo[3] + "," + jobInfo[11] + ",";
            }

        }
        return jobDetails;
    }

    private void writeToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\HireUp\\HireUp\\HireUP\\Application.txt", true))) {
            writer.newLine();
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error writing to file");
            e.printStackTrace();
        }
    }


    public void processApplication(String serialNo, List<String> jobList, String email) {
        if(resume.isCreated(email)) {
            String combinedContent = findJob(serialNo, jobList) + findApplicant(email) + "," + "pending";
            writeToFile(combinedContent);
        }
        else {
            System.out.println("You Have To Create Your Resume To Apply For Any Job!");
        }
    }



     public List<String> applicationList(String email) {
            List<String> jobList = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("\\HireUp\\HireUp\\HireUP\\Application.txt"))) {
                String line;
                int serial = 0;

                System.out.println("==========================================================================================");
                System.out.println("| S.No | Company Name                   | Job Position              | Job Status         |");
                System.out.println("==========================================================================================");

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");

                    if (parts.length > 6 && parts[6].equals(email)) {
                        serial++;
                        jobList.add(serial + "," + line);

                        System.out.printf("| %-4d | %-30s | %-25s | %-18s |\n",
                                serial, parts[1], parts[2], parts[7]);
                        System.out.println("------------------------------------------------------------------------------------------");

                    }
                }


                if (serial == 0) {
                    System.out.println("| No applications found for the given email.                                                              |");
                    System.out.println("==========================================================================================================");
                }

            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }

            return jobList;
    }
    

}
