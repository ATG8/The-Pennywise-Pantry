package main.utils;

import main.domain_objects.Inventory;
import main.domain_objects.Recipe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class PantryFileUtils {

  /**
   * Method to read the inventory file to create a {@link List} of Inventory items.
   *
   * @return a {@link List} of Inventory items
   */
  public static List<Inventory> getInventoryFromFile() {
    List<Inventory> inventoryList = new ArrayList<>();
    if (Files.exists(Paths.get("Inventory.txt"))) {
      try {
        List<String> contents = Files.readAllLines(Paths.get("Inventory.txt"));
        contents.forEach(line -> {
          List<String> lineContents = stream(line.split("\\|")).collect(Collectors.toList());
          long itemNumber = Long.parseLong(lineContents.get(0));
          long expiryDays = Long.parseLong(lineContents.get(3));
          Instant dateEntered = Instant.parse(lineContents.get(4));
          Instant expiryDate = dateEntered.plus(expiryDays, ChronoUnit.DAYS);
          inventoryList.add(new Inventory(itemNumber, lineContents.get(1), dateEntered, expiryDate));
        });

      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return inventoryList;
  }

  /**
   * Method to read the recipe file and create a {@link List} of Recipe items.
   *
   * @return a {@link List} of Recipe items
   */
  public static List<Recipe> getRecipesFromFile() {
    List<Recipe> recipeList = new ArrayList<>();
    if (Files.exists(Paths.get("Recipes.txt"))) {
      try {
        List<String> contents = Files.readAllLines(Paths.get("Recipes.txt"));
        contents.forEach(line -> {
          List<String> lineContents = stream(line.split("\\|")).collect(Collectors.toList());
          List<Recipe.IngredientAndQuantity> ingredients = new ArrayList<>();
          for (int i = 1; i < lineContents.size(); i++) {
            String ingredient = lineContents.get(i);
            ingredients.add(
                new Recipe.IngredientAndQuantity(ingredient.substring(0, ingredient.indexOf(",")),
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

}
