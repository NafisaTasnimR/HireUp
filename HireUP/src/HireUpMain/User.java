package HireUpMain;

import java.io.*;
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

    public User() {

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
                "User_Info.txt"))) {
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

    public boolean registration(User user) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("User_info.txt", true))) {
                bufferedWriter.newLine();
                bufferedWriter.write(user.getUserName() + "," +
                        user.getPassword() + "," + user.getEmail() +
                        "," + user.getRole());
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            System.err.println("Error in file writing." + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean adminRegistrationRequest(User user) {
        try (BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter("AdminRequest.txt", true))) {
            bufferedWriter1.newLine();
            bufferedWriter1.write(user.getUserName() + "," + user.getPassword() + "," +user.getEmail() +
                    "," + user.getRole());
            bufferedWriter1.flush();
            bufferedWriter1.close();
            return true;
        } catch (IOException e) {
            System.err.println("Error in file writing." + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static Object userObject(String password, String email, String role) {
        try (BufferedReader reader = new BufferedReader(new FileReader("User_info.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String username = parts[0];
                    String Password = parts[1];
                    String Email = parts[2];
                    String Role = parts[3];

                    if (Password.equals(password) && Email.equals(email) && Role.equals(role)) {
                        return new User(username, password, Email, Role);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return null;
    }



}
