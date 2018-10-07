/**
 * File: ViewRecipesInventory
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.guis;

import main.gui_elements.PantryButton;
import main.gui_elements.PantryFrame;
import main.gui_elements.PantryPanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ViewRecipesInventory {

	/**
	 * Create the ViewRecipesInventory frame.
	 */
  ViewRecipesInventory() {
    PantryFrame viewRecipesInventoryGui = new PantryFrame("Pennywise Pantry", 100, 100, 440, 367);
    PantryPanel contentPane = new PantryPanel();

    PantryButton closeButton = new PantryButton("CLOSE", 15, 273, 218, 104, 39);
    closeButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent ignored) {
        viewRecipesInventoryGui.dispose();
      }
    });
    contentPane.add(closeButton);

    //Button that will log the user out (b/c the last screen was login) and take them to login screen
    PantryButton backButton = new PantryButton("BACK", 15, 59, 218, 104, 39);
    backButton.addActionListener(ignored -> {
      new TaskGui();
      viewRecipesInventoryGui.dispose();
    });
    contentPane.add(backButton);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(195, 76, 126, 61);
    contentPane.add(scrollPane);

    viewRecipesInventoryGui.setContentPane(contentPane);
    viewRecipesInventoryGui.display();
	}
}
