/**
 * File: Inventory
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.domain_objects;

import java.time.Instant;

/**
 * Class to hold an Inventory item.
 */
public class Inventory {
  private long inventoryNumber;
  private String itemName;
  private Instant dateEntered;
  private Instant expireDate;

  /**
   * Constructor.
   *
   * @param inventoryNumber the primary key
   * @param itemName        the name of the inventory item
   * @param dateEntered     the date the item was entered into the file
   * @param expireDate      the date the item expires
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

  @Override
  public String toString() {
    return "Inventory number: "
        + inventoryNumber
        + "\nItem name: "
        + itemName
        + "\nDate entered: "
        + dateEntered
        + "\nDate of expiration: "
        + expireDate
        + "\n";
  }
}