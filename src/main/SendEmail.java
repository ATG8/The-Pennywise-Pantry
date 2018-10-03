package main;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author ATG8
 */
public final class SendEmail {

  // constructor to get username from main
  public SendEmail(String user, String email) {
    // set user and email address
    // declare variables
    String user1 = user;
    String email1 = email;

    // send email to user with list of expired goods
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

    Session session = Session.getDefaultInstance(props,
        new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            //username and password of Send account
            return new PasswordAuthentication("noreply.cmscgroup5", "CisforCookie,that'sgoodenoughforme!");
          }
        });

    try {

      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("noreply.cmscgroup5@gmail.com"));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email1));
      message.setSubject("Pennywise Pantry - Soon to Expire");
      message.setText("Hello " + user1 + ",\n\n" + "Please find your list of pantry items about to expire.");

      //need to append list of items about to expire to setText

      Transport.send(message);

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }
}