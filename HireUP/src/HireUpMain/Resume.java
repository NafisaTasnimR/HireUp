package HireUpMain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static HireUpMain.Utility.updateConsole;

public class Resume {
    private PersonalInformation PersonalInformation;
    private EducationalInformation EducationalInformation;
    private AdditionalInformation AdditionalInformation;

    public Resume() {}

    public Resume(PersonalInformation personalInformation, EducationalInformation educationalInformation, AdditionalInformation additionalInformation) {
        this.PersonalInformation = personalInformation;
        this.EducationalInformation = educationalInformation;
        this.AdditionalInformation = additionalInformation;
    }


    public PersonalInformation getPersonalInformation() {
        return PersonalInformation;
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
            writer.write(PersonalInformation.toFileString()+","+email+ "," +
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

                        String[] resumeList = line.split(",");
                        String applicantEmail = resumeList[10];
                        if (Objects.equals(applicantEmail, email)) {

                            System.out.println("\n==========================================================================================================================================");
                            System.out.println("                       RESUME");
                            System.out.println("==========================================================================================================================================\n");
                            System.out.println("\n-------------------------------------------------------   PERSONAL INFORMATION   -------------------------------------------------------\n");
                            System.out.println("Name                         : " + resumeList[0] +"\n");
                            System.out.println("Father's Name                : " + resumeList[1] +"\n");
                            System.out.println("Mother's Name                : " + resumeList[2] +"\n");
                            System.out.println("Date of Birth                : " + resumeList[3] +"\n");
                            System.out.println("Nationality                  : " + resumeList[4] +"\n");
                            System.out.println("Religion                     : " + resumeList[5] +"\n");
                            System.out.println("Gender                       : " + resumeList[6] +"\n");
                            System.out.println("Phone Number                 : " + resumeList[7] +"\n");
                            System.out.println("Address                      : " + resumeList[8] +"\n");
                            System.out.println("National ID                  : " + resumeList[9] +"\n");
                            System.out.println("Email                        : " + resumeList[10] +"\n");
                            System.out.println("\n-------------------------------------------------------   EDUCATIONAL INFORMATION   -------------------------------------------------------\n");
                            System.out.println("==========================================================================================================================================");
                            System.out.println("| Exam Name                  | Institution Name                   | Subject                          | Result       | Passing Year       |");
                            System.out.println("==========================================================================================================================================");

                            for (int i = 11; i < 41; i += 5) {
                                if (!resumeList[i].equals("n/a")) {
                                    System.out.printf("| %-26s | %-34s | %-32s | %-12s | %-18s |\n",
                                            resumeList[i], resumeList[i + 1], resumeList[i + 2], resumeList[i + 3], resumeList[i + 4]);
                                }
                            }

                            System.out.println("==========================================================================================================================================");
                            System.out.println("\n-------------------------------------------------------   ADDITIONAL INFORMATION   -------------------------------------------------------\n");
                            System.out.println("Experience                   : " + resumeList[41] +"\n");
                            System.out.println("Hobbies                      : " + resumeList[42] +"\n");
                            System.out.println("Skills                       : " + resumeList[43] +"\n");
                            System.out.println("==========================================================================================================================================\n");


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



     public void updateInfo(String email,int choice) {
         Scanner scanner = new Scanner(System.in);
         List<String> updatedLines = new ArrayList<>();
         boolean found = false;

         try (BufferedReader reader = new BufferedReader(new FileReader("Applicant_info.txt"))) {
             String line;

             while ((line = reader.readLine()) != null) {
                 String[] resumeList = line.split(",");

                 if (resumeList[10].equals(email)) {
                     found = true;

                     switch (choice) {
                         case 1:
                             System.out.print("Enter new Phone Number: ");
                             resumeList[7] = scanner.nextLine();
                             break;
                         case 2:
                             System.out.print("Enter new Address: ");
                             resumeList[8] = scanner.nextLine();
                             break;
                         case 3:
                             System.out.print("Enter new Email: ");
                             resumeList[10] = scanner.nextLine();
                             break;
                         case 4:
                             EducationalInformation educationalInformation = new EducationalInformation();
                             System.out.println("Update Educational Information");

                             int eduIndex = 11;
                             int currentCount = 0;
                             for (int i = 0; i < 6; i++) {
                                 int startIdx = eduIndex + (i * 5);
                                 if (!resumeList[startIdx].equals("n/a")) {
                                     educationalInformation.addEducation(resumeList[startIdx], resumeList[startIdx + 1], resumeList[startIdx + 2], resumeList[startIdx + 3], resumeList[startIdx + 4]);
                                     currentCount++;
                                 }
                             }

                             while (true) {
                                 if (currentCount >= 6) {
                                     System.out.println("Maximum 6 educational entries allowed.");
                                     break;
                                 }

                                 System.out.println("\n1. Add Educational Info");
                                 System.out.println("2. Done");
                                 int eduChoice = scanner.nextInt();
                                 scanner.nextLine();

                                 if (eduChoice == 1) {
                                     System.out.print("Enter Degree Name: ");
                                     String degree = scanner.nextLine();

                                     System.out.print("Enter Institution Name: ");
                                     String institution = scanner.nextLine();

                                     System.out.print("Enter Subject: ");
                                     String subject = scanner.nextLine();

                                     System.out.print("Enter Result: ");
                                     String result = scanner.nextLine();

                                     System.out.print("Enter Passing Year: ");
                                     String year = scanner.nextLine();

                                     educationalInformation.addEducation(degree, institution, subject, result, year);
                                     currentCount++;
                                 } else if (eduChoice == 2) {
                                     break;
                                 } else {
                                     System.out.println("Invalid choice. Try again.");
                                 }
                             }

                             String[] eduArray = educationalInformation.toFileString().split(",");
                             for (int i = 0; i < eduArray.length; i++) {
                                 resumeList[eduIndex + i] = eduArray[i];
                             }
                             break;

                         case 5:
                             System.out.print("Enter Experience: ");
                             resumeList[41] = scanner.nextLine();
                             break;
                         case 6:
                             System.out.print("Enter Skills: ");
                             resumeList[42] = scanner.nextLine();
                             break;
                         case 7:
                             System.out.print("Enter Hobbies: ");
                             resumeList[43] = scanner.nextLine();
                             break;
                         default:
                             System.out.println("Invalid choice. No changes made.");
                     }

                     line = String.join(",", resumeList);
                 }
                 updatedLines.add(line);
             }

             if (!found) {
                 System.out.println("Resume not found for the given email.");
                 return;
             }
         } catch (IOException e) {
             e.printStackTrace();
         }

         try (BufferedWriter writer = new BufferedWriter(new FileWriter("Applicant_info.txt"))) {
             for (String updatedLine : updatedLines) {
                 writer.write(updatedLine);
                 writer.newLine();
             }
             System.out.println("Information updated successfully!");
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
    public boolean isCreated(String email)
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("Applicant_info.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] applicantData = line.split(",");
                if(Objects.equals(applicantData[10], email)){
                    return true;
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

}
