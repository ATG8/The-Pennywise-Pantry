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
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class AddInventory extends JFrame {

	private JPanel contentPane;
	private JTextField textItemName;
	private JTextField txtQuantity;
	private JTextField txtExpirationDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddInventory frame = new AddInventory();
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
	public AddInventory() {
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
	    JLabel lblInstructions = new JLabel("Please add your new item below:");
	    lblInstructions.setForeground(Color.BLACK);
	    lblInstructions.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblInstructions.setBounds(114, 48, 208, 20);
	    contentPane.add(lblInstructions);
	    
	    JLabel lblItemName = new JLabel("Item Name:");
	    lblItemName.setForeground(Color.BLACK);
	    lblItemName.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblItemName.setBounds(86, 116, 83, 20);
	    contentPane.add(lblItemName);
	    
	    textItemName = new JTextField();
	    textItemName.setFont(new Font("Tahoma", Font.BOLD, 14));
	    textItemName.setForeground(Color.BLACK);
	    textItemName.setText("Item Name...");
	    textItemName.setBounds(179, 116, 162, 20);
	    contentPane.add(textItemName);
	    textItemName.setColumns(10);
	    
	    JLabel lblItemQuantity = new JLabel("Quantity:");
	    lblItemQuantity.setForeground(Color.BLACK);
	    lblItemQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblItemQuantity.setBounds(104, 147, 65, 20);
	    contentPane.add(lblItemQuantity);
	    
	    txtQuantity = new JTextField();
	    txtQuantity.setText("Quantity...");
	    txtQuantity.setForeground(Color.BLACK);
	    txtQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
	    txtQuantity.setColumns(10);
	    txtQuantity.setBounds(179, 147, 162, 20);
	    contentPane.add(txtQuantity);
	    
	    JLabel lblExpirationDate = new JLabel("Expiration Date:");
	    lblExpirationDate.setForeground(Color.BLACK);
	    lblExpirationDate.setFont(new Font("Tahoma", Font.BOLD, 14));
	    lblExpirationDate.setBounds(58, 181, 111, 14);
	    contentPane.add(lblExpirationDate);
	    
	    txtExpirationDate = new JTextField();
	    txtExpirationDate.setText("Expiration Date...");
	    txtExpirationDate.setForeground(Color.BLACK);
	    txtExpirationDate.setFont(new Font("Tahoma", Font.BOLD, 14));
	    txtExpirationDate.setColumns(10);
	    txtExpirationDate.setBounds(179, 178, 162, 20);
	    contentPane.add(txtExpirationDate);
	    
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
