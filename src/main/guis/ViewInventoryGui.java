/**
 * File: ViewInventoryGui
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.guis;

import java.awt.Dimension;
import main.domain_objects.Inventory;
import main.gui_elements.*;
import main.utils.PantryFileUtils;

import javax.swing.*;
import java.util.List;

import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;
import static javax.swing.JOptionPane.showMessageDialog;
import static main.utils.PantryFileUtils.getComboLists;
import static main.utils.PantryFileUtils.getInventoryFromFile;

/**
 * Creates the GUI used to view the {@link Inventory}.
 */
class ViewInventoryGui {

  /**
	 * Create the frame to view the {@link Inventory}.
	 */
  ViewInventoryGui() {
    PantryFrame viewInventoryGui = new PantryFrame("Pennywise Pantry", 100, 100, 440, 367);
    PantryPanel contentPane = new PantryPanel();
    contentPane.add(new PantryLabel("The Pennywise Pantry!", BOLD, 20, 93, 11, 234, 33));
    contentPane.add(new PantryLabel("Would you like to view a particular a item or all items?", PLAIN, 14, 65, 50, 325, 20));

    ButtonGroup buttonGroup = new ButtonGroup();

    PantryRadioButton viewAllRadio = new PantryRadioButton("View All", true, 93, 118, 102, 23);
    buttonGroup.add(viewAllRadio);
    contentPane.add(viewAllRadio);

    PantryRadioButton searchRadio = new PantryRadioButton("Search:", false, 93, 156, 77, 23);
    buttonGroup.add(searchRadio);
    contentPane.add(searchRadio);
    List<String> myList = getComboLists("Inventory");
    PantryComboBox listCombo = new PantryComboBox(myList, 173, 159, 154, 20);
    contentPane.add(listCombo);

    PantryButton searchButton = new PantryButton("SEARCH", 15, 29, 239, 104, 39);
    searchButton.addActionListener(ignored -> {
        
      StringBuilder sbInventory = new StringBuilder();  
        
      if (viewAllRadio.isSelected()) {
        List<Inventory> inventoryList = getInventoryFromFile();
        
        for (Inventory item : inventoryList) {
        sbInventory.append(item);
        sbInventory.append("\n");
        }
        
        JTextArea displayList = new JTextArea();
        displayList.setText(sbInventory.toString());
        displayList.setCaretPosition(0);

        JScrollPane scrollPane = new JScrollPane(displayList);
        scrollPane.setPreferredSize(new Dimension(405, 240));
        
        showMessageDialog(null, scrollPane);
        }else{
          //get combobox selection
          String inventoryValue = listCombo.getSelectedItem().toString();
          List<Inventory> inventoryList = getInventoryFromFile();
      
          for (Inventory item : inventoryList) {
              if(item.getItemName().equalsIgnoreCase(inventoryValue)) {
                sbInventory.append(item);
                sbInventory.append("\n");
              }
          }
              
          JTextArea displayList = new JTextArea();
          displayList.setText(sbInventory.toString());
          displayList.setCaretPosition(0);

          JScrollPane scrollPane = new JScrollPane(displayList);
          scrollPane.setPreferredSize(new Dimension(405, 240));

          showMessageDialog(null, scrollPane);
        }
    });
    contentPane.add(searchButton);

    PantryButton backButton = new PantryButton("BACK", 15, 159, 239, 104, 39);
    backButton.addActionListener(ignored -> {
      new TaskGui();
      viewInventoryGui.dispose();
    });
    contentPane.add(backButton);

    PantryButton closeButton = new PantryButton("CLOSE", 15, 286, 239, 104, 39);
    closeButton.addActionListener(ignored -> viewInventoryGui.dispose());
    contentPane.add(closeButton);

    viewInventoryGui.setContentPane(contentPane);
    viewInventoryGui.display();
  }
}

