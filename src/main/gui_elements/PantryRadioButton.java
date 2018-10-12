/**
 * File: PantryRadioButton
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
 * Creates a {@link JRadioButton} to use in the application.
 */
public class PantryRadioButton extends JRadioButton {

  /**
   * Constructor.
   *
   * @param title the button title
   * @param selected if the button is selected as default
   * @param x the x-coordinated
   * @param y the y-coordinated
   * @param width the width of the element
   * @param height the height of the element
   */
  public PantryRadioButton(String title, boolean selected, int x, int y, int width, int height) {
    super(title);
    setForeground(BLACK);
    setSelected(selected);
    setFont(new Font("Tahoma", BOLD, 14));
    setBounds(x, y, width, height);
  }
}
