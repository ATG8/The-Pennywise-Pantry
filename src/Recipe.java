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
   
   protected void setRecipeNumber(long recipeNumber) {
      this.recipeNumber = recipeNumber;
   }
   
   public long getRecipeNumber() {
      return recipeNumber;
   }
   
   protected void setRecipeName(String recipeName) {
      this.recipeName = recipeName;
   }
   
   public String getRecipeName() {
      return recipeName;
   }
   
   protected void setIngredients(List<String> ingredients) {
      this.ingredients = ingredients;
   }
   
   public List<String> getIngredients() {
      return ingredients;
   }
   
   protected void setInstructions(String instructions) {
      this.instructions = instructions;
   }
   
   public String getInstructions() {
      return instructions;
   }
   
}