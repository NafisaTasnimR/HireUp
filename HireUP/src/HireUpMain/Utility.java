package HireUpMain;

public class Utility {
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
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                char toLowerCaseChar = (char)((s.charAt(i) - 'A')+'a');
                secondPartOfString = secondPartOfString + toLowerCaseChar;
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
}
