package HireUpMain;
import java.util.regex.Pattern;
public  class Utility {
    public static String formatData(String s)
    {
        int length = s.length();
        char firstChar = 0;
        if(s.charAt(0) >= 'a' && s.charAt(0) <= 'z') {
            firstChar = (char) ((s.charAt(0) - 'a') + 'A');
        }
        else {
            firstChar = s.charAt(0);
        }
        String secondPartOfString = "";
        for(int i=1; i<length; i++)
        {
            if(s.charAt(i-1) != ' ' && s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                char toLowerCaseChar = (char)((s.charAt(i) - 'A')+'a');
                secondPartOfString = secondPartOfString + toLowerCaseChar;
            }
            else if(s.charAt(i-1) == ' ' && s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
            {
                char toUpperCaseChar = (char)((s.charAt(i) - 'a')+'A');
                secondPartOfString = secondPartOfString + toUpperCaseChar;
            }
            else {
                secondPartOfString = secondPartOfString + s.charAt(i);
            }
        }
        String modifiedFormat = firstChar + secondPartOfString;
        return modifiedFormat;
    }

    public static void updateConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing the console.");
        }
    }

    public static boolean isValidEmail(String email){
        String emailRegex = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$";
        return Pattern.matches(emailRegex, email);

    }

    public static boolean isValidPassword(String password){
        String passwordRegex = "^(?=.*[A-Z])(?=.*[!@#$%^&*])(?=.*[a-zA-Z0-9]).{8,}$";
        return Pattern.matches(passwordRegex, password);
    }

    public static boolean isValidPhoneNumber(String phoneNumber){
        String phoneNumberRegex = "^(\\+8801|01)[3-9]\\d{8}$";
        return Pattern.matches(phoneNumberRegex, phoneNumber);
    }

    public static String extractYear(String experience)
    {
        return null;
    }

}
