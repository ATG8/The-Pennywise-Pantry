import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

  }

  /**
   * Create the frame.
   */
  private PantryGui() {

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

      //Checks username and password
      //username = student
      //password = password
      if(attempt < 3 && username.equals("student") && password.equals("password")) {
        //if username and password are correct then a welcome message appears
        //SHOULD TAKE USER TO NEXT GUI
        JOptionPane.showMessageDialog(null,  "Welcome!");
      }
      //If the username or password are incorrect then an error message will appear
      else if(attempt != 3){
        JOptionPane.showMessageDialog(null,  "Sorry! Incorrect Username and/or Password. Attempt: " + attempt + " of 3.");
      }

      else {
        //Making the text fields unusable and the Login button invisible
        JOptionPane.showMessageDialog(null, "You have exceeded your allotted attempts");
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
    btnClear.addActionListener(e -> {
      txtUser.setText("");
      passPass.setText("");
    });

    btnClear.setBounds(159, 239, 104, 39);
    contentPane.add(btnClear);
  }
}
