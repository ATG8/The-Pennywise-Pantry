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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TaskGui extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskGui frame = new TaskGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TaskGui() {
		setTitle("Pennywise Pantry");
	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    setBounds(100, 100, 475, 405);
	    JPanel contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);

	    //A welcome message
	    JLabel lblPennywisePantry = new JLabel("The Pennywise Pantry!");
	    lblPennywisePantry.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblPennywisePantry.setBounds(93, 11, 234, 33);
	    contentPane.add(lblPennywisePantry);

	    //Informative label instructing what to do next
	    JLabel lblInstructions = new JLabel("Please select your desired task below:");
	    lblInstructions.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblInstructions.setBounds(103, 65, 228, 20);
	    contentPane.add(lblInstructions);

	    //View Inventory Button
	    JButton btnViewInv = new JButton("View Inventory ");
	    btnViewInv.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnViewInv.setForeground(Color.BLACK);
	    btnViewInv.addActionListener(ignored -> {
	    	ViewInventory inventory = new ViewInventory();
	    	inventory.setVisible(true);
	    	dispose();
	    	
	    });

	    btnViewInv.setBounds(10, 123, 203, 39);
	    contentPane.add(btnViewInv);

	    //View Recipes and Inventory button
	    JButton btnViewRecNInv = new JButton("View Recipes and Inventory");
	    btnViewRecNInv.setForeground(Color.BLACK);
	    btnViewRecNInv.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnViewRecNInv.addMouseListener(new MouseAdapter() {
	      @Override
	      public void mouseClicked(MouseEvent arg0) {
	    	ViewRecipesInventory viewri = new ViewRecipesInventory();
	    	viewri.setVisible(true);;
	        dispose();
	      }
	    });

	    btnViewRecNInv.setBounds(10, 223, 203, 39);
	    contentPane.add(btnViewRecNInv);

	    //View Recipes button
	    JButton btnViewRec = new JButton("View Recipes");
	    btnViewRec.setForeground(Color.BLACK);
	    btnViewRec.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnViewRec.addActionListener(e -> {
	    	ViewRecipes recipes = new ViewRecipes();
	    	recipes.setVisible(true);
	        dispose();
	    });

	    btnViewRec.setBounds(10, 173, 203, 39);
	    contentPane.add(btnViewRec);
	    
	    //Add Inventory Button
	    JButton btnAddInventoryItem = new JButton("Add Inventory Item");
	    btnAddInventoryItem.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		AddInventory addInventory = new AddInventory();
	    		addInventory.setVisible(true);
	    		dispose();
	    	}
	    });
	    btnAddInventoryItem.setForeground(Color.BLACK);
	    btnAddInventoryItem.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnAddInventoryItem.setBounds(243, 123, 203, 39);
	    contentPane.add(btnAddInventoryItem);
	    
	    //Add Recipes button
	    JButton btnAddRecipes = new JButton("Add Recipes");
	    btnAddRecipes.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		AddRecipes addRecipes = new AddRecipes();
	    		addRecipes.setVisible(true);
	    		dispose();
	    	}
	    });
	    btnAddRecipes.setForeground(Color.BLACK);
	    btnAddRecipes.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnAddRecipes.setBounds(243, 173, 203, 39);
	    contentPane.add(btnAddRecipes);
	    
	    //List expiring items button
	    JButton btnListExpiringItems = new JButton("List Expiring Items");
	    btnListExpiringItems.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
		    	ViewRecipesInventory viewri = new ViewRecipesInventory();
		    	viewri.setVisible(true);;
		        dispose();	
	    	}
	    });
	    btnListExpiringItems.setForeground(Color.BLACK);
	    btnListExpiringItems.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnListExpiringItems.setBounds(243, 223, 203, 39);
	    contentPane.add(btnListExpiringItems);
	    
	    //close button
	    JButton btnClose = new JButton("CLOSE");
	    btnClose.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		dispose();
	    	}
	    });
	    btnClose.setForeground(Color.BLACK);
	    btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnClose.setBounds(243, 273, 203, 39);
	    contentPane.add(btnClose);
	    
	    //Back button
	    JButton btnBack = new JButton("BACK");
	    btnBack.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		PantryGui pantry = new PantryGui();
	    		pantry.setVisible(true);;
	    		dispose();
	    	}
	    });
	    btnBack.setForeground(Color.BLACK);
	    btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
	    btnBack.setBounds(10, 273, 203, 39);
	    contentPane.add(btnBack);
	  }
	}

