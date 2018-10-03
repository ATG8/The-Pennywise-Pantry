package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ViewInventory {

  /**
	 * Create the frame.
	 */
  ViewInventory() {
    PantryFrame viewInventoryGui = new PantryFrame("Pennywise Pantry", 100, 100, 440, 367);

    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(null);

    //A welcome message
    JLabel pantryLabel = new JLabel("The Pennywise Pantry!");
    pantryLabel.setForeground(Color.BLACK);
    pantryLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
    pantryLabel.setBounds(93, 11, 234, 33);
    contentPane.add(pantryLabel);

    //Informative label instructing what to do next
    JLabel instructionLabel = new JLabel("Would you like to view a particular a item or all items?");
    instructionLabel.setForeground(Color.BLACK);
    instructionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
    instructionLabel.setBounds(65, 50, 325, 20);
    contentPane.add(instructionLabel);

    ButtonGroup buttonGroup = new ButtonGroup();

    JRadioButton viewAllRadio = new JRadioButton("View All");
    viewAllRadio.setSelected(true);
    buttonGroup.add(viewAllRadio);
    viewAllRadio.setForeground(Color.BLACK);
    viewAllRadio.setFont(new Font("Tahoma", Font.BOLD, 14));
    viewAllRadio.setBounds(93, 118, 102, 23);
    contentPane.add(viewAllRadio);

    JRadioButton searchRadio = new JRadioButton("Search:");
    buttonGroup.add(searchRadio);
    searchRadio.setForeground(Color.BLACK);
    searchRadio.setFont(new Font("Tahoma", Font.BOLD, 14));
    searchRadio.setBounds(93, 156, 77, 23);
    contentPane.add(searchRadio);

    JTextField textField = new JTextField();
    textField.setForeground(Color.BLACK);
    textField.setFont(new Font("Tahoma", Font.BOLD, 14));
    textField.setBounds(173, 159, 154, 20);
    contentPane.add(textField);
    textField.setColumns(10);

    //Search Button
    JButton searchButton = new JButton("SEARCH");
    searchButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    searchButton.setForeground(Color.BLACK);
    searchButton.addActionListener(ignored -> {
    });
    searchButton.setBounds(29, 239, 104, 39);
    contentPane.add(searchButton);

    //Button to close the program
    JButton closeButton = new JButton("CLOSE");
    closeButton.setForeground(Color.BLACK);
    closeButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    closeButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent ignored) {
        viewInventoryGui.dispose();
      }
    });
    closeButton.setBounds(286, 239, 104, 39);
    contentPane.add(closeButton);

    //Button that will log the user out (b/c the last screen was login) and take them to login screen
    JButton backButton = new JButton("BACK");
    backButton.setForeground(Color.BLACK);
    backButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    backButton.addActionListener(e -> {
      new TaskGui();
      viewInventoryGui.dispose();
    });
    backButton.setBounds(159, 239, 104, 39);
    contentPane.add(backButton);

    viewInventoryGui.setContentPane(contentPane);
    viewInventoryGui.display();
  }
}

