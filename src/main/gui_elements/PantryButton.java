/**
 * File: PantryButton
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.gui_elements;

import javax.swing.*;
import java.awt.*;

public class PantryButton extends JButton {

  public PantryButton(String title, int fontSize, int x, int y, int width, int height) {
    super(title);
    setForeground(Color.BLACK);
    setFont(new Font("Tahoma", Font.BOLD, fontSize));
    setBounds(x, y, width, height);
  }
}
