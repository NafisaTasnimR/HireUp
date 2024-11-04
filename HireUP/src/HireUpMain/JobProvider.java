package HireUpMain;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JobProvider {
    private String companyName;
    private String webAddress;

    public JobProvider(String companyname,String webaddress)
    {
        this.companyName = companyname;
        this.webAddress = webaddress;
    }

    public String getCompanyName()
    {
        return companyName;
    }
    public String getWebAddress()
    {
        return webAddress;
    }
    //getter setter
    public boolean registrationJobProvider() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("JobProvider_info.txt", true))) {
            writer.write(this.getCompanyName() + "," + this.getWebAddress());
            writer.newLine();
            System.out.println("Data has been written to file!");
            return true;
        } catch (IOException e) {
            System.err.println(" Error writing to file : " + e.getMessage());
        }
        return false;
    }

}
