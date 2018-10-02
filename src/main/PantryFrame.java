package main;

import javax.swing.*;

class PantryFrame extends JFrame {

  PantryFrame(String title, int x, int y, int width, int height) {
    super(title);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setBounds(x, y, width, height);
  }

  void display() {
    setVisible(true);
  }
}
