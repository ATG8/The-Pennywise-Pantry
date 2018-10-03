package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ViewRecipes{

  /**
	 * Create the frame.
	 */
  ViewRecipes() {
    PantryFrame viewRecipesGui = new PantryFrame("Pennywise Pantry", 100, 100, 440, 367);
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
    JLabel instructionLabel = new JLabel("Would you like to view a particular recipe or all recipes?");
    instructionLabel.setForeground(Color.BLACK);
    instructionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
    instructionLabel.setBounds(38, 49, 344, 20);
    contentPane.add(instructionLabel);

    //All radio button
    JRadioButton viewAllRadio = new JRadioButton("View All");
    viewAllRadio.setForeground(Color.BLACK);
    viewAllRadio.setSelected(true);
    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(viewAllRadio);
    viewAllRadio.setFont(new Font("Tahoma", Font.BOLD, 14));
    viewAllRadio.setBounds(93, 119, 102, 23);
    contentPane.add(viewAllRadio);

	    //Search button
    JRadioButton searchRadio = new JRadioButton("Search:");
    searchRadio.setForeground(Color.BLACK);
    buttonGroup.add(searchRadio);
    searchRadio.setFont(new Font("Tahoma", Font.BOLD, 14));
    searchRadio.setBounds(93, 157, 77, 23);
    contentPane.add(searchRadio);
    JTextField textField = new JTextField();
    textField.setForeground(Color.BLACK);
    textField.setFont(new Font("Tahoma", Font.BOLD, 14));
    textField.setBounds(173, 160, 154, 20);
    contentPane.add(textField);
    textField.setColumns(10);

	  //Submit Button
    JButton submitButton = new JButton("SUBMIT");
    submitButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    submitButton.setForeground(Color.BLACK);
    submitButton.addActionListener(ignored -> {});

    submitButton.setBounds(29, 239, 104, 39);
    contentPane.add(submitButton);

    //Button to close the program
    JButton closeButton = new JButton("CLOSE");
    closeButton.setForeground(Color.BLACK);
    closeButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    closeButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent ignored) {
        viewRecipesGui.dispose();
      }
    });
    closeButton.setBounds(286, 239, 104, 39);
    contentPane.add(closeButton);

    //Button that will log the user out (b/c the last screen was login) and take them to login screen
    JButton backButton = new JButton("BACK");
    backButton.setForeground(Color.BLACK);
    backButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    backButton.addActionListener(ignored -> {
      new TaskGui();
      viewRecipesGui.dispose();
    });
    backButton.setBounds(159, 239, 104, 39);
    contentPane.add(backButton);

    viewRecipesGui.setContentPane(contentPane);
    viewRecipesGui.display();
	}
}
