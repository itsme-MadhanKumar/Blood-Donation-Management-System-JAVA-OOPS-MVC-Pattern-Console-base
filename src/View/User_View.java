package View;
import Controller.Validationcontroller;
import Resource.UserDTO;
import Util.Input;

import java.util.ArrayList;

public class User_View
{
    public static int user_input()
    {
        System.out.println(" ".repeat(45)+"---------------- Logged in Successful ---------------");
        while(true)
        {
            System.out.println(" ".repeat(45)+"Press 1 : Search Blood Donor");
            System.out.println(" ".repeat(45)+"Press 2 : Search Blood Donor Near Your Location📍");
            System.out.println(" ".repeat(45)+"Press 3 : View by Donor Recent Blood Donate Location 📍");
            System.out.println(" ".repeat(45)+"Press 4 : To Update Your Blood Donate History [Needs Authentication]");
            System.out.println(" ".repeat(45)+"Press 5 : To Update Your Current Location [Needs Authentication]");
            System.out.println(" ".repeat(45)+"Press 6 : Send Mail to Donor [Needs Mail Id]");
            System.out.println(" ".repeat(45)+"Press 7 : Log out ✅");
            System.out.print("Enter your choice : ");
            int n;
            try
            {
                n = Input.getInt();
                if(n>=1 && n<=7)
                {
                    return n;
                }
                else
                {
                    System.out.println("Enter a Valid Option");
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                Input.getStringLine();
            }
        }
    }
    public static int run(UserDTO obj)
    {
        System.out.println(" ".repeat(45)+"-".repeat(75));
        System.out.printf(" ".repeat(45)+"|%-20s|%-30s|%-20s|%n",
                "Subjects", "Given Details", "Mobile");
        System.out.println(" ".repeat(45)+"-".repeat(75));
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;
        for (int j = 0; j < 100; j++)
        {
            if(j==5)
            {
                System.out.printf(" ".repeat(45)+"|%-20s|%-30s|%-20s|%n","User Name :",obj.getUsername(),"VERIFIED✅");
            }
            if(j==10)
            {
                boolean checkemail = Validationcontroller.verify(obj.getMailid());
                if(checkemail)
                {
                    System.out.printf(" ".repeat(45)+"|%-20s|%-30s|%-20s|%n","Email Id :",obj.getMailid(),"VERIFIED✅");
                   // System.out.println();
                    c1=1;
                }
                else
                {
                    System.out.printf(" ".repeat(45)+"|%-20s|%-30s|%-20s|%n","Email Id : ",obj.getMailid(),"NOT VERIFIED❌");
                    //System.out.println();
                }
            }
            else if(j==25)
            {
                boolean checkpassword = Validationcontroller.verifyPassword(obj.getPassword());
                if(checkpassword)
                {
                    System.out.printf(" ".repeat(45)+"|%-20s|%-30s|%-20s|%n","Password :",obj.getPassword(),"VERIFIED✅");
                   // System.out.println();
                    c2=1;
                }
                else
                {
                    System.out.printf(" ".repeat(45)+"|%-20s|%-30s|%-20s|%n","Password :",obj.getPassword(),"NOT VERIFIED❌");
                   // System.out.println();
                }
            }
            else if(j==40)
            {
                boolean checkphone = Validationcontroller.verifyPhone(obj.getMobile());
                if(checkphone)
                {
                    System.out.printf(" ".repeat(45)+"|%-20s|%-30s|%-20s|%n","Phone Number :",obj.getMobile(),"VERIFIED✅");
                   // System.out.println();
                    c3=1;
                }
                else
                {
                    System.out.printf(" ".repeat(45)+"|%-20s|%-30s|%-20s|%n","Phone Number :",obj.getMobile(),"NOT VERIFIED❌");
                }
            }
            else if(j==50)
            {
                System.out.printf(" ".repeat(45)+"|%-20s|%-30s|%-20s|%n","Blood Group : ",obj.getType(),"VERIFIED✅");
               // System.out.println();
            }
            else if(j==65)
            {
                System.out.printf(" ".repeat(45)+"|%-20s|%-30s|%-20s|%n","District Selected : ",obj.getAddress(),"VERIFIED✅");
               // System.out.println();
            }
            else if(j==80)
            {
                boolean checkdate = Validationcontroller.verifyDate(obj.getDate());
                if(checkdate)
                {
                    System.out.printf(" ".repeat(45)+"|%-20s|%-30s|%-20s|%n","Recent Date :(OPT)",obj.getDate(),"VERIFIED✅");
                 //   System.out.println();
                    c4 = 1;
                }
                else
                {
                    System.out.printf(" ".repeat(45)+"|%-20s|%-30s|%-20s|%n","Recent Date :(OPT)",obj.getDate(),"NOT VERIFIED❌");
                }
            }
            else if(j==88)
            {
                System.out.printf(" ".repeat(45)+"|%-20s|%-30s|%-20s|%n","Health Issues",obj.getIssues(),"VERIFIED✅");
            }
            //--------------------------------------------------------
            //---------------------------------------------------------
            if(j==92)
            {
                int i;
                for (i = 92; i <98; i++)
                {
                    System.out.print("Processing your Data [" + i + "]" + "\r");
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                j = i;
            }
            System.out.print("Processing your Data [" + j + "]" + "\r");
            try
            {
                Thread.sleep(90);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(" ".repeat(45)+"-".repeat(75));
        if(c1==1 && c2==1 && c3==1 && c4==1)
        {
            System.out.println(" ".repeat(70)+"All Verifications Done ✅");
            System.out.println(" ".repeat(55) + "Data Inserted Successfully✅ - Press Enter to Continue");
            return 100;
        }
        else
        {
            System.out.println("Some Details Marked ❌ Are Incorrect - Retry");
            return 0;
        }
    }
    public static void display1(ArrayList<ArrayList<String>> list)
    {
        System.out.printf(
                "--------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("|%-20s|%-30s|%-10s|%-10s|%-20s|%-20s|%-20s|%-20s|%-10s|%n",
                "User Name", "E-Mail id", "Mobile", "Blood Type", "Issues","Address","Recent Donate Date","Donated Location","Donated Time");
        System.out.printf(
                "---------------------------------------------------------------------------------------------------%n");
        for (ArrayList<String> strings : list)
        {
            System.out.printf(("|%-20s|%-30s|%-10s|%-10s|%-20s|%-20s|%-20s|%-20s|%-10s|%n"),
                    strings.get(0), strings.get(1), strings.get(2), strings.get(3), strings.get(4),strings.get(5),strings.get(6),strings.get(7),strings.get(8));
        }
        System.out.printf(
                "------------------------------------------------------------------------------------------------------------------------%n");
    }
    public static String getUserBloodLocation()
    {
        Input.getStringLine();
        System.out.println("Enter Location you Need Blood : ");
        return Input.getStringLine();
    }
    public static void Display_Kindlywait()
    {
        System.out.println("This Process May take up to 10 Seconds Kindly wait");
    }
    public static String getOtp()
    {
        Input.getStringLine();
        System.out.println("Enter your OTP : ");
        return Input.getString();
    }
    public static void displayBloodEnter()
    {
        System.out.println(" ".repeat(45)+"Enter your Blood Type Sported by Serial Number");
    }
    public static UserDTO getRecentUpdateDetails()
    {
        UserDTO obj = new UserDTO();
        System.out.print("Enter your Mail id : ");
        String email = Input.getString();
        System.out.print("Enter your password : ");
        String password = Input.getString();
        obj.setUpdatedDetails(email,password);
        return obj;
    }
    public static String EnterMessage()
    {
        System.out.print("Enter Messgae : ");
        Input.getStringLine();
        return Input.getStringLine();
    }
    public static String EnterEmail()
    {
        System.out.print("Enter Mail id to Send : ");
        Input.getStringLine();
        return Input.getString();
    }
}
