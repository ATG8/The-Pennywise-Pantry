package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class AddInventory {

  /**
	 * Create the frame.
	 */
  AddInventory() {
    PantryFrame addInventoryGui = new PantryFrame("Pennywise Pantry", 100, 100, 440, 367);

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
    JLabel instructionLabel = new JLabel("Please add your new item below:");
    instructionLabel.setForeground(Color.BLACK);
    instructionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
    instructionLabel.setBounds(114, 48, 208, 20);
    contentPane.add(instructionLabel);

    JLabel itemNameLabel = new JLabel("Item Name:");
    itemNameLabel.setForeground(Color.BLACK);
    itemNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    itemNameLabel.setBounds(86, 116, 83, 20);
    contentPane.add(itemNameLabel);

    JTextField itemNameText = new JTextField();
    itemNameText.setFont(new Font("Tahoma", Font.BOLD, 14));
    itemNameText.setForeground(Color.BLACK);
    itemNameText.setText("Item Name...");
    itemNameText.setBounds(179, 116, 162, 20);
    itemNameText.setColumns(10);
    contentPane.add(itemNameText);


    JLabel itemQuatityLabel = new JLabel("Quantity:");
    itemQuatityLabel.setForeground(Color.BLACK);
    itemQuatityLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    itemQuatityLabel.setBounds(104, 147, 65, 20);
    contentPane.add(itemQuatityLabel);

    JTextField quantityText = new JTextField();
    quantityText.setText("Quantity...");
    quantityText.setForeground(Color.BLACK);
    quantityText.setFont(new Font("Tahoma", Font.BOLD, 14));
    quantityText.setColumns(10);
    quantityText.setBounds(179, 147, 162, 20);
    contentPane.add(quantityText);

    JLabel expirationDateLabel = new JLabel("Expiration Date:");
    expirationDateLabel.setForeground(Color.BLACK);
    expirationDateLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    expirationDateLabel.setBounds(58, 181, 111, 14);
    contentPane.add(expirationDateLabel);

    JTextField expirationDateText = new JTextField();
    expirationDateText.setText("Expiration Date...");
    expirationDateText.setForeground(Color.BLACK);
    expirationDateText.setFont(new Font("Tahoma", Font.BOLD, 14));
    expirationDateText.setColumns(10);
    expirationDateText.setBounds(179, 178, 162, 20);
    contentPane.add(expirationDateText);

    //Search Button
    JButton enterButton = new JButton("ENTER");
    enterButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    enterButton.setForeground(Color.BLACK);
    enterButton.addActionListener(ignored -> {
      itemNameText.setText("");
      quantityText.setText("");
      expirationDateText.setText("");
    });
    enterButton.setBounds(30, 256, 104, 39);
    contentPane.add(enterButton);

    //Button to close the program
    JButton closeButton = new JButton("CLOSE");
    closeButton.setForeground(Color.BLACK);
    closeButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    closeButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent ignored) {
        addInventoryGui.dispose();
      }
    });
    closeButton.setBounds(287, 256, 104, 39);
    contentPane.add(closeButton);

    //Button that will log the user out (b/c the last screen was login) and take them to login screen
    JButton backButton = new JButton("BACK");
    backButton.setForeground(Color.BLACK);
    backButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    backButton.addActionListener(ignored -> {
      new TaskGui();
      addInventoryGui.dispose();
    });
    backButton.setBounds(160, 256, 104, 39);
    contentPane.add(backButton);

    addInventoryGui.setContentPane(contentPane);
    addInventoryGui.display();
	}
}
