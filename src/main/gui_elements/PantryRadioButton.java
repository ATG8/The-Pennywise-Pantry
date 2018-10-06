/**
 * File: PantryRadioButton
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.gui_elements;

import javax.swing.*;
import java.awt.*;

public class PantryRadioButton extends JRadioButton {

  public PantryRadioButton(String title, boolean selected, int x, int y, int width, int height) {
    super(title);
    setForeground(Color.BLACK);
    setSelected(selected);
    setFont(new Font("Tahoma", Font.BOLD, 14));
    setBounds(x, y, width, height);
  }
}
