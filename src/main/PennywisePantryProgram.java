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
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PennywisePantryProgram {

  private int attempt = 1;
  private static String email;
  private static List<List<String>> credentialContents = new ArrayList<>();


  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    PennywisePantryProgram program = new PennywisePantryProgram();
    getCredentials();
    program.startGui();

  }

  private static void getCredentials() {
    if (Files.exists(Paths.get("Login.txt"))) {
      try {
        List<String> contents = Files.readAllLines(Paths.get("Login.txt"));
        contents.forEach(line -> credentialContents.add(Arrays.stream(line.split("\\|")).collect(Collectors.toList())));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private boolean validCreds(String username, String password) {
    boolean isValid = false;
    
    for (List list : credentialContents) {
      if (list.get(0).toString().equalsIgnoreCase(username) && list.get(1).equals(password)) {
        isValid = true;
      }
    }
    return isValid;
  }

  private String getEmail(String username) {
    for (List list : credentialContents) {
      if (list.get(0).toString().equalsIgnoreCase(username)) {
        email = list.get(2).toString();
      }
    }
    return email;
  }
  
  private void startGui() {
    PantryFrame loginGui = new PantryFrame("Pennywise Pantry", 100, 100, 431, 367);
    PantryPanel contentPane = new PantryPanel();
    contentPane.add(new PantryLabel("Welcome to the Pennywise Pantry!", Font.BOLD, 20, 29, 11, 361, 33));
    contentPane.add(new PantryLabel("USERNAME:", Font.BOLD, 14, 75, 119, 93, 14));
    contentPane.add(new PantryLabel("PASSWORD:", Font.BOLD, 14, 75, 161, 92, 14));
    contentPane.add(new PantryLabel("Please login below with your username and password",
        Font.PLAIN, 14, 39, 50, 330, 20));

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
      if (attempt < 3 && validCreds(username, password)) {
        //On successful login, send email
        //Need to figure out how to create list of expired items here

        //get email address from login2dArray
        email = getEmail(username);

        //pass username and email to SendEmail Class
//        SendEmail expired = new SendEmail(username, email);

        //if username and password are correct then a welcome message appears
        //TAKES USER TO NEXT GUI
        new TaskGui();

        //closes login gui
        loginGui.dispose();
      } else if (attempt < 3) { //If the username or password are incorrect then an error message will appear
        JOptionPane.showMessageDialog(null, "Sorry! Incorrect Username and/or Password. Attempt: " + attempt + " of 3.");
      } else {
        //Making the text fields unusable and the Login button invisible
        JOptionPane.showMessageDialog(null, "Sorry! Incorrect Username and/or Password. Attempt: "
            + attempt
            + " of 3.\n You have reached max attempts and you must restart the program.");
        userField.setEditable(false);
        passwordField.setEditable(false);
        loginButton.setVisible(false);
      }
      attempt++;
    });
    contentPane.add(loginButton);

    //    Button to close the program
    PantryButton closeButton = new PantryButton("CLOSE", 15, 286, 239, 104, 39);
    closeButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent arg0) {
        loginGui.dispose();
      }
    });
    contentPane.add(closeButton);

        //Button to clear both Username and Password text fields
    PantryButton clearButton = new PantryButton("CLEAR", 15, 159, 239, 104, 39);
    clearButton.addActionListener(ignored -> {
      userField.setText("");
      passwordField.setText("");
    });
    contentPane.add(clearButton);

    loginGui.setContentPane(contentPane);
    loginGui.display();
  }
}
