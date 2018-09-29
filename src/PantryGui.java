import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

/*
 * Author: Thomas Lloyd
 * Purpose:To create a login GUI for the Pennywise Pantry.
 * 			The GUI will only allow the user 3 attempts before
 * 			locking them out.
 * Date:	9/25/2018
 */
public class PantryGui extends JFrame {

  private JPasswordField passPass;
  private JTextField txtUser;
  private int attempt = 1;
  private static String[][] login2dArray;
  private static String email;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        PantryGui frame = new PantryGui();
        frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
    
    //Get credentials from Login.txt file and create 2D array of data
    try{
      Scanner loginFile = null;
      List<String> temps = new ArrayList<String>();

      //try to open file, catch exception
      try {
          loginFile = new Scanner(new File("Login.txt"));
      } catch (FileNotFoundException fnf) {
          Logger.getLogger(PantryGui.class.getName()).log(Level.SEVERE, null, fnf);
      }

      //try to read file, finally block to close in case of fail
      try{
          while(loginFile.hasNextLine()){
              String token = loginFile.next();
              temps.add(token);
          }
              loginFile.close();
              //create 1D array
              String[] loginArray = temps.toArray(new String[0]);
              
              //create 2D array
              login2dArray = new String[temps.size()][];
              for(int i = 0; i < login2dArray.length; i++){
                  String[] row = temps.get(i).split("\\|");
                  login2dArray [i] = row;
              }
              
              //these lines were to test array storage was correct
              //for(int j = 0; j < login2dArray.length; j++){
                  //for(int k = 0; k < login2dArray[j].length; k++){
                      //System.out.println(login2dArray[j][k]);
                  //}
              //}
              
      }finally{
          loginFile.close();
      }

    //catch any other exceptions?  A little vague
    }catch(Exception e){
        Logger.getLogger(PantryGui.class.getName()).log(Level.SEVERE, null, e);
    }
    
  }
  
  public boolean validCreds(String username, String password){
        boolean isValid = false;
        
        for(int i = 0; i < login2dArray.length; i++){
            for(int j = 0; j < 3; j++){
                if(username.equalsIgnoreCase(login2dArray[i][0])){
                    if(password.equals(login2dArray[i][1])){
                        isValid = true;
                    }
                }
            }
        }
        return isValid;
    }
  
  public String getEmail(String username){
      for(int i = 0; i < login2dArray.length; i++){
            for(int j = 0; j < 4; j++){
                if(username.equalsIgnoreCase(login2dArray[i][0])){
                    email = login2dArray[i][2];
                }
            }
        }
      return email;
  }
  
  /**
   * Create the frame.
   */
  PantryGui() {

    setTitle("Pennywise Pantry");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setBounds(100, 100, 431, 367);
    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    //A welcome message
    JLabel lblPennywisePantry = new JLabel("Welcome to the Pennywise Pantry!");
    lblPennywisePantry.setFont(new Font("Tahoma", Font.BOLD, 20));
    lblPennywisePantry.setBounds(29, 11, 361, 33);
    contentPane.add(lblPennywisePantry);

    //labeling the username text field
    JLabel lblUsername = new JLabel("USERNAME:");
    lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblUsername.setBounds(75, 119, 93, 14);
    contentPane.add(lblUsername);

    //Labeling the password text field
    JLabel lblPassword = new JLabel("PASSWORD:");
    lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblPassword.setBounds(75, 161, 92, 14);
    contentPane.add(lblPassword);

    //Informative label instructing what to do next
    JLabel lblInstructions = new JLabel("Please login below with your username and password");
    lblInstructions.setFont(new Font("Tahoma", Font.PLAIN, 14));
    lblInstructions.setBounds(39, 50, 330, 20);
    contentPane.add(lblInstructions);

    //The password's text field
    passPass = new JPasswordField();
    passPass.setBounds(175, 160, 152, 20);
    contentPane.add(passPass);

    //The username's text field
    txtUser = new JTextField();
    txtUser.setBounds(176, 118, 151, 20);
    contentPane.add(txtUser);
    txtUser.setColumns(10);

    //Login Button
    JButton btnLogin = new JButton("LOGIN");
    btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnLogin.setForeground(Color.BLACK);
    btnLogin.addActionListener(ignored -> {

    //Hardcoded username and password to test functionality
    //needs to be replaced with DB
    //Declare username and password (hard code bad!)
    String username = txtUser.getText();
    String password = String.valueOf(passPass.getPassword());

      
      if (attempt < 3 && validCreds(username, password)) {
        //On successful login, send email
        //Need to figure out how to create list of expired items here
        
        //get email address from login2dArray
        email = getEmail(username);
        
        //pass username and email to SendEmail Class
        SendEmail expired = new SendEmail(username, email);
          
        //if username and password are correct then a welcome message appears
        //TAKES USER TO NEXT GUI
        TaskGui task = new TaskGui();
        task.setVisible(true);
        //closes login gui
        dispose();
      } else if (attempt < 3) { //If the username or password are incorrect then an error message will appear
        JOptionPane.showMessageDialog(null,  "Sorry! Incorrect Username and/or Password. Attempt: " + attempt + " of 3.");
      } else {
        //Making the text fields unusable and the Login button invisible
        
        JOptionPane.showMessageDialog(null, "Sorry! Incorrect Username and/or"
                        + " Password. Attempt: " + attempt + " of 3.\n"
                            +"You have reached max attempts and you must restart"
                                + " the program.");
        txtUser.setEditable(false);
        passPass.setEditable(false);
        btnLogin.setVisible(false);
      }
      attempt++;
    });

    btnLogin.setBounds(29, 239, 104, 39);
    contentPane.add(btnLogin);

    //Button to close the program
    JButton btnClose = new JButton("CLOSE");
    btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnClose.setForeground(Color.BLACK);
    btnClose.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent arg0) {
        dispose();
      }
    });

    btnClose.setBounds(286, 239, 104, 39);
    contentPane.add(btnClose);

    //Button to clear both Username and Password text fields
    JButton btnClear = new JButton("CLEAR");
    btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnClear.setForeground(Color.BLACK);
    btnClear.addActionListener(e -> {
      txtUser.setText("");
      passPass.setText("");
    });

    btnClear.setBounds(159, 239, 104, 39);
    contentPane.add(btnClear);
  }  
  }
