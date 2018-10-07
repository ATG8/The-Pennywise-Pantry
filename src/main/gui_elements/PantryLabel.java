/**
 * File: PantryLabel
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.gui_elements;

import javax.swing.*;
import java.awt.*;

public class PantryLabel extends JLabel {

  public PantryLabel(String title, int fontWeight, int fontSize, int x, int y, int width, int height) {
    super(title);
    setForeground(Color.BLACK);
    setFont(new Font("Tahoma", fontWeight, fontSize));
    setBounds(x, y, width, height);
  }
}
