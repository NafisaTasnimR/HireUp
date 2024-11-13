package HireUpMain;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class JobProvider {
    private String companyName;
    private String webAddress;

    public JobProvider(String companyname,String webaddress)
    {
        this.companyName = companyname;
        this.webAddress = webaddress;
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
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Job_info.txt",true))){
            bufferedWriter.write(job.getCompanyName() + "," +
                    job.getJobPosition() + "," + job.getSkill() + "," + job.getExperience()
            + "," + job.getSalary() + "," + job.getLocation() + "," + job.getTime()
            + "," + job.getWebsiteLink() + "," + job.getAdditional());
            bufferedWriter.newLine();
            System.out.println("You have successfully posted a job circular!");
            return true;
        }catch (IOException e)
        {
            System.out.println("Error occurred writing to file: " + e.getMessage());
        }
        return false;
    }

    public void seeApplicantList()
    {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("Applicant_info.txt"))){
            String line;
            int serial=1;
            String applicantInfo = "";
            List<String> applicantList = new ArrayList<>();
            while((line = bufferedReader.readLine()) != null)
            {
                String[] data = line.split(",");
                System.out.println(serial+" "+data[0]);
                applicantInfo = serial + "," + line;
                applicantList.add(applicantInfo);
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

}
