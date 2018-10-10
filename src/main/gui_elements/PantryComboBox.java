/**
 * File: PantryComboBox
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.gui_elements;

import javax.swing.*;
import java.util.List;

public class PantryComboBox extends JComboBox {
    
  public PantryComboBox(List<String> uniqueList, int x, int y, int width, int height) {
    super(uniqueList.toArray());
    setBounds(x, y, width, height);
  }
}
