package HireUpMain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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

        try (BufferedReader reader = new BufferedReader(new FileReader("Applicant_info.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                        String[] Resume = line.split(",");
                        if (Resume[10].equals(email) ) {
                            System.out.println("PERSONAL INFORMATION");
                            System.out.println("Name: " + Resume[0] +"\n");
                            System.out.println("Father's Name: " + Resume[1] +"\n");
                            System.out.println("Mother's Name: " + Resume[2] +"\n");
                            System.out.println("Date of Birth: " + Resume[3] +"\n");
                            System.out.println("Nationality: " + Resume[4] +"\n");
                            System.out.println("Religion: " + Resume[5] +"\n");
                            System.out.println("Gender: " + Resume[6] +"\n");
                            System.out.println("Phone Number: " + Resume[7] +"\n");
                            System.out.println("Address: " + Resume[8] +"\n");
                            System.out.println("National ID: " + Resume[9] +"\n");
                            System.out.println("Email: " + Resume[10] +"\n");
                            System.out.println(" EDUCATIONAL INFORMATION ");
                            System.out.println("School Name: " + Resume[11] +"\n");
                            System.out.println("Passing Year(SSC/O Level): " + Resume[12] +"\n");
                            System.out.println("SSC/O Level Result: " + Resume[13] +"\n");
                            System.out.println("College Name: " + Resume[14] +"\n");
                            System.out.println("Passing Year (HSC/A Level): " + Resume[15] +"\n");
                            System.out.println("HSC/A Level Result: " + Resume[16] +"\n");
                            System.out.println("University Name: " + Resume[17] +"\n");
                            System.out.println("Department: " + Resume[18] +"\n");
                            System.out.println("Undergraduate Degree: " + Resume[19] +"\n");
                            System.out.println("CGPA: " + Resume[20] +"\n");
                            System.out.println("Postgraduate Degree: " + Resume[21] +"\n");
                            System.out.println("CGPA: " + Resume[22] +"\n");
                            System.out.println("ADDITIONAL INFORMATION: ");
                            System.out.println("Experience: " + Resume[23] +"\n");
                            System.out.println("Hobbies: " + Resume[24] +"\n");
                            System.out.println("Skills: " + Resume[25] +"\n");

                            found = true;

                        }
                    }


            if (!found) {
                System.out.println("You have not created your resume!");
            }


        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    }
