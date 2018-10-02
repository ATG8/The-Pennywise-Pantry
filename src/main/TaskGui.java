package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

public class TaskGui {

  /**
   * Create the frame.
   */
  public TaskGui() {
    PantryFrame taskGui = new PantryFrame("Pennywise Pantry", 100, 100, 475, 405);

    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(null);

    JLabel pennywiseLabel = new JLabel("The Pennywise Pantry!");
    pennywiseLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
    pennywiseLabel.setBounds(93, 11, 234, 33);
    contentPane.add(pennywiseLabel);

    JLabel instructionLabel = new JLabel("Please select your desired task below:");
    instructionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
    instructionLabel.setBounds(103, 65, 228, 20);
    contentPane.add(instructionLabel);

    JButton viewInventoryButton = new JButton("View Inventory ");
    viewInventoryButton.setFont(new Font("Tahoma", Font.BOLD, 12));
    viewInventoryButton.setForeground(Color.BLACK);
//    viewInventoryButton.addActionListener(ignored -> {
//      ViewInventory inventory = new ViewInventory();
//      inventory.setVisible(true);
//      dispose();
//    });
    viewInventoryButton.setBounds(10, 123, 203, 39);
    contentPane.add(viewInventoryButton);

    JButton viewRecipesAndInventoryButton = new JButton("View Recipes and Inventory");
    viewRecipesAndInventoryButton.setForeground(Color.BLACK);
    viewRecipesAndInventoryButton.setFont(new Font("Tahoma", Font.BOLD, 12));
//	    viewRecipesAndInventoryButton.addMouseListener(new MouseAdapter() {
//	      @Override
//	      public void mouseClicked(MouseEvent arg0) {
//	    	ViewRecipesInventory viewri = new ViewRecipesInventory();
//	    	viewri.setVisible(true);;
//	        dispose();
//	      }
//	    });
    viewRecipesAndInventoryButton.setBounds(10, 223, 203, 39);
    contentPane.add(viewRecipesAndInventoryButton);

    JButton viewRecipesButton = new JButton("View Recipes");
    viewRecipesButton.setForeground(Color.BLACK);
    viewRecipesButton.setFont(new Font("Tahoma", Font.BOLD, 12));
//	    viewRecipesButton.addActionListener(e -> {
//	    	ViewRecipes recipes = new ViewRecipes();
//	    	recipes.setVisible(true);
//	        dispose();
//	    });
    viewRecipesButton.setBounds(10, 173, 203, 39);
    contentPane.add(viewRecipesButton);

    JButton addInventoryButton = new JButton("Add Inventory Item");
//    addInventoryButton.addActionListener(arg0 -> {
//      AddInventory addInventory = new AddInventory();
//      addInventory.setVisible(true);
//      taskGui.dispose();
//    });
    addInventoryButton.setForeground(Color.BLACK);
    addInventoryButton.setFont(new Font("Tahoma", Font.BOLD, 12));
    addInventoryButton.setBounds(243, 123, 203, 39);
    contentPane.add(addInventoryButton);

    JButton addRecipesButton = new JButton("Add Recipes");
//    addRecipesButton.addActionListener(arg0 -> {
//      AddRecipes addRecipes = new AddRecipes();
//      addRecipes.setVisible(true);
//      taskGui.dispose();
//    });
    addRecipesButton.setForeground(Color.BLACK);
    addRecipesButton.setFont(new Font("Tahoma", Font.BOLD, 12));
    addRecipesButton.setBounds(243, 173, 203, 39);
    contentPane.add(addRecipesButton);

    JButton listExpiringItemsButton = new JButton("List Expiring Items");
//    listExpiringItemsButton.addActionListener(arg0 -> {
//      ViewRecipesInventory viewri = new ViewRecipesInventory();
//      viewri.setVisible(true);
//      taskGui.dispose();
//    });
    listExpiringItemsButton.setForeground(Color.BLACK);
    listExpiringItemsButton.setFont(new Font("Tahoma", Font.BOLD, 12));
    listExpiringItemsButton.setBounds(243, 223, 203, 39);
    contentPane.add(listExpiringItemsButton);

    JButton closeButton = new JButton("CLOSE");
    closeButton.addActionListener(ignored -> taskGui.dispose());
    closeButton.setForeground(Color.BLACK);
    closeButton.setFont(new Font("Tahoma", Font.BOLD, 12));
    closeButton.setBounds(243, 273, 203, 39);
    contentPane.add(closeButton);

    JButton backButton = new JButton("BACK");
//    backButton.addActionListener(arg0 -> {
//      PennywisePantryProgram pantry = new PennywisePantryProgram();
//      taskGui.dispose();
//    });
    backButton.setForeground(Color.BLACK);
    backButton.setFont(new Font("Tahoma", Font.BOLD, 12));
    backButton.setBounds(10, 273, 203, 39);
    contentPane.add(backButton);

    taskGui.setContentPane(contentPane);
    taskGui.display();
  }
}

