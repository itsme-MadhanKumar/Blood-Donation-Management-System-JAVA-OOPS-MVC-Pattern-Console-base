package Controller;
import Model.UserDAO;
import Resource.UserDTO;
import View.Sign_Page;
import View.User_View;
import View.Welcome_Page;
public class maincontroller
{
    public static void start()
    {
        while (true)
        {

            int num = Welcome_Page.welcome_start();
            if(num==1)
            {
                UserDTO obj = Sign_Page.signin_page();
                boolean flag = Accesscontroller.signin(obj);
                if(flag)
                {
                    Usercontroller.user_start(obj);
                }
            }
            else if(num==2)
            {
                UserDTO Main_obj = new UserDTO();
                boolean flag = Accesscontroller.sighup(Main_obj);
                if(flag)
                {
                    int num1 = Sign_Page.isalreayDonated();
                    if(num1==1)
                    {
                        Sign_Page.firstLogin(Main_obj);
                        int n = User_View.run(Main_obj);
                        if(n==100)
                        {
                            boolean flag1 = UserDAO.insertUserDetails(Main_obj);
                            boolean flag2 = UserDAO.insertrecentStatus(Main_obj);
                            // remove
                            if (flag2 && flag1)
                            {
                               User_View.displaySuccess();
                            }

                        }
                        else
                        {
                          User_View.displaywentwrong();
                        }
                    }
                    else
                    {
                        int n = User_View.run(Main_obj);
                        if(n==100)
                        {
                            boolean flag1 = UserDAO.insertUserDetails(Main_obj);
                            boolean flag2 = UserDAO.insertrecentStatus(Main_obj);
                            if(flag2 && flag1)
                            {
                               User_View.displaysuccess1();
                            }
                        }
                        else
                        {
                           User_View.displaywentwrong();
                        }
                    }
                }
            }
            else
            {
              User_View.displayWish();
                System.exit(0);
            }
        }
    }
}
