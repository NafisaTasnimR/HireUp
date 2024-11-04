package HireUpMain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
                "HireUP\\Job_Provider_Info.txt"))) {
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

    public boolean verify() {
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "HireUP\\Job_Provider_Info.txt"))) {
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
    public void delete(String webAddress) {
            String line;
            List<String> JobProviderInfo = new ArrayList<>();


            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
                    "HireUP\\Job_Provider_Info.txt"))) {
                System.out.println("Job Provider Information:");
                while ((line = bufferedReader.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 2) {
                        String Company_Name = data[0];
                        String Weblink = data[1];
                        if(data[1]!=webAddress){
                            JobProviderInfo.add(line);

                        }

                    } else {
                        System.out.println("Invalid Data:" + line);

                    }

                }
            } catch (IOException e) {
                System.err.println("Error reading file" + e.getMessage());
                e.printStackTrace();
            }

            try {
                FileWriter fileWriter = new FileWriter("HireUP\\Job_Provider_Info.txt");
                for(String jobprovider: JobProviderInfo ){
                    fileWriter.write(jobprovider);
                    fileWriter.write("\n");
                    fileWriter.close();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }





}