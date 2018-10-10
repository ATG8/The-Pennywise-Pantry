/**
 * File: AddRecipes
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.guis;

import main.domain_objects.Recipe;
import main.gui_elements.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static main.utils.PantryFileUtils.saveRecipesToFile;

class AddRecipes {


  /**
	 * Create the frame.
	 */
  AddRecipes() {
    PantryFrame addRecipesGui = new PantryFrame("Pennywise Pantry", 100, 100, 440, 367);
    PantryPanel contentPane = new PantryPanel();

    //A welcome message
    contentPane.add(new PantryLabel("The Pennywise Pantry!", Font.BOLD, 20, 93, 11, 234, 33));

    //Informative label instructing what to do next
    contentPane.add(new PantryLabel("Please add your new recipes below:", Font.PLAIN, 14, 103, 48, 224, 20));

    PantryTextField recipeNameText = new PantryTextField("Recipes Name...", 179, 116, 162, 20);
    PantryTextField ingredientText = new PantryTextField("Ingredients...", 179, 147, 162, 20);
    contentPane.add(new PantryLabel("Recipes Name:", Font.BOLD, 14, 65, 116, 104, 20));
    contentPane.add(recipeNameText);
    contentPane.add(new PantryLabel("Ingredients:", Font.BOLD, 14, 75, 147, 94, 20));
    contentPane.add(ingredientText);

    //Enter Button
    List<Recipe> recipeList = new ArrayList<>();
    PantryButton enterButton = new PantryButton("ENTER", 15, 30, 256, 104, 39);
    enterButton.addActionListener(ignored -> {
      String recipeName = recipeNameText.getText();
      String ingredients = ingredientText.getText();
      if (recipeName.trim().isEmpty() || recipeName == null
          || ingredients.trim().isEmpty() || ingredients == null) {
        JOptionPane.showMessageDialog(null, "All fields are required.");
      }
      List<String> stringList = stream(ingredients.split("\\|")).collect(Collectors.toList());
      List<Recipe.IngredientAndQuantity> ingredientList = new ArrayList<>();
      stringList.forEach(item -> {
        String[] stringArray = item.split(",");
        int quant = Integer.parseInt(stringArray[1]);
        ingredientList.add(new Recipe.IngredientAndQuantity(stringArray[0], quant));
      });
      recipeList.add(new Recipe(recipeName, ingredientList, null));
      recipeNameText.setText("");
      ingredientText.setText("");
    });
    contentPane.add(enterButton);

    //Button to close the program
    PantryButton closeButton = new PantryButton("CLOSE", 15, 287, 256, 104, 39);
    closeButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent ignored) {
        saveRecipesToFile(recipeList);
        addRecipesGui.dispose();
      }
    });
    contentPane.add(closeButton);

    //Button that will log the user out (b/c the last screen was login) and take them to login screen
    PantryButton backButton = new PantryButton("BACK", 15, 160, 256, 104, 39);
    backButton.addActionListener(ignored -> {
      saveRecipesToFile(recipeList);
      new TaskGui();
      addRecipesGui.dispose();
    });
    contentPane.add(backButton);

    addRecipesGui.setContentPane(contentPane);
    addRecipesGui.display();
	}
}
