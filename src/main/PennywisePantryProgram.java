/**
 * File: PennywisePantryProgram
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main;

import main.gui_elements.PantryButton;
import main.gui_elements.PantryFrame;
import main.gui_elements.PantryLabel;
import main.gui_elements.PantryPanel;
import main.guis.TaskGui;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Entry point into the Pennywise Pantry program.
 */
public class PennywisePantryProgram {

  private int attempt = 1;
  private static String email;
  private static List<List<String>> credentialContents = new ArrayList<>();
  public static boolean access;


  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    PennywisePantryProgram program = new PennywisePantryProgram();
    getCredentials();
    program.startGui();

  }

  /**
   * Method to get a list of valid credentials stored in a file.
   */
  private static void getCredentials() {
    Path path = null;
    try {
      path = Paths.get(PennywisePantryProgram.class.getClassLoader().getResource("Login.txt").toURI());
    } catch (URISyntaxException ex) {
      ex.printStackTrace();
    }
    if (Files.exists(path)) {
      try {
        List<String> contents = Files.readAllLines(path);
        contents.forEach(line -> credentialContents.add(Arrays.stream(line.split("\\|")).collect(Collectors.toList())));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Method to validate the credentials entered by the user.
   *
   * @param username the username
   * @param password the password
   * @return if the credentials are valid.
   */
  private boolean validateCredentials(String username, String password) {
    boolean isValid = false;
    
    for (List list : credentialContents) {
      if (list.get(0).toString().equalsIgnoreCase(username) && list.get(1).equals(password)) {
        isValid = true;
      }
    }
    return isValid;
  }

  /**
   * Method that gets the email address of the user.
   *
   * @param username the username
   * @return the email address of the user
   */
  private String getEmail(String username) {
    for (List list : credentialContents) {
      if (list.get(0).toString().equalsIgnoreCase(username)) {
        email = list.get(2).toString();
      }
    }
    return email;
  }

  /**
   * Method that sets the access level for the application.
   *
   * @param username the username
   * @return if the user has privileged access
   */
  private boolean setAccess(String username){
    access = false;
    for (List list : credentialContents) {
      if (list.get(0).toString().equalsIgnoreCase(username) && Integer.parseInt(list.get(3).toString()) == 0) {
        access = true;
      }
    }
      return access;
  }

  /**
   * Method that builds and displays the initial GUI.
   */
  private void startGui() {
    PantryFrame loginGui = new PantryFrame("Pennywise Pantry", 100, 100, 431, 367);
    PantryPanel contentPane = new PantryPanel();
    contentPane.add(new PantryLabel("Welcome to the Pennywise Pantry!", BOLD, 20, 29, 11, 361, 33));
    contentPane.add(new PantryLabel("USERNAME:", BOLD, 14, 75, 119, 93, 14));
    contentPane.add(new PantryLabel("PASSWORD:", BOLD, 14, 75, 161, 92, 14));
    contentPane.add(new PantryLabel("Please login below with your username and password", PLAIN, 14, 39, 50, 330, 20));

    JPasswordField passwordField = new JPasswordField();
    passwordField.setBounds(175, 160, 152, 20);
    contentPane.add(passwordField);

    JTextField userField = new JTextField();
    userField.setBounds(176, 118, 151, 20);
    userField.setColumns(10);
    contentPane.add(userField);

    PantryButton loginButton = new PantryButton("LOGIN", 15, 29, 239, 104, 39);
    loginButton.addActionListener(ignored -> {
      String username = userField.getText();
      String password = String.valueOf(passwordField.getPassword());
      if (attempt < 3 && validateCredentials(username, password)) {
        //On successful login, send email
        //destroy entered password and set access level
        password = "";
        access = setAccess(username);

        email = getEmail(username);

        // pass username and email to EmailSender Class
//        EmailSender expired = new EmailSender(username, email);

        // if username and password are correct then the next GUI is displayed.
        new TaskGui();

        loginGui.dispose();

      } else if (attempt < 3) {
        showMessageDialog(null, "Sorry! Incorrect Username and/or Password. Attempt: " + attempt + " of 3.");
      } else {
        // Making the text fields unusable and the Login button invisible
        showMessageDialog(null, "Sorry! Incorrect Username and/or Password. Attempt: "
            + attempt
            + " of 3.\n You have reached max attempts and you must restart the program.");

        userField.setEditable(false);
        passwordField.setEditable(false);
        loginButton.setVisible(false);
      }
      attempt++;
    });
    contentPane.add(loginButton);

    PantryButton clearButton = new PantryButton("CLEAR", 15, 159, 239, 104, 39);
    clearButton.addActionListener(ignored -> {
      userField.setText("");
      passwordField.setText("");
    });
    contentPane.add(clearButton);

    PantryButton closeButton = new PantryButton("CLOSE", 15, 286, 239, 104, 39);
    closeButton.addActionListener(ignored -> loginGui.dispose());
    contentPane.add(closeButton);

    loginGui.setContentPane(contentPane);
    loginGui.display();
  }
}
