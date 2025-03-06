package HireUpMain;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Admin extends User {


    public Admin(String userName, String password, String email, String role) {
        super(userName, password, email, role);

    }

    public Admin() {

    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }

    public String getPassword() {
        return super.getPassword();
    }

    public String getEmail() { return super.getEmail();}

    public String getRole() {
        return super.getRole();
    }

    public List<String> ViewInformation() {
        List<String> JobProviderList = new ArrayList<>();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "JobProvider_info.txt"))) {
            System.out.println("======================================================================================");
            System.out.println("| S.No | Company Name                        | Weblink                               |");
            System.out.println("======================================================================================");
            int serial1 = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                String companyName = data[0];
                String Weblink = data[1];
                serial1++;
                System.out.printf("| %-4d | %-35s | %-37s |%n",
                        serial1, companyName, Weblink);
            System.out.println("--------------------------------------------------------------------------------------");
                JobProviderList.add(serial1 + "," + companyName + "," + Weblink);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
        return JobProviderList;
    }



    public boolean delete(int serial, List<String> JobProviderList) {
        List<String> JobProviderInfo = new ArrayList<>();
        boolean dataDeleted = false;
        for (String JobProvider : JobProviderList) {
            String[] data = JobProvider.split(",");
            int serial1 = Integer.parseInt(data[0]);
            String companyName = data[1];
            String Weblink = data[2];
            if (serial == serial1) {
                dataDeleted = true;
            } else {
                JobProviderInfo.add(companyName + "," + Weblink);
            }
        }
        if (dataDeleted) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("JobProvider_info.txt"))) {
                for (String jobprovider : JobProviderInfo) {
                    writer.write(jobprovider);
                    writer.newLine();
                    writer.flush();
                }
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }



    public List<String> ViewApplicantInformation() {
        List<String> ApplicantList = new ArrayList<>();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "Applicant_info.txt"))) {
            System.out.println("=====================================================================================================");
            System.out.println("| S.No | Name                           | National ID          | Email                               |");
            System.out.println("=====================================================================================================");
            int applicantSerial = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                String Name = data[0];
                String NID = data[9];
                String Email = data[10];
                applicantSerial++;
                System.out.printf("| %-4d | %-30s | %-20s | %-35s |%n",
                        applicantSerial, Name, NID, Email);
                System.out.println("-----------------------------------------------------------------------------------------------------");
                ApplicantList.add(applicantSerial + "," + Name + "," + NID + "," + Email);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
        return ApplicantList;
    }



    public boolean deleteApplicant(int serial,List<String> ApplicantList) {
        List<String> ApplicantInfo = new ArrayList<>();
        boolean applicantDeleted = false;
        for(String Applicant : ApplicantList) {
            String[] data = Applicant.split(",");
            int applicantSerial= Integer.parseInt(data[0]);
            String Name = data[1];
            String FatherName = data[2];
            String MotherName = data[3];
            String DateOfBirth = data[4];
            String Nationality = data[5];
            String Religion = data[6];
            String Gender = data[7];
            String PhoneNumber = data[8];
            String Address = data[9];
            String NID = data[10];
            String Email = data[11];
            String SchoolName = data[12];
            String PassingYearSSC= data[13];
            String SSCResult = data[14];
            String CollegeName = data[15];
            String PassingYearHSC= data[16];
            String HSCResult = data[17];
            String UniversityName = data[18];
            String DepartmentName = data[19];
            String UnderGraduateDegree = data[20];
            String UnderGraduateCGPA = data[21];
            String PostGraduateDegree = data[22];
            String PostGraduateCGPA = data[23];
            String ExtraInformation = data[24];
            String Experience = data[25];
            String Hobby = data[26];
            String Skills = data[27];
            String status =  (data.length > 28) ? data[28] : "Not Verified";
           if(serial==applicantSerial){
               applicantDeleted=true;
           }
           else{
               if ("Verified".equals(status)) {
                   ApplicantInfo.add(Name +","+ FatherName + "," + MotherName + "," + DateOfBirth + "," + Nationality + "," + Religion + "," + Gender + "," + PhoneNumber + "," + Address + "," + NID + "," + Email + "," + SchoolName + "," + PassingYearSSC + "," + SSCResult + "," + CollegeName + "," + PassingYearHSC + "," + HSCResult + "," + UniversityName + "," + DepartmentName + "," + UnderGraduateDegree + "," + UnderGraduateCGPA + "," + PostGraduateDegree + "," + PostGraduateCGPA + "," + ExtraInformation + "," + Experience + "," + Hobby + "," + Skills + "," + "Verified");
               } else {
                   ApplicantInfo.add(Name +","+ FatherName + "," + MotherName + "," + DateOfBirth + "," + Nationality + "," + Religion + "," + Gender + "," + PhoneNumber + "," + Address + "," + NID + "," + Email + "," + SchoolName + "," + PassingYearSSC + "," + SSCResult + "," + CollegeName + "," + PassingYearHSC + "," + HSCResult + "," + UniversityName + "," + DepartmentName + "," + UnderGraduateDegree + "," + UnderGraduateCGPA + "," + PostGraduateDegree + "," + PostGraduateCGPA + "," + ExtraInformation + "," + Experience + "," + Hobby + "," + Skills + "," + "Not Verified");
               }
           }
        }
        if (applicantDeleted) {
            try (BufferedWriter writer7 = new BufferedWriter(new FileWriter("Applicant_info.txt"))) {
                for (String applicant : ApplicantInfo) {
                    writer7.write(applicant);
                    writer7.newLine();
                    writer7.flush();
                } writer7.close();
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public List<String> viewNewJobProviderRequests(){
        List<String> JobProviderRequestList = new ArrayList<>();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "JobProviderRequest.txt"))) {
            System.out.println("======================================================================================================");
            System.out.println("| S.No | Name                          | Web Address                                 | Role          |");
            System.out.println("======================================================================================================");
            int serial27=0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                String companyName = data[4];
                String webAddress = data[5];
                String role = data[3];
                serial27++;
                System.out.printf("| %-4d | %-29s | %-37s | %-13s |%n",
                        serial27, companyName, webAddress, role);
                JobProviderRequestList.add(serial27+","+line);
            System.out.println("=====================================================================================================");
            }
        } catch (IOException e) {
            System.err.println("Error reading file" + e.getMessage());
            e.printStackTrace();
        }
        return  JobProviderRequestList;
    }
    public boolean approveJobProvider(int Serial,List<String> JobProviderRequestList) {
        List<String> approvedJobProviders = new ArrayList<>();
        boolean approvedJobProvider = false;
        for(String JobProviderRequest : JobProviderRequestList) {
            String[] data = JobProviderRequest.split(",");
            int serial27= Integer.parseInt(data[0]);
            String userName1 = data[1];
            String password1 = data[2];
            String email1 = data[3];
            String role1 = data[4];
            String companyName=data[5];
            String webAddress=data[6];
            if (Serial==serial27) {
                approvedJobProviders.add(userName1 + "," + password1 + "," + email1+ "," + role1 + "," + companyName + "," + webAddress);
                approvedJobProvider = true;
            }
        }
        if (approvedJobProvider) {
            try (BufferedWriter writer8 = new BufferedWriter(new FileWriter("User_info.txt", true))) {
                for (String jobProvider : approvedJobProviders) {
                    writer8.newLine();
                    writer8.write(jobProvider);
                    writer8.flush();
                }
                this.deleteJobProviderRequest(Serial,JobProviderRequestList);
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } return false;
    }


    public boolean deleteJobProviderRequest(int serial3,List<String> JobProviderRequestList) {
        List<String> approvedJobProviders = new ArrayList<>();
        boolean jobproviderRequestDeleted = false;
        for(String JobProviderRequest : JobProviderRequestList) {
            String[] data = JobProviderRequest.split(",");
            int serial27= Integer.parseInt(data[0]);
            String userName = data[1];
            String password = data[2];
            String email = data[3];
            String role = data[4];
            String companyName=data[5];
            String webAddress=data[6];
            if (!(serial3==serial27)||jobproviderRequestDeleted) {
                approvedJobProviders.add(userName + "," + password + "," + email+ "," + role + "," + companyName + "," + webAddress );
            } else {
                jobproviderRequestDeleted = true;
            }
        }
        if (jobproviderRequestDeleted) {
            try (BufferedWriter writer47 = new BufferedWriter(new FileWriter("JobProviderRequest.txt"))) {
                for (String approvedJobProvider: approvedJobProviders) {
                    writer47.write(approvedJobProvider);
                    writer47.newLine();
                    writer47.flush();
                } writer47.close();
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }


    public List<String> viewApplicantRequests(){
        List<String> ApplicantRequestList = new ArrayList<>();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "ApplicantRequest.txt"))) {
            System.out.println("================================================================================================");
            System.out.println("| S.No | Name                          | Email                                 | Role          |");
            System.out.println("================================================================================================");
            int serial28=0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                String userName = data[0];
                String email = data[2];
                String role = data[3];
                serial28++;
                System.out.printf("| %-4d | %-29s | %-37s | %-13s |%n",
                        serial28, userName, email, role);
                ApplicantRequestList.add(serial28+","+line);
            System.out.println("================================================================================================");
            }
        } catch (IOException e) {
            System.err.println("Error reading file" + e.getMessage());
            e.printStackTrace();
        }
        return  ApplicantRequestList;
    }

    public boolean approveApplicant(int Serial,List<String> ApplicantRequestList) {
        List<String> approvedApplicants = new ArrayList<>();
        boolean approvedApplicant = false;
        for(String ApplicantRequest : ApplicantRequestList) {
            String[] data = ApplicantRequest.split(",");
            int serial28= Integer.parseInt(data[0]);
            String userName1 = data[1];
            String password1 = data[2];
            String email1 = data[3];
            String role1 = data[4];
            if (Serial==serial28) {
                approvedApplicants.add(userName1 + "," + password1 + "," + email1+ "," + role1 );
                approvedApplicant = true;
            }
        }
        if (approvedApplicant) {
            try (BufferedWriter writer9 = new BufferedWriter(new FileWriter("User_info.txt", true))) {
                for (String Applicant : approvedApplicants) {
                    writer9.newLine();
                    writer9.write(Applicant);
                    writer9.flush();
                }
                this.deleteApplicantRequest(Serial,ApplicantRequestList);
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } return false;
    }
    public boolean deleteApplicantRequest(int serial3,List<String> ApplicantRequestList) {
        List<String> approvedApplicants = new ArrayList<>();
        boolean ApplicantRequestDeleted = false;
        for(String JobProviderRequest : ApplicantRequestList) {
            String[] data = JobProviderRequest.split(",");
            int serial28= Integer.parseInt(data[0]);
            String userName = data[1];
            String password = data[2];
            String email = data[3];
            String role = data[4];
            if (!(serial3==serial28)||ApplicantRequestDeleted) {
                approvedApplicants.add(userName + "," + password + "," + email+ "," + role );
            } else {
                ApplicantRequestDeleted = true;
            }
        }
        if (ApplicantRequestDeleted) {
            try (BufferedWriter writer48 = new BufferedWriter(new FileWriter("ApplicantRequest.txt"))) {
                for (String approvedApplicant: approvedApplicants) {
                    writer48.write(approvedApplicant);
                    writer48.newLine();
                    writer48.flush();
                } writer48.close();
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
    public boolean processMultipleJobProviderRequests(List<Integer> serialNumbers, boolean approve, List<String> JobProviderRequestList) {
        List<String> processedJobProviders = new ArrayList<>();
        List<String> remainingJobProviders = new ArrayList<>();
        boolean processed = false;

        for (String jobProviderRequest : JobProviderRequestList) {
            String[] data = jobProviderRequest.split(",");
            int serial = Integer.parseInt(data[0]);

            if (serialNumbers.contains(serial)) {
                if (approve) {
                    processedJobProviders.add(String.join(",", Arrays.copyOfRange(data, 1, data.length)));
                }
                processed = true;
            } else {
                // FIX: Exclude serial when adding to remainingJobProviders
                String remainingData = String.join(",", Arrays.copyOfRange(data, 1, data.length));
                remainingJobProviders.add(remainingData);
            }
        }

        if (processed) {
            if (approve) {
                try (BufferedWriter multiplewriter = new BufferedWriter(new FileWriter("User_info.txt", true))) {
                    for (String jobProvider : processedJobProviders) {
                        multiplewriter.write(jobProvider.trim());
                        multiplewriter.newLine();
                    }
                    multiplewriter.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            try (BufferedWriter writer23 = new BufferedWriter(new FileWriter("JobProviderRequest.txt"))) {
                for (String remainingJobProvider : remainingJobProviders) {
                    writer23.write(remainingJobProvider.trim());
                    writer23.newLine();
                }
                writer23.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return true;
        }

        return false;
    }

    public boolean processMultipleApplicantRequests(List<Integer> serialNumbers, boolean approve, List<String> ApplicantRequestList) {
        List<String> processedApplicants = new ArrayList<>();
        List<String> remainingApplicants = new ArrayList<>();
        boolean processed = false;

        for (String applicantRequest : ApplicantRequestList) {
            String[] data = applicantRequest.split(",");
            int serial = Integer.parseInt(data[0]);

            if (serialNumbers.contains(serial)) {
                if (approve) {
                    // Exclude serial number when approving
                    processedApplicants.add(String.join(",", Arrays.copyOfRange(data, 1, data.length)));
                }
                processed = true;
            } else {
                // Exclude serial number from remaining applicants
                String remainingData = String.join(",", Arrays.copyOfRange(data, 1, data.length));
                remainingApplicants.add(remainingData);
            }
        }

        if (processed) {
            if (approve) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("User_info.txt", true))) {
                    for (String applicant : processedApplicants) {
                        writer.write(applicant.trim()); // Ensure no unnecessary spaces
                        writer.newLine();
                    }
                    writer.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            // Write updated remaining applicants to "ApplicantRequest.txt"
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("ApplicantRequest.txt"))) {
                for (String remainingApplicant : remainingApplicants) {
                    writer.write(remainingApplicant.trim());
                    writer.newLine();
                }
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return true;
        }

        return false;
    }





}

