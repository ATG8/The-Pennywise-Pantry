/**
 * File: ViewRecipesInventoryGui
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.guis;

import main.domain_objects.Inventory;
import main.domain_objects.Recipe;
import main.gui_elements.PantryButton;
import main.gui_elements.PantryFrame;
import main.gui_elements.PantryPanel;

import javax.swing.*;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;
import static main.utils.PantryFileUtils.getInventoryFromFile;
import static main.utils.PantryFileUtils.getRecipesFromFile;

/**
 * Creates the GUI to view the {@link Recipe}s and {@link Inventory}.
 */
class ViewRecipesInventoryGui {

	/**
	 * Create the GUI to view the {@link Recipe}s and {@link Inventory}.
	 */
  ViewRecipesInventoryGui(String viewWhat) {
    PantryFrame viewRecipesInventoryGui = new PantryFrame("Pennywise Pantry", 100, 100, 440, 367);
    PantryPanel contentPane = new PantryPanel();

    if ("all".equals(viewWhat)) {
      List<Inventory> inventoryList = getInventoryFromFile();
      List<Recipe> recipeList = getRecipesFromFile();
      StringBuilder sbInventoryRecipe = new StringBuilder();

      for (Inventory item : inventoryList) {
        sbInventoryRecipe.append(item);
        sbInventoryRecipe.append("\n");
      }
      for (Recipe ingredients : recipeList) {
        sbInventoryRecipe.append(ingredients);
        sbInventoryRecipe.append("\n");
      }
      JTextArea displayList = new JTextArea();
      displayList.setText(sbInventoryRecipe.toString());
      displayList.setCaretPosition(0);

      JScrollPane scrollPane = new JScrollPane(displayList);

      scrollPane.setBounds(10, 10, 405, 240);
      contentPane.add(scrollPane);
    } else { // only list inventory about to expire
      List<Inventory> inventoryList = getInventoryFromFile();
      StringBuilder sbInventoryExpiring = new StringBuilder();
      for (Inventory item : inventoryList) {
        if (Instant.now().plus(Duration.of(3, DAYS)).isAfter(item.getExpireDate())) {
          sbInventoryExpiring.append(item);
          sbInventoryExpiring.append("\n");
        }
      }

      JTextArea displayList = new JTextArea();
      displayList.setText(sbInventoryExpiring.toString());
      displayList.setCaretPosition(0);

      JScrollPane scrollPane = new JScrollPane(displayList);
      scrollPane.setBounds(10, 10, 405, 240);
      contentPane.add(scrollPane);
    }

    PantryButton backButton = new PantryButton("BACK", 15, 59, 268, 104, 39);
    backButton.addActionListener(ignored -> {
      new TaskGui();
      viewRecipesInventoryGui.dispose();
    });
    contentPane.add(backButton);

    PantryButton closeButton = new PantryButton("CLOSE", 15, 273, 268, 104, 39);
    closeButton.addActionListener(ignored -> viewRecipesInventoryGui.dispose());
    contentPane.add(closeButton);

    viewRecipesInventoryGui.setContentPane(contentPane);
    viewRecipesInventoryGui.display();
	}
}
