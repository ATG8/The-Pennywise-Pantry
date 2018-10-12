/**
 * File: EmailSender
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main;

import main.domain_objects.Inventory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static java.time.temporal.ChronoUnit.DAYS;
import static main.utils.PantryFileUtils.getInventoryFromFile;

/**
 * Sends an email with a list of expiring inventory to the application user.
 */
final class EmailSender {

  /**
   * Constructor.
   *
   * @param user the user to send the email to
   * @param email the email address of the user
   */
  EmailSender(String user, String email) {
    List<Inventory> inventoryList = getInventoryFromFile();

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
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
      message.setSubject("Pennywise Pantry - Soon to Expire");

      StringBuilder expiringItems = new StringBuilder();
      List<Inventory> expiringList = new ArrayList<>();
      for (Inventory item : inventoryList) {
        if (Instant.now().plus(Duration.of(3, DAYS)).isAfter(item.getExpireDate())) {
          expiringList.add(item);
        }
      }

      for (Inventory item : expiringList) {
        expiringItems.append(item);
      }

      if (expiringItems.toString().isEmpty()) {
        message.setText("Hello " + user + ",\n\n" + "You have no items expiring in the next 3 days.");
      } else {
        message.setText("Hello " + user + ",\n\n" + "Please find your list of pantry items about to expire." + "\n\n"
            + "[Item Number, Description]\n" + expiringItems.toString());
      }

      Transport.send(message);

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }
}