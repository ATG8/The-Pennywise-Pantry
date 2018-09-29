import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class AddRecipes extends JFrame {

	private JPanel contentPane;
	private JTextField textRecipesName;
	private JTextField txtQuantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRecipes frame = new AddRecipes();
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
	public AddRecipes() {
		setTitle("Pennywise Pantry");
	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    setBounds(100, 100, 440, 367);
	    JPanel contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);
	    contentPane.setLayout(null);

	    //A welcome message
	    JLabel lblPennywisePantry = new JLabel("The Pennywise Pantry!");
	    lblPennywisePantry.setForeground(Color.BLACK);
	    lblPennywisePantry.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblPennywisePantry.setBounds(93, 11, 234, 33);
	    contentPane.add(lblPennywisePantry);

	    //Informative label instructing what to do next
	    JLabel lblInstructions = new JLabel("Please add your new recipes below:");
	    lblInstructions.setForeground(Color.BLACK);
	    lblInstructions.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblInstructions.setBounds(103, 48, 224, 20);
	    contentPane.add(lblInstructions);
	    
	    JLabel lblItemName = new JLabel("Recipes Name:");
	    lblItemName.setForeground(Color.BLACK);
	    lblItemName.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblItemName.setBounds(65, 116, 104, 20);
	    contentPane.add(lblItemName);
	    
	    textRecipesName = new JTextField();
	    textRecipesName.setFont(new Font("Tahoma", Font.BOLD, 14));
	    textRecipesName.setForeground(Color.BLACK);
	    textRecipesName.setText("Recipes Name...");
	    textRecipesName.setBounds(179, 116, 162, 20);
	    contentPane.add(textRecipesName);
	    textRecipesName.setColumns(10);
	    
	    JLabel lblIngredients = new JLabel("Ingredients:");
	    lblIngredients.setForeground(Color.BLACK);
	    lblIngredients.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblIngredients.setBounds(75, 147, 94, 20);
	    contentPane.add(lblIngredients);
	    
	    txtQuantity = new JTextField();
	    txtQuantity.setText("Ingredients...");
	    txtQuantity.setForeground(Color.BLACK);
	    txtQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
	    txtQuantity.setColumns(10);
	    txtQuantity.setBounds(179, 147, 162, 20);
	    contentPane.add(txtQuantity);
	    
	  //Search Button
	    JButton btnEnter = new JButton("ENTER");
	    btnEnter.setFont(new Font("Tahoma", Font.BOLD, 15));
	    btnEnter.setForeground(Color.BLACK);
	    btnEnter.addActionListener(ignored -> {

	    });

	    btnEnter.setBounds(30, 256, 104, 39);
	    contentPane.add(btnEnter);

	    //Button to close the program
	    JButton btnClose = new JButton("CLOSE");
	    btnClose.setForeground(Color.BLACK);
	    btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
	    btnClose.addMouseListener(new MouseAdapter() {
	      @Override
	      public void mouseClicked(MouseEvent arg0) {
	        dispose();
	      }
	    });

	    btnClose.setBounds(287, 256, 104, 39);
	    contentPane.add(btnClose);

	    //Button that will log the user out (b/c the last screen was login) and take them to login screen
	    JButton btnBack = new JButton("BACK");
	    btnBack.setForeground(Color.BLACK);
	    btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
	    btnBack.addActionListener(e -> {
	    	TaskGui task = new TaskGui();
	    	task.setVisible(true);
	    	dispose();
	        
	    });
	    
	    btnBack.setBounds(160, 256, 104, 39);
	    contentPane.add(btnBack);
	}
}
