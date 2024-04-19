package Controller;
import Model.EmailDAO;
import Resource.UserDTO;
import View.User_View;
import java.util.ArrayList;
import Model.UserDAO;
import View.Sign_Page;
public class Usercontroller
{
    public static void user_start(UserDTO obj)
    {
        while (true)
        {
            int num = User_View.user_input();
            if(num==1)
            {
                // display all persome of user blood type
                String bloodtype = Sign_Page.getBloodType();
                ArrayList<ArrayList<String>> list = UserDAO.getBloodDonar(bloodtype,obj.getMailid());
                if(list.isEmpty())
                {
                    User_View.displayNoDonor();
                }
                else
                {
                    User_View.display1(list);
                }
            }
            else if(num==2)
            {
            // search donor by district
                User_View.displayBloodEnter();
                String blood_type = Sign_Page.getBloodType();
                String district = Sign_Page.getDistrict();
                ArrayList<ArrayList<String>> list = UserDAO.getBloodDonarByDistrict(blood_type,district,obj.getMailid());
                if(list.isEmpty())
                {
                   User_View.displayNoDonor();
                }
                else
                {
                    User_View.display1(list);
                }
            }
            else if(num==3)
            {
                //View by Donor Recent Blood Donate Location
                User_View.displayBloodEnter();
                String blood_type = Sign_Page.getBloodType();
              //  System.out.println(" ".repeat(45)+"Enter District that Donor May Donated in Your Location");
                String district = Sign_Page.getDistrict();
                ArrayList<ArrayList<String>> list = UserDAO.getBloodDonarByRecent(blood_type,district,obj.getMailid());
                if(list.isEmpty())
                {
                   User_View.displayNoDonor();
                }
                else
                {
                    User_View.display1(list);
                }
            }
            else if(num==4)
            {
                String email1 = obj.getMailid();
                String password1 = obj.getPassword();
                UserDTO obj2 = User_View.getRecentUpdateDetails();
                String email2 = obj2.getMailid();
                String password2 = obj2.getPassword();
                boolean flag1 = Accesscontroller.check(email1,email2,password1,password2);
                if(flag1)
                {
                    Sign_Page.firstLogin1(obj);
                    boolean flag = UserDAO.updaterecentLocation(obj);
                    if(flag)
                    {
                       User_View.Inseted();
                        System.out.println("Email : "+obj.getMailid());
                    }
                    else
                    {
                      User_View.notInserted();
                    }
                }
                else
                {
                    obj.setMailid(email1);
                    obj.setPassword(password1);
                  User_View.displayErrorValidation();
                }

            }
            else if(num==5)
            {
                // update current location
                String email1 = obj.getMailid();
                String password1 = obj.getPassword();
                UserDTO obj2 = User_View.getRecentUpdateDetails();
                String email2 = obj2.getMailid();
                String password2 = obj2.getPassword();
                boolean flag1 = Accesscontroller.check(email1,email2,password1,password2);
                if(flag1)
                {
                    String new_location = Sign_Page.getDistrict();
                    boolean flag2 = UserDAO.updatingnewLocation(new_location,obj);
                    if(flag2)
                    {
                       User_View.newLocation();
                    }
                }
                else
                {
                    obj.setMailid(email1);
                    obj.setPassword(password1);
                    User_View.displayErrorValidation();
                }
            }
            else if(num==6)
            {
                String emailid = User_View.EnterEmail();
                boolean flag1 = UserDAO.checkDatabase(emailid);
                if(flag1)
                {
                    String msg = User_View.EnterMessage();
                    boolean flag = EmailDAO.sendEmail(obj,msg,emailid);
                    if(flag)
                    {
                      User_View.msgsent();
                    }

                }
                else
                {
                    User_View.notfound();
                }
            }
            else if(num==7)
            {
                return;
            }
        }

    }
}
