/**
 * File: Recipe
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.domain_objects;

import java.util.List;
/**
*  
*/

public class Recipe {
   private long recipeNumber;
   private String recipeName;
   private List<String> ingredients;
   private String instructions;
  
   public Recipe() {}
  
   public Recipe(long recipeNumber, String recipeName, List<String> ingredients, String instructions) {
      this.recipeNumber = recipeNumber;
      this.recipeName = recipeName;
      this.ingredients = ingredients;
      this.instructions = instructions;
   }  
   
   public void setRecipeNumber(long recipeNumber) {
      this.recipeNumber = recipeNumber;
   }
   
   public long getRecipeNumber() {
      return recipeNumber;
   }

   public void setRecipeName(String recipeName) {
      this.recipeName = recipeName;
   }
   
   public String getRecipeName() {
      return recipeName;
   }

   public void setIngredients(List<String> ingredients) {
      this.ingredients = ingredients;
   }
   
   public List<String> getIngredients() {
      return ingredients;
   }

   public void setInstructions(String instructions) {
      this.instructions = instructions;
   }
   
   public String getInstructions() {
      return instructions;
   }
   
}