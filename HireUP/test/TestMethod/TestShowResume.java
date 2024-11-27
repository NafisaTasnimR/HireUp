package TestMethod;

import HireUpMain.Resume;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;

public class TestShowResume {
    public static void main(String[] args) {
 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("\\HireUp\\HireUp\\HireUP\\Applicant_info.txt", true))) {
            writer.write("mira,jack,mita,2003,bangladeshi,islam,female,12345,dhaka,577697,mira.com,lps,2019,5,rajuk,2022,5,iut,cse,bsc,3.7,msc,3.5,5year,coding,java \n");
        } catch (IOException e) {
            System.out.println("Error creating test file: " + e.getMessage());
            return;
        }

        Resume resume = new Resume();
        resume.showResume("mira.com");

    }
}
