package View;
import Util.Input;
public class Welcome_Page
{
    public static int welcome_start()
    {
        while (true)
        {
            System.out.println(" ".repeat(45)+"Press 1 : Sign in");
            System.out.println(" ".repeat(45)+"Press 2 : Sign up");
            System.out.println(" ".repeat(45)+"Press 3 : Exit ");
            System.out.print("Enter your Choice : ");
            int n;
            try
            {
                n = Input.getInt();
                if(n>=1 && n<=3)
                    return n;
                else
                    System.out.println("Enter a Valid Number");
            }
            catch (Exception e)
            {
                System.out.println("Invalid Format - Enter a Valid Number");
                Input.getStringLine();
            }
        }

    }
}
