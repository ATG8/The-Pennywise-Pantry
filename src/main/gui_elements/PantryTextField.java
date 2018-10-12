/**
 * File: PantryTextField
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.gui_elements;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Font.BOLD;

/**
 * Creates a {@link JTextField} to use in the application.
 */
public class PantryTextField extends JTextField {

  /**
   * Constructor.
   *
   * @param text the text to populate the field with
   * @param x the x-coordinate
   * @param y the y-coordinate
   * @param width the width of the element
   * @param height the height of the element
   */
  public PantryTextField(String text, int x, int y, int width, int height) {
    super();
    setText(text);
    setForeground(BLACK);
    setFont(new Font("Tahoma", BOLD, 14));
    setColumns(10);
    setBounds(x, y, width, height);
  }
}
