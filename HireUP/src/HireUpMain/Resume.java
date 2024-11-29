package HireUpMain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Resume {
    private PersonalInformation PersonalInformation;
    private EducationalInformation EducationalInformation;
    private AdditionalInformation AdditionalInformation;

    public Resume() {}

    public Resume(PersonalInformation personalInformation, EducationalInformation educationalInformation, AdditionalInformation additionalInformation) {
        PersonalInformation = personalInformation;
        EducationalInformation = educationalInformation;
        AdditionalInformation = additionalInformation;
    }

    public PersonalInformation getPersonalInformation() {
        return PersonalInformation;
    }
    public EducationalInformation getEducationalInformation() {
        return EducationalInformation;
    }
    public AdditionalInformation getAdditionalInformation() {
        return AdditionalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        PersonalInformation = personalInformation;
    }
    public void setEducationalInformation(EducationalInformation educationalInformation) {
        EducationalInformation = educationalInformation;
    }
    public void setAdditionalInformation(AdditionalInformation additionalInformation) {
        AdditionalInformation = additionalInformation;
    }

    public boolean generateResume(String email) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Applicant_info.txt", true))) {
            writer.write(PersonalInformation.toFileString()+","+"Email:"+email+
                    EducationalInformation.toFileString()+","+
                    AdditionalInformation.toFileString());
            writer.newLine();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean showResume(String email) {
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("\\HireUp\\HireUp\\HireUP\\Applicant_info.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {

                        String[] resumeList = line.split(",");
                        String applicantEmail = resumeList[10];
                        if (Objects.equals(applicantEmail, email)) {
                            System.out.println("PERSONAL INFORMATION\n");
                            System.out.println("Name: " + resumeList[0] +"\n");
                            System.out.println("Father's Name: " + resumeList[1] +"\n");
                            System.out.println("Mother's Name: " + resumeList[2] +"\n");
                            System.out.println("Date of Birth: " + resumeList[3] +"\n");
                            System.out.println("Nationality: " + resumeList[4] +"\n");
                            System.out.println("Religion: " + resumeList[5] +"\n");
                            System.out.println("Gender: " + resumeList[6] +"\n");
                            System.out.println("Phone Number: " + resumeList[7] +"\n");
                            System.out.println("Address: " + resumeList[8] +"\n");
                            System.out.println("National ID: " + resumeList[9] +"\n");
                            System.out.println("Email: " + resumeList[10] +"\n");
                            System.out.println("EDUCATIONAL INFORMATION \n");
                            System.out.println("School Name: " + resumeList[11] +"\n");
                            System.out.println("Passing Year(SSC/O Level): " + resumeList[12] +"\n");
                            System.out.println("SSC/O Level Result: " + resumeList[13] +"\n");
                            System.out.println("College Name: " + resumeList[14] +"\n");
                            System.out.println("Passing Year (HSC/A Level): " + resumeList[15] +"\n");
                            System.out.println("HSC/A Level Result: " + resumeList[16] +"\n");
                            System.out.println("University Name: " + resumeList[17] +"\n");
                            System.out.println("Department: " + resumeList[18] +"\n");
                            System.out.println("Undergraduate Degree: " + resumeList[19] +"\n");
                            System.out.println("CGPA: " + resumeList[20] +"\n");
                            System.out.println("Postgraduate Degree: " + resumeList[21] +"\n");
                            System.out.println("CGPA: " + resumeList[22] +"\n");
                            System.out.println("ADDITIONAL INFORMATION \n");
                            System.out.println("Experience: " + resumeList[23] +"\n");
                            System.out.println("Hobbies: " + resumeList[24] +"\n");
                            System.out.println("Skills: " + resumeList[25] +"\n");

                            found = true;

                        }
                    }


            if (!found) {
                System.out.println("You have not created your resume!");

            }

            return true;


        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    }
