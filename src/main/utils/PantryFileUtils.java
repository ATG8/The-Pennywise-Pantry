/**
 * File: PantryFileUtils
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.utils;

import main.PennywisePantryProgram;
import main.domain_objects.Inventory;
import main.domain_objects.Recipe;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.util.Arrays.stream;

/**
 * Holds utility methods used in this application.
 */
public class PantryFileUtils {

  /**
   * Reads the inventory file to create a {@link List} of {@link Inventory} items.
   *
   * @return a {@link List} of {@link Inventory} items
   */
  public static List<Inventory> getInventoryFromFile() {
    List<Inventory> inventoryList = new ArrayList<>();
    Path path = null;
    try {
      path = Paths.get(PantryFileUtils.class.getClassLoader().getResource("Inventory.txt").toURI());
    } catch (URISyntaxException ex) {
      ex.printStackTrace();
    }
    if (Files.exists(path)) {
      try {
        List<String> contents = Files.readAllLines(path);
        contents.forEach(line -> {
          List<String> lineContents = stream(line.split("\\|")).collect(Collectors.toList());
          long itemNumber = Long.parseLong(lineContents.get(0));
          long expiryDays = Long.parseLong(lineContents.get(2));
          Instant dateEntered = Instant.parse(lineContents.get(3));
          Instant expiryDate = dateEntered.plus(expiryDays, DAYS);
          inventoryList.add(new Inventory(itemNumber, lineContents.get(1), dateEntered, expiryDate));
        });
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return inventoryList;
  }

  /**
   * Reads the recipe file and create a {@link List} of {@link Recipe} items.
   *
   * @return a {@link List} of {@link Recipe} items
   */
  public static List<Recipe> getRecipesFromFile() {
    List<Recipe> recipeList = new ArrayList<>();
    Path path = null;
    try {
      path = Paths.get(PantryFileUtils.class.getClassLoader().getResource("Recipes.txt").toURI());
    } catch (URISyntaxException ex) {
      ex.printStackTrace();
    }
    if (Files.exists(path)) {
      try {
        List<String> contents = Files.readAllLines(path);
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

  /**
   * Creates a list of unique entries for use in a combo box.
   *
   * @param listType the object type of the list to turn into a list for the combo box
   * @return the list to use for the combo box
   */
  public static List<String> getComboLists(String listType) {
    List<String> comboList;
    if ("Inventory".equals(listType)) {
      List<Inventory> inventoryList = getInventoryFromFile();
      comboList = inventoryList.stream().map(Inventory::getItemName).distinct().collect(Collectors.toList());
    } else {
      List<Recipe> recipeList = getRecipesFromFile();
      comboList = recipeList.stream().map(Recipe::getRecipeName).distinct().collect(Collectors.toList());
    }
    return comboList;
  }

  /**
   * Saves the {@link List} of {@link Inventory} to file.
   *
   * @param inventoryList the {@link List} of {@link Inventory} to save
   */
  public static void saveInventoryToFile(List<Inventory> inventoryList) {
    List<Inventory> currentList = getInventoryFromFile();
    currentList.addAll(inventoryList);
    for (int i = 0; i < currentList.size(); i++) {
      currentList.get(i).setInventoryNumber(i + 1);
    }
    StringBuilder sb = new StringBuilder();
    currentList.forEach(item -> sb.append(item.getInventoryNumber())
        .append("|")
        .append(item.getItemName())
        .append("|")
        .append(Instant.now().until(item.getExpireDate(), DAYS))
        .append("|")
        .append(item.getDateEntered())
        .append("\n"));
    byte[] contents = sb.toString().getBytes();

    Path path = null;
    try {
      path = Paths.get(PantryFileUtils.class.getClassLoader().getResource("Inventory.txt").toURI());
    } catch (URISyntaxException ex) {
      ex.printStackTrace();
    }

    try (OutputStream out = Files.newOutputStream(path)) {
      out.write(contents);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Saves the {@link List} of {@link Recipe} to file.
   *
   * @param recipeList the {@link List} of {@link Recipe} to save
   */
  public static void saveRecipesToFile(List<Recipe> recipeList) {
    List<Recipe> currentList = getRecipesFromFile();
    currentList.addAll(recipeList);

    StringBuilder sb = new StringBuilder();
    currentList.forEach(item -> {
      sb.append(item.getRecipeName());
      item.getIngredients().forEach(ingredient -> sb.append("|")
          .append(ingredient.getIngredient())
          .append(",")
          .append(ingredient.getQuantity()));
      sb.append("\n");
    });
    byte[] contents = sb.toString().getBytes();

    Path path = null;
    try {
      path = Paths.get(PantryFileUtils.class.getClassLoader().getResource("Recipes.txt").toURI());
    } catch (URISyntaxException ex) {
      ex.printStackTrace();
    }

    try (OutputStream out = Files.newOutputStream(path)) {
      out.write(contents);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
