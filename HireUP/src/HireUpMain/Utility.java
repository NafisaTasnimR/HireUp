package HireUpMain;

public class Utility {
    public static String formatData(String s)
    {
        int length = s.length();
        char firstChar = (char) ((s.charAt(0) - 'a')+'A');
        String secondPartOfString = "";
        for(int i=1; i<length; i++)
        {
            secondPartOfString = secondPartOfString + s.charAt(i);
        }
        String modifiedFormat = firstChar + secondPartOfString;
        return modifiedFormat;
    }
}
