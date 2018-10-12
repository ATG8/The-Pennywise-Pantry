/**
 * File: TaskGui
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.guis;

import main.PennywisePantryProgram;
import main.gui_elements.PantryButton;
import main.gui_elements.PantryFrame;
import main.gui_elements.PantryLabel;
import main.gui_elements.PantryPanel;

import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;
import static javax.swing.JOptionPane.showMessageDialog;
import static main.PennywisePantryProgram.access;

/**
 * Creates the GUI that lists the available tasks.
 */
public class TaskGui {

  /**
   * Create the frame for the tasks.
   */
  public TaskGui() {
    PantryFrame taskGui = new PantryFrame("Pennywise Pantry", 100, 100, 475, 405);
    PantryPanel contentPane = new PantryPanel();
    contentPane.add(new PantryLabel("The Pennywise Pantry!", BOLD, 20, 93, 11, 234, 33));
    contentPane.add(new PantryLabel("Please select your desired task below:", PLAIN, 14, 103, 65, 228, 20));

    PantryButton viewInventoryButton = new PantryButton("View Inventory", 12, 10, 123, 203, 39);
    viewInventoryButton.addActionListener(ignored -> {
      new ViewInventoryGui();
      taskGui.dispose();
    });
    contentPane.add(viewInventoryButton);

    PantryButton viewRecipesAndInventoryButton = new PantryButton("View Recipes and Inventory", 12, 10, 223, 203, 39);
    viewRecipesAndInventoryButton.addActionListener(ignored -> {
      new ViewRecipesInventoryGui("all");
      taskGui.dispose();
    });
    contentPane.add(viewRecipesAndInventoryButton);

    PantryButton viewRecipesButton = new PantryButton("View Recipes", 12, 10, 173, 203, 39);
    viewRecipesButton.addActionListener(ignored -> {
      new ViewRecipesGui();
      taskGui.dispose();
    });
    contentPane.add(viewRecipesButton);

    PantryButton addInventoryButton = new PantryButton("Add Inventory Item", 12, 243, 123, 203, 39);
    addInventoryButton.addActionListener(ignored -> {
      if (access) {
        new AddInventoryGui();
        taskGui.dispose();
      } else {
        showMessageDialog(null, "Sorry, you do not have access to modify inventory!");
      }
    });
    contentPane.add(addInventoryButton);

    PantryButton addRecipesButton = new PantryButton("Add Recipes", 12, 243, 173, 203, 39);
    addRecipesButton.addActionListener(ignored -> {
      if (access) {
        new AddRecipesGui();
        taskGui.dispose();
      } else {
        showMessageDialog(null, "Sorry, you do not have access to modify recipes!");
      }
    });
    contentPane.add(addRecipesButton);

    PantryButton listExpiringItemsButton = new PantryButton("List Expiring Items", 12, 243, 223, 203, 39);
    listExpiringItemsButton.addActionListener(ignored -> {
      new ViewRecipesInventoryGui("expiring");
      taskGui.dispose();
    });
    contentPane.add(listExpiringItemsButton);

    PantryButton backButton = new PantryButton("BACK", 12, 10, 273, 203, 39);
    backButton.addActionListener(ignored -> {
      new PennywisePantryProgram();
      taskGui.dispose();
    });
    contentPane.add(backButton);

    PantryButton closeButton = new PantryButton("CLOSE", 12, 243, 273, 203, 39);
    closeButton.addActionListener(ignored -> taskGui.dispose());
    contentPane.add(closeButton);

    taskGui.setContentPane(contentPane);
    taskGui.display();
  }
}

