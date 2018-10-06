/**
 * File: AddInventory
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.guis;

import main.gui_elements.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class AddInventory {

  /**
	 * Create the frame.
	 */
  AddInventory() {
    PantryFrame addInventoryGui = new PantryFrame("Pennywise Pantry", 100, 100, 440, 367);

    PantryPanel contentPane = new PantryPanel();

    //A welcome message
    contentPane.add(new PantryLabel("The Pennywise Pantry!", Font.BOLD, 20, 93, 11, 234, 33));
    contentPane.add(new PantryLabel("Please add your new item below:", Font.PLAIN, 14, 114, 48, 208, 20));
    contentPane.add(new PantryLabel("Item Name:", Font.BOLD, 14, 86, 116, 83, 20));

    PantryTextField itemNameText = new PantryTextField("Item Name...", 179, 116, 162, 20);
    contentPane.add(itemNameText);

    contentPane.add(new PantryLabel("Quantity:", Font.BOLD, 14, 104, 147, 65, 20));

    PantryTextField quantityText = new PantryTextField("Quantity...", 179, 147, 162, 20);
    contentPane.add(quantityText);

    contentPane.add(new PantryLabel("Expiration Date:", Font.BOLD, 14, 58, 181, 111, 14));

    PantryTextField expirationDateText = new PantryTextField("Expiration Date...", 179, 178, 162, 20);
    contentPane.add(expirationDateText);

    //Search Button
    PantryButton enterButton = new PantryButton("ENTER", 15, 30, 256, 104, 39);
    enterButton.addActionListener(ignored -> {
      itemNameText.setText("");
      quantityText.setText("");
      expirationDateText.setText("");
    });
    contentPane.add(enterButton);

    //Button to close the program
    PantryButton closeButton = new PantryButton("CLOSE", 15, 287, 256, 104, 39);
    closeButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent ignored) {
        addInventoryGui.dispose();
      }
    });
    contentPane.add(closeButton);

    //Button that will log the user out (b/c the last screen was login) and take them to login screen
    PantryButton backButton = new PantryButton("BACK", 15, 160, 256, 104, 39);
    backButton.addActionListener(ignored -> {
      new TaskGui();
      addInventoryGui.dispose();
    });
    contentPane.add(backButton);

    addInventoryGui.setContentPane(contentPane);
    addInventoryGui.display();
	}
}
