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

    public boolean verify() {
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "JobProvider_info.txt"))) {
            System.out.println("Job Provider Information:");
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String Company_Name = data[0];
                    String Weblink = data[1];
                    System.out.println("Company Name: " + Company_Name);
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
                        if(!Weblink.equals(webAddress) || dataDeleted) {
                            JobProviderInfo.add(companyName + "," + Weblink);

                        } else{
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

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("JobProvider_info.txt"))){
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

}