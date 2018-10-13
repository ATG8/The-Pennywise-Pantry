/**
 * File: ViewRecipesGui
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.guis;

import java.awt.Dimension;
import main.domain_objects.Recipe;
import main.gui_elements.*;
import main.utils.PantryFileUtils;

import javax.swing.*;
import java.util.List;

import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;
import static javax.swing.JOptionPane.showMessageDialog;
import main.domain_objects.Inventory;
import static main.utils.PantryFileUtils.getComboLists;
import static main.utils.PantryFileUtils.getInventoryFromFile;
import static main.utils.PantryFileUtils.getRecipesFromFile;

/**
 * Creates the GUI used to view the {@link Recipe}s.
 */
class ViewRecipesGui {

  /**
	 * Create the frame to view the {@link Recipe}s.
	 */
  ViewRecipesGui() {
    PantryFrame viewRecipesGui = new PantryFrame("Pennywise Pantry", 100, 100, 440, 367);
    PantryPanel contentPane = new PantryPanel();
    contentPane.add(new PantryLabel("The Pennywise Pantry!", BOLD, 20, 93, 11, 234, 33));
    contentPane.add(new PantryLabel("Would you like to view a particular recipe or all recipes?", PLAIN, 14, 38, 49, 344, 20));

    ButtonGroup buttonGroup = new ButtonGroup();

    PantryRadioButton viewAllRadio = new PantryRadioButton("View All", true, 93, 119, 102, 23);
    buttonGroup.add(viewAllRadio);
    contentPane.add(viewAllRadio);

    PantryRadioButton searchRadio = new PantryRadioButton("Search:", false, 93, 157, 77, 23);
    buttonGroup.add(searchRadio);
    contentPane.add(searchRadio);

    List<String> myList = getComboLists("Recipes");
    PantryComboBox listCombo = new PantryComboBox(myList, 173, 160, 154, 20);
    contentPane.add(listCombo);

    PantryButton submitButton = new PantryButton("SUBMIT", 15, 29, 239, 104, 39);
    submitButton.addActionListener(ignored -> {
        
        
      StringBuilder sbRecipes = new StringBuilder();
        
      if (viewAllRadio.isSelected()) {
        List<Recipe> recipeList = getRecipesFromFile();
        
        for (Recipe item : recipeList) {
        sbRecipes.append(item);
        sbRecipes.append("\n");
        }
        
        JTextArea displayList = new JTextArea();
        displayList.setText(sbRecipes.toString());
        displayList.setCaretPosition(0);

        JScrollPane scrollPane = new JScrollPane(displayList);
        scrollPane.setPreferredSize(new Dimension(405, 240));
        
        showMessageDialog(null, scrollPane);
        }else{
          //get combobox selection
          String recipeValue = listCombo.getSelectedItem().toString();
          List<Recipe> recipeList = getRecipesFromFile();
      
          for (Recipe item : recipeList) {
              if(item.getRecipeName().equalsIgnoreCase(recipeValue)) {
                sbRecipes.append(item);
                sbRecipes.append("\n");
              }
          }
              
          JTextArea displayList = new JTextArea();
          displayList.setText(sbRecipes.toString());
          displayList.setCaretPosition(0);

          JScrollPane scrollPane = new JScrollPane(displayList);
          scrollPane.setPreferredSize(new Dimension(405, 240));

          showMessageDialog(null, scrollPane);
        }
    });
    contentPane.add(submitButton);

    PantryButton backButton = new PantryButton("BACK", 15, 159, 239, 104, 39);
    backButton.addActionListener(ignored -> {
      new TaskGui();
      viewRecipesGui.dispose();
    });
    contentPane.add(backButton);

    PantryButton closeButton = new PantryButton("CLOSE", 15, 286, 239, 104, 39);
    closeButton.addActionListener(ignored -> viewRecipesGui.dispose());
    contentPane.add(closeButton);

    viewRecipesGui.setContentPane(contentPane);
    viewRecipesGui.display();
	}
}
