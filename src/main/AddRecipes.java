package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class AddRecipes {


  /**
	 * Create the frame.
	 */
  AddRecipes() {
    PantryFrame addRecipesGui = new PantryFrame("Pennywise Pantry", 100, 100, 440, 367);
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
    JLabel instructionLabel = new JLabel("Please add your new recipes below:");
    instructionLabel.setForeground(Color.BLACK);
    instructionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
    instructionLabel.setBounds(103, 48, 224, 20);
    contentPane.add(instructionLabel);

    JLabel itemNameLabel = new JLabel("Recipes Name:");
    itemNameLabel.setForeground(Color.BLACK);
    itemNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    itemNameLabel.setBounds(65, 116, 104, 20);
    contentPane.add(itemNameLabel);

    JTextField textRecipesName = new JTextField();
    textRecipesName.setFont(new Font("Tahoma", Font.BOLD, 14));
    textRecipesName.setForeground(Color.BLACK);
    textRecipesName.setText("Recipes Name...");
    textRecipesName.setBounds(179, 116, 162, 20);
    textRecipesName.setColumns(10);
    contentPane.add(textRecipesName);


    JLabel ingredientsLabel = new JLabel("Ingredients:");
    ingredientsLabel.setForeground(Color.BLACK);
    ingredientsLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
    ingredientsLabel.setBounds(75, 147, 94, 20);
    contentPane.add(ingredientsLabel);

    JTextField txtQuantity = new JTextField();
    txtQuantity.setText("Ingredients...");
    txtQuantity.setForeground(Color.BLACK);
    txtQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
    txtQuantity.setColumns(10);
    txtQuantity.setBounds(179, 147, 162, 20);
    contentPane.add(txtQuantity);

    //Search Button
    JButton enterButton = new JButton("ENTER");
    enterButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    enterButton.setForeground(Color.BLACK);
    enterButton.addActionListener(ignored -> {});
    enterButton.setBounds(30, 256, 104, 39);
    contentPane.add(enterButton);

    //Button to close the program
    JButton closeButton = new JButton("CLOSE");
    closeButton.setForeground(Color.BLACK);
    closeButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    closeButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent ignored) {
        addRecipesGui.dispose();
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
      addRecipesGui.dispose();
    });
    backButton.setBounds(160, 256, 104, 39);
    contentPane.add(backButton);

    addRecipesGui.setContentPane(contentPane);
    addRecipesGui.display();
	}
}
