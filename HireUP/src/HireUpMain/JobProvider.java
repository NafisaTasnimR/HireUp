package HireUpMain;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class JobProvider extends User{
    private String companyName;
    private String webAddress;

    public JobProvider(String companyname,String webaddress)
    {
        this.companyName = companyname;
        this.webAddress = webaddress;
    }
    public JobProvider(){}

    public JobProvider(String companyName){
        this.companyName = companyName;
    }

    public String getCompanyName()
    {
        return companyName;
    }
    public String getWebAddress()
    {
        return webAddress;
    }
    //getter setter
    public boolean registrationJobProvider() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("JobProvider_info.txt", true))) {
            writer.write(this.getCompanyName() + "," + this.getWebAddress());
            writer.newLine();
            System.out.println("Data has been written to file!");
            return true;
        } catch (IOException e) {
            System.err.println("Error occurred writing to file : " + e.getMessage());
        }
        return false;
    }

    public boolean postJob(Job job)
    {
        String companyName = job.getCompanyName();
        String regex = "[,\\.\\s]";
        String[] nameArray = companyName.split(regex);
        String jobPostNo = nameArray[0] + String.valueOf((int)(Math.random()*100));
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Job_info.txt",true))){
            bufferedWriter.newLine();
            bufferedWriter.write(jobPostNo + "," + job.getCompanyName() + "," +
                    job.getJobPosition() + "," + job.getSkill() + "," + job.getExperience()
            + "," + job.getSalary() + "," + job.getLocation() + "," + job.getTime()
            + "," + job.getWebsiteLink() + "," + job.getAdditional());
            bufferedWriter.flush();
            bufferedWriter.close();
            System.out.println("You have successfully posted a job circular!");
            return true;
        }catch (IOException e)
        {
            System.out.println("Error occurred writing to file: " + e.getMessage());
        }
        return false;
    }

    public List<String> seeApplicantList(String jobPostNo)
    {
        List<String> applicantList = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("Application.txt")))
        {
            String line;
            String applicantInfo = null;
            int serial = 0;
            while((line = bufferedReader.readLine()) != null)
            {
                String[] data = line.split(",");
                String applicantEmail = data[5];
                if(Objects.equals(this.getCompanyName(), data[1]) && Objects.equals(jobPostNo, data[0]))
                {
                    try(BufferedReader bufferedReader1 = new BufferedReader(new FileReader("Applicant_info.txt"))){
                        String line1;
                        while ((line1 = bufferedReader1.readLine()) != null)
                        {
                            String[] data1 = line1.split(",");
                            if(Objects.equals(data1[10], applicantEmail)){
                                serial++;
                                System.out.println(serial + "."+"Name: " + data1[0] +" "+
                                        "Phone Number: " + data1[7] +" "+
                                        "Email: " + data1[10] + '\n');
                                applicantInfo = serial + "," + jobPostNo + "," + line1;
                                applicantList.add(applicantInfo);
                            }
                        }
                    }catch (IOException e){
                        System.out.println("Error while getting the applicant info: " + e.getMessage());
                    }
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("There is a error : " + e.getMessage());
        }
        return applicantList;
    }

    public String viewApplicantDetails(String serialNumber,List<String> applicantList)
    {
        String email = null;
        String applicantResume = null;
        for(String applicantInfo : applicantList)
        {
            String[] data = applicantInfo.split(",");
            if(Objects.equals(data[0], serialNumber))
            {
                email = data[12];
                applicantResume = applicantInfo;
                //applicant details print
            }
        }
        return applicantResume;
    }

    public List<String> changeStatus(String applicantResume,String status)
    {
        String jobPostNo = null;
        String applicantEmail = null;
        List<String> changedApplicationInfo = new ArrayList<>();
        String[] data = applicantResume.split(",");
        jobPostNo = data[1];
        applicantEmail = data[12];
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("Application.txt")))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] applicationData = line.split(",");
                if(Objects.equals(jobPostNo, applicationData[0]) && Objects.equals(applicantEmail, applicationData[5]))
                {
                    applicationData[6] = status;
                    changedApplicationInfo.add(applicationData[0] + "," +applicationData[1] + ","+applicationData[2]
                            + "," +applicationData[3] + ","+applicationData[4] +
                            ","+applicationData[5] + ","+applicationData[6]);
                }
                else {
                    changedApplicationInfo.add(line);
                }
            }
        } catch (IOException e)
        {
            System.out.println("There is a error : " + e.getMessage());
        }


        //need to pass the data from application.txt file to change the status
        //already have the applicantEmail and job post no to find the accurate applicant and change his/her status
        return changedApplicationInfo;

    }

    public void addToShortList(List<String> changedApplicationInfo)
    {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Application.txt"))){
            for(String application: changedApplicationInfo){
                bufferedWriter.write(application);
                bufferedWriter.newLine();
            }
        }catch (IOException e)
        {
            System.out.println("Error occurred while writing ");
        }
    }

    public void seeShortList()
    {
        int serial =0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("ApplicantShortList.txt")))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] data = line.split(",");
                String name = data[2];
                String phoneNumber = data[9];
                String email = data[12];
                serial++;
                System.out.println(serial + " " + "Name: " + name + " " +
                       "Phone Number: " + phoneNumber + " " +
                        "Email: " + email + '\n');

            }
        }catch (IOException e)
        {
            System.out.println("Some error occurred while showing the list: " + e.getMessage());
        }
    }
    public List<String> seeJobPosts()
    {
        List<String> jobPostList = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("Job_info.txt")))
        {
            String line;
            String jobPost;
            int serial = 0;
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] data = line.split(",");
                String jobPostNo = data[0];
                String companyName = data[1];
                String position = data[2];
                if(Objects.equals(this.getCompanyName(), data[1])) {
                    serial++;
                    System.out.println(serial +"."+" "+ "Job Post No: " + jobPostNo +" "+
                            "Company Name: " + companyName + " " + "Position: " + position + '\n');
                    jobPost = serial + "," + line;
                    jobPostList.add(jobPost);
                }
            }
        }catch (IOException e)
        {
            System.out.println("Error while showing the Job Posts :" + e.getMessage());
        }
        return jobPostList;
    }

    public String getJobPostNo(String number,List<String> jobPostList)
    {
        String jobPostNo = null;
        for(String jobPost: jobPostList)
        {
            String[] data = jobPost.split(",");
            if(Objects.equals(data[0], number))
            {
                jobPostNo = data[1];
            }
        }
        return jobPostNo;
    }

}
