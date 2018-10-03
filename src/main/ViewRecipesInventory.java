package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ViewRecipesInventory {

	/**
	 * Create the frame.
	 */
  ViewRecipesInventory() {
    PantryFrame viewRecipesInventoryGui = new PantryFrame("Pennywise Pantry", 100, 100, 440, 367);
    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(null);

    JButton closeButton = new JButton("CLOSE");
    closeButton.setForeground(Color.BLACK);
    closeButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    closeButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent ignored) {
        viewRecipesInventoryGui.dispose();
      }
    });
    closeButton.setBounds(273, 218, 104, 39);
    contentPane.add(closeButton);

    //Button that will log the user out (b/c the last screen was login) and take them to login screen
    JButton backButton = new JButton("BACK");
    backButton.setForeground(Color.BLACK);
    backButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    backButton.addActionListener(ignored -> {
      new TaskGui();
      viewRecipesInventoryGui.dispose();
    });
    backButton.setBounds(59, 218, 104, 39);
    contentPane.add(backButton);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(195, 76, 126, 61);
    contentPane.add(scrollPane);

    viewRecipesInventoryGui.setContentPane(contentPane);
    viewRecipesInventoryGui.display();
	}
}
