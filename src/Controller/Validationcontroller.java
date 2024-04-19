package Controller;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validationcontroller
{
    public static boolean verify(String email)
    {
        return email.contains("@gmail.com");
    }
    public static boolean verifyPassword(String pass)
    {
        int dig = 0;int low = 0;int up = 0;int sym = 0;
        char[] arr = pass.toCharArray();
        for (char c : arr) {
            if (Character.isDigit(c))
            {
                dig = 1;
            } else if (Character.isLowerCase(c)) {
                low = 1;
            } else if (Character.isUpperCase(c)) {
                up = 1;
            } else {
                sym = 1;
            }
        }
        return low == 1 && up == 1 && dig == 1 && sym == 1;
    }
    public static boolean verifyPhone(String phone)
    {
        int count = 0;
        if(phone.length()!=10)
        {
            return false;
        }
        else
        {
            for(int i =0;i<phone.length();i++)
            {
                if(Character.isDigit(phone.charAt(i)))
                {
                    count++;
                }
            }
        }
        return count == 10;
    }
    public static boolean verifyDate(String date)
    {
        if(date.equals("---") || date.isEmpty())
        {
            return true;
        }
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
}
