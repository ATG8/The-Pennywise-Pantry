/**
 * File: Recipe
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.domain_objects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

/**
 *
 */

public class Recipe {
  private String recipeName;
  private List<IngredientAndQuantity> ingredients;
  private String instructions;

  public Recipe() {}

  public Recipe(String recipeName, List<IngredientAndQuantity> ingredients, String instructions) {
    this.recipeName = recipeName;
    this.ingredients = ingredients;
    this.instructions = instructions;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  public String getRecipeName() {
    return recipeName;
  }

  public void setIngredients(List<IngredientAndQuantity> ingredients) {
    this.ingredients = ingredients;
  }

  public List<IngredientAndQuantity> getIngredients() {
    return ingredients;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  public String getInstructions() {
    return instructions;
  }

  public List<Recipe> getRecipesFromFile() {
    List<Recipe> recipeList = new ArrayList<>();
    if (Files.exists(Paths.get("Recipes.txt"))) {
      try {
        List<String> contents = Files.readAllLines(Paths.get("Recipes.txt"));
        contents.forEach(line -> {
          List<String> lineContents = stream(line.split("\\|")).collect(Collectors.toList());
          List<IngredientAndQuantity> ingredients = new ArrayList<>();
          for (int i = 1; i < lineContents.size(); i++) {
            String ingredient = lineContents.get(i);
            ingredients.add(
                new IngredientAndQuantity(ingredient.substring(0, ingredient.indexOf(",")),
                    Integer.parseInt(ingredient.substring(ingredient.indexOf(",") + 1))));
          }
          String name = lineContents.get(0);
          recipeList.add(new Recipe(name, ingredients, null));
        });

      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return recipeList;
  }

  private class IngredientAndQuantity {
    private String ingredient;
    private int quantity;

    IngredientAndQuantity(String ingredient, int quantity) {
      this.ingredient = ingredient;
      this.quantity = quantity;
    }

    public String getIngredient() {
      return ingredient;
    }

    public int getQuantity() {
      return quantity;
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Recipe name: ")
        .append(recipeName);
    ingredients.forEach(ingredient -> sb.append("\nIngredient: ")
        .append(ingredient.getIngredient())
        .append("\nQuantity: ")
        .append(ingredient.getQuantity()));
    sb.append("\nInstructions: ")
        .append(instructions);

    return sb.toString();
  }

}