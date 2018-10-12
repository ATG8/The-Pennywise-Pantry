/**
 * File: PantryButton
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
 * Creates a {@link JButton} to use in the application.
 */
public class PantryButton extends JButton {

  /**
   * Constructor.
   *
   * @param title the title of the button
   * @param fontSize the font size to use
   * @param x the x-coordinate
   * @param y the y-coordinate
   * @param width the width of the element
   * @param height the height of the element
   */
  public PantryButton(String title, int fontSize, int x, int y, int width, int height) {
    super(title);
    setForeground(BLACK);
    setFont(new Font("Tahoma", BOLD, fontSize));
    setBounds(x, y, width, height);
  }
}
