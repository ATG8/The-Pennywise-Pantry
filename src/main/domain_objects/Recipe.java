/**
 * File: Recipe
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.domain_objects;

import java.util.List;

/**
 * Class to hold a Recipe item.
 */
public class Recipe {
  private String recipeName;
  private List<IngredientAndQuantity> ingredients;
  private String instructions;

  /**
   * Constructor.
   *
   * @param recipeName the name of the recipe
   * @param ingredients the ingredients
   * @param instructions the recipe instructions
   */
  public Recipe(String recipeName, List<IngredientAndQuantity> ingredients, String instructions) {
    this.recipeName = recipeName;
    this.ingredients = ingredients;
    this.instructions = instructions;
  }

  /**
   * @param recipeName the name of the recipe
   */
  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  /**
   * @return the name of the recipe
   */
  public String getRecipeName() {
    return recipeName;
  }

  /**
   * @param ingredients the {@link List} of {@link IngredientAndQuantity}
   */
  public void setIngredients(List<IngredientAndQuantity> ingredients) {
    this.ingredients = ingredients;
  }

  /**
   * @return the {@link List} of {@link IngredientAndQuantity}
   */
  public List<IngredientAndQuantity> getIngredients() {
    return ingredients;
  }

  /**
   * @param instructions the recipe instructions
   */
  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  /**
   * @return the recipe instructions
   */
  public String getInstructions() {
    return instructions;
  }


  /**
   * Private class to hold a list of ingredients and the quantity needed
   */
  public static class IngredientAndQuantity {
    private String ingredient;
    private int quantity;

    /**
     * Constructor.
     *
     * @param ingredient the ingredient
     * @param quantity the quantity of the ingredient
     */
    public IngredientAndQuantity(String ingredient, int quantity) {
      this.ingredient = ingredient;
      this.quantity = quantity;
    }

    /**
     * @return the ingredient
     */
    public String getIngredient() {
      return ingredient;
    }

    /**
     * @return the quantity
     */
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
        .append(instructions)
        .append("\n");

    return sb.toString();
  }
}