package Controller;
import Model.UserDAO;
import Resource.UserDTO;
import View.Sign_Page;
import View.User_View;
import java.sql.SQLException;
public class Accesscontroller
{
    public static boolean signin(UserDTO obj)
    {
       // UserDTO obj = Sign_Page.signin_page();
        boolean flag = UserDAO.isUser(obj);
        if(flag)
        {
            return true;
        }
        else
        {
            System.out.println("Invalid Mail and Passwords");
            return false;
        }
    }
    public static boolean sighup(UserDTO Main_obj) throws SQLException
    {
        Sign_Page.signup_page(Main_obj);
        boolean flag1 = UserDAO.isuserAlredyExist(Main_obj);
        if(flag1)
        {
            System.out.println("User Already Exists");
            return false;
        }
        else
        {
            // validation part
            return true;
        }
    }
    public static boolean check(String email1,String email2,String pass1,String pass2)
    {
        if(email1.equals(email2) && pass1.equals(pass2))
        {
            return true;
        }
        return false;
    }
}

