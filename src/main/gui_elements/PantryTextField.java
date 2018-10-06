/**
 * File: PantryTextField
 * Group 5: JayElElEm
 * Date: 12 Oct 2018
 * Purpose: CMSC 495 Group Project
 */
package main.gui_elements;

import javax.swing.*;
import java.awt.*;

public class PantryTextField extends JTextField {

  public PantryTextField(String text, int x, int y, int width, int height) {
    super();
    setText(text);
    setForeground(Color.BLACK);
    setFont(new Font("Tahoma", Font.BOLD, 14));
    setColumns(10);
    setBounds(x, y, width, height);
  }
}
