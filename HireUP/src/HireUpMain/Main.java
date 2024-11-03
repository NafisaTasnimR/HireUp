package HireUpMain;

import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome To HIREUP");
        System.out.println("Do you want to");
        System.out.println("1.Login");
        System.out.println("2.Sign up");
        System.out.println("3.Exit");
        System.out.println("Enter your selection:");
        Scanner sc = new Scanner(System.in);
        int caseValue = sc.nextInt();
        System.out.println("//////////////////////////////");
        switch (caseValue) {
            case 1:
                System.out.println("You choose :Login");
                System.out.println("\\\\\\\\\\\\\\\\ Login \\\\\\\\\\\\\\\\");
                System.out.println("Enter your ");
                System.out.println("Interface.User name:");
                Scanner sc1 = new Scanner(System.in);
                String user = sc1.nextLine();

                System.out.println("Password:");
                Scanner sc2 = new Scanner(System.in);
                String pass = sc2.nextLine();

                System.out.println("Email:");
                Scanner sc3 = new Scanner(System.in);
                String email = sc3.nextLine();

                System.out.println("Role:");
                Scanner sc4 = new Scanner(System.in);
                String role = sc4.nextLine();

                System.out.println("1.Enter");

                System.out.println("2.Exit");

                System.out.println("Enter your selection");
                Scanner sc5 = new Scanner(System.in);
                int selection = sc5.nextInt();
                switch (selection) {
                    case 1:
                        System.out.println("Enter");
                        if (Objects.equals(role, "Applicant") || Objects.equals(role, "applicant")) {
                            //file checking function where pass and email is going to be checked
                            //function returns false then
                            System.out.println("If you give 1 then you'll see the error page to see other page give input any number except 1.");
                            Scanner sc6 = new Scanner(System.in);
                            int value = sc6.nextInt();
                            System.out.println("//////////////////////////////////");
                            if (value == 1) {
                                System.out.println("Error! Incorrect username or password.");
                                System.out.println("1.Go back");
                                System.out.println("2.Exit");
                                System.out.println("Enter your selection: ");
                                Scanner sc7 = new Scanner(System.in);
                                switch (sc7.nextInt()) {
                                    case 1:
                                        System.out.println("You have successfully go back!");
                                        break;
                                    case 2:
                                        System.out.println("Goodbye!");
                                        break;
                                }
                                System.out.println("/////////////////////////////////////");
                            } else {
                                System.out.println("\\\\\\\\\\    Applicant    \\\\\\\\\\\\");
                                System.out.println("1.Job Search");
                                System.out.println("2.See Job Information");
                                System.out.println("3.See Job Status");
                                System.out.println("Enter your selection");
                                Scanner sc8 = new Scanner(System.in);
                                int selection1 = sc8.nextInt();
                                System.out.println("/////////////////////////////////////");
                                switch (selection1) {
                                    case 1:
                                        System.out.println("Search job");
                                        System.out.println("****************    Job Search    ******************");
                                        System.out.println("Add your preference");
                                        System.out.println("1.Location");
                                        System.out.println("2.Experience");
                                        System.out.println("3.Salary");
                                        System.out.println("4.Skills");
                                        System.out.println("5.Time");
                                        System.out.println("Enter your selection");
                                        Scanner sc9 = new Scanner(System.in);
                                        int selection2 = sc9.nextInt();
                                        switch (selection2) {
                                            case 1:
                                                System.out.println("Location");
                                                //Location/Experience/Salary/Skills/Time:
                                                ///1…….
                                                //2……
                                                //3……
                                                //Enter your selected job:/ //
                                                break;
                                            case 2:
                                                System.out.println("Experience");
                                                //Location/Experience/Salary/Skills/Time:
                                                ///1…….
                                                //2……
                                                //3……
                                                //Enter your selected job:/ //
                                                break;
                                            case 3:
                                                System.out.println("Salary");
                                                //Location/Experience/Salary/Skills/Time:
                                                ///1…….
                                                //2……
                                                //3……
                                                //Enter your selected job:/ //
                                                break;
                                            case 4:
                                                System.out.println("Skills");
                                                //Location/Experience/Salary/Skills/Time:
                                                ///1…….
                                                //2……
                                                //3……
                                                //Enter your selected job:/ //
                                                break;
                                            case 5:
                                                System.out.println("Time");
                                                //Location/Experience/Salary/Skills/Time:
                                                ///1…….
                                                //2……
                                                //3……
                                                //Enter your selected job:/ //
                                                break;
                                            default:
                                                System.out.println("1.Go Back");
                                                System.out.println("2.Exit");
                                                System.out.println("Enter your selection");
                                                Scanner sc10 = new Scanner(System.in);
                                                int selection3 = sc10.nextInt();
                                                switch (selection3) {
                                                    case 1:
                                                        System.out.println("Go Back");
                                                        break;
                                                    case 2:
                                                        System.out.println("Exit");
                                                        break;
                                                }
                                                break;

                                        }
                                        System.out.println("//////////////////////////////////");
                                    case 2:
                                        System.out.println("Job information");
                                        System.out.println("****************    Job Information    **************");
                                        System.out.println("Company name:");
                                        System.out.println("Job position:");
                                        System.out.println("Skill:");
                                        System.out.println("Experience:");
                                        System.out.println("Salary:");
                                        System.out.println("Website Link:");
                                        System.out.println("Additional:");
                                        System.out.println("1.Apply");
                                        System.out.println("2.Go back");
                                        System.out.println("3.Exit");
                                        System.out.println("Enter your selection");
                                        Scanner sc11 = new Scanner(System.in);
                                        int selection4 = sc11.nextInt();
                                        switch (selection4) {
                                            case 1:
                                                System.out.println(" Apply");
                                                break;
                                            case 2:
                                                System.out.println(" Go Back");
                                                break;
                                            case 3:
                                                System.out.println("Exit");
                                                break;
                                        }

                                        System.out.println("////////////////////////////////");
                                        break;
                                    case 3:
                                        System.out.println("Job status");
                                        System.out.println("****************    Job Status    **************");
                                        //Job list
                                        ///1…….
                                        //2……
                                        //3……
                                        //Enter your selected job:/ //
                                        //after selecting a job they can see the status (a method will be implemented)
                                        int a = 1;
                                        if (a == 1) {
                                            System.out.println("////////////////////////////////////////////////////////////");
                                            System.out.println("Shortlisted/Rejected");
                                            System.out.println("1.Go back");
                                            System.out.println("2.Exit");
                                            System.out.println("Enter your selection");
                                            Scanner sc12 = new Scanner(System.in);
                                            int selection5 = sc12.nextInt();
                                            switch (selection5) {
                                                case 1:
                                                    System.out.println(" Go Back to last page ");
                                                    break;
                                                case 2:
                                                    System.out.println(" Exit ");
                                                    break;
                                            }
                                            System.out.println("/////////////////////////////");
                                        }
                                        //after that
                                        System.out.println("1.Go Back");
                                        System.out.println("2.Exit");
                                        System.out.println("Enter your selection");
                                        Scanner sc13 = new Scanner(System.in);
                                        int selection5 = sc13.nextInt();
                                        switch (selection5) {
                                            case 1:
                                                System.out.println(" Go Back ");
                                                break;
                                            case 2:
                                                System.out.println(" Exit ");
                                                break;
                                        }
                                        System.out.println("////////////////////////////////");
                                        break;
                                }

                            }
                        } else if (Objects.equals(role, "Job Provider") || Objects.equals(role, "job provider")) {
                            //file checking function where pass and email is going to be checked
                            //function returns false then
                            System.out.println("If you give 1 then you'll see the error page to see other page give input any number except 1.");
                            Scanner sc14 = new Scanner(System.in);
                            int value = sc14.nextInt();
                            System.out.println("////////////////////////////");
                            if (value == 1) {
                                System.out.println("Error! Incorrect username or password.");
                                System.out.println("1.Go back");
                                System.out.println("2.Exit");
                                System.out.println("Enter your selection: ");
                                Scanner sc15 = new Scanner(System.in);
                                switch (sc15.nextInt()) {
                                    case 1:
                                        System.out.println("You have successfully go back!");
                                        break;
                                    case 2:
                                        System.out.println("Goodbye!");
                                        break;
                                }
                                System.out.println("/////////////////////////////////////");
                            } else {
                                System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\     Job Provider     " +
                                        "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");

                                System.out.println("1.Post Job Circular");
                                System.out.println("2.See Applicant List");
                                System.out.println("3.See Short List");
                                System.out.println("Enter your selection: ");
                                Scanner sc16 = new Scanner(System.in);
                                int selectionForProvider = sc16.nextInt();
                                System.out.println("////////////////////////////////////////");
                                switch (selectionForProvider) {
                                    case 1:
                                        System.out.println("Post Job Circular");
                                        System.out.println("**************      Post Job Circular      **************");
                                        System.out.println("Company Name: ");
                                        String companyName = sc.nextLine();
                                        System.out.println("Job position: ");
                                        String jobPosition = sc.nextLine();
                                        System.out.println("Skill: ");
                                        String skill = sc.nextLine();
                                        System.out.println("Experience: ");
                                        int experience = sc.nextInt();
                                        System.out.println("Salary: ");
                                        int salary = sc.nextInt();
                                        System.out.println("Location: ");
                                        String location = sc.nextLine();
                                        System.out.println("Time: ");
                                        int time = sc.nextInt();
                                        System.out.println("Website Link: ");
                                        String websiteLink = sc.nextLine();
                                        System.out.println("Addional: ");

                                        System.out.println("1. Post");
                                        System.out.println("2. Go Back");
                                        System.out.println("3. Exit ");
                                        System.out.println("Enter your selection: ");
                                        int selection1 = sc.nextInt();
                                        switch (selection1) {
                                            case 1:
                                                System.out.println("You have successfully posted a Job post!");
                                                break;
                                            case 2:
                                                System.out.println("You have successfully gone back!");
                                                break;
                                            case 3:
                                                System.out.println("Goodbye!");
                                                break;
                                        }
                                        
                                        break;
                                    case 2:
                                        System.out.println("See Applicant List");
                                        System.out.println("************     Watch Application list    ************");
                                        //Application list showing
                                        //here input for watch the applicant info will be taken
                                        //a function will be called and that would show the info
                                        int a = 1;
                                        if (a == 1) {
                                            System.out.println("*********   Applicants Personal Information   ********");
                                            System.out.println("PERSONAL INFORMATION");
                                            System.out.println("Name: ");
                                            String name = sc.nextLine();

                                            System.out.println("Father's Name: ");
                                            String fatherName = sc.nextLine();

                                            System.out.println("Mother's Name: ");
                                            String motherName = sc.nextLine();

                                            System.out.println("Date of Birth: ");
                                            String dateOfBirth = sc.nextLine();

                                            System.out.println("Nationality: ");
                                            String nationality = sc.nextLine();

                                            System.out.println("Religion: ");
                                            String religion = sc.nextLine();

                                            System.out.println("Gender: ");
                                            String gender = sc.nextLine();

                                            System.out.println("Phone Number: ");
                                            String phoneNumber = sc.nextLine();

                                            System.out.println("Address: ");
                                            String address = sc.nextLine();

                                            System.out.println("National ID: ");
                                            String nationalID = sc.nextLine();

                                            System.out.println(" EDUCATIONAL INFORMATION ");

                                            System.out.println("School Name: ");
                                            String schoolName = sc.nextLine();

                                            System.out.println("Passing Year(SSC/O Level): ");
                                            int passingYear = sc.nextInt();

                                            System.out.println("SSC/O Level Result: ");
                                            double sscOLevelResult = sc.nextDouble();

                                            System.out.println("College Name: ");
                                            String collegeName = sc.nextLine();

                                            System.out.println("Passing Year (HSC/A Level): ");
                                            int passingYearHSC = sc.nextInt();

                                            System.out.println("HSC/A Level Result: ");
                                            double hscALevelResult = sc.nextDouble();

                                            System.out.println("University Name: ");
                                            String universityName = sc.nextLine();

                                            System.out.println("Undergraduate Degree: ");
                                            String undergraduateDegree = sc.nextLine();

                                            System.out.println("CGPA: ");
                                            double cgpa = sc.nextDouble();

                                            System.out.println("Postgraduate Degree: ");
                                            String postgraduateDegree = sc.nextLine();

                                            System.out.println("CGPA: ");
                                            double cgpaCGPA = sc.nextDouble();

                                            System.out.println("ADDITIONAL INFORMATION: ");
                                            System.out.println("Experience: ");
                                            String additionalInformation = sc.nextLine();

                                            System.out.println("Hobbies: ");
                                            String hobbies = sc.nextLine();

                                            System.out.println("Skills: ");
                                            String skills = sc.nextLine();

                                            System.out.println("1. Select ");
                                            System.out.println("2. Reject ");
                                            System.out.println("3. Go Back ");
                                            System.out.println("4. Exit ");
                                            System.out.println("Enter your selection: ");
                                            int selection3 = sc.nextInt();
                                            switch (selection3) {
                                                case 1:
                                                    System.out.println("Selected!");
                                                    break;
                                                case 2:
                                                    System.out.println("Rejected!");
                                                    break;
                                                case 3:
                                                    System.out.println("You have successfully go back!");
                                                    break;
                                                case 4:
                                                    System.out.println("Goodbye!");
                                                    break;

                                            }
                                            System.out.println("");
                                        }

                                        System.out.println("1. Go back");
                                        System.out.println("2. Exit");
                                        System.out.println("Enter your selection: ");
                                        String selection2 = sc.nextLine();

                                        switch (selection2) {
                                            case "1":
                                                System.out.println("You have successfully go back!");
                                                break;
                                            case "2":
                                                System.out.println("Goodbye!");
                                                break;
                                            case "a":
                                                System.out.println("Job Applicant Details");
                                                break;
                                        }
                                        System.out.println("");
                                        break;
                                    case 3:
                                        System.out.println("See Short List");
                                        System.out.println("************     Shortlisted Applicants     ************");
                                        //list will be shown
                                        System.out.println("1. Go Back");
                                        System.out.println("2. Exit");
                                        System.out.println("Enter your selection: ");
                                        String selection4 = sc.nextLine();
                                        switch (selection4) {
                                            case "1":
                                                System.out.println("You have successfully go back!");
                                                break;
                                            case "2":
                                                System.out.println("Goodbye!");
                                                break;

                                        }

                                        System.out.println("");
                                        break;
                                }


                            }
                        } else if (Objects.equals(role, "Admin") || Objects.equals(role, "admin")) {
                            //file checking function where pass and email is going to be checked
                            //function returns false then
                            System.out.println("If you give 1 then you'll see the error page to see other page give input any number except 1.");
                            Scanner sc6 = new Scanner(System.in);
                            int value = sc6.nextInt();
                            System.out.println("//////////////////////////////////");
                            if (value == 1) {
                                System.out.println("Error! Incorrect username or password.");
                                System.out.println("1.Go back");
                                System.out.println("2.Exit");
                                System.out.println("Enter your selection: ");
                                Scanner scIDKFixIt = new Scanner(System.in);
                                switch (scIDKFixIt.nextInt()) {
                                    case 1:
                                        System.out.println("You have successfully go back!");
                                        break;
                                    case 2:
                                        System.out.println("Goodbye!");
                                        break;
                                }
                                System.out.println("");
                            } else {
                                System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\     Admin    " +
                                        "  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
                                System.out.println("1.View Interface.User Information" + '\n' +
                                        "2.Go back" + '\n' + "3.Exit" + '\n' +
                                        "Enter your selection: ");
                                Scanner sc10 = new Scanner(System.in);
                                int selct = sc10.nextInt();
                                System.out.println("///////////////////////////////");
                                switch (selct) {
                                    case 1:
                                        System.out.println("************     View Interface.User Information    ************");
                                        System.out.println("1. Job Provider");
                                        System.out.println("2. Go Back");
                                        System.out.println("3. Exit");
                                        System.out.println("Enter your selection: ");
                                        String selection6 = sc.nextLine();
                                        switch (selection6) {
                                            case "1":
                                                System.out.println("Job Provider");
                                                System.out.println("*********      Job Provider’s Website List      **********");
                                                //list
                                                //input from the list
                                                int a = 1;
                                                if (a == 1) {
                                                    System.out.println("***************     Verification      *****************");
                                                    System.out.println("Company Name:");
                                                    String companyName = sc.nextLine();

                                                    System.out.println("Web Address:");
                                                    String webAddress = sc.nextLine();

                                                    System.out.println("1. Verify ");
                                                    System.out.println("2. Delete");
                                                    System.out.println("3. Go Back");
                                                    System.out.println("4. Exit");
                                                    System.out.println("Enter your selection: ");
                                                    int selection8 = sc.nextInt();
                                                    switch (selection8) {
                                                        case 1:
                                                            System.out.println("Verify");
                                                            break;
                                                        case 2:
                                                            System.out.println("Delete");
                                                            break;
                                                        case 3:
                                                            System.out.println("Go Back");
                                                            break;
                                                        case 4:
                                                            System.out.println("Exit");
                                                            break;
                                                    }
                                                    System.out.println("");

                                                }
                                                System.out.println("1. Go Back");
                                                System.out.println("2. Exit");
                                                System.out.println("Enter your selection: ");
                                                String selection7 = sc.nextLine();
                                                switch (selection7) {
                                                    case "1":
                                                        System.out.println("Go Back");
                                                        break;
                                                    case "2":
                                                        System.out.println("Goodbye!");
                                                        break;

                                                }
                                                System.out.println("");

                                                break;
                                            case "2":
                                                System.out.println("You have successfully go back!");
                                                break;
                                            case "3":
                                                System.out.println("Goodbye!");
                                                break;

                                        }
                                        System.out.println("");
                                }
                            }
                        } else {
                            System.out.println("Invalid role!");
                        }
                        break;
                    case 2:
                        System.out.println("Exit");
                        break;

                }

                break;
            case 2:
                System.out.println("You choose :SignUp");
                System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\    Registration    " +
                        " \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
                System.out.println("Name: ");
                String name = sc.nextLine();
                System.out.println("Email: ");
                String email1 = sc.nextLine();
                System.out.println("Password: ");
                String pass1 = sc.nextLine();
                System.out.println("Role: ");
                System.out.println("1.Applicant");
                System.out.println("2.Job Provider");
                System.out.println("3.Admin");
                System.out.println("Enter your role: ");
                int roleValue = sc.nextInt();
                System.out.println("///////////////////////////");
                switch (roleValue) {
                    case 1:
                        System.out.println("****************    Applicant      *****************");

                        System.out.println("PERSONAL INFORMATION");
                        System.out.println("Name: ");
                        name = sc.nextLine();

                        System.out.println("Father's Name: ");
                        String fatherName = sc.nextLine();

                        System.out.println("Mother's Name: ");
                        String motherName = sc.nextLine();

                        System.out.println("Date of Birth: ");
                        String dateOfBirth = sc.nextLine();

                        System.out.println("Nationality: ");
                        String nationality = sc.nextLine();

                        System.out.println("Religion: ");
                        String religion = sc.nextLine();

                        System.out.println("Gender: ");
                        String gender = sc.nextLine();

                        System.out.println("Phone Number: ");
                        String phoneNumber = sc.nextLine();

                        System.out.println("Address: ");
                        String address = sc.nextLine();

                        System.out.println("National ID: ");
                        String nationalID = sc.nextLine();

                        System.out.println(" EDUCATIONAL INFORMATION ");

                        System.out.println("School Name: ");
                        String schoolName = sc.nextLine();

                        System.out.println("Passing Year(SSC/O Level): ");
                        int passingYear = sc.nextInt();

                        System.out.println("SSC/O Level Result: ");
                        Double sscOLevelResult = sc.nextDouble();

                        System.out.println("College Name: ");
                        String collegeName = sc.nextLine();

                        System.out.println("Passing Year (HSC/A Level): ");
                        int passingYearHSC = sc.nextInt();

                        System.out.println("HSC/A Level Result: ");
                        Double hscALevelResult = sc.nextDouble();

                        System.out.println("University Name: ");
                        String universityName = sc.nextLine();

                        System.out.println("Undergraduate Degree: ");
                        String undergraduateDegree = sc.nextLine();

                        System.out.println("CGPA: ");
                        double cgpa = sc.nextDouble();

                        System.out.println("Postgraduate Degree: ");
                        String postgraduateDegree = sc.nextLine();

                        System.out.println("CGPA: ");
                        Double cgpaCGPA = sc.nextDouble();

                        System.out.println("ADDITIONAL INFORMATION: ");
                        System.out.println("Experience: ");
                        String Experince = sc.nextLine();

                        System.out.println("Hobbies: ");
                        String hobbies = sc.nextLine();

                        System.out.println("Skills: ");
                        String skills = sc.nextLine();


                        System.out.println("1. Finish Registration ");
                        System.out.println("2. Go Back ");
                        System.out.println("3. Exit ");
                        System.out.println("Enter your selection: ");
                        int selection9 = sc.nextInt();
                        switch (selection9) {
                            case 1:
                                System.out.println("Finish Registration");
                                //method call to save info in file
                                break;
                            case 2:
                                System.out.println("Go Back");
                                break;
                            case 3:
                                System.out.println("Exit");
                                break;

                        }
                        System.out.println("Congratulations! You have created your resume");
                        System.out.println("1.Go back");
                        System.out.println("2.Exit");
                        System.out.println("Enter your selection: ");
                        int selection10 = sc.nextInt();
                        switch (selection10) {
                            case 1:
                                System.out.println("Go Back");
                                break;

                            case 2:
                                System.out.println("Exit");
                                break;

                        }
                        System.out.println("//////////////////////////////");
                        System.out.println("You choose :Exit");
                        break;
                    case 2:
                        System.out.println("**    Job Provider     **");
                        System.out.println("Company Name:");
                        System.out.println("Web Address:");
                        System.out.println("1.Register");
                        System.out.println("2.Go back");
                        System.out.println("3.Exit");
                        System.out.println("Enter your selection");
                        Scanner in6 = new Scanner(System.in);
                        int selection6 = in6.nextInt();
                        switch (selection6) {
                            case 1:
                                System.out.println("Register");
                                break;
                            case 2:
                                System.out.println("Go Back");
                                break;
                            case 3:
                                System.out.println("Exit ");
                        }

                        System.out.println("/////////////////");
                    case 3:
                        System.out.println("**    Admin      **");
                        System.out.println("1.Register");
                        System.out.println("2.Go Back");
                        System.out.println("3.Exit");
                        System.out.println("Enter your selection");
                        Scanner in7 = new Scanner(System.in);
                        int selection7 = in7.nextInt();
                        switch (selection7) {
                            case 1:
                                System.out.println("Register");
                                break;
                            case 2:
                                System.out.println("Go Back");
                                break;
                        }
                        System.out.println("//////////////");

                }
            default:
                System.out.println("Invalid entry!");
        }



    }
}