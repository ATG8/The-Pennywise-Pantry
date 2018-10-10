/**
 * File: SendEmail
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.stream.Collectors;

final class SendEmail {

  private static List<List<String>> inventoryContents = new ArrayList<>();
  private static List<List<String>> expiringList = new ArrayList<>();

  // constructor to get username from main
  SendEmail(String user, String email) {

    getInventory();

    // set user and email address
    // declare variables

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
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
      message.setSubject("Pennywise Pantry - Soon to Expire");

      StringBuilder expiringItems = new StringBuilder();
      for (List<String> item : getExpiring()) {
        expiringItems.append(item);
        expiringItems.append("\n");
      }

      if (getExpiring().isEmpty()) {
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

  private static void getInventory() {
    if (Files.exists(Paths.get("Inventory.txt"))) {
      try {
        List<String> contents = Files.readAllLines(Paths.get("Inventory.txt"));
        contents.forEach(line -> inventoryContents.add(Arrays.stream(line.split("\\|")).collect(Collectors.toList())));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private List<List<String>> getExpiring() {
    for (List list : inventoryContents) {
      if (Instant.now()
          .plus(Duration.of(3, ChronoUnit.DAYS))
          .isAfter(Instant.parse(list.get(3)
              .toString())
              .plus(Duration.of(Integer.parseInt(list.get(2).toString()), ChronoUnit.DAYS)))) {
        expiringList.add(list.subList(0, 2));
      }
    }
    return expiringList;
  }
}