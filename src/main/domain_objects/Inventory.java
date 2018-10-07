/**
 * File: Inventory
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.domain_objects;

import java.time.Instant;
/**
*  
*/

public class Inventory {
   private long inventoryNumber;
   private String itemName;
   private Instant dateEntered;
   private Instant expireDate;
  
   public Inventory() {}
  
   public Inventory(long inventoryNumber, String itemName, Instant dateEntered, Instant expireDate) {
      this.inventoryNumber = inventoryNumber;
      this.itemName = itemName;
      this.dateEntered = dateEntered;
      this.expireDate = expireDate;
   }

   public void setInventoryNumber(long inventoryNumber) {
      this.inventoryNumber = inventoryNumber;
   }
   
   public long getInventoryNumber() {
      return inventoryNumber;
   }

   public void setItemName(String itemName) {
      this.itemName = itemName;
   }
   
   public String getItemName() {
      return itemName;
   }

   public void setDateEntered(Instant dateEntered) {
      this.dateEntered = dateEntered;
   }
   
   public Instant getDateEntered() {
      return dateEntered;
   }

   public void setExpireDate(Instant expireDate) {
      this.expireDate = expireDate;
   }
   
   public Instant getExpireDate() {
      return expireDate;
   }
}