package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

/*
 * Author: Thomas Lloyd
 * Purpose:To create a login GUI for the Pennywise Pantry.
 * 			The GUI will only allow the user 3 attempts before
 * 			locking them out.
 * Date:	9/25/2018
 */
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
    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(null);

    JLabel pantryLabel = new JLabel("Welcome to the Pennywise Pantry!");
    pantryLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
    pantryLabel.setBounds(29, 11, 361, 33);
    contentPane.add(pantryLabel);

    JLabel userNameLabel = new JLabel("USERNAME:");
    userNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    userNameLabel.setBounds(75, 119, 93, 14);
    contentPane.add(userNameLabel);

    JLabel passwordLabel = new JLabel("PASSWORD:");
    passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    passwordLabel.setBounds(75, 161, 92, 14);
    contentPane.add(passwordLabel);

    JLabel instructionLabel = new JLabel("Please login below with your username and password");
    instructionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
    instructionLabel.setBounds(39, 50, 330, 20);
    contentPane.add(instructionLabel);

    JPasswordField passwordField = new JPasswordField();
    passwordField.setBounds(175, 160, 152, 20);
    contentPane.add(passwordField);

    JTextField userField = new JTextField();
    userField.setBounds(176, 118, 151, 20);
    userField.setColumns(10);
    contentPane.add(userField);

    JButton loginButton = new JButton("LOGIN");
    loginButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    loginButton.setForeground(Color.BLACK);
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
    loginButton.setBounds(29, 239, 104, 39);
    contentPane.add(loginButton);

    //    Button to close the program
    JButton closeButton = new JButton("CLOSE");
    closeButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    closeButton.setForeground(Color.BLACK);
    closeButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent arg0) {
        loginGui.dispose();
      }
    });
    closeButton.setBounds(286, 239, 104, 39);
    contentPane.add(closeButton);

        //Button to clear both Username and Password text fields
    JButton clearButton = new JButton("CLEAR");
    clearButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    clearButton.setForeground(Color.BLACK);
    clearButton.addActionListener(ignored -> {
      userField.setText("");
      passwordField.setText("");
    });
    clearButton.setBounds(159, 239, 104, 39);
    contentPane.add(clearButton);

    loginGui.setContentPane(contentPane);
    loginGui.display();
  }
}
