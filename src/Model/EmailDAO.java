package Model;

import Resource.UserDTO;
import View.User_View;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailDAO
{
    public static boolean sendEmail(UserDTO obj,String msg,String email)
    {
        String from = "madhanofficial08@gmail.com";
        String host = "smtp.gmail.com";
        String username = "madhanofficial08@gmail.com";
        String password = "nvdberblgyndoxeb";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(username, password);
            }
        });
        try
        {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("From, \n "+obj.getMailid());
            message.setText(msg);
            Transport.send(message);
            User_View.msgsent();
            return true;
        }
        catch (MessagingException mex)
        {
            User_View.notfound();
            return false;
        }
    }
}
