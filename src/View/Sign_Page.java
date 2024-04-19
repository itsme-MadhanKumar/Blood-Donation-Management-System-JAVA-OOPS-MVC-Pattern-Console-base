package View;
import Resource.UserDTO;
import Util.Input;
import java.util.Scanner;
public class Sign_Page
{
    public static UserDTO signin_page()
    {
        Input.getStringLine();
        System.out.print("Enter your Mail Id : ");
        String mail = Input.getStringLine();
        System.out.print("Enter Your Password : ");
        String password = Input.getStringLine();
        UserDTO obj = new UserDTO();
        obj.setMailid(mail);
        obj.setPassword(password);
        return obj;
    }
    public static String getBloodType()
    {
        while (true)
        {
            System.out.println(" ".repeat(45)+"1 -> O+");
            System.out.println(" ".repeat(45)+"2 -> O-");
            System.out.println(" ".repeat(45)+"3 -> A+");
            System.out.println(" ".repeat(45)+"4 -> A-");
            System.out.println(" ".repeat(45)+"5 -> B+");
            System.out.println(" ".repeat(45)+"6 -> B-");
            System.out.println(" ".repeat(45)+"7 -> AB+");
            System.out.println(" ".repeat(45)+"8 -> AB-");
            System.out.print("Enter your Blood Group S Number : ");
            int n;
            try
            {
                n = Input.getInt();
                if(n>=1 && n<=8)
                {
                    if(n==1) return "O+";
                    else if(n==2) return "O-";
                    else if(n==3) return "A+";
                    else if(n==4) return "A-";
                    else if(n==5) return "B+";
                    else if(n==6) return "B-";
                    else if(n==7) return "AB+";
                    else return "AB-";
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                Input.getStringLine();
            }
        }
    }
    public static void signup_page(UserDTO obj)
    {
        Input.getStringLine();
        System.out.print("Enter your Name : ");
        String name  = Input.getStringLine();
        System.out.print("Enter your Mailid : ");
        String mailid = Input.getStringLine();
        obj.setRun_email(mailid);
        System.out.print("Enter your Password [1U|1L|1D|1S] : ");
        String password = Input.getStringLine();
        System.out.print("Enter your Mobile Number : ");
        String mobile = Input.getStringLine();
        String type = Sign_Page.getBloodType();
        Input.getStringLine();
        System.out.print("Enter if you any Health Issues / Null  : ");
        String issues  = Input.getStringLine();
        //-------------district
        System.out.println(" ".repeat(45)+"Enter Your District By Serial Number");
        String address = Sign_Page.getDistrict();
        obj.setMailid(mailid);
        obj.setUserDetails(name,mailid,password,mobile,type,issues,address);
    }
    public static String getDistrict()
    {
        String[] districtNames =
                {
                "Chennai", "Coimbatore", "Madurai", "Tiruchirappalli", "Salem",
                "Tiruppur", "Erode", "Vellore", "Thoothukudi", "Thanjavur",
                "Kancheepuram", "Tirunelveli", "Dindigul", "Cuddalore", "Tirupattur",
                "Kanniyakumari", "Viluppuram", "Virudhunagar", "Krishnagiri", "Ramanathapuram",
                "Karur", "Namakkal", "Sivaganga", "Nagapattinam", "Thiruvarur",
                "Theni", "Perambalur", "Pudukkottai", "Dharmapuri", "Nilgiris", "Ariyalur"
        };

        int numRows = 10;
        int numCols = 3;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numCols; j++)
            {
                int index = i + j * numRows;
                sb.append(String.format("%-20s", (index + 1) + ". " + districtNames[index]));
            }
            sb.append("\n");
        }
        String result = sb.toString();
        System.out.println(result);

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.print("\nEnter the district number: ");
            int input;
            try
            {
                input = scanner.nextInt();
                if (input >= 1 && input <= districtNames.length)
                {
                    String districtName = districtNames[input - 1];
                    System.out.println("Entered District Name  " + input + ": " + districtName);
                    return districtName;
                }
                else
                {
                    System.out.println("Invalid district number.");
                    //Input.getStringLine();
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                Input.getStringLine();
            }

        }
    }

    public static int isalreayDonated()
    {
        while (true)
        {
            System.out.println(" ".repeat(45)+"Press 1 : If you Have Recent Blood Donate");
            System.out.println(" ".repeat(45)+"Press 2 : Skip this page");
            System.out.print("Enter your Choice : ");
            int n;
            try
            {
                n = Input.getInt();
                return n;
            }
            catch (Exception e)
            {
                System.out.println("Invalid Input");
                Input.getStringLine();
            }
        }
    }
    public static void  firstLogin(UserDTO obj)
    {
        Input.getStringLine();
        System.out.println(" ".repeat(45)+"--Kindly Update Recent Donate Status--");
        System.out.print("Enter your Recent Donate Date : ");
        String date = Input.getStringLine();
        System.out.println("Enter where you Donated : ");
        String location = Sign_Page.getDistrict();
        System.out.print("Enter Donated Time (Optional) -> Press Enter to Continue : ");
        String time = Input.getStringLine();
        String email = obj.getRun_email();
        obj.getStatus(email,date,location,time);
    }
    public static UserDTO  firstLogin1(UserDTO obj)
    {
        Input.getStringLine();
        System.out.println(" ".repeat(45)+"--Kindly Update Recent Donate Status--");
        System.out.print("Enter your Recent Donate Date : ");
        String date = Input.getStringLine();
        System.out.println("Enter where you Donated : ");
        String location = Sign_Page.getDistrict();
        System.out.print("Enter Donated Time (Optional) -> Press Enter to Continue : ");
        String time = Input.getStringLine();
        String email = obj.getMailid();
        obj.getStatus(email,date,location,time);
        return obj;
    }
}
