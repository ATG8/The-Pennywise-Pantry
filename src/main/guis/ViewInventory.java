/**
 * File: ViewInventory
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.guis;

import main.domain_objects.Inventory;
import main.gui_elements.*;
import main.utils.PantryFileUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import static main.utils.PantryFileUtils.getComboLists;

class ViewInventory {

  /**
	 * Create the frame.
	 */
  ViewInventory() {
    PantryFrame viewInventoryGui = new PantryFrame("Pennywise Pantry", 100, 100, 440, 367);
    PantryPanel contentPane = new PantryPanel();
    //A welcome message
    contentPane.add(new PantryLabel("The Pennywise Pantry!", Font.BOLD, 20, 93, 11, 234, 33));

    //Informative label instructing what to do next
    contentPane.add(new PantryLabel("Would you like to view a particular a item or all items?",
        Font.PLAIN, 14, 65, 50, 325, 20));

    ButtonGroup buttonGroup = new ButtonGroup();

    PantryRadioButton viewAllRadio = new PantryRadioButton("View All", true, 93, 118, 102, 23);
    buttonGroup.add(viewAllRadio);
    contentPane.add(viewAllRadio);

    PantryRadioButton searchRadio = new PantryRadioButton("Search:", false, 93, 156, 77, 23);
    buttonGroup.add(searchRadio);
    contentPane.add(searchRadio);
    List<String> myList = getComboLists("Inventory");
    contentPane.add(new PantryComboBox(myList, 173, 159, 154, 20));

    //Search Button
    PantryButton searchButton = new PantryButton("SEARCH", 15, 29, 239, 104, 39);
    searchButton.addActionListener(ignored -> {
      if (viewAllRadio.isSelected()) {
        List<Inventory> inventoryList = PantryFileUtils.getInventoryFromFile();
        inventoryList.forEach(System.out::println);
      }
    });
    contentPane.add(searchButton);

    //Button to close the program
    PantryButton closeButton = new PantryButton("CLOSE", 15, 286, 239, 104, 39);
    closeButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent ignored) {
        viewInventoryGui.dispose();
      }
    });
    contentPane.add(closeButton);

    //Button that will log the user out (b/c the last screen was login) and take them to login screen
    PantryButton backButton = new PantryButton("BACK", 15, 159, 239, 104, 39);
    backButton.addActionListener(e -> {
      new TaskGui();
      viewInventoryGui.dispose();
    });
    contentPane.add(backButton);

    viewInventoryGui.setContentPane(contentPane);
    viewInventoryGui.display();
  }
}

