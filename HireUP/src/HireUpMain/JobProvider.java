package HireUpMain;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static HireUpMain.Utility.extractYear;

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

    public List<String> seeApplicantList(String jobPostNo,String sortingPreference)
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
        this.sortList(applicantList,sortingPreference);
        return applicantList;
    }

    public String viewApplicantDetails(String serialNumber,List<String> applicantList)
    {
        String email;
        String applicantResume = null;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("Applicant_info.txt"))){
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                int count = 0;
                String[] applicantData = line.split(",");
                email = applicantData[10];
                for(String applicantInfo : applicantList)
                {
                    String[] data = applicantInfo.split(",");
                    int index = data.length;
                    for(int i=0; i<index; i++)
                    {
                        if(Objects.equals(email,data[i]) && Objects.equals(serialNumber,data[0])){
                            count = 1;
                            applicantResume = applicantInfo;
                            break;
                        }
                    }
                    if(count == 1)
                    {
                        break;
                    }
                }
                if(count == 1) {
                    System.out.println("PERSONAL INFORMATION");
                    System.out.println("Name: " + applicantData[0]);
                    System.out.println("Father's Name: " + applicantData[1]);
                    System.out.println("Mother's Name: " + applicantData[2]);
                    System.out.println("Date of Birth: " + applicantData[3]);
                    System.out.println("Nationality: " + applicantData[4]);
                    System.out.println("Religion: " + applicantData[5]);
                    System.out.println("Gender: " + applicantData[6]);
                    System.out.println("Phone Number: " + applicantData[7]);
                    System.out.println("Address: " + applicantData[8]);
                    System.out.println("National ID: " + applicantData[9]);
                    System.out.println(" EDUCATIONAL INFORMATION ");
                    System.out.println("School Name: " + applicantData[11]);
                    System.out.println("Passing Year(SSC/O Level): " + applicantData[12]);
                    System.out.println("SSC/O Level Result: " + applicantData[13]);
                    System.out.println("College Name: " + applicantData[14]);
                    System.out.println("Passing Year (HSC/A Level): " + applicantData[15]);
                    System.out.println("HSC/A Level Result: " + applicantData[16]);
                    System.out.println("University Name: " + applicantData[17]);
                    System.out.println("University Department Name: " + applicantData[18]);
                    System.out.println("Undergraduate Degree: " + applicantData[19]);
                    System.out.println("CGPA: " + applicantData[20]);
                    System.out.println("Postgraduate Degree: " + applicantData[21]);
                    System.out.println("CGPA: " + applicantData[22]);
                    System.out.println("ADDITIONAL INFORMATION: ");
                    System.out.println("Experience: " + applicantData[23]);
                    System.out.println("Hobbies: " + applicantData[24]);
                    System.out.println("Skills: " + applicantData[25]);
                }
            }
        }catch (IOException e){
            System.out.println("Error occurred while reading the file:" + e.getMessage());
            e.printStackTrace();
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

    public List<String> seeShortList(String serialNUmber,List<String> jobPostList)
    {
        int serial =0;
        String jobPostNo = null;
        List<String> applicantShortList = new ArrayList<>();
        boolean pendingApplicant = false;
        for(String jobPost : jobPostList)
        {
            String[] jobData = jobPost.split(",");
            if(Objects.equals(serialNUmber, jobData[0]))
            {
                jobPostNo = jobData[1];
            }
        }
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("Application.txt")))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] data = line.split(",");
                String name = data[3];
                String phoneNumber = data[4];
                String email = data[5];
                if(Objects.equals(jobPostNo, data[0]) && Objects.equals(data[6], "Shortlisted")) {
                    serial++;
                    System.out.println(serial + "." + "Name: " + name + " " +
                            "Phone Number: " + phoneNumber + " " +
                            "Email: " + email + '\n');
                    applicantShortList.add(serial + "," + name + ","+ phoneNumber + ","+ email);
                    pendingApplicant = true;
                }
            }
            if(!pendingApplicant)
            {
                System.out.println("You haven't selected any applicant!");
            }

        }catch (IOException e)
        {
            System.out.println("Some error occurred while showing the list: " + e.getMessage());
        }
        return applicantShortList;
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

    private void sortList(List<String> applicantList, String sortBy)
    {
        if (sortBy.equalsIgnoreCase("cgpa")) {
            applicantList.sort((a, b) -> {
                double cgpaA = Double.parseDouble(a.split(",")[22]); // Assuming CGPA is the 3rd field in the info
                double cgpaB = Double.parseDouble(b.split(",")[22]);
                return Double.compare(cgpaB, cgpaA); // Descending order
            });
        } else if (sortBy.equalsIgnoreCase("msc")) {
            applicantList.sort((a, b) -> {
                String mscA = a.split(",")[23].trim(); // Assuming MSc info is the 5th field in the info
                String mscB = b.split(",")[23].trim();
                return mscB.compareTo(mscA); // Yes first, No later
            });
        }else if (sortBy.equalsIgnoreCase("experience")) {
            applicantList.sort((a, b) -> {
                double experienceA = Double.parseDouble(extractYear(a.split(",")[25].trim())); // Assuming MSc info is the 5th field in the info
                double experienceB = Double.parseDouble(extractYear(b.split(",")[25].trim()));
                return Double.compare(experienceB, experienceA); // Yes first, No later
            });
        }

    }

}
