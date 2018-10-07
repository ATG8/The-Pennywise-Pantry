/**
 * File: Inventory
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.domain_objects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

/**
* Class to hold an Inventory item.
*/
public class Inventory {
   private long inventoryNumber;
   private String itemName;
   private Instant dateEntered;
   private Instant expireDate;
  
   public Inventory() {}

   /**
    * Constructor.
    *
    * @param inventoryNumber the primary key
    * @param itemName the name of the inventory item
    * @param dateEntered the date the item was entered into the file
    * @param expireDate the date the item expires
    */
   public Inventory(long inventoryNumber, String itemName, Instant dateEntered, Instant expireDate) {
      this.inventoryNumber = inventoryNumber;
      this.itemName = itemName;
      this.dateEntered = dateEntered;
      this.expireDate = expireDate;
   }

   /**
    * @param inventoryNumber the primary key
    */
   public void setInventoryNumber(long inventoryNumber) {
      this.inventoryNumber = inventoryNumber;
   }

   /**
    * @return the primary key
    */
   public long getInventoryNumber() {
      return inventoryNumber;
   }

   /**
    * @param itemName the name of the inventory item
    */
   public void setItemName(String itemName) {
      this.itemName = itemName;
   }

   /**
    * @return the name of the inventory item
    */
   public String getItemName() {
      return itemName;
   }

   /**
    * @param dateEntered the date the item was entered
    */
   public void setDateEntered(Instant dateEntered) {
      this.dateEntered = dateEntered;
   }

   /**
    * @return the date the item was entered
    */
   public Instant getDateEntered() {
      return dateEntered;
   }

   /**
    * @param expireDate the date the item expires
    */
   public void setExpireDate(Instant expireDate) {
      this.expireDate = expireDate;
   }

   /**
    * @return the date the item expires
    */
   public Instant getExpireDate() {
      return expireDate;
   }

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
}