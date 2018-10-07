/**
 * File: ViewRecipes
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.guis;

import main.domain_objects.Recipe;
import main.gui_elements.*;
import main.utils.PantryFileUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

class ViewRecipes{

  /**
	 * Create the frame.
	 */
  ViewRecipes() {
    PantryFrame viewRecipesGui = new PantryFrame("Pennywise Pantry", 100, 100, 440, 367);
    PantryPanel contentPane = new PantryPanel();

    //A welcome message
    contentPane.add(new PantryLabel("The Pennywise Pantry!", Font.BOLD, 20, 93, 11, 234, 33));

	    //Informative label instructing what to do next
    contentPane.add(new PantryLabel("Would you like to view a particular recipe or all recipes?", Font.PLAIN,
        14, 38, 49, 344, 20));

    ButtonGroup buttonGroup = new ButtonGroup();
    //All radio button
    PantryRadioButton viewAllRadio = new PantryRadioButton("View All", true, 93, 119, 102, 23);
    buttonGroup.add(viewAllRadio);
    contentPane.add(viewAllRadio);

	    //Search button
    PantryRadioButton searchRadio = new PantryRadioButton("Search:", false, 93, 157, 77, 23);
    buttonGroup.add(searchRadio);
    contentPane.add(searchRadio);
    PantryComboLists pcl = new PantryComboLists();
    List<List<String>> myList = pcl.getComboLists("Recipes");
    contentPane.add(new PantryComboBox(myList, 173, 160, 154, 20));

	  //Submit Button
    PantryButton submitButton = new PantryButton("SUBMIT", 15, 29, 239, 104, 39);
    submitButton.addActionListener(ignored -> {
      if (viewAllRadio.isSelected()) {
        List<Recipe> recipeList = PantryFileUtils.getRecipesFromFile();
        recipeList.forEach(System.out::println);
      }
    });
    contentPane.add(submitButton);

    //Button to close the program
    PantryButton closeButton = new PantryButton("CLOSE", 15, 286, 239, 104, 39);
    closeButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent ignored) {
        viewRecipesGui.dispose();
      }
    });
    contentPane.add(closeButton);

    //Button that will log the user out (b/c the last screen was login) and take them to login screen
    PantryButton backButton = new PantryButton("BACK", 15, 159, 239, 104, 39);
    backButton.addActionListener(ignored -> {
      new TaskGui();
      viewRecipesGui.dispose();
    });
    contentPane.add(backButton);

    viewRecipesGui.setContentPane(contentPane);
    viewRecipesGui.display();
	}
}
