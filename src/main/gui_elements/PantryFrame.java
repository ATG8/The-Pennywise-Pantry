/**
 * File: PantryFrame
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.gui_elements;

import javax.swing.*;

public class PantryFrame extends JFrame {

  public PantryFrame(String title, int x, int y, int width, int height) {
    super(title);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setBounds(x, y, width, height);
  }

  public void display() {
    setVisible(true);
  }
}
