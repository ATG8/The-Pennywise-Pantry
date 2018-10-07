/**
 * File: PantryComboLists
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.gui_elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PantryComboLists{
    private static List<List<String>> fileContents = new ArrayList<>();
    private static List<List<String>> temp = new ArrayList<>();
    private static List<List<String>> uniqueList = new ArrayList<>();
    
  public List<List<String>> getComboLists(String listType) {
    if(listType.equals("Inventory")){
        getInventory();
        getRefined("Inventory");
    }else{
        getRecipes();
        getRefined("Recipes");
    }
    return uniqueList;
  }
  
  private static void getInventory() {
    if (Files.exists(Paths.get("Inventory.txt"))) {
      try {
        fileContents.clear();
        List<String> contents = Files.readAllLines(Paths.get("Inventory.txt"));
        contents.forEach(line -> fileContents.add(Arrays.stream(line.split("\\|")).collect(Collectors.toList())));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  private static void getRecipes() {
    if (Files.exists(Paths.get("Recipes.txt"))) {
      try {
        fileContents.clear();
        List<String> contents = Files.readAllLines(Paths.get("Recipes.txt"));
        contents.forEach(line -> fileContents.add(Arrays.stream(line.split("\\|")).collect(Collectors.toList())));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  private List<List<String>> getRefined(String listType) {
    if(listType.equals("Inventory")){
        uniqueList.clear();
        temp.clear();
        for(List list : fileContents){
            temp.add(list.subList(1, 2));
        }
        for(List list : temp){
            if(!uniqueList.contains(list)){
                uniqueList.add(list);
            }
        }
    }else{
        uniqueList.clear();
        temp.clear();
        for(List list : fileContents){
            temp.add(list.subList(0, 1));
        }
        for(List list : temp){
            if(!uniqueList.contains(list)){
                uniqueList.add(list);
            }
        }
    }
    return uniqueList;
  }
}