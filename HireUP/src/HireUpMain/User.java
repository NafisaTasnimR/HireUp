package HireUpMain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class User {
    private String userName;
    private String password;
    private String email;
    private String role;

    public User(String userName, String password, String email, String role) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public boolean logIn() {
        try (BufferedReader br = new BufferedReader(new FileReader(
                "LogIn_Info.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String name = data[0];
                    String pass = data[1];
                    String mail = data[2];
                    String role = data[3];
                    if (Objects.equals(this.getUserName(), name) && Objects.equals(this.getPassword(), pass) && Objects.equals(this.getEmail(), mail) && Objects.equals(this.getRole(), role)) {
                        System.out.println("Welcome," + data[0] + "!");
                        return true;
                    }
                } else {
                    System.out.println("Invalid data format.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error in file reading.");
            e.printStackTrace();
        }
        return false;
    }
}
