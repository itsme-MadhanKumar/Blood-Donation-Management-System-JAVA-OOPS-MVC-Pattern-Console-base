package Model;
import Resource.UserDTO;
import Util.Connections;
import View.User_View;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO
{
    public static boolean insertUserDetails(UserDTO obj)
    {
        Connections db = new Connections();
        try
        {
            Connection connection = db.connect();
         String q = "INSERT INTO USER_INFO(username,mailid,passwords,mobile,bloodtype,issues,address) values(?,?,?,?,?,?,?)";
         PreparedStatement ps = connection.prepareStatement(q);
         ps.setString(1,obj.getUsername());
         ps.setString(2,obj.getMailid());
         ps.setString(3,obj.getPassword());
            ps.setString(4,obj.getMobile());
            ps.setString(5,obj.getType());
            ps.setString(6,obj.getIssues());
            ps.setString(7,obj.getAddress());
            int rs = ps.executeUpdate();
            return rs == 1;
        }
        catch (SQLException e)
        {

            User_View.emessage(e);
            return false;
        }
    }
    public static boolean insertrecentStatus(UserDTO obj)
    {
        Connections db = new Connections();
        try
        {
            Connection connection = db.connect();
            String updateQuery = "UPDATE USER_INFO SET recent_blooddonate = ?, donated_location = ?, time_of_donate = ? WHERE mailid = ?";
            PreparedStatement ps = connection.prepareStatement(updateQuery);
            ps.setString(1,obj.getDate());
            ps.setString(2,obj.getLocation());
            ps.setString(3,obj.getTime());
            ps.setString(4,obj.getRun_email());
            int rs = ps.executeUpdate();
            return rs == 1;
        }
        catch (SQLException e)
        {
            User_View.emessage(e);
            return false;
        }
    }
    public static boolean isuserAlredyExist(UserDTO obj)
    {
        Connections connections = new Connections();
        try
        {
            Connection connection = connections.connect();
            String query = "SELECT COUNT(*) FROM USER_INFO WHERE mailid = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,obj.getMailid());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                int count = rs.getInt(1);
                if(count==0)
                {
                    return false;
                }
            }
        }
        catch (SQLException e)
        {
            User_View.emessage(e);
        }
        return true;
    }
    public static boolean isUser(UserDTO obj)
    {
        Connections connections = new Connections();
        try
        {
            Connection connection = connections.connect();
            String query = "SELECT mailid,passwords FROM USER_INFO WHERE mailid = ? AND passwords = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,obj.getMailid());
            ps.setString(2,obj.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
        }
        catch (SQLException e)
        {
            User_View.emessage(e);
        }
        return false;
    }
    public static ArrayList<ArrayList<String>> getBloodDonar(String blood,String currentEmail)
    {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        Connections connections = new Connections();
        try
        {
            Connection connection = connections.connect();
            String query = "SELECT username,mailid,mobile,bloodtype,issues,address,recent_blooddonate,donated_location,time_of_donate FROM USER_INFO WHERE bloodtype = ? AND mailid != ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,blood);
            ps.setString(2, currentEmail);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                ArrayList<String> l = new ArrayList<>();
                l.add(rs.getString(1));
                l.add(rs.getString(2));
                l.add(rs.getString(3));
                l.add(rs.getString(4));
                l.add(rs.getString(5));
                l.add(rs.getString(6));
                l.add(rs.getString(7));
                l.add(rs.getString(8));
                l.add(rs.getString(9));
                list.add(l);
            }
        }
        catch (SQLException e)
        {
            User_View.emessage(e);
        }
        return list;
    }
    public static ArrayList<ArrayList<String>> getBloodDonarByDistrict(String blood,String district,String currentEmail)
    {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        Connections connections = new Connections();
        try
        {
            Connection connection = connections.connect();
            String query = "SELECT username,mailid,mobile,bloodtype,issues,address,recent_blooddonate,donated_location,time_of_donate FROM USER_INFO WHERE bloodtype = ? AND address = ? AND mailid != ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,blood);
            ps.setString(2,district);
            ps.setString(3, currentEmail);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                ArrayList<String> l = new ArrayList<>();
                l.add(rs.getString(1));
                l.add(rs.getString(2));
                l.add(rs.getString(3));
                l.add(rs.getString(4));
                l.add(rs.getString(5));
                l.add(rs.getString(6));
                l.add(rs.getString(7));
                l.add(rs.getString(8));
                l.add(rs.getString(9));
                list.add(l);
            }
        }
        catch (SQLException e)
        {
            User_View.emessage(e);
        }
        return list;
    }
    public static ArrayList<ArrayList<String>> getBloodDonarByRecent(String blood,String district,String currentEmail)
    {
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        Connections connections = new Connections();
        try
        {
            Connection connection = connections.connect();
            String query = "SELECT username,mailid,mobile,bloodtype,issues,address,recent_blooddonate,donated_location,time_of_donate FROM USER_INFO WHERE bloodtype = ? AND donated_location = ? AND mailid != ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,blood);
            ps.setString(2,district);
            ps.setString(3, currentEmail);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                ArrayList<String> l = new ArrayList<>();
                l.add(rs.getString(1));
                l.add(rs.getString(2));
                l.add(rs.getString(3));
                l.add(rs.getString(4));
                l.add(rs.getString(5));
                l.add(rs.getString(6));
                l.add(rs.getString(7));
                l.add(rs.getString(8));
                l.add(rs.getString(9));
                list.add(l);
            }
        }
        catch (SQLException e)
        {
            User_View.emessage(e);
        }
        return list;
    }
    public static boolean updaterecentLocation(UserDTO obj)
    {
        Connections connections = new Connections();

        try
        {
            Connection connection = connections.connect();
            String query = "UPDATE USER_INFO SET recent_blooddonate = ?,donated_location =?,time_of_donate = ? WHERE mailid = ?";
            PreparedStatement ps  = connection.prepareStatement(query);
            ps.setString(1,obj.getDate());
            ps.setString(2,obj.getLocation());
            ps.setString(3,obj.getTime());
            ps.setString(4,obj.getMailid());
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected!=1)
            {
               // System.out.println("Recent Update Done");
                return false;
            }
        }
        catch (SQLException e)
        {
            User_View.emessage(e);
        }
        return true;
    }
    public static boolean updatingnewLocation(String location,UserDTO obj)
    {
        Connections connections = new Connections();
        try
        {
            Connection connection = connections.connect();
            String q = "UPDATE USER_INFO SET address = ? WHERE mailid = ?";
            PreparedStatement ps = connection.prepareStatement(q);
            ps.setString(1,location);
            ps.setString(2,obj.getMailid());
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected!=1)
            {
                // System.out.println("Recent Update Done");
                return false;
            }
        }
        catch (SQLException e)
        {
            User_View.emessage(e);
        }
        return true;
    }
    public static boolean checkDatabase(String email)
    {
        Connections connections = new Connections();
        try
        {
            Connection connection = connections.connect();
            String query = "SELECT COUNT(*) FROM USER_INFO WHERE mailid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        }
        catch (SQLException e)
        {
            User_View.emessage(e);
        }
        return false;
    }
}
