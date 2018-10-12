/**
 * File: PantryComboBox
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.gui_elements;

import javax.swing.*;
import java.util.List;

/**
 * Creates a {@link JComboBox} to use in the application.
 */
public class PantryComboBox extends JComboBox {

  /**
   * Constructor.
   *
   * @param uniqueList the {@link List} of {@link String} to use in the combo box
   * @param x the x-coordinate
   * @param y the y-coordinate
   * @param width the width of the element
   * @param height the height of the element
   */
  public PantryComboBox(List<String> uniqueList, int x, int y, int width, int height) {
    super(uniqueList.toArray());
    setBounds(x, y, width, height);
  }
}
