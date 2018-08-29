import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class PantryGui {

  public static void main(String[] args) {
    PantryGui pantryGui = new PantryGui();
    pantryGui.startGui();
  }

  private void startGui() {

    JFrame frame = new JFrame("Pennywise Pantry");
    frame.setSize(500, 200);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    JPanel welcomePanel = new JPanel();
    JTextArea welcomeTextArea = new JTextArea();
    welcomeTextArea.setEditable(false);
    welcomeTextArea.setBackground(Color.WHITE);
    welcomeTextArea.setForeground(Color.BLACK);
    welcomeTextArea.setFont(new Font(null, 0, 24));
    welcomeTextArea.setText("Welcome to the Pantry");
    welcomePanel.add(welcomeTextArea);

    JPanel userEntryPanel = new JPanel(new GridBagLayout());
    JTextArea uidTextArea = new JTextArea();
    uidTextArea.setEditable(false);
    uidTextArea.setBackground(Color.WHITE);
    uidTextArea.setForeground(Color.BLACK);
    uidTextArea.setText("User ID");
    uidTextArea.setColumns(8);
    JTextArea uidEntryTextArea = new JTextArea();
    uidEntryTextArea.setEditable(true);
    uidEntryTextArea.setBackground(Color.WHITE);
    uidEntryTextArea.setForeground(Color.BLACK);
    uidEntryTextArea.setColumns(25);
    JTextArea pwTextArea = new JTextArea();
    pwTextArea.setEditable(false);
    pwTextArea.setBackground(Color.WHITE);
    pwTextArea.setForeground(Color.BLACK);
    pwTextArea.setText("Password");
    pwTextArea.setColumns(8);
    JTextArea pwEntryTextArea = new JTextArea();
    pwEntryTextArea.setEditable(true);
    pwEntryTextArea.setBackground(Color.WHITE);
    pwEntryTextArea.setForeground(Color.BLACK);
    pwEntryTextArea.setColumns(25);

    userEntryPanel.add(uidTextArea, createConstraints(0, 0));
    userEntryPanel.add(uidEntryTextArea, createConstraints(1, 0));
    userEntryPanel.add(pwTextArea, createConstraints(0, 1));
    userEntryPanel.add(pwEntryTextArea, createConstraints(1, 1));

    JPanel buttonPanel = new JPanel();

    JButton loginButton = new JButton("Login");
    JButton clearButton = new JButton("Clear");
    JButton closeButton = new JButton("Close");

    buttonPanel.add(loginButton);
    buttonPanel.add(clearButton);
    buttonPanel.add(closeButton);

    frame.add(welcomePanel, BorderLayout.NORTH);
    frame.add(userEntryPanel, BorderLayout.CENTER);
    frame.add(buttonPanel, BorderLayout.SOUTH);


    frame.setVisible(true);

  }

  private GridBagConstraints createConstraints(int x, int y) {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = x;
    gbc.gridy = y;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(3, 3, 3, 3);
    return gbc;
  }
}
