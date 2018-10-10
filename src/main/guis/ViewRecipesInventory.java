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
import java.util.List;
import main.domain_objects.Inventory;
import main.utils.PantryFileUtils;

class ViewRecipesInventory {

	/**
	 * Create the ViewRecipesInventory frame.
	 */
  ViewRecipesInventory() {
    PantryFrame viewRecipesInventoryGui = new PantryFrame("Pennywise Pantry", 100, 100, 440, 367);
    PantryPanel contentPane = new PantryPanel();

    PantryButton closeButton = new PantryButton("CLOSE", 15, 273, 268, 104, 39);
    closeButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent ignored) {
        viewRecipesInventoryGui.dispose();
      }
    });
    contentPane.add(closeButton);

    //Button that will log the user out (b/c the last screen was login) and take them to login screen
    PantryButton backButton = new PantryButton("BACK", 15, 59, 268, 104, 39);
    backButton.addActionListener(ignored -> {
      new TaskGui();
      viewRecipesInventoryGui.dispose();
    });
    contentPane.add(backButton);

    //populate inventory
    List<Inventory> inventoryList = PantryFileUtils.getInventoryFromFile();
    StringBuilder sbInventory = new StringBuilder();
    for(Inventory item : inventoryList){
        sbInventory.append(item);
        sbInventory.append("\n");
    }
    JTextArea displayList = new JTextArea();
    displayList.setText(sbInventory.toString());
    displayList.setCaretPosition(0);
    
    JScrollPane scrollPane = new JScrollPane(displayList);
    
    scrollPane.setBounds(10, 10, 405, 240);
    contentPane.add(scrollPane);

    viewRecipesInventoryGui.setContentPane(contentPane);
    viewRecipesInventoryGui.display();
	}
}
