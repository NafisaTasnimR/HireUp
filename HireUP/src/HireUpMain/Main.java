
package HireUpMain;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static HireUpMain.Utility.updateConsole;

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
        System.out.println("//////////////////////////////////////////////");
        updateConsole();
        switch (caseValue) {
            case 1:
                System.out.println("You choose :Login");
                System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ Login \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
                System.out.println("Enter your ");

                System.out.println("Email:");
                Scanner sc3 = new Scanner(System.in);
                String email = sc3.nextLine();

                System.out.println("Password:");
                Scanner sc2 = new Scanner(System.in);
                String pass = sc2.nextLine();

                System.out.println("Role:");
                System.out.println("1.Applicant");
                System.out.println("2.Job Provider");
                System.out.println("3.Admin");
                System.out.println("Enter your selection:");

                Scanner sc4 = new Scanner(System.in);
                String role = sc4.nextLine();

                switch (role) {
                    case "1":
                        role = "applicant";
                        break;
                    case "2":
                        role = "job provider";
                        break;
                    case "3":
                        role = "admin";
                        break;
                }

                User user2 = new User();

                user2 = user2.userObject(pass, email, role);

                System.out.println("1.Enter");

                System.out.println("2.Exit");

                System.out.println("Enter your selection");
                Scanner sc5 = new Scanner(System.in);
                int selection = sc5.nextInt();

                switch (selection) {
                    case 1:
                        System.out.println("Enter");


                        Applicant applicant = new Applicant(user2.getUserName(), pass, email, role);

                        if (Objects.equals(role, "Applicant") || Objects.equals(role, "applicant")) {
                            //file checking function where pass and email is going to be checked
                            //function returns false then
                            System.out.println("//////////////////////////////////////////////");
                            if (!user2.logIn()) {
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
                                System.out.println("//////////////////////////////////////////////");
                                updateConsole();
                            } else {
                                System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\  Applicant \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
                                System.out.println("1.Job Search");
                                System.out.println("2.See Job Information");
                                System.out.println("3.See Job Status");
                                System.out.println("4.Create Resume");
                                System.out.println("5.View Resume");
                                System.out.println("Enter your selection");
                                Scanner sc8 = new Scanner(System.in);
                                int selection1 = sc8.nextInt();
                              
                                List<String> jobList = new ArrayList<>();
                                System.out.println("//////////////////////////////////////////////");
                                updateConsole();
                                switch (selection1) {
                                    case 1:
                                        System.out.println("Search job");
                                        System.out.println("***************  Job Search  *****************");
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
                                                System.out.println("Location: ");
                                                Scanner sc71 = new Scanner(System.in);
                                                String location = sc71.nextLine();
                                                jobList = applicant.searchJob(location);

                                                //Location/Experience/Salary/Skills/Time:
                                                ///1…….
                                                //2……
                                                //3……
                                                //Enter your selected job:/ //
                                                break;
                                            case 2:
                                                System.out.println("Experience");
                                                Scanner sc72 = new Scanner(System.in);
                                                String experience = sc72.nextLine();
                                                jobList = applicant.searchJob(experience);
                                                //Location/Experience/Salary/Skills/Time:
                                                ///1…….
                                                //2……
                                                //3……
                                                //Enter your selected job:/ //
                                                break;
                                            case 3:
                                                System.out.println("Salary");
                                                Scanner sc73 = new Scanner(System.in);
                                                String salary = sc73.nextLine();
                                                jobList = applicant.searchJob(salary);
                                                //Location/Experience/Salary/Skills/Time:
                                                ///1…….
                                                //2……
                                                //3……
                                                //Enter your selected job:/ //
                                                break;
                                            case 4:
                                                System.out.println("Skills");
                                                Scanner sc74 = new Scanner(System.in);
                                                String skills = sc74.nextLine();
                                                jobList = applicant.searchJob(skills);
                                                //Location/Experience/Salary/Skills/Time:
                                                ///1…….
                                                //2……
                                                //3……
                                                //Enter your selected job:/ //
                                                break;
                                            case 5:
                                                System.out.println("Time");
                                                Scanner sc75 = new Scanner(System.in);
                                                String time = sc75.nextLine();
                                                jobList = applicant.searchJob(time);
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
                                        System.out.println("//////////////////////////////////////////////");
                                        updateConsole();
                                    case 2:
                                        System.out.println("Job information");
                                        System.out.println("***************  Job Information  *************");
                                        System.out.println("Add your preferred job no");
                                        Scanner sc70 = new Scanner(System.in);
                                        String query = sc70.nextLine();
                                        applicant.showInformation(query, jobList);

                                        System.out.println("1.Apply");
                                        System.out.println("2.Go back");
                                        System.out.println("3.Exit");
                                        System.out.println("Enter your selection");
                                        Scanner sc11 = new Scanner(System.in);
                                        int selection4 = sc11.nextInt();
                                        switch (selection4) {
                                            case 1:
                                                System.out.println(" Apply");

                                                applicant.processApplication(query,jobList,email);

                                                break;
                                            case 2:
                                                System.out.println(" Go Back");
                                                break;
                                            case 3:
                                                System.out.println("Exit");
                                                break;
                                        }
                                        System.out.println("//////////////////////////////////////////////");
                                        updateConsole();
                                        break;

                                    case 3:
                                        System.out.println("Job status");
                                        System.out.println("***************  Job Status  ***************");
                                        List<String> jobs = applicant.applicationList(email);
                                        System.out.println("Enter the number of the job you want to see status of :");
                                        Scanner jobPostNo = new Scanner(System.in);
                                        String  selection80 = jobPostNo.nextLine();
                                        applicant.applicationStatus(selection80, jobs);

                                        //after selecting a job they can see the status (a method will be implemented)
                                        int a = 1;
                                        if (a == 1) {
                                            System.out.println("//////////////////////////////////////////////");
                                            updateConsole();
                                            System.out.println("Shortlisted/Rejected/Pending");
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
                                            System.out.println("//////////////////////////////////////////////");
                                            updateConsole();
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
                                        System.out.println("//////////////////////////////////////////////");
                                        updateConsole();
                                        break;


                                    case 4:
                                        System.out.println("Create Resume");
                                        System.out.println("***************  Create Resume ***************");
                                        System.out.println("=======================================");
                                        System.out.println("         RESUME BUILDER        ");
                                        System.out.println("=======================================\n");
                                        System.out.println("===============   PERSONAL INFORMATION   ===============");
                                        System.out.println("Full Name: ");

                                        Scanner sc39 = new Scanner(System.in);
                                        String name = sc39.nextLine();

                                        System.out.println("Father's Name: ");
                                        Scanner sc40 = new Scanner(System.in);
                                        String fatherName = sc40.nextLine();

                                        System.out.println("Mother's Name: ");
                                        Scanner sc41 = new Scanner(System.in);
                                        String motherName = sc41.nextLine();

                                        System.out.println("Date of Birth: ");
                                        Scanner sc42 = new Scanner(System.in);
                                        String dateOfBirth = sc42.nextLine();

                                        System.out.println("Nationality: ");
                                        Scanner sc43 = new Scanner(System.in);
                                        String nationality = sc43.nextLine();

                                        System.out.println("Religion: ");
                                        Scanner sc44 = new Scanner(System.in);
                                        String religion = sc44.nextLine();

                                        System.out.println("Gender: ");
                                        Scanner sc45 = new Scanner(System.in);
                                        String gender = sc45.nextLine();

                                        System.out.println("Phone Number: ");
                                        Scanner sc46 = new Scanner(System.in);
                                        String phoneNumber = sc46.nextLine();

                                        System.out.println("Address: ");
                                        Scanner sc47 = new Scanner(System.in);
                                        String address = sc47.nextLine();

                                        System.out.println("National ID: ");
                                        Scanner sc48 = new Scanner(System.in);
                                        String nationalID = sc48.nextLine();


                                        System.out.println("===============   EDUCATIONAL INFORMATION   ===============");

                                        System.out.println("School Name: ");

                                        Scanner sc49 = new Scanner(System.in);
                                        String schoolName = sc49.nextLine();

                                        System.out.println("Passing Year(SSC/O Level): ");
                                        Scanner sc50 = new Scanner(System.in);
                                        String passingYear = sc50.nextLine();

                                        System.out.println("SSC/O Level Result: ");
                                        Scanner sc51 = new Scanner(System.in);
                                        String sscOLevelResult = sc51.nextLine();

                                        System.out.println("College Name: ");
                                        Scanner sc52 = new Scanner(System.in);
                                        String collegeName = sc52.nextLine();

                                        System.out.println("Passing Year (HSC/A Level): ");
                                        Scanner sc53 = new Scanner(System.in);
                                        String passingYearHSC = sc53.nextLine();

                                        System.out.println("HSC/A Level Result: ");
                                        Scanner sc54 = new Scanner(System.in);
                                        String hscALevelResult = sc54.nextLine();

                                        System.out.println("University Name: ");
                                        Scanner sc55 = new Scanner(System.in);
                                        String universityName = sc55.nextLine();

                                        System.out.println("Department: ");
                                        Scanner dept = new Scanner(System.in);
                                        String department = dept.nextLine();

                                        System.out.println("Undergraduate Degree: ");
                                        Scanner sc56 = new Scanner(System.in);
                                        String undergraduateDegree = sc56.nextLine();

                                        System.out.println("UnderGraduate CGPA: ");
                                        Scanner sc57 = new Scanner(System.in);
                                        String undergradCGPA = sc57.nextLine();

                                        System.out.println("Postgraduate Degree: ");
                                        Scanner sc58 = new Scanner(System.in);
                                        String postgraduateDegree = sc58.nextLine();

                                        System.out.println("Postgraduate CGPA: ");
                                        Scanner sc59 = new Scanner(System.in);
                                        String postgradCGPA = sc59.nextLine();

                                        System.out.println("===============   ADDITIONAL INFORMATION   ===============");
                                        System.out.println("Experience: ");
                                        Scanner sc60 = new Scanner(System.in);
                                        String experince = sc60.nextLine();

                                        System.out.println("Hobbies: ");
                                        Scanner sc61 = new Scanner(System.in);
                                        String hobbies = sc61.nextLine();

                                        System.out.println("Skills: ");
                                        Scanner sc62 = new Scanner(System.in);
                                        String skills = sc62.nextLine();

                                        System.out.println("=======================================");

                                        PersonalInformation personalInformation = new PersonalInformation(name,fatherName,motherName,dateOfBirth,nationality,religion,gender,phoneNumber,address,nationalID);
                                        EducationalInformation educationalInformation = new EducationalInformation(name,schoolName,passingYear,sscOLevelResult,collegeName,passingYearHSC,hscALevelResult,universityName,department,undergraduateDegree,undergradCGPA,postgraduateDegree,postgradCGPA);
                                        AdditionalInformation additionalInformation = new AdditionalInformation(name,experince,hobbies,skills);
                                        Resume resume = new Resume(personalInformation,educationalInformation,additionalInformation);
                                        applicant = new Applicant(user2.getUserName(), pass, email, role, resume);



                                        System.out.println("1.Enter");

                                        System.out.println("2.Go Back");

                                        System.out.println("3.Exit");

                                        System.out.println("Enter your selection");
                                        Scanner scanner = new Scanner(System.in);
                                        int option = scanner.nextInt();

                                        switch (option) {
                                            case 1:
                                                applicant.createResume();

                                                break;
                                            case 2:
                                                System.out.println(" Go Back ");
                                                break;

                                            case 3:
                                                System.out.println(" Exit ");
                                        }
                                        System.out.println("//////////////////////////////////////////////");
                                        updateConsole();
                                        break;

                                    case 5:
                                        System.out.println("View Resume");
                                        System.out.println("***************  View Resume ***************");

                                        applicant.showResume();


                                }

                            }
                        } else if (Objects.equals(role, "Job Provider") || Objects.equals(role, "job provider")) {
                            //file checking function where pass and email is going to be checked
                            //function returns false then
                            User user1 = new User(user2.getUserName(), pass,email,role);
                            //System.out.println("If you give 1 then you'll see the error page to see other page give input any number except 1.");
                            //Scanner sc14 = new Scanner(System.in);
                            //int value = sc14.nextInt();
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            if (!user1.logIn()) {
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
                                System.out.println("//////////////////////////////////////////////");
                                updateConsole();
                            } else {
                                System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\     Job Provider     " +
                                        "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
                                JobProvider jobProvider = new JobProvider(user1.getUserName());
                                System.out.println("1.Post Job Circular");
                                System.out.println("2.See Applicant List");
                                System.out.println("3.See Short List");
                                System.out.println("4. Go Back");
                                System.out.println("5. Exit");
                                System.out.println("Enter your selection: ");
                                Scanner sc16 = new Scanner(System.in);
                                int selectionForProvider = sc16.nextInt();
                                System.out.println("//////////////////////////////////////////////");
                                updateConsole();
                                switch (selectionForProvider) {
                                    case 1:
                                        System.out.println("Post Job Circular");
                                        System.out.println("***************  Post Job Circular  ***************");
                                        System.out.println("Company Name: ");
                                        Scanner sc17 = new Scanner(System.in);
                                        String companyName = sc17.nextLine();
                                        System.out.println("Job position: ");
                                        Scanner sc18 = new Scanner(System.in);
                                        String jobPosition = sc18.nextLine();
                                        System.out.println("Skill: ");
                                        Scanner sc19 = new Scanner(System.in);
                                        String skill = sc19.nextLine();
                                        System.out.println("Experience: ");
                                        Scanner sc20 = new Scanner(System.in);
                                        String experience = sc20.nextLine();
                                        System.out.println("Salary: ");
                                        Scanner sc21 = new Scanner(System.in);
                                        String salary = sc21.nextLine();
                                        System.out.println("Location: ");
                                        Scanner sc22 = new Scanner(System.in);
                                        String location = sc22.nextLine();
                                        System.out.println("Time: ");
                                        Scanner sc23 = new Scanner(System.in);
                                        String time = sc23.nextLine();
                                        System.out.println("Website Link: ");
                                        Scanner sc24 = new Scanner(System.in);
                                        String websiteLink = sc24.nextLine();
                                        System.out.println("Additional: ");
                                        Scanner sc69 = new Scanner(System.in);
                                        String additional = sc69.nextLine();

                                        System.out.println("1. Post");
                                        System.out.println("2. Go Back");
                                        System.out.println("3. Exit ");
                                        System.out.println("Enter your selection: ");
                                        Scanner sc25 = new Scanner(System.in);
                                        int selection1 = sc25.nextInt();
                                        switch (selection1) {
                                            case 1:
                                                Job job = new Job(companyName,jobPosition,skill,experience,salary,location,time,websiteLink,additional);
                                                if(jobProvider.postJob(job)) {
                                                    System.out.println("You have successfully posted a Job post!");
                                                }
                                                break;
                                            case 2:
                                                System.out.println("You have successfully gone back!");
                                                break;
                                            case 3:
                                                System.out.println("Goodbye!");
                                                break;
                                        }
                                        System.out.println("//////////////////////////////////////////////");
                                        updateConsole();

                                        break;
                                    case 2:
                                        System.out.println("See Applicant List");
                                        System.out.println("***************  Watch Application list  ***************");
                                        //Application list showing
                                        //here input for watch the applicant info will be taken
                                        //a function will be called and that would show the info
                                        System.out.println("Choose a Job Circular from the following list: ");
                                        List<String> jobPostList = jobProvider.seeJobPosts();
                                        System.out.println("Enter the Job Post Number that you want to see: ");
                                        Scanner sc70 = new Scanner(System.in);
                                        String serialNo = sc70.nextLine();
                                        List<String> applicantList = jobProvider.seeApplicantList(jobProvider.getJobPostNo(serialNo,jobPostList));
                                        if (serialNo != null) {
                                            System.out.println("***************  Applicants Personal Information  ***************");
                                            System.out.println("Enter the Serial number of the applicant you want to see: ");
                                            Scanner scanner1 = new Scanner(System.in);
                                            String serialNumber = scanner1.nextLine();
                                            String applicantResume = jobProvider.viewApplicantDetails(serialNumber,applicantList);
                                            System.out.println("1. Select ");
                                            System.out.println("2. Reject ");
                                            System.out.println("3. Go Back ");
                                            System.out.println("4. Exit ");
                                            System.out.println("Enter your selection: ");
                                            Scanner sc43 = new Scanner(System.in);
                                            int selection3 = sc43.nextInt();
                                            switch (selection3) {
                                                case 1:
                                                    System.out.println("Selected!");
                                                    List<String> applications = jobProvider.changeStatus(applicantResume,"Shortlisted");
                                                    jobProvider.addToShortList(applications);
                                                    break;
                                                case 2:
                                                    System.out.println("Rejected!");
                                                    List<String> applications1 = jobProvider.changeStatus(applicantResume,"Rejected");
                                                    jobProvider.addToShortList(applications1);
                                                    break;
                                                case 3:
                                                    System.out.println("You have successfully go back!");
                                                    break;
                                                case 4:
                                                    System.out.println("Goodbye!");
                                                    break;

                                            }
                                            System.out.println("//////////////////////////////////////////////");
                                            updateConsole();
                                        }
                                        System.out.println("1. Go back");
                                        System.out.println("2. Exit");
                                        System.out.println("Enter your selection: ");
                                        Scanner sc26 = new Scanner(System.in);
                                        String selection2 = sc26.nextLine();
                                        switch (selection2) {
                                            case "1":
                                                System.out.println("You have successfully go back!");
                                                break;
                                            case "2":
                                                System.out.println("Goodbye!");
                                                break;
                                        }
                                        System.out.println("//////////////////////////////////////////////");
                                        updateConsole();
                                        break;
                                    case 3:
                                        System.out.println("See Short List");
                                        System.out.println("***************  Shortlisted Applicants  ***************");
                                        //list will be shown
                                        System.out.println("You have previously posted these posts:");
                                        List<String> jobPostList1 = jobProvider.seeJobPosts();
                                        System.out.println("Choose a post to see it's shortListed applicants:");
                                        Scanner scanner100 = new Scanner(System.in);
                                        String selectedJobPost = scanner100.nextLine();
                                        List<String> applicantShortList = jobProvider.seeShortList(selectedJobPost,jobPostList1);
                                        System.out.println("1. See Any Applicant's Details");
                                        System.out.println("2. Go Back");
                                        System.out.println("3. Exit");
                                        System.out.println("Enter your selection: ");
                                        Scanner sc27 = new Scanner(System.in);
                                        String selection4 = sc27.nextLine();
                                        switch (selection4) {
                                            case "1":
                                                System.out.println("Enter the serial number: ");
                                                Scanner scanner2 = new Scanner(System.in);
                                                String serialNumber = scanner2.nextLine();
                                                jobProvider.viewApplicantDetails(serialNumber,applicantShortList);
                                                System.out.println("1. Go Back");
                                                System.out.println("2. Exit");
                                                System.out.println("Enter your selection: ");
                                                Scanner sc100 = new Scanner(System.in);
                                                String selection100 = sc100.nextLine();
                                                switch (selection100){
                                                    case "1":
                                                        System.out.println("You have successfully go back!");
                                                        break;
                                                    case "2":
                                                        System.out.println("Goodbye!");
                                                        break;
                                                }
                                            case "2":
                                                System.out.println("You have successfully go back!");
                                                break;
                                            case "3":
                                                System.out.println("Goodbye!");
                                                break;

                                        }
                                        System.out.println("//////////////////////////////////////////////");
                                        updateConsole();
                                        break;
                                    case 4:
                                        System.out.println("You have successfully go back!");
                                        System.out.println("//////////////////////////////////////////////");
                                        updateConsole();
                                        break;
                                    case 5:
                                        System.out.println("Goodbye!");

                                        System.out.println("//////////////////////////////////////////////");
                                        updateConsole();
                                        break;
                                }


                            }
                        } else if (Objects.equals(role, "Admin") || Objects.equals(role, "admin")) {
                            User user4= new User(user2.getUserName(),pass,email,role);
                            //file checking function where pass and email is going to be checked
                            //function returns false then
                            //System.out.println("If you give 1 then you'll see the error page to see other page give input any number except 1.");

                            //Scanner sc28 = new Scanner(System.in);
                            //int value = sc28.nextInt();
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            if (!user4.logIn()) {
                                System.out.println("Error! Incorrect username or password.");
                                System.out.println("1.Go back");
                                System.out.println("2.Exit");
                                System.out.println("Enter your selection: ");
                                Scanner us4 = new Scanner(System.in);
                                switch (us4.nextInt()) {
                                    case 1:
                                        System.out.println("You have successfully go back!");
                                        break;
                                    case 2:
                                        System.out.println("Goodbye!");
                                        break;
                                }
                                System.out.println("//////////////////////////////////////////////");
                                updateConsole();

                            } else {
                                System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\     Admin    " +
                                        "  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
                                System.out.println("1.View User Information" + '\n' +
                                        "2.Go back" + '\n' + "3.Exit" + '\n' +
                                        "Enter your selection: ");

                                Scanner sc29 = new Scanner(System.in);
                                int select = sc29.nextInt();
                                System.out.println("//////////////////////////////////////////////");
                                updateConsole();

                                switch (select) {
                                    case 1:

                                        System.out.println("***************  User Information  ***************");
                                        System.out.println("1. Applicant");
                                        System.out.println("2. Job Provider");
                                        System.out.println("3. Admin Requests");
                                        System.out.println("4. Go Back");
                                        System.out.println("5. Exit");

                                        System.out.println("Enter your selection: ");
                                        Scanner sc30 = new Scanner(System.in);
                                        String selection6 = sc30.nextLine();
                                        System.out.println("//////////////////////////////////////////////");
                                        updateConsole();
                                        switch (selection6) {
                                            case "1":
                                                System.out.println("Applicant");
                                                System.out.println("***************  Applicant List  ***************");
                                                Admin admin=new Admin();
                                                List<String>applicants= admin.ViewApplicantInformation();
                                                System.out.println("Enter your selection: ");
                                                Scanner applicantsc = new Scanner(System.in);
                                                int selectionApplicant = applicantsc.nextInt();

                                                //list
                                                //input from the list
                                                int a = 1;
                                                if (a == 1) {
                                                    System.out.println("***************  Verification  ***************");
                                                    System.out.println("1. Verify ");
                                                    System.out.println("2. Delete");
                                                    System.out.println("3. Go Back");
                                                    System.out.println("4. Exit");
                                                    System.out.println("Enter your selection: ");
                                                    Scanner applicantsc33 = new Scanner(System.in);
                                                    int applicantInformationSelection = applicantsc33.nextInt();
                                                    switch (applicantInformationSelection) {
                                                        case 1:
                                                            admin.verifyApplicant(selectionApplicant,applicants);
                                                            System.out.println("Verified");
                                                            break;
                                                        case 2:
                                                            admin.deleteApplicant(selectionApplicant,applicants);
                                                            System.out.println("Deleted");
                                                            break;
                                                        case 3:
                                                            System.out.println("Go Back");
                                                            break;
                                                        case 4:
                                                            System.out.println("Exit");
                                                            break;
                                                    }
                                                    System.out.println("//////////////////////////////////////////////");
                                                    updateConsole();

                                                }
                                                System.out.println("1. Go Back");
                                                System.out.println("2. Exit");
                                                System.out.println("Enter your selection: ");
                                                Scanner sc34 = new Scanner(System.in);
                                                String selection7 = sc34.nextLine();
                                                switch (selection7) {
                                                    case "1":
                                                        System.out.println("Go Back");
                                                        break;
                                                    case "2":
                                                        System.out.println("Goodbye!");
                                                        break;

                                                }
                                                System.out.println("//////////////////////////////////////////////");
                                                updateConsole();
                                                break;
                                            case "2":
                                                System.out.println("Job Provider");
                                                System.out.println("***************  Job Provider’s Website List  ***************");
                                                Admin admin12=new Admin();
                                               List<String>jobProviders= admin12.ViewInformation();
                                               System.out.println("Enter your selection: ");
                                               Scanner jobProvidersc = new Scanner(System.in);
                                               int selectionJobProvider = jobProvidersc.nextInt();
                                                //list
                                                //input from the list
                                                int b = 1;
                                                if (b == 1) {
                                                    System.out.println("***************  Verification  ***************");
                                                    System.out.println("1. Verify ");
                                                    System.out.println("2. Delete");
                                                    System.out.println("3. Go Back");
                                                    System.out.println("4. Exit");
                                                    System.out.println("Enter your selection: ");
                                                    Scanner sc33 = new Scanner(System.in);
                                                    int selection8 = sc33.nextInt();
                                                    switch (selection8) {
                                                        case 1:
                                                            admin12.verify(selectionJobProvider,jobProviders);
                                                            System.out.println("Verified");
                                                            break;
                                                        case 2:
                                                            admin12.delete(selectionJobProvider,jobProviders);
                                                            System.out.println("Deleted");
                                                            break;
                                                        case 3:
                                                            System.out.println("Go Back");
                                                            break;
                                                        case 4:
                                                            System.out.println("Exit");
                                                            break;
                                                    }
                                                    System.out.println("//////////////////////////////////////////////");
                                                    updateConsole();

                                                }
                                                System.out.println("1. Go Back");
                                                System.out.println("2. Exit");
                                                System.out.println("Enter your selection: ");
                                                Scanner sc345 = new Scanner(System.in);
                                                String selection785 = sc345.nextLine();
                                                switch (selection785) {
                                                    case "1":
                                                        System.out.println("Go Back");
                                                        break;
                                                    case "2":
                                                        System.out.println("Goodbye!");
                                                        break;

                                                }
                                                System.out.println("//////////////////////////////////////////////");
                                                updateConsole();
                                                break;
                                            case "3":
                                                Admin admin2=new Admin();
                                              List<String> adminRequests=  admin2.viewAdminRequest();
                                              Scanner adminRequestsc = new Scanner(System.in);
                                              System.out.println("Enter your selection: ");
                                              int selectionAdminRequest = adminRequestsc.nextInt();
                                                System.out.println("***************  Approval  ***************");
                                                System.out.println("1. Approve ");
                                                System.out.println("2. Reject ");
                                                System.out.println("3. Go Back");
                                                System.out.println("4. Exit");
                                                System.out.println("Enter your selection: ");
                                                Scanner sc888 = new Scanner(System.in);
                                                int selection15 = sc888.nextInt();
                                                switch (selection15) {
                                                    case 1:
                                                        admin2.approve(selectionAdminRequest,adminRequests);
                                                        System.out.println("Approved");
                                                        break;
                                                    case 2:
                                                        admin2.deleteRequest(selectionAdminRequest,adminRequests);
                                                        System.out.println("Rejected");
                                                        break;
                                                    case 3:
                                                        System.out.println("Go Back");
                                                        break;
                                                    case 4:
                                                        System.out.println("Exit");
                                                        break;
                                                }

                                                System.out.println("//////////////////////////////////////////////");
                                                updateConsole();

                                            case "4":
                                                System.out.println("You have successfully go back!");
                                                break;
                                            case "5":
                                                System.out.println("Goodbye!");
                                                break;
                                        }
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
                Scanner sc35= new Scanner(System.in);
                String name = sc35.nextLine();
                System.out.println("Email: ");
                Scanner sc36 = new Scanner(System.in);
                String email1 = sc36.nextLine();
                System.out.println("Password: ");
                Scanner sc37 = new Scanner(System.in);
                String pass1 = sc37.nextLine();
                System.out.println("Role: ");
                System.out.println("1.Applicant");
                System.out.println("2.Job Provider");
                System.out.println("3.Admin");
                System.out.println("Enter your role: ");

                Scanner sc38 = new Scanner(System.in);
                int roleValue = sc38.nextInt();
                User user1 = null;
                switch (roleValue) {
                    case 1:
                        user1 = new User(name,pass1,email1,"applicant");
                        user1.registration(user1);
                        System.out.println("Congratulations! You have been registered.");
                        break;
                    case 2:
                        user1 = new User(name, pass1, email1, "job provider");
                        System.out.println("You need to provide some additional information");
                        System.out.println("Company Name:");
                        Scanner sc65 = new Scanner(System.in);
                        String companyName = sc65.nextLine();

                        System.out.println("Web Address:");
                        Scanner sc66 = new Scanner(System.in);
                        String webAddress = sc66.nextLine();

                        user1.registration(user1);

                        System.out.println("Congratulations! You have been registered.");

                        break;
                    case 3:
                        user1 = new User(name, pass1, email1, "admin");
                        user1.adminRegistrationRequest(user1);

                        System.out.println("Your request has been sent to Admin.");
                        break;
                }

                System.out.println("//////////////////////////////////////////////");
                updateConsole();

        }
    }
}
