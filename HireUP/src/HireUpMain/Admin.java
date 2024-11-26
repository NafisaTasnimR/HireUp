package HireUpMain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public String getEmail() {
        return super.getEmail();
    }

    public String getRole() {
        return super.getRole();
    }

    public List<String> ViewInformation() {
        List<String> JobProviderList = new ArrayList<>();
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "JobProvider_info.txt"))) {
            System.out.println("Job Provider Information:");
            int serial1 =0;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                String companyName = data[0];
                String Weblink = data[1];
                if (companyName.equals(companyName)) {
                    serial1++;
                    System.out.println(serial1 +"."+" "+ "Company Name:" + companyName + " " + "Weblink:" + Weblink + '\n');
                    JobProviderList.add(serial1+","+line);
                } else {
                    System.out.println("Invalid Data:" + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file" + e.getMessage());
            e.printStackTrace();
        }
        return JobProviderList;
    }


    public boolean verify(int serial,List<String> JobProviderList) {
        String line = "";
        List<String> VerifiedCompanies = new ArrayList<>();
        boolean verifiedCompany = false;

        for(String JobProvider : JobProviderList) {
            String[] data = JobProvider.split(",");
            int serial1= Integer.parseInt(data[0]);
            String companyName = data[1];
            String Weblink = data[2];
            if (serial==serial1) {
                VerifiedCompanies.add(companyName + "," + Weblink);
                verifiedCompany = true;
            }

        }

        if (verifiedCompany) {
            try (BufferedWriter writer2 = new BufferedWriter(new FileWriter("VerifiedCompanies.txt", true))) {
                for (String company : VerifiedCompanies) {
                    writer2.newLine();
                    writer2.write(company);
                    writer2.flush();
                    writer2.close();

                }
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }


    public boolean delete(int serial,List<String> JobProviderList) {
        String line ;
        List<String> JobProviderInfo = new ArrayList<>();

        boolean dataDeleted = false;

        for(String JobProvider : JobProviderList) {
            String[] data = JobProvider.split(",");
            int serial1= Integer.parseInt(data[0]);
            String companyName = data[1];
            String Weblink = data[2];
            if (!(serial ==serial1) || dataDeleted) {
                JobProviderInfo.add(companyName +","+ Weblink);
            } else {
                dataDeleted = true;
            }
        }
        if (dataDeleted) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("JobProvider_info.txt"))) {
                for (String jobprovider : JobProviderInfo) {
                    writer.write(jobprovider);
                    writer.newLine();
                    writer.flush();
                } writer.close();
                return true;

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public boolean viewAdminRequest(){
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "AdminRequest.txt"))) {
            System.out.println("Admin Requests:");
            int serial=0;
            boolean foundRequest = false;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");

                    String userName = data[0];
                    String email = data[1];
                    String role = data[2];
                    if(userName.equals(data[0])){
                        serial++;
                        System.out.println(serial +"."+" "+ "Username:"+ userName + " " + "Email:" + email + " "+"Role:"+role+'\n');

                    foundRequest = true;
                } else {
                    System.out.println("Invalid Data:" + line);
                }
            } return foundRequest;
        } catch (IOException e) {
            System.err.println("Error reading file" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }


    public boolean approve(String Email1) {
        String line;
        List<String> approvedAdmins = new ArrayList<>();
        boolean approvedAdmin = false;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "AdminRequest.txt"))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String userName = data[0];
                    String email = data[1];
                    String role = data[2];
                    if (email.equals(Email1)) {
                       approvedAdmins.add(userName + "," + email+ "," + role );
                        approvedAdmin = true;
                    }

                } else {
                    System.out.println("Invalid Data:" + line);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file" + e.getMessage());
            e.printStackTrace();
        }
        if (approvedAdmin) {
            try (BufferedWriter writer3 = new BufferedWriter(new FileWriter("Registration_info.txt", true))) {
                for (String admin : approvedAdmins) {
                    writer3.newLine();
                    writer3.write(admin);
                    writer3.flush();
                } writer3.close();
                this.deleteRequest(Email1);
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } this.deleteRequest(Email1);
        return false;
    }


    public boolean deleteRequest(String Email) {
        String line;
        List<String> approvedAdmins = new ArrayList<>();
        boolean requestDeleted = false;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "AdminRequest.txt" ))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String userName = data[0];
                    String email = data[1];
                    String role = data[2];
                    if (!email.equals(Email) || requestDeleted) {
                        approvedAdmins.add(userName +","+ email+ "," + role);
                    } else {
                        requestDeleted = true;
                    }
                } else {
                    System.out.println("Invalid Data:" + line);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Error reading file" + e.getMessage());
            e.printStackTrace();
        }
        if (requestDeleted) {
            try (BufferedWriter writer4 = new BufferedWriter(new FileWriter("AdminRequest.txt"))) {
                for (String approvedAdmin: approvedAdmins) {
                    writer4.write(approvedAdmin);
                    writer4.newLine();
                    writer4.flush();
                } writer4.close();
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

}

