package HireUpMain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Admin extends User {


    public Admin(String userName, String password, String email, String role) {
        super(userName, password, email, role);

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

    public boolean ViewInformation() {
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "JobProvider_info.txt"))) {
            System.out.println("Job Provider Information:");
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String companyName = data[0];
                    String Weblink = data[1];
                    System.out.println("Company Name: " + companyName);
                    System.out.println("Weblink: " + Weblink);
                    return true;
                } else {
                    System.out.println("Invalid Data:" + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }


    public boolean verify(String webAddress2) {
        String line;
        List<String> VerifiedCompanies = new ArrayList<>();
        boolean verifiedCompany = false;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "JobProvider_info.txt"))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String companyName = data[0];
                    String Weblink = data[1];
                    if (Weblink.equals(webAddress2)) {
                        VerifiedCompanies.add(companyName + "," + Weblink);
                        verifiedCompany = true;
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
        if (verifiedCompany) {
            try (BufferedWriter writer2 = new BufferedWriter(new FileWriter("VerifiedCompanies.txt", true))) {
                for (String company : VerifiedCompanies) {
                    writer2.write(company);

                }
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }


    public boolean delete(String webAddress) {
        String line;
        List<String> JobProviderInfo = new ArrayList<>();
        boolean dataDeleted = false;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "JobProvider_info.txt"))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String companyName = data[0];
                    String Weblink = data[1];
                    if (!Weblink.equals(webAddress) || dataDeleted) {
                        JobProviderInfo.add(companyName + "," + Weblink);
                    } else {
                        dataDeleted = true;
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
        if (dataDeleted) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("JobProvider_info.txt"))) {
                for (String jobprovider : JobProviderInfo) {
                    writer.write(jobprovider);
                    writer.newLine();
                }
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
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String userName = data[0];
                    String email = data[1];
                    String role = data[2];
                    System.out.println("Name: " + userName);
                    System.out.println("Email: " + email);
                    System.out.println("Role: " + role);
                    return true;
                } else {
                    System.out.println("Invalid Data:" + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }


    public boolean approve(String UserName) {
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
                    if (userName.equals(UserName)) {
                       approvedAdmins.add(userName + "," + email+ "," + role );
                        approvedAdmin = true;
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
        if (approvedAdmin) {
            try (BufferedWriter writer3 = new BufferedWriter(new FileWriter("Registration_info.txt", true))) {
                for (String admin : approvedAdmins) {
                    writer3.write(admin);

                }
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public boolean reject(String UserName1) {
        String line;
        List<String> approvedAdmins = new ArrayList<>();
        boolean requestDeleted = false;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "AdminRequest.txt"))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String userName = data[0];
                    String email = data[1];
                    String role = data[2];
                    if (!userName.equals(UserName1) || requestDeleted) {
                        approvedAdmins.add(userName + "," + email+ "," + role);
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
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("AdminRequest.txt"))) {
                for (String approvedAdmin: approvedAdmins) {
                    writer.write(approvedAdmin);

                }
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

}