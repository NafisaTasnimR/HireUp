package HireUpMain;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static HireUpMain.Utility.isValidPhoneNumber;
import static HireUpMain.Utility.updateConsole;

public class Main {
    private static boolean isRunning = true;

    public static void main(String[] args) {
        mainMenu();
    }
    private static void mainMenu(){
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

    private static void exitApplication() {
        System.out.println("Thank You For Using HireUp!");
        System.out.println("Exiting The System...");
        isRunning = false;
        System.exit(0);
    }
    private static void logout()
    {
        System.out.println("Logging out...");
        System.out.println("//////////////////////////////////////////////");
        updateConsole();
        mainMenu();
    }
    private static void loginMenu(Scanner sc) {
        while (true) {
            System.out.println("You choose :Login");
            System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ Login \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            System.out.println("Enter your ");

            System.out.println("Email:");
            Scanner sc3 = new Scanner(System.in);
            String email = sc3.nextLine();

            /*System.out.println("Password:");
            Scanner sc2 = new Scanner(System.in);
            String password = sc2.nextLine();*/

            Console console = System.console();
            char[] passwordArray = ((Console) console).readPassword("Password : ");
            String password = new String(passwordArray);

            System.out.println("Role:");
            System.out.println("1. Applicant");
            System.out.println("2. Job Provider");
            System.out.println("3. Admin");
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

            user = user.userObject(password, email, role);

            System.out.println("//////////////////////////////////////////////");
            updateConsole();
            if (user != null && user.logIn()) {
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
    }

    private static void applicantMenu(Scanner sc, User user) {
        while (true) {
            System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\  Applicant \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            System.out.println("1. Job Search");
            System.out.println("2. See Job Status");
            System.out.println("3. Create Resume");
            System.out.println("4. View Resume");
            System.out.println("5. Update Information");
            System.out.println("6. Logout");
            System.out.print("Enter your selection: ");

            int selection = sc.nextInt();
            sc.nextLine();
            Applicant applicant = new Applicant(user.getUserName(), user.getPassword(), user.getEmail(), user.getRole());

            updateConsole();
            switch (selection) {
                case 1 -> {
                    System.out.println("Search for Jobs selected.");
                    List<String> jobList = null;
                    while(true){
                        if (jobList == null) {
                            jobList = jobSearch(sc, applicant);
                            if (jobList == null || jobList.isEmpty()) {
                                System.out.println("Currently, there are no job openings with your search!");
                                break;
                            }
                        }
                        printJobList(jobList);

                        System.out.println("1. See job details from the post");
                        System.out.println("2. Go Back");
                        System.out.println("3. Logout");
                        System.out.println("Enter your selection: ");
                        int selection02 = sc.nextInt();
                        sc.nextLine();
                        switch (selection02) {
                            case 1 -> {
                                System.out.println("Add your preferred job no");
                                Scanner sc70 = new Scanner(System.in);
                                String query = sc70.nextLine();
                                System.out.println("View Jobs details information.");
                                seeJobInformation(sc, applicant, jobList,query);
                                System.out.println("//////////////////////////////////////////////");
                                updateConsole();
                            }
                            case 2 -> {
                                jobList = null;
                                System.out.println("Returning to Previous Menu...");
                                System.out.println("//////////////////////////////////////////////");
                                updateConsole();
                            }
                            case 3 -> logout();
                            default -> System.out.println("Invalid selection. Try again.");
                        }
                    }
                }
                case 2 -> {
                    System.out.println("View Application Status selected.");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    seeJobStatus(sc, applicant);
                }
                case 3 -> {
                    System.out.println("Create Resume selected.");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    createResumeOption(sc, user, applicant);
                }
                case 4 -> {
                    System.out.println("View Resume selected.");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    viewResumeOption(sc, applicant);
                }
                case 5 -> {
                    System.out.println("Update Resume selected.");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    updateInformationOption(sc, applicant);
                }
                case 6 -> logout();
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void jobProviderMenu(Scanner sc, User user) {
        while (true) {
            System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\  Job Provider  " +
                    "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            JobProvider jobProvider = JobProvider.loadFromFile(user.getEmail());
            System.out.println("1. Post Job Circular");
            System.out.println("2. Review & Shortlist Applicants");
            System.out.println("3. See Short List");
            System.out.println("4. Logout");
            System.out.print("Enter your selection: ");

            int selection = sc.nextInt();
            sc.nextLine();

            switch (selection) {
                case 1 -> {
                    System.out.println("Post Job Circular selected.");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    postJobCircularOption(sc, jobProvider);
                }
                case 2 -> {
                    System.out.println("View Applicants selected.");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    seeApplicantListOption(sc, jobProvider);
                }
                case 3 -> {
                    System.out.println("View Applicants short listed.");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    seeShortListOption(sc, jobProvider);
                }
                case 4 -> logout();
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void adminMenu(Scanner sc) {
        while (true) {
            System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\  Admin  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            System.out.println("1. New Applicant Requests");
            System.out.println("2. New Job Provider Requests");
            System.out.println("3. Manage Users");
            System.out.println("4. Logout");
            System.out.print("Enter your selection: ");

            int selection = sc.nextInt();
            sc.nextLine();

            Admin admin = new Admin();

            switch (selection) {
                case 1 -> {
                    System.out.println("View applicant requests selected.");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    applicantRequestOption(sc, admin);
                }
                case 2 -> {
                    System.out.println("View job provider requests selected.");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    jobProviderRequestOption(sc, admin);
                }
                case 3 -> {
                    System.out.println("Manage Users selected.");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    deleteUserOption(sc, admin);
                }
                case 4 -> logout();
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void registrationMenu(Scanner sc) {
        while (true) {
            System.out.println("You choose :SignUp");
            System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\    Registration    " +
                    " \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            System.out.println("Name: ");
            Scanner sc35 = new Scanner(System.in);
            String name = sc35.nextLine();
            System.out.println("Email: ");
            Scanner sc36 = new Scanner(System.in);
            String email = sc36.nextLine();
            System.out.println("Password: ");
            Scanner sc37 = new Scanner(System.in);
            String password = sc37.nextLine();
            System.out.println("Role: ");
            System.out.println("1. Applicant");
            System.out.println("2. Job Provider");
            System.out.println("Enter your role: ");

            Scanner sc38 = new Scanner(System.in);
            int roleValue = sc38.nextInt();
            User user;
            switch (roleValue) {
                case 1 -> {
                    user = new User(name, password, email, "applicant");
                    if(user.sendNewApplicantRequest(user)){
                        System.out.println("Applicant Request Has Been Sent.");
                    } else{
                        System.out.println("Sorry! Applicant Request Has Not Been Sent.");
                    }

                }
                case 2 -> {
                    user = new User(name, password, email, "job provider");
                    System.out.println("You need to provide some additional information");
                    System.out.println("Company Name:");
                    Scanner sc65 = new Scanner(System.in);
                    String companyName = sc65.nextLine();

                    System.out.println("Web Address:");
                    Scanner sc66 = new Scanner(System.in);
                    String webAddress = sc66.nextLine();
                    if (user.sendNewJobProviderRequest(user, companyName, webAddress)) {
                        System.out.println("Your request has been sent to Admin.");
                    } else {
                        System.out.println("Sorry! Your request has not been sent to Admin.");
                    }
                }
            }

            System.out.println("1. Go back");
            System.out.println("2. Exit");
            System.out.println("Enter your selection");

            int selection = sc.nextInt();
            sc.nextLine();

            switch (selection) {
                case 1 -> {
                    System.out.println("Returning to Previous Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return;
                }
                case 2 -> exitApplication();
                default -> System.out.println("Invalid selection. Try again.");

            }
        }
    }

    private static List<String> jobSearch(Scanner sc, Applicant applicant) {
        while (true) {
            System.out.println("Search job");
            System.out.println("***************  Job Search  ***************");
            System.out.println("Add your preference");
            System.out.println("1. Location");
            System.out.println("2. Experience");
            System.out.println("3. Salary");
            System.out.println("4. Skills");
            System.out.println("5. Time");
            System.out.println("6. Go Back");
            System.out.println("7. Logout");
            System.out.println("Enter your selection");

            List<String> jobList = new ArrayList<>();

            int selection = sc.nextInt();
            sc.nextLine();

            switch (selection) {
                case 1 -> {
                    System.out.println("Location: ");
                    Scanner sc71 = new Scanner(System.in);
                    String location = sc71.nextLine();
                    jobList = applicant.searchJob(location);
                }
                case 2 -> {
                    System.out.println("Experience: ");
                    Scanner sc72 = new Scanner(System.in);
                    String experience = sc72.nextLine();
                    jobList = applicant.searchJob(experience);
                }
                case 3 -> {
                    System.out.println("Salary: ");
                    Scanner sc73 = new Scanner(System.in);
                    String salary = sc73.nextLine();
                    jobList = applicant.searchJob(salary);
                }
                case 4 -> {
                    System.out.println("Skills: ");
                    Scanner sc74 = new Scanner(System.in);
                    String skills = sc74.nextLine();
                    jobList = applicant.searchJob(skills);
                }
                case 5 -> {
                    System.out.println("Time: ");
                    Scanner sc75 = new Scanner(System.in);
                    String time = sc75.nextLine();
                    jobList = applicant.searchJob(time);
                }
                case 6 -> {
                    System.out.println("Returning to Previous Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return new ArrayList<>();
                }
                case 7 -> logout();
                default -> System.out.println("Invalid selection. Try again.");


            }
            return jobList;
        }
    }

    private static void printJobList(List<String> jobList) {
        System.out.println("================================================================================================================");
        System.out.println("| S.No | Company Name                   | Job Position              | Website Address                          |");
        System.out.println("================================================================================================================");

        int outputSerial = 0;
        for (String job : jobList) {
            String[] data = job.split(",");
            if (data.length >= 11) {
                outputSerial++;
                System.out.printf("| %-4d | %-30s | %-25s | %-40s | \n",
                        outputSerial, data[2], data[3], data[9]);
                System.out.println("================================================================================================================");
            }
        }

        if (jobList.isEmpty()) {
            System.out.println("No matching jobs found.");
        }
    }

    private static void seeJobInformation(Scanner sc, Applicant applicant, List<String> jobList,String query) {
        while (true) {
            System.out.println("Job information");
            System.out.println("***************  Job Information  *************");

            applicant.showInformation(query, jobList);

            System.out.println("1. Apply");
            System.out.println("2. Go back");
            System.out.println("3. Logout");
            System.out.println("Enter your selection");

            int selection = sc.nextInt();
            sc.nextLine();

            switch (selection) {
                case 1 -> {
                    applicant.processApplication(query, jobList, applicant.getEmail());
                    System.out.println("1. Go back");
                    System.out.println("2. Logout");
                    System.out.println("Enter your selection");

                    int selection1 = sc.nextInt();
                    sc.nextLine();
                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Job List...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            return;
                        }
                        case 2 -> logout();
                        default -> System.out.println("Invalid selection. Try again.");
                    }
                }
                case 2 -> {
                    System.out.println("Returning to Previous Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return;
                }
                case 3 -> logout();
                default -> System.out.println("Invalid selection. Try again.");

            }
        }
    }

    private static void seeJobStatus(Scanner sc, Applicant applicant) {
        while (true) {
            System.out.println("Job status");
            System.out.println("***************  Job Status  ***************");
            List<String> jobs = applicant.getApplicationList(applicant.getEmail());

            System.out.println("1. Go Back");
            System.out.println("2. Logout");
            System.out.println("Enter your selection");

            int selection = sc.nextInt();
            sc.nextLine();

            switch (selection) {
                case 1 -> {
                    System.out.println("Returning to Previous Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return;
                }
                case 2 -> logout();
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void createResumeOption(Scanner sc, User user, Applicant applicant) {
        while (true) {
            System.out.println("Create Resume");
            System.out.println("********************  Create Resume ********************");
            System.out.println("========================================================");
            System.out.println("                    RESUME BUILDER                      ");
            System.out.println("========================================================\n");
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

            EducationalInformation educationalInformation = new EducationalInformation();

            while (true) {
                System.out.println("\n1. Add Educational Information");
                System.out.println("2. Done");

                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    if (educationalInformation.getEducationRecords().size() >= 6) {
                        System.out.println("You can add up to 6 educational entries only.");
                        continue;
                    }

                    System.out.println("Enter Degree Name: ");
                    String degree = sc.nextLine();

                    System.out.println("Enter Institution Name: ");
                    String institution = sc.nextLine();

                    System.out.println("Enter Subject: ");
                    String subject = sc.nextLine();

                    System.out.println("Enter Result: ");
                    String result = sc.nextLine();

                    System.out.println("Enter Passing Year: ");
                    String year = sc.nextLine();

                    educationalInformation.addEducation(degree, institution, subject, result, year);
                } else if (choice == 2) {
                    break;
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            }


            System.out.println("===============   ADDITIONAL INFORMATION   ===============");
            System.out.println("Experience: ");
            Scanner sc60 = new Scanner(System.in);
            String experience = sc60.nextLine();

            System.out.println("Hobbies: ");
            Scanner sc61 = new Scanner(System.in);
            String hobbies = sc61.nextLine();

            System.out.println("Skills: ");
            Scanner sc62 = new Scanner(System.in);
            String skills = sc62.nextLine();

            System.out.println("==========================================================");

            PersonalInformation personalInformation = new PersonalInformation(name, fatherName, motherName, dateOfBirth, nationality, religion, gender, phoneNumber, address, nationalID);
            AdditionalInformation additionalInformation = new AdditionalInformation( experience, hobbies, skills);
            Resume resume = new Resume(personalInformation, educationalInformation, additionalInformation);
            applicant = new Applicant(user.getUserName(), user.getPassword(), user.getEmail(), user.getRole(), resume);

            System.out.println("1. Enter");

            System.out.println("2. Go Back");

            System.out.println("3. Logout");

            System.out.println("Enter your selection");
            int selection = sc.nextInt();
            sc.nextLine();

            switch (selection) {
                case 1 -> {
                    System.out.println("Enter selected.");
                    if (isValidPhoneNumber(phoneNumber)) {
                        applicant.createResume();
                    } else {
                        System.out.println("Invalid phone number");
                    }
                    System.out.println("1. Go Back");
                    System.out.println("2. Logout");
                    System.out.println("Enter your selection");

                    int selection1 = sc.nextInt();
                    sc.nextLine();

                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Previous Menu...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            return;
                        }
                        case 2 -> logout();
                        default -> System.out.println("Invalid selection. Try again.");
                    }

                }
                case 2 -> {
                    System.out.println("Returning to Previous Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return;
                }
                case 3 -> logout();
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void viewResumeOption(Scanner sc, Applicant applicant) {
        while (true) {
            System.out.println("View Resume");
            System.out.println("***************  View Resume  ***************");
            System.out.println("Showing resume: ");
            applicant.showResume();

            System.out.println("1. Go Back");
            System.out.println("2. Logout");
            System.out.println("Enter your selection");

            int selection = sc.nextInt();
            sc.nextLine();

            switch (selection) {
                case 1 -> {
                    System.out.println("Returning to Previous Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return;
                }
                case 2 -> logout();
                default -> System.out.println("Invalid selection. Try again.");
            }
        }

    }

    private static void updateInformationOption(Scanner sc, Applicant applicant) {
        while (true) {
            System.out.println("***************  Update Information  ***************");
            System.out.println("Necessary info will be shown here");
            System.out.println("What do you want to update?");
            System.out.println("1. Phone Number");
            System.out.println("2. Address");
            System.out.println("3. Email");
            System.out.println("4. Educational Information");
            System.out.println("5. Experience");
            System.out.println("6. Skills");
            System.out.println("7. Hobby");
            System.out.println("8. Go Back");
            System.out.println("9. Logout");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice>=1 && choice<=7)
            {
                applicant.updateInfo(choice);
                System.out.println("1. Go Back");
                System.out.println("2. Logout");
                System.out.println("Enter your selection");

                int selection = sc.nextInt();
                sc.nextLine();

                switch (selection) {
                    case 1 -> {
                        System.out.println("Returning to Previous Menu...");
                        System.out.println("//////////////////////////////////////////////");
                        updateConsole();
                        break;
                    }
                    case 2 -> logout();
                    default -> System.out.println("Invalid selection. Try again.");
                }
            }
            else if(choice == 8){
                System.out.println("Returning to Previous Menu...");
                System.out.println("//////////////////////////////////////////////");
                updateConsole();
                return;
            } else if (choice == 9) {
                logout();
            }else {
                System.out.println("Invalid selection. Try again.");
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
            System.out.println("3. Logout");
            System.out.println("Enter your selection: ");

            int selection = sc.nextInt();
            sc.nextLine();

            switch (selection) {
                case 1 -> {
                    while (true) {
                        Job job = new Job(companyName, jobPosition, skill, experience, salary, location, time, websiteLink, additional);
                        if (jobProvider.postJob(job)) {
                            System.out.println("You have successfully posted a job circular!");
                        }
                        System.out.println("1. Go Back");
                        System.out.println("2. Logout");
                        System.out.println("Enter your selection: ");

                        int selection1 = sc.nextInt();
                        sc.nextLine();
                        switch (selection1) {
                            case 1 -> {
                                System.out.println("Returning to Previous Menu...");
                                System.out.println("//////////////////////////////////////////////");
                                updateConsole();
                                return;
                            }
                            case 2 -> logout();
                            default -> System.out.println("Invalid selection. Try again.");
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Returning to Previous Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return;
                }
                case 3 -> logout();
                case 4 -> exitApplication();
                default -> System.out.println("Invalid selection. Try again.");
            }
        }

    }

    private static void seeApplicantListOption(Scanner sc, JobProvider jobProvider) {
        System.out.println("See Applicant List");
        System.out.println("***************  Watch Application list  ***************");

        while (true) {
            List<String> jobPostList = jobProvider.seeJobPosts();
            System.out.println("1. View Applicant List Under A Job Post");
            System.out.println("2. Go Back");
            System.out.println("3. Logout");
            System.out.println("Enter your selection: ");
            int selection = sc.nextInt();
            sc.nextLine();
            switch (selection){
                case 1 -> {
                    String serialNo = chooseJobCircular(sc);
                    if (serialNo == null) return;

                    String searchPreference = getApplicantSortingPreference(sc);
                    handleApplicantList(sc, jobProvider, serialNo, searchPreference, jobPostList);
                }
                case 2 -> {
                    System.out.println("Returning to Previous Menu...");
                    updateConsole();
                    return;
                }
                case 3 -> logout();
                default -> System.out.println("Invalid selection. Try again.");
            }

        }
    }

    private static String chooseJobCircular(Scanner sc) {

        System.out.println("Enter the Job Post Number that you want to see: ");
        String serialNo = sc.nextLine();
        return serialNo.isEmpty() ? null : serialNo;
    }

    private static String getApplicantSortingPreference(Scanner sc) {
        System.out.println("Enter your preference to see the applicant list sorted: ");
        System.out.println("1. BSc CGPA");
        System.out.println("2. Has MSc Degree");
        System.out.println("3. Experience");
        System.out.println("Enter Your Filtering Preference:");

        int selectionNo = sc.nextInt();
        sc.nextLine();
        return switch (selectionNo) {
            case 1 -> "cgpa";
            case 2 -> "MSc";
            case 3 -> "experience";
            default -> "";
        };
    }

    private static void handleApplicantList(Scanner sc, JobProvider jobProvider, String serialNo, String searchPreference, List<String> jobPostList) {
        while (true) {
            System.out.println("***************  Applicant List  ***************");
            List<String> applicantList = jobProvider.seeApplicantList(jobProvider.getJobPostNo(serialNo, jobPostList), searchPreference);

            if (applicantList.isEmpty()) {
                System.out.println("//////////////////////////////////////////////");
                updateConsole();
                System.out.println("There is no application submitted for this job post yet!");
                System.out.println("1. Go Back ");
                System.out.println("2. Logout");
                System.out.println("Enter Your Selection: ");
                int selection = sc.nextInt();
                sc.nextLine();

                switch (selection) {
                    case 1 -> {
                        System.out.println("Returning to Previous Menu...");
                        updateConsole();
                        return;
                    }
                    case 2 -> logout();
                    default -> System.out.println("Invalid selection. Try again.");
                }
                return;
            }

            System.out.println("1. Review an applicant");
            System.out.println("2. Go Back");
            System.out.println("3. Logout");
            System.out.println("Enter your selection: ");

            int choiceNo = sc.nextInt();
            sc.nextLine();

            switch (choiceNo) {
                case 1 -> reviewApplicant(sc, jobProvider, applicantList);
                case 2 -> {
                    System.out.println("Returning to Job Circular List...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return;
                }
                case 3 -> logout();
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void reviewApplicant(Scanner sc, JobProvider jobProvider, List<String> applicantList) {
        System.out.println("Enter the Serial number of the applicant you want to see: ");
        String serialNumber = sc.nextLine();
        String applicantResume = jobProvider.viewApplicantDetails(serialNumber, applicantList);

        System.out.println("1. Select ");
        System.out.println("2. Reject ");
        System.out.println("3. Go Back ");
        System.out.println("4. Logout");
        System.out.println("Enter your selection: ");

        int selection = sc.nextInt();
        sc.nextLine();

        switch (selection) {
            case 1 -> handleApplicantDecision(sc, jobProvider, applicantResume, "Shortlisted");
            case 2 -> handleApplicantDecision(sc, jobProvider, applicantResume, "Rejected");
            case 3 -> {
                System.out.println("//////////////////////////////////////////////");
                updateConsole();
                return;
            }
            case 4 -> logout();
            default -> System.out.println("Invalid selection. Try again.");
        }
    }

    private static void handleApplicantDecision(Scanner sc, JobProvider jobProvider, String applicantResume, String status) {
        System.out.println(status.equals("Shortlisted") ? "Selected!" : "Rejected!");
        List<String> applications = jobProvider.changeStatus(applicantResume, status);
        jobProvider.addToShortList(applications);

        System.out.println("1. Go Back to Applicant List");
        System.out.println("2. Logout");
        System.out.println("Enter your selection: ");

        int selection = sc.nextInt();
        sc.nextLine();

        switch (selection) {
            case 1 -> {
                System.out.println("//////////////////////////////////////////////");
                updateConsole();
                return;
            }
            case 2 -> logout();
            default -> System.out.println("Invalid selection. Try again.");
        }
    }



    private static void seeShortListOption(Scanner sc, JobProvider jobProvider) {
        while (true) {
            System.out.println("See Short List");
            System.out.println("You have previously posted these posts:");
            List<String> jobPostList1 = jobProvider.seeJobPosts();
            System.out.println("1. View Short List Under Job Post");
            System.out.println("2. Go Back");
            System.out.println("3. Logout");
            System.out.println("Enter Your Selection: ");
            Scanner scanner = new Scanner(System.in);
            int choiceNo = scanner.nextInt();
            if(choiceNo == 2){
                System.out.println("Returning to Previous Menu...");
                System.out.println("//////////////////////////////////////////////");
                updateConsole();
                return;
            }else if (choiceNo == 3){
                logout();
            }
            System.out.println("Choose a post to see it's shortListed applicants:");
            Scanner scanner100 = new Scanner(System.in);
            String selectedJobPost = scanner100.nextLine();
            boolean backToJobList = false;
            while (!backToJobList) {
                System.out.println("***************  Shortlisted Applicants  ***************");
                List<String> applicantShortList = jobProvider.seeShortList(selectedJobPost, jobPostList1);
                System.out.println("1. See Any Applicant's Details");
                System.out.println("2. Go Back");
                System.out.println("3. Logout");
                System.out.println("Enter your selection: ");
                int selection = sc.nextInt();
                sc.nextLine();
                switch (selection) {
                    case 1 -> {
                        System.out.println("Enter the serial number from the applicant list: ");
                        Scanner scanner2 = new Scanner(System.in);
                        String serialNumber = scanner2.nextLine();
                        System.out.println("//////////////////////////////////////////////");
                        updateConsole();
                        jobProvider.viewApplicantDetails(serialNumber, applicantShortList);
                        System.out.println("1. Go Back");
                        System.out.println("2. Logout");
                        System.out.println("Enter your selection: ");
                        String selection100 = sc.nextLine();
                        switch (selection100) {
                            case "1" -> {
                                System.out.println("Returning to Previous Menu...");
                                System.out.println("//////////////////////////////////////////////");
                                updateConsole();
                                break;
                            }
                            case "2" -> logout();
                            default -> System.out.println("Invalid selection. Try again.");
                        }
                    }
                    case 2 -> {
                        System.out.println("Returning to Previous Menu...");
                        System.out.println("//////////////////////////////////////////////");
                        updateConsole();
                        backToJobList = true;
                    }
                    case 3 -> logout();
                    default -> System.out.println("Invalid selection. Try again.");
                }
            }
        }
    }

    private static void deleteUserOption(Scanner sc, Admin admin) {
        while (true) {
            System.out.println("***************  User Information  ***************");
            System.out.println("1. Applicant");
            System.out.println("2. Job Provider");
            System.out.println("3. Go Back");
            System.out.println("4. Logout");

            System.out.println("Enter your selection: ");

            int selection = sc.nextInt();
            sc.nextLine();

            switch (selection) {
                case 1 -> {
                    System.out.println("View Applicant Information");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    viewApplicantInformationOption(sc, admin);
                }
                case 2 -> {
                    System.out.println("View Job Provider Information");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    viewJobProviderInformation(sc, admin);
                }
                case 3 -> {
                    System.out.println("Returning to Previous Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return;
                }
                case 4 -> logout();
                default -> System.out.println("Invalid selection. Try again.");
            }
        }

    }

    private static void viewApplicantInformationOption(Scanner sc, Admin admin) {
        while (true) {
            System.out.println("=========================================  Applicant Information  ========================================");
            List<String> applicants = admin.ViewApplicantInformation();
            System.out.println("Enter your selection: ");
            Scanner scanner = new Scanner(System.in);
            int selectionApplicant = scanner.nextInt();

            System.out.println("********************  Remove Applicant  ********************");
            System.out.println("1. Delete");
            System.out.println("2. Go Back");
            System.out.println("3. Logout");
            System.out.println("Enter your selection: ");

            int selection = sc.nextInt();
            sc.nextLine();

            switch (selection) {

                case 1 -> {
                    admin.deleteApplicant(selectionApplicant, applicants);
                    System.out.println("Deleted");
                    System.out.println("1. Go Back");
                    System.out.println("2. Logout");
                    System.out.println("Enter your selection: ");

                    int selection1 = sc.nextInt();
                    sc.nextLine();
                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Previous Menu...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            return;
                        }
                        case 2 -> logout();
                        default -> System.out.println("Invalid selection. Try again.");
                    }
                }
                case 2 -> {
                    System.out.println("Returning to Previous Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return;
                }
                case 3 -> logout();
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void viewJobProviderInformation(Scanner sc, Admin admin) {
        while (true) {
            System.out.println("================================  Job Provider Information  ================================");
            List<String> jobProviders = admin.ViewInformation();
            System.out.println("Enter your selection: ");
            Scanner scanner = new Scanner(System.in);
            int selectionJobProvider = scanner.nextInt();
            System.out.println("********************  Remove Job Provider  ********************");
            System.out.println("1. Delete");
            System.out.println("2. Go Back");
            System.out.println("3. Logout");
            System.out.println("Enter your selection: ");

            int selection = sc.nextInt();
            sc.nextLine();

            switch (selection) {

                case 1 -> {
                    admin.deleteJobProvider(selectionJobProvider, jobProviders);
                    System.out.println("Deleted");
                    System.out.println("1. Go Back");
                    System.out.println("2. Logout");
                    System.out.println("Enter your selection: ");

                    int selection1 = sc.nextInt();
                    sc.nextLine();
                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Previous Menu...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            return;
                        }
                        case 2 -> logout();
                        default -> System.out.println("Invalid selection. Try again.");
                    }
                }
                case 2 -> {
                    System.out.println("Returning to Previous Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return;
                }
                case 3 -> logout();
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    private static void jobProviderRequestOption(Scanner sc, Admin admin) {
        while (true) {
            System.out.println("=========================================Job Provider Requests=======================================");
            List<String> jobProviderRequests = admin.viewJobProviderRequests();
            System.out.println("********************  Approval  ********************");
            System.out.println("1. Single Approval ");
            System.out.println("2. Group By Approval");
            System.out.println("3. Single Rejection");
            System.out.println("4. Group By Rejection");
            System.out.println("5. Go Back");
            System.out.println("6. Logout");
            System.out.println("Enter your selection: ");

            int selection = sc.nextInt();
            sc.nextLine();

            switch (selection) {
                case 1 -> {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter serial no: ");
                    int selectionJobProviderRequest = scanner.nextInt();
                    admin.approveJobProvider(selectionJobProviderRequest, jobProviderRequests);
                    System.out.println("The Selected Job Provider Request Has Been Approved");
                    System.out.println("1. Go Back");
                    System.out.println("2. Logout");
                    System.out.println("Enter your selection: ");

                    int selection1 = sc.nextInt();
                    sc.nextLine();
                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Previous Menu...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            break;
                        }
                        case 2 -> logout();
                        default -> System.out.println("Invalid selection. Try again.");
                    }
                }

                case 2 -> {
                    System.out.println("Enter serial numbers (comma-separated) for selection: ");

                    String input = sc.nextLine();
                    List<Integer> serialNumbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
                    admin.processMultipleJobProviderRequests(serialNumbers, true, jobProviderRequests);
                    System.out.println("Selected Job Provider Requests Have Been Approved");
                    System.out.println("1. Go Back");
                    System.out.println("2. Logout");
                    System.out.println("Enter your selection: ");

                    int selection1 = sc.nextInt();
                    sc.nextLine();
                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Previous Menu...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            break;
                        }
                        case 2 -> logout();
                        default -> System.out.println("Invalid selection. Try again.");
                    }
                }
                case 3 -> {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter serial no: ");
                    int selectionJobProviderRequest = scanner.nextInt();
                    admin.deleteJobProviderRequest(selectionJobProviderRequest, jobProviderRequests);
                    System.out.println("The Selected Job Provider Request Has Been Rejected");
                    System.out.println("1. Go Back");
                    System.out.println("2. Logout");
                    System.out.println("Enter your selection: ");

                    int selection1 = sc.nextInt();
                    sc.nextLine();
                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Previous Menu...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            break;
                        }
                        case 2 -> logout();
                        default -> System.out.println("Invalid selection. Try again.");
                    }
                }
                case 4 -> {
                    System.out.println("Enter serial numbers (comma-separated) for selection: ");

                    String input = sc.nextLine();
                    List<Integer> serialNumbers = Arrays.stream(input.split(","))
                            .map(String::trim)
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());
                    admin.processMultipleJobProviderRequests(serialNumbers, false, jobProviderRequests);
                    System.out.println("Selected Job Provider Requests Have Been Rejected");
                    System.out.println("1. Go Back");
                    System.out.println("2. Logout");
                    System.out.println("Enter your selection: ");

                    int selection1 = sc.nextInt();
                    sc.nextLine();
                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Previous Menu...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            break;
                        }
                        case 2 -> logout();
                        default -> System.out.println("Invalid selection. Try again.");
                    }
                }
                case 5-> {
                    System.out.println("Returning to Previous Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return;
                }
                case 6 -> logout();
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }



    private static void applicantRequestOption(Scanner sc, Admin admin) {
        while (true) {
            System.out.println("=======================================  Applicant Requests  ======================================");
            List<String> applicantRequests = admin.viewApplicantRequests();
            System.out.println("***************  Approval  ***************");
            System.out.println("1. Single Approval ");
            System.out.println("2. Group By Approval ");
            System.out.println("3. Single Rejection ");
            System.out.println("4. Group By Rejection");
            System.out.println("5. Go Back");
            System.out.println("6. Logout");
            System.out.println("Enter your selection: ");

            int selection = sc.nextInt();
            sc.nextLine();

            switch (selection) {
                case 1 -> {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter serial no: ");
                    int selectionApplicantRequest = scanner.nextInt();
                    admin.approveApplicant(selectionApplicantRequest, applicantRequests);
                    System.out.println("The Selected Applicant Request Has Been Approved");
                    System.out.println("1. Go Back");
                    System.out.println("2. Logout");
                    System.out.println("Enter your selection: ");

                    int selection1 = sc.nextInt();
                    sc.nextLine();
                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Previous Menu...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            break;
                        }
                        case 2 -> logout();
                        default -> System.out.println("Invalid selection. Try again.");
                    }
                }

                case 2 -> {
                    System.out.println("Enter serial numbers (comma-separated) for selection: ");
                    String input = sc.nextLine();
                    List<Integer> serialNumbers = Arrays.stream(input.split(","))
                            .map(String::trim)
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());
                    admin.processMultipleApplicantRequests(serialNumbers, true, applicantRequests);
                    System.out.println("Selected Applicant Requests Have Been Approved");
                    System.out.println("1. Go Back");
                    System.out.println("2. Logout");
                    System.out.println("Enter your selection: ");

                    int selection1 = sc.nextInt();
                    sc.nextLine();
                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Previous Menu...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            break;
                        }
                        case 2 -> logout();
                        default -> System.out.println("Invalid selection. Try again.");
                    }
                }
                case 3 -> {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter serial no: ");
                    int selectionApplicantRequest = scanner.nextInt();
                    admin.deleteApplicantRequest(selectionApplicantRequest, applicantRequests);
                    System.out.println("Selected Applicant Request Has Been Rejected");
                    System.out.println("1. Go Back");
                    System.out.println("2. Logout");
                    System.out.println("Enter your selection: ");

                    int selection1 = sc.nextInt();
                    sc.nextLine();
                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Previous Menu...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            break;
                        }
                        case 2 -> logout();
                        default -> System.out.println("Invalid selection. Try again.");
                    }
                }
                case 4 -> {
                    System.out.println("Enter serial numbers (comma-separated) for selection: ");
                    String input = sc.nextLine();
                    List<Integer> serialNumbers = Arrays.stream(input.split(","))
                            .map(String::trim)
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());
                    admin.processMultipleApplicantRequests(serialNumbers, false, applicantRequests);
                    System.out.println("Selected Applicant Requests Have Been Rejected");
                    System.out.println("1. Go Back");
                    System.out.println("2. Logout");
                    System.out.println("Enter your selection: ");

                    int selection1 = sc.nextInt();
                    sc.nextLine();
                    switch (selection1) {
                        case 1 -> {
                            System.out.println("Returning to Previous Menu...");
                            System.out.println("//////////////////////////////////////////////");
                            updateConsole();
                            break;
                        }
                        case 2 -> logout();
                        default -> System.out.println("Invalid selection. Try again.");
                    }
                }
                case 5 -> {
                    System.out.println("Returning to Previous Menu...");
                    System.out.println("//////////////////////////////////////////////");
                    updateConsole();
                    return;
                }
                case 6 -> logout();
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }


}



