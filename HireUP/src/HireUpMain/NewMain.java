package HireUpMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static HireUpMain.Utility.isValidPhoneNumber;
import static HireUpMain.Utility.updateConsole;

public class NewMain {
    private static boolean isRunning = true; // Global flag for the application state

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (isRunning) {
            System.out.println("\nWelcome To HIREUP");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Enter your selection: ");

            int caseValue = sc.nextInt();

            switch (caseValue) {
                case 1 -> {
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    loginMenu(sc);
                }
                case 2 -> {
                    updateConsole();
                    System.out.println("//////////////////////////////////////////////");
                    registrationMenu(sc);
                }
                case 3 -> exitApplication();
                default -> System.out.println("Invalid selection. Try again.");
            }
        }

        sc.close();
    }

    private static void loginMenu(Scanner sc) {
        while (true) {
            System.out.println("\n--- Login Menu ---");
            System.out.println("1. Proceed to Login");
            System.out.println("2. Go Back");
            System.out.println("3. Exit");
            System.out.print("Enter your selection: ");

            int selection = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (selection) {
                case 1 -> { // Proceed to login
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

                    role = switch (role) {
                        case "1" -> "Applicant";
                        case "2" -> "Job Provider";
                        case "3" -> "Admin";
                        default -> role;
                    };

                    User user = new User();

                    user = user.userObject(pass, email, role);

                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    if (user != null && user.logIn()) {
                        //System.out.println("Login successful!");
                        // Navigate to the corresponding menu based on role
                        switch (role.toLowerCase()) {
                            case "applicant" -> applicantMenu(sc, user);
                            case "job provider" -> jobProviderMenu(sc, user);
                            case "admin" -> adminMenu(sc);
                            default -> System.out.println("Invalid role. Returning to Login Menu.");
                        }
                    } else {
                        System.out.println("Invalid credentials. Please try again.");
                    }
                }
                case 2 -> { // Go Back
                    System.out.println("Returning to Main Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return; // Exit to Main Menu
                }
                case 3 -> exitApplication(); // Exit the program
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void applicantMenu(Scanner sc, User user) {
        while (true) {
            System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\  Applicant \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            System.out.println("1.Job Search");
            System.out.println("2.See Job Status");
            System.out.println("3.Create Resume");
            System.out.println("4.View Resume");
            System.out.println("5.Update Information");
            System.out.println("6. Go Back");
            System.out.println("7. Exit");
            System.out.print("Enter your selection: ");

            int selection = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            List<String> jobList;
            Applicant applicant = new Applicant(user.getUserName(), user.getPassword(), user.getEmail(), user.getRole());

            updateConsole();
            switch (selection) {
                case 1 -> {
                    System.out.println("Search for Jobs selected.");
                    jobList = jobSearch(sc, applicant);
                    System.out.println("View Jobs details information.");
                    seeJobInformation(sc, applicant, jobList);
                    // Job search logic here
                }
                case 2 -> {
                    System.out.println("View Application Status selected.");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    seeJobStatus(sc, applicant);
                    // Application status logic here
                }
                case 3 -> {
                    System.out.println("Create Resume selected.");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    createResumeOption(sc, user, applicant);
                    // Resume creation logic here
                }
                case 4 -> {
                    System.out.println("View Resume selected.");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    viewResumeOption(sc, applicant);
                    //View resume logic here
                }
                case 5 -> {
                    System.out.println("Update Resume selected.");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    updateInformationOption(sc, applicant);
                    //Update resume information logic here
                }
                case 6 -> {
                    System.out.println("Returning to Login Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return; // Go back to the Login menu
                }
                case 7 -> exitApplication(); // Exit the program
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void jobProviderMenu(Scanner sc, User user) {
        while (true) {
            System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\     Job Provider     " +
                    "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            JobProvider jobProvider = new JobProvider(user.getUserName());
            System.out.println("1.Post Job Circular");
            System.out.println("2.See Applicant List");
            System.out.println("3.See Short List");
            System.out.println("4. Go Back");
            System.out.println("5. Exit");
            System.out.print("Enter your selection: ");

            int selection = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (selection) {
                case 1 -> {
                    System.out.println("Post Job Circular selected.");
                    // Job circular posting logic here
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    postJobCircularOption(sc, jobProvider);
                }
                case 2 -> {
                    System.out.println("View Applicants selected.");
                    // Applicant viewing logic here
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    seeApplicantListOption(sc, jobProvider);
                }
                case 3 -> {
                    System.out.println("View Applicants short listed.");
                    //Shortlisted applicant viewing logic here
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    seeShortListOption(sc, jobProvider);
                }
                case 4 -> {
                    System.out.println("Returning to Login Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return; // Go back to the Login menu
                }
                case 5 -> exitApplication(); // Exit the program
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void adminMenu(Scanner sc) {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Admin Requests");
            System.out.println("2. Manage Users");
            System.out.println("3. Go Back");
            System.out.println("4. Exit");
            System.out.print("Enter your selection: ");

            int selection = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            Admin admin = new Admin();

            switch (selection) {
                case 1 -> {
                    System.out.println("View admin requests selected.");
                    // Job verification logic here
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    adminRequestOption(sc, admin);
                }
                case 2 -> {
                    System.out.println("Manage Users selected.");
                    // User management logic here
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    manageUserOption(sc, admin);
                }
                case 3 -> {
                    System.out.println("Returning to Login Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return; // Go back to the Login menu
                }
                case 4 -> exitApplication(); // Exit the program
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void registrationMenu(Scanner sc) {
        while (true) {
            System.out.println("\n--- Registration Menu ---");
            System.out.println("Logic for registration here...");
            // Implement similar structure for registration as needed
            System.out.println("You choose :SignUp");
            System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\    Registration    " +
                    " \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            System.out.println("Name: ");
            Scanner sc35 = new Scanner(System.in);
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
            User user;
            switch (roleValue) {
                case 1 -> {
                    user = new User(name, pass1, email1, "applicant");
                    if (user.registration(user)) {
                        System.out.println("Congratulations! You have been registered.");
                    } else {
                        System.out.println("Sorry! You have not registered.");
                    }
                }
                case 2 -> {
                    user = new User(name, pass1, email1, "job provider");
                    System.out.println("You need to provide some additional information");
                    System.out.println("Company Name:");
                    Scanner sc65 = new Scanner(System.in);
                    String companyName = sc65.nextLine();

                    System.out.println("Web Address:");
                    Scanner sc66 = new Scanner(System.in);
                    String webAddress = sc66.nextLine();

                    if (user.registration(user)) {
                        JobProvider jobProvider = new JobProvider(companyName, webAddress);
                        jobProvider.registrationJobProvider();

                        System.out.println("Congratulations! You have been registered.");
                    } else {
                        System.out.println("Sorry! You have not registered.");
                    }

                }
                case 3 -> {
                    System.out.println("Admin req send");
                    user = new User(name, pass1, email1, "admin");
                    if (user.adminRegistrationRequest(user)) {
                        System.out.println("Your request has been sent to Admin.");
                    } else {
                        System.out.println("Sorry! Your request has not been sent to Admin.");
                    }
                }
            }

            System.out.println("1.Go back");
            System.out.println("2.Exit");
            System.out.println("Enter your selection");

            int selection = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (selection) {
                case 1 -> {
                    System.out.println("Returning to Login Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return; // Go back to the Login menu
                }
                case 2 -> exitApplication(); // Exit the program
                default -> System.out.println("Invalid selection. Try again.");

            }
        }
    }

    private static void exitApplication() {
        System.out.println("Exiting application. Goodbye!");
        isRunning = false; // Stop the main loop
        System.exit(0); // Optional: Immediate termination
    }

    private static List<String> jobSearch(Scanner sc, Applicant applicant) {
        while (true) {
            System.out.println("Search job");
            System.out.println("***************  Job Search  *****************");
            System.out.println("Add your preference");
            System.out.println("1.Location");
            System.out.println("2.Experience");
            System.out.println("3.Salary");
            System.out.println("4.Skills");
            System.out.println("5.Time");
            System.out.println("6. Go Back");
            System.out.println("7. Exit");
            System.out.println("Enter your selection");

            List<String> jobList = new ArrayList<>();

            int selection = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (selection) {
                case 1 -> {
                    System.out.println("Location: ");
                    Scanner sc71 = new Scanner(System.in);
                    String location = sc71.nextLine();
                    jobList = applicant.searchJob(location);
                }
                case 2 -> {
                    System.out.println("Experience");
                    Scanner sc72 = new Scanner(System.in);
                    String experience = sc72.nextLine();
                    jobList = applicant.searchJob(experience);
                }
                case 3 -> {
                    System.out.println("Salary");
                    Scanner sc73 = new Scanner(System.in);
                    String salary = sc73.nextLine();
                    jobList = applicant.searchJob(salary);
                }
                case 4 -> {
                    System.out.println("Skills");
                    Scanner sc74 = new Scanner(System.in);
                    String skills = sc74.nextLine();
                    jobList = applicant.searchJob(skills);
                }
                case 5 -> {
                    System.out.println("Time");
                    Scanner sc75 = new Scanner(System.in);
                    String time = sc75.nextLine();
                    jobList = applicant.searchJob(time);
                }
                case 6 -> {
                    System.out.println("Returning to Login Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return new ArrayList<>(); // Go back to the Login menu
                }
                case 7 -> exitApplication(); // Exit the program
                default -> System.out.println("Invalid selection. Try again.");


            }
            System.out.println("//////////////////////////////////////////////");
            //updateConsole();
            return jobList;
        }
    }

    private static void seeJobInformation(Scanner sc, Applicant applicant, List<String> jobList) {
        while (true) {
            System.out.println("Job information");
            System.out.println("***************  Job Information  *************");
            System.out.println("Add your preferred job no");
            Scanner sc70 = new Scanner(System.in);
            String query = sc70.nextLine();
            System.out.println("//////////////////////////////////////////////");
            updateConsole();
            applicant.showInformation(query, jobList);

            System.out.println("1.Apply");
            System.out.println("2.Go back");
            System.out.println("3.Exit");
            System.out.println("Enter your selection");

            int selection = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (selection) {
                case 1 -> {
                        System.out.println(" Apply");
                        applicant.processApplication(query, jobList, applicant.getEmail());
                        System.out.println("1.Go back");
                        System.out.println("2.Exit");
                        System.out.println("Enter your selection");

                        int selection1 = sc.nextInt();
                        sc.nextLine();
                        switch (selection1) {
                            case 1 -> {
                                System.out.println("Returning to Login Menu...");
                                System.out.println("//////////////////////////////////////////////");
                                updateConsole();
                                return; // Go back to the Login menu
                            }
                            case 2 -> exitApplication(); // Exit the program
                            default -> System.out.println("Invalid selection. Try again.");
                        }

                }
                case 2 -> {
                    System.out.println("Returning to Login Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return; // Go back to the Login menu
                }
                case 3 -> exitApplication(); // Exit the program
                default -> System.out.println("Invalid selection. Try again.");

            }
        }
    }

    private static void seeJobStatus(Scanner sc, Applicant applicant) {
        while (true) {
            System.out.println("Job status");
            System.out.println("***************  Job Status  ***************");
            List<String> jobs = applicant.applicationList(applicant.getEmail());
            System.out.println("Enter the number of the job you want to see status of :");
            Scanner jobPostNo = new Scanner(System.in);
            String selection80 = jobPostNo.nextLine();
            applicant.applicationStatus(selection80, jobs);

            System.out.println("1.Go Back");
            System.out.println("2.Exit");
            System.out.println("Enter your selection");

            int selection = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (selection) {
                case 1 -> {
                    System.out.println("Returning to Login Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return; // Go back to the Login menu
                }
                case 2 -> exitApplication(); // Exit the program
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void createResumeOption(Scanner sc, User user, Applicant applicant) {
        while (true) {
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

            PersonalInformation personalInformation = new PersonalInformation(name, fatherName, motherName, dateOfBirth, nationality, religion, gender, phoneNumber, address, nationalID);
            EducationalInformation educationalInformation = new EducationalInformation(name, schoolName, passingYear, sscOLevelResult, collegeName, passingYearHSC, hscALevelResult, universityName, department, undergraduateDegree, undergradCGPA, postgraduateDegree, postgradCGPA);
            AdditionalInformation additionalInformation = new AdditionalInformation(name, experince, hobbies, skills);
            Resume resume = new Resume(personalInformation, educationalInformation, additionalInformation);
            applicant = new Applicant(user.getUserName(), user.getPassword(), user.getEmail(), user.getRole(), resume);


            System.out.println("1.Enter");

            System.out.println("2.Go Back");

            System.out.println("3.Exit");

            System.out.println("Enter your selection");
            int selection = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (selection) {
                case 1 -> {
                    System.out.println("Enter selected.");
                    if (isValidPhoneNumber(phoneNumber)) {
                        applicant.createResume();
                    } else {
                        System.out.println("Invalid phone number");
                    }
                    System.out.println("1.Go Back");
                    System.out.println("2.Exit");
                    System.out.println("Enter your selection");

                    int selection1 = sc.nextInt();
                    sc.nextLine(); // Consume the newline character

                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Login Menu...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            return; // Go back to the Login menu
                        }
                        case 2 -> exitApplication(); // Exit the program
                        default -> System.out.println("Invalid selection. Try again.");
                    }

                }
                case 2 -> {
                    System.out.println("Returning to Login Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return; // Go back to the Login menu
                }
                case 3 -> exitApplication(); // Exit the program
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void viewResumeOption(Scanner sc, Applicant applicant) {
        while (true) {
            System.out.println("View Resume");
            System.out.println("***************  View Resume  ***************");
            System.out.println("Showing resume");
            applicant.showResume();

            System.out.println("1.Go Back");
            System.out.println("2.Exit");
            System.out.println("Enter your selection");

            int selection = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (selection) {
                case 1 -> {
                    System.out.println("Returning to Login Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return; // Go back to the Login menu
                }
                case 2 -> exitApplication(); // Exit the program
                default -> System.out.println("Invalid selection. Try again.");
            }
        }

    }

    private static void updateInformationOption(Scanner sc, Applicant applicant) {
        while (true) {
            System.out.println("***************  Update Information  ***************");
            System.out.println("Necessary info will be shown here");
            applicant.updateInfo();

            System.out.println("1.Go Back");
            System.out.println("2.Exit");
            System.out.println("Enter your selection");

            int selection = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (selection) {
                case 1 -> {
                    System.out.println("Returning to Login Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return; // Go back to the Login menu
                }
                case 2 -> exitApplication(); // Exit the program
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void postJobCircularOption(Scanner sc, JobProvider jobProvider) {
        while (true) {
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

            int selection = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (selection) {
                case 1 -> {
                    while (true) {
                        Job job = new Job(companyName, jobPosition, skill, experience, salary, location, time, websiteLink, additional);
                        if (jobProvider.postJob(job)) {
                            System.out.println("You have successfully posted a Job post!");
                        }
                        System.out.println("1. Go Back");
                        System.out.println("2. Exit ");
                        System.out.println("Enter your selection: ");

                        int selection1 = sc.nextInt();
                        sc.nextLine(); // Consume the newline character
                        switch (selection1) {
                            case 1 -> {
                                System.out.println("Returning to Login Menu...");
                                System.out.println("//////////////////////////////////////////////");
                                updateConsole();
                                return; // Go back to the Login menu
                            }
                            case 2 -> exitApplication(); // Exit the program
                            default -> System.out.println("Invalid selection. Try again.");
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Returning to Login Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return; // Go back to the Login menu
                }
                case 3 -> exitApplication(); // Exit the program
                default -> System.out.println("Invalid selection. Try again.");
            }
        }

    }

    private static void seeApplicantListOption(Scanner sc, JobProvider jobProvider) {
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
        System.out.println("Enter your preference to see the applicant list sorted: ");
        System.out.println("1.BSc CGPA");
        System.out.println("2. Has MSc Degree");
        System.out.println("3. Experience");
        Scanner scanner110 = new Scanner(System.in);
        int selectionNo101 = scanner110.nextInt();
        String searchPreference = "";
        switch (selectionNo101) {
            case 1:
                searchPreference = "cgpa";
                break;
            case 2:
                searchPreference = "MSc";
                break;
            case 3:
                searchPreference = "experience";
                break;
        }

        List<String> applicantList = jobProvider.seeApplicantList(jobProvider.getJobPostNo(serialNo, jobPostList), searchPreference);
        while (true) {
            if (!applicantList.isEmpty() && serialNo != null) {
                System.out.println("Enter the Serial number of the applicant you want to see: ");
                Scanner scanner1 = new Scanner(System.in);
                String serialNumber = scanner1.nextLine();
                System.out.println("//////////////////////////////////////////////");
                updateConsole();
                System.out.println("***************  Applicants Personal Information  ***************");
                String applicantResume = jobProvider.viewApplicantDetails(serialNumber, applicantList);
                System.out.println("1. Select ");
                System.out.println("2. Reject ");
                System.out.println("3. Go Back ");
                System.out.println("4. Exit ");
                System.out.println("Enter your selection: ");
                int selection = sc.nextInt();
                sc.nextLine(); // Consume the newline character
                switch (selection) {
                    case 1 -> {
                        System.out.println("Selected!");
                        List<String> applications = jobProvider.changeStatus(applicantResume, "Shortlisted");
                        jobProvider.addToShortList(applications);
                        System.out.println("1. Go Back");
                        System.out.println("2. Exit ");
                        System.out.println("Enter your selection: ");

                        int selection1 = sc.nextInt();
                        sc.nextLine(); // Consume the newline character
                        switch (selection1) {
                            case 1 -> {
                                System.out.println("Returning to Login Menu...");
                                System.out.println("//////////////////////////////////////////////");
                                updateConsole();
                                return; // Go back to the Login menu
                            }
                            case 2 -> exitApplication(); // Exit the program
                            default -> System.out.println("Invalid selection. Try again.");
                        }
                    }
                    case 2 -> {
                        System.out.println("Rejected!");
                        List<String> applications1 = jobProvider.changeStatus(applicantResume, "Rejected");
                        jobProvider.addToShortList(applications1);
                        System.out.println("1. Go Back");
                        System.out.println("2. Exit ");
                        System.out.println("Enter your selection: ");

                        int selection1 = sc.nextInt();
                        sc.nextLine(); // Consume the newline character
                        switch (selection1) {
                            case 1 -> {
                                System.out.println("Returning to Login Menu...");
                                System.out.println("//////////////////////////////////////////////");
                                updateConsole();
                                return; // Go back to the Login menu
                            }
                            case 2 -> exitApplication(); // Exit the program
                            default -> System.out.println("Invalid selection. Try again.");
                        }
                    }
                    case 3 -> {
                        System.out.println("Returning to Login Menu...");
                        System.out.println("//////////////////////////////////////////////");
                        updateConsole();
                        return; // Go back to the Login menu
                    }
                    case 4 -> exitApplication(); // Exit the program
                    default -> System.out.println("Invalid selection. Try again.");

                }
            }
            else {
                System.out.println("//////////////////////////////////////////////");
                updateConsole();
                System.out.println("There is no application submitted for this job post yet!");
                System.out.println("1. Go Back ");
                System.out.println("2. Exit ");
                System.out.println("Enter your selection: ");
                int selection = sc.nextInt();
                sc.nextLine();
                switch (selection) {
                    case 1 -> {
                        System.out.println("Returning to Login Menu...");
                        System.out.println("//////////////////////////////////////////////");
                        updateConsole();
                        return; // Go back to the Login menu
                    }
                    case 2 -> exitApplication(); // Exit the program
                    default -> System.out.println("Invalid selection. Try again.");
                }
            }
        }
    }

    private static void seeShortListOption(Scanner sc, JobProvider jobProvider) {
        while (true) {
            System.out.println("See Short List");
            //list will be shown
            System.out.println("You have previously posted these posts:");
            List<String> jobPostList1 = jobProvider.seeJobPosts();
            System.out.println("Choose a post to see it's shortListed applicants:");
            Scanner scanner100 = new Scanner(System.in);
            String selectedJobPost = scanner100.nextLine();
            System.out.println("***************  Shortlisted Applicants  ***************");
            List<String> applicantShortList = jobProvider.seeShortList(selectedJobPost, jobPostList1);
            System.out.println("1. See Any Applicant's Details");
            System.out.println("2. Go Back");
            System.out.println("3. Exit");
            System.out.println("Enter your selection: ");
            int selection = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            switch (selection) {
                case 1 -> {
                    while (true) {
                        System.out.println("Enter the serial number from the applicant list: ");
                        Scanner scanner2 = new Scanner(System.in);
                        String serialNumber = scanner2.nextLine();
                        System.out.println("//////////////////////////////////////////////");
                        updateConsole();
                        jobProvider.viewApplicantDetails(serialNumber, applicantShortList);
                        System.out.println("1. Go Back");
                        System.out.println("2. Exit");
                        System.out.println("Enter your selection: ");
                        String selection100 = sc.nextLine();
                        switch (selection100) {
                            case "1" -> {
                                System.out.println("Returning to Login Menu...");
                                System.out.println("//////////////////////////////////////////////");
                                updateConsole();
                                return; // Go back to the Login menu
                            }
                            case "2" -> exitApplication(); // Exit the program
                            default -> System.out.println("Invalid selection. Try again.");
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Returning to Login Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return; // Go back to the Login menu
                }
                case 3 -> exitApplication(); // Exit the program
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void manageUserOption(Scanner sc, Admin admin) {
        while (true) {
            System.out.println("***************  User Information  ***************");
            System.out.println("1. Applicant");
            System.out.println("2. Job Provider");
            System.out.println("3. Go Back");
            System.out.println("4. Exit");

            System.out.println("Enter your selection: ");

            int selection = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (selection) {
                case 1 -> {
                    System.out.println("view applicant info");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    viewApplicantInformationOption(sc, admin);
                }
                case 2 -> {
                    System.out.println("view job provider info");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    viewJobProviderInformation(sc, admin);
                }
                case 3 -> {
                    System.out.println("Returning to Login Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return; // Go back to the Login menu
                }
                case 4 -> exitApplication(); // Exit the program
                default -> System.out.println("Invalid selection. Try again.");
            }
        }

    }

    private static void viewApplicantInformationOption(Scanner sc, Admin admin) {
        while (true) {
            System.out.println("=================================================Applicant Information================================================");
            List<String> applicants = admin.ViewApplicantInformation();
            System.out.println("Enter your selection: ");
            Scanner applicantsc = new Scanner(System.in);
            int selectionApplicant = applicantsc.nextInt();

            //input from the list
            System.out.println("***************  Verification  ***************");
            System.out.println("1. Verify ");
            System.out.println("2. Delete");
            System.out.println("3. Go Back");
            System.out.println("4. Exit");
            System.out.println("Enter your selection: ");

            int selection = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (selection) {
                case 1 -> {
                    admin.verifyApplicant(selectionApplicant, applicants);
                    System.out.println("Verified");
                    System.out.println("1. Go Back");
                    System.out.println("2. Exit ");
                    System.out.println("Enter your selection: ");

                    int selection1 = sc.nextInt();
                    sc.nextLine(); // Consume the newline character
                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Login Menu...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            return; // Go back to the Login menu
                        }
                        case 2 -> exitApplication(); // Exit the program
                        default -> System.out.println("Invalid selection. Try again.");
                    }
                }
                case 2 -> {
                    admin.deleteApplicant(selectionApplicant, applicants);
                    System.out.println("Deleted");
                    System.out.println("1. Go Back");
                    System.out.println("2. Exit ");
                    System.out.println("Enter your selection: ");

                    int selection1 = sc.nextInt();
                    sc.nextLine(); // Consume the newline character
                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Login Menu...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            return; // Go back to the Login menu
                        }
                        case 2 -> exitApplication(); // Exit the program
                        default -> System.out.println("Invalid selection. Try again.");
                    }
                }
                case 3 -> {
                    System.out.println("Returning to Login Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return; // Go back to the Login menu
                }
                case 4 -> exitApplication(); // Exit the program
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void viewJobProviderInformation(Scanner sc, Admin admin) {
        while (true) {
            System.out.println("================================Job Provider Information======================================");
            //System.out.println("***************  Job Provider’s Website List  ***************");
            //Admin admin12=new Admin();
            List<String> jobProviders = admin.ViewInformation();
            System.out.println("Enter your selection: ");
            Scanner jobProvidersc = new Scanner(System.in);
            int selectionJobProvider = jobProvidersc.nextInt();
            //input from the list
            System.out.println("***************  Verification  ***************");
            System.out.println("1. Verify ");
            System.out.println("2. Delete");
            System.out.println("3. Go Back");
            System.out.println("4. Exit");
            System.out.println("Enter your selection: ");

            int selection = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (selection) {
                case 1 -> {
                    admin.verify(selectionJobProvider, jobProviders);
                    System.out.println("Verified");
                    System.out.println("1. Go Back");
                    System.out.println("2. Exit ");
                    System.out.println("Enter your selection: ");

                    int selection1 = sc.nextInt();
                    sc.nextLine(); // Consume the newline character
                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Login Menu...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            return; // Go back to the Login menu
                        }
                        case 2 -> exitApplication(); // Exit the program
                        default -> System.out.println("Invalid selection. Try again.");
                    }
                }
                case 2 -> {
                    admin.delete(selectionJobProvider, jobProviders);
                    System.out.println("Deleted");
                    System.out.println("1. Go Back");
                    System.out.println("2. Exit ");
                    System.out.println("Enter your selection: ");

                    int selection1 = sc.nextInt();
                    sc.nextLine(); // Consume the newline character
                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Login Menu...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            return; // Go back to the Login menu
                        }
                        case 2 -> exitApplication(); // Exit the program
                        default -> System.out.println("Invalid selection. Try again.");
                    }
                }
                case 3 -> {
                    System.out.println("Returning to Login Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return; // Go back to the Login menu
                }
                case 4 -> exitApplication(); // Exit the program
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void adminRequestOption(Scanner sc, Admin admin) {
        while (true) {
            System.out.println("=========================================Admin Requests========================================");
            List<String> adminRequests = admin.viewAdminRequest();
            Scanner adminRequestsc = new Scanner(System.in);
            System.out.println("Enter your selection: ");
            int selectionAdminRequest = adminRequestsc.nextInt();
            System.out.println("***************  Approval  ***************");
            System.out.println("1. Approve ");
            System.out.println("2. Reject ");
            System.out.println("3. Go Back");
            System.out.println("4. Exit");
            System.out.println("Enter your selection: ");

            int selection = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (selection) {
                case 1 -> {
                    admin.approve(selectionAdminRequest, adminRequests);
                    System.out.println("Approved");
                    System.out.println("1. Go Back");
                    System.out.println("2. Exit ");
                    System.out.println("Enter your selection: ");

                    int selection1 = sc.nextInt();
                    sc.nextLine(); // Consume the newline character
                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Login Menu...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            return; // Go back to the Login menu
                        }
                        case 2 -> exitApplication(); // Exit the program
                        default -> System.out.println("Invalid selection. Try again.");
                    }
                }
                case 2 -> {
                    admin.deleteRequest(selectionAdminRequest, adminRequests);
                    System.out.println("Rejected");
                    System.out.println("1. Go Back");
                    System.out.println("2. Exit ");
                    System.out.println("Enter your selection: ");

                    int selection1 = sc.nextInt();
                    sc.nextLine(); // Consume the newline character
                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Login Menu...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            return; // Go back to the Login menu
                        }
                        case 2 -> exitApplication(); // Exit the program
                        default -> System.out.println("Invalid selection. Try again.");
                    }
                }
                case 3 -> {
                    System.out.println("Returning to Login Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return; // Go back to the Login menu
                }
                case 4 -> exitApplication(); // Exit the program
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }
}



