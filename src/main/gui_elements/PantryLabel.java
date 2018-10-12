/**
 * File: PantryLabel
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.gui_elements;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.BLACK;

/**
 * Creates a {@link JLabel} to use in the application.
 */
public class PantryLabel extends JLabel {

  /**
   * Constructor.
   *
   * @param title the label title
   * @param fontWeight the weight of the font
   * @param fontSize the size of the font
   * @param x the x-coordinate
   * @param y the y-coordinate
   * @param width the width of the element
   * @param height the height of the element
   */
  public PantryLabel(String title, int fontWeight, int fontSize, int x, int y, int width, int height) {
    super(title);
    setForeground(BLACK);
    setFont(new Font("Tahoma", fontWeight, fontSize));
    setBounds(x, y, width, height);
  }
}
