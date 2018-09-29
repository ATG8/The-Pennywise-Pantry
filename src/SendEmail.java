import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author ATG8
 */
public final class SendEmail {
    
    // declare variables
    private String user;
    private String email;

    // constructor to get username from main
    public SendEmail(String user, String email) {
        // set user and email address
        this.user = user;
        this.email = email;
        
        // send email to user with list of expired goods
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                        "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    //username and password of Send account
                    return new PasswordAuthentication("noreply.cmscgroup5","CisforCookie,that'sgoodenoughforme!");
                }
            });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("noreply.cmscgroup5@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(this.email));
            message.setSubject("Pennywise Pantry - Soon to Expire");
            message.setText("Hello " + this.user + ",\n\n" + "Please find your "
                    + "list of pantry items about to expire.");
                    
            //need to append list of items about to expire to setText

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}