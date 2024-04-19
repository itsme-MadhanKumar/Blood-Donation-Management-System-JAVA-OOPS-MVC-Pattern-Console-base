package Controller;
import Model.UserDAO;
import Resource.UserDTO;
import View.Sign_Page;
import View.User_View;
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
            User_View.displayErrorValidation();
            return false;
        }
    }
    public static boolean sighup(UserDTO Main_obj)
    {
        Sign_Page.signup_page(Main_obj);
        boolean flag1 = UserDAO.isuserAlredyExist(Main_obj);
        if(flag1)
        {
           User_View.displayUserAlready();
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
        return email1.equals(email2) && pass1.equals(pass2);
    }
}

