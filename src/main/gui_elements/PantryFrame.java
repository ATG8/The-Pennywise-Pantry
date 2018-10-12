/**
 * File: PantryFrame
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.gui_elements;

import javax.swing.*;

/**
 * Creates a {@link JFrame} to use in the application.
 */
public class PantryFrame extends JFrame {

  /**
   * Constructor.
   *
   * @param title the title of the {@link JFrame}
   * @param x the x-coordinate
   * @param y the y-coordinate
   * @param width the width of the element
   * @param height the height of the element
   */
  public PantryFrame(String title, int x, int y, int width, int height) {
    super(title);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setBounds(x, y, width, height);
  }

  /**
   * Sets the visibility of the {@link JFrame} to true.
   */
  public void display() {
    setVisible(true);
  }
}
