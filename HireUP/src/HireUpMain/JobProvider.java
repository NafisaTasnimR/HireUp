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

    public void seeApplicantList(String jobPostNo)
    {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("Application.txt")))
        {
            String line;
            int serial = 0;
            while((line = bufferedReader.readLine()) != null)
            {
                String[] data = line.split(",");
                String applicantName;
                if(Objects.equals(this.getUserName(), data[1]) && Objects.equals(jobPostNo, data[0]))
                {
                    try(BufferedReader bufferedReader1 = new BufferedReader(new FileReader("Applicant_info.txt"))){
                        String line1;
                        while ((line1 = bufferedReader1.readLine()) != null)
                        {
                            String[] data1 = line1.split(",");
                            if(Objects.equals(data1[0], data[3])){
                                serial++;
                                System.out.println(serial + "Name: " + data1[0] +
                                        "Phone Number: " + data1[7] +
                                        "Email: " + data1[10] + '\n');
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
    }

    public void addToShortList(Resume resume)
    {
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("ApplicantShortList.txt",true)))
            {
                bufferedWriter.write(resume.getPersonalInformation().toFileString()+","+
                        resume.getEducationalInformation().toFileString()+","+
                        resume.getAdditionalInformation().toFileString());
                bufferedWriter.newLine();
            } catch (IOException e)
            {
                System.out.println("There is a error : " + e.getMessage());
            }
    }

    public void seeShortList()
    {
        int serial =0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("ApplicantList.txt")))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] data = line.split(",");
                String name = data[0];
                String phoneNumber = data[7];
                String email = data[10];
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
    public boolean seeJobPosts()
    {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("Job_info.txt")))
        {
            String line;
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
                }
            }
            return true;
        }catch (IOException e)
        {
            System.out.println("Error while showing the Job Posts :" + e.getMessage());
        }
        return false;
    }

}
