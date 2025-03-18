package HireUpMain;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static HireUpMain.Utility.extractYear;
import static HireUpMain.Utility.formatData;

public class JobProvider extends User{
    private String companyName;
    private String webAddress;

    private List<Job> jobs;

    public JobProvider(String username,String password,String email,String role,String companyName,String webAddress){
        super(username,password,email,role);
        this.companyName = companyName;
        this.webAddress = webAddress;
        this.jobs = new ArrayList<>();
    }

    public String getCompanyName()
    {
        return companyName;
    }
    public String getWebAddress()
    {
        return webAddress;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public static JobProvider loadFromFile(String email) {
        try (BufferedReader br = new BufferedReader(new FileReader("JobProvider_info.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[2].equals(email)) {
                    return new JobProvider(data[0], data[1], data[2], data[3],data[4],data[5]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return null;
    }

    public void addJob(Job job) {
        jobs.add(job);
    }

    private boolean saveToFile(Job job) {
        String companyName = job.getCompanyName();
        String regex = "[,\\.\\s]";
        String[] nameArray = companyName.split(regex);
        String jobPostNo = nameArray[0] + String.valueOf((int)(Math.random()*100));
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Job_info.txt", true))) {
            bufferedWriter.newLine();
            bufferedWriter.write(jobPostNo + "," + formatData(this.getCompanyName()) + "," +
                    formatData(job.getJobPosition()) + "," + formatData(job.getSkill()) + "," + job.getExperience()
                    + "," + job.getSalary() + "," + formatData(job.getLocation()) + "," + job.getTime()
                    + "," + this.getWebAddress() + "," + job.getAdditional() + "," + this.getEmail());
            bufferedWriter.flush();
            return true;
        } catch (IOException e) {
            System.out.println("Error occurred writing to file: " + e.getMessage());
            return false;
        }
    }

    public boolean postJob(Job job) {
        this.addJob(job);
        return saveToFile(job);
    }

    public List<String> seeApplicantList(String jobPostNo,String sortingPreference)
    {
        System.out.println("================================================================================================================");
        System.out.println("| S.No | Name                           | Phone Number              | Email                                    |");
        System.out.println("================================================================================================================");
        List<String> applicantList = new ArrayList<>();
        int serial = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("Application.txt")))
        {
            String line;
            String applicantInfo = null;
            while((line = bufferedReader.readLine()) != null)
            {
                String[] data = line.split(",");
                String applicantEmail = data[6];
                if(Objects.equals(this.getEmail(), data[3]) && Objects.equals(jobPostNo, data[0]) && Objects.equals(data[7],"pending"))
                {
                    try(BufferedReader bufferedReader1 = new BufferedReader(new FileReader("Applicant_info.txt"))){;

                        String line1;
                        while ((line1 = bufferedReader1.readLine()) != null)
                        {
                            String[] data1 = line1.split(",");
                            if(Objects.equals(data1[10], applicantEmail)){
                                applicantInfo = jobPostNo + "," + line1;
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
        for(String applicant: applicantList)
        {
            serial++;
            String[] data1 = applicant.split(",");

            System.out.printf("| %-4d | %-30s | %-25s | %-40s | \n",
                    serial, data1[1], data1[8], data1[11]);
            applicantList.set(serial-1,serial + "," + applicantList.get(serial-1));
            System.out.println("================================================================================================================");

        }
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
                    System.out.println("\n==========================================================================================================================================");
                    System.out.println("                                                                 RESUME");
                    System.out.println("==========================================================================================================================================\n");
                    System.out.println("\n-------------------------------------------------------   PERSONAL INFORMATION   ---------------------------------------------------------\n");
                    System.out.println("Name                         : " + applicantData[0] +"\n");
                    System.out.println("Father's Name                : " + applicantData[1] +"\n");
                    System.out.println("Mother's Name                : " + applicantData[2] +"\n");
                    System.out.println("Date of Birth                : " + applicantData[3] +"\n");
                    System.out.println("Nationality                  : " + applicantData[4] +"\n");
                    System.out.println("Religion                     : " + applicantData[5] +"\n");
                    System.out.println("Gender                       : " + applicantData[6] +"\n");
                    System.out.println("Phone Number                 : " + applicantData[7] +"\n");
                    System.out.println("Address                      : " + applicantData[8] +"\n");
                    System.out.println("National ID                  : " + applicantData[9] +"\n");
                    System.out.println("Email                        : " + applicantData[10] +"\n");
                    System.out.println("\n-------------------------------------------------------   EDUCATIONAL INFORMATION   ------------------------------------------------------\n");
                    System.out.println("==========================================================================================================================================");
                    System.out.println("| Exam Name                  | Institution Name                   | Subject                          | Result       | Passing Year       |");
                    System.out.println("==========================================================================================================================================");

                    for (int i = 11; i < 41; i += 5) {
                        if (!applicantData[i].equals("n/a")) {
                            System.out.printf("| %-26s | %-34s | %-32s | %-12s | %-18s |\n",
                                    applicantData[i], applicantData[i + 1], applicantData[i + 2], applicantData[i + 3], applicantData[i + 4]);
                        }
                    }

                    System.out.println("==========================================================================================================================================");
                    System.out.println("\n-------------------------------------------------------   ADDITIONAL INFORMATION   -------------------------------------------------------\n");
                    System.out.println("Experience                   : " + applicantData[41] +"\n");
                    System.out.println("Hobbies                      : " + applicantData[42] +"\n");
                    System.out.println("Skills                       : " + applicantData[43] +"\n");
                    System.out.println("==========================================================================================================================================\n");



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
                if(Objects.equals(jobPostNo, applicationData[0]) && Objects.equals(applicantEmail, applicationData[6]))
                {
                    applicationData[7] = status;
                    changedApplicationInfo.add(applicationData[0] + "," +applicationData[1] + ","+applicationData[2]
                            + "," +applicationData[3] + ","+applicationData[4] +
                            ","+applicationData[5] + ","+applicationData[6] + "," + applicationData[7]);
                }
                else {
                    changedApplicationInfo.add(line);
                }
            }
        } catch (IOException e)
        {
            System.out.println("There is a error : " + e.getMessage());
        }
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
            System.out.println("================================================================================================================");
            System.out.println("| S.No | Name                           | Phone Number              | Email                                    |");
            System.out.println("================================================================================================================");

            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] data = line.split(",");
                String name = data[4];
                String phoneNumber = data[5];
                String email = data[6];
                if(Objects.equals(jobPostNo, data[0]) && Objects.equals(data[7], "Shortlisted")) {
                    serial++;
                    System.out.printf("| %-4d | %-30s | %-25s | %-40s | \n",
                            serial, name, phoneNumber, email);
                    applicantShortList.add(serial + "," + name + ","+ phoneNumber + ","+ email);
                    pendingApplicant = true;
                    System.out.println("================================================================================================================");

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
            System.out.println("================================================================================================================");
            System.out.println("| S.No | Job Post No                    | Company Name              | Position                                 |");
            System.out.println("================================================================================================================");

            String line;
            String jobPost;
            int serial = 0;
            boolean noJobPostYet = true;
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] data = line.split(",");
                String jobPostNo = data[0];
                String companyName = data[1];
                String position = data[2];
                if(Objects.equals(this.getEmail(), data[10])) {
                    serial++;
                    noJobPostYet = false;
                    System.out.printf("| %-4d | %-30s | %-25s | %-40s | \n",
                            serial, jobPostNo, companyName, position);
                    jobPost = serial + "," + line;
                    jobPostList.add(jobPost);
                    System.out.println("================================================================================================================");

                }
            }
            if(noJobPostYet){
                System.out.println("There Is No Job Post Available Under Your Company!");
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
                double cgpaA = Double.parseDouble(a.split(",")[25]);
                double cgpaB = Double.parseDouble(b.split(",")[25]);
                return Double.compare(cgpaB, cgpaA);
            });
        } else if (sortBy.equalsIgnoreCase("msc")) {
            applicantList.sort((a, b) -> {
                String mscA = a.split(",")[30].trim();
                String mscB = b.split(",")[30].trim();
                return mscB.compareTo(mscA);
            });
        }else if (sortBy.equalsIgnoreCase("experience")) {
            applicantList.sort((a, b) -> {
                double experienceA = Double.parseDouble(extractYear(a.split(",")[42].trim()));
                double experienceB = Double.parseDouble(extractYear(b.split(",")[42].trim()));
                return Double.compare(experienceB, experienceA);
            });
        }

    }

}
