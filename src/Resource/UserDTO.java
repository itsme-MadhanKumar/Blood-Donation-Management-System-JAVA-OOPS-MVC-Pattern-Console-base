package Resource;

public class UserDTO
{
    private String username;
    private  String mailid;
    private String password;
    private String mobile;
    private String type;
    private String issues = "---";
    private String address;
    private String date = "---";
    private String location = "---";
    private String time = "---";
    private String run_email;
    public void setUpdatedDetails(String mail,String password)
    {
        this.mailid = mail;
        this.password = password;
    }

    public String getRun_email()
    {
        return run_email;
    }

    public void setRun_email(String run_email)
    {
        this.run_email = run_email;
    }

    public void setMailid(String mailid)
    {
        this.mailid = mailid;
    }
    public String getTime()
    {
        return time;
    }

    public String getDate()
    {
        return date;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }
    public void setDate(String date)
    {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getIssues() {
        return issues;
    }

    public String getMobile()
    {
        return mobile;
    }

    public String getType()
    {
        return type;
    }

    public String getUsername()
    {
        return username;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setIssues(String issues)
    {
        this.issues = issues;
    }

    public void setMobile(String mobile)
    {

        this.mobile = mobile;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public  String getMailid()
    {
        return mailid;
    }
    public void setUserDetails(String name,String mailid,String pass,String mobile,String type,String issues,String address)
    {
        this.username = name;
        this.mailid = mailid;//defs
        this.password =pass;
        this.mobile = mobile;
        this.type = type;
        this.issues = issues;
        this.address = address;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    public void getStatus(String email,String date,String location,String time)
    {
        this.mailid = email;
        this.date = date;
        this.location = location;
        this.time  = time;
    }
}
