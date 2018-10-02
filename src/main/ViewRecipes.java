//package main;
//
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.WindowConstants;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JRadioButton;
//import javax.swing.JTextField;
//import javax.swing.ButtonGroup;
//
//public class ViewRecipes extends JFrame {
//
//	private JPanel contentPane;
//	private JTextField textField;
//	private final ButtonGroup buttonGroup = new ButtonGroup();
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewRecipes frame = new ViewRecipes();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public ViewRecipes() {
//		setTitle("Pennywise Pantry");
//	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//	    setBounds(100, 100, 440, 367);
//	    JPanel contentPane = new JPanel();
//	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//	    setContentPane(contentPane);
//	    contentPane.setLayout(null);
//
//	    //A welcome message
//	    JLabel lblPennywisePantry = new JLabel("The Pennywise Pantry!");
//	    lblPennywisePantry.setForeground(Color.BLACK);
//	    lblPennywisePantry.setFont(new Font("Tahoma", Font.BOLD, 20));
//	    lblPennywisePantry.setBounds(93, 11, 234, 33);
//	    contentPane.add(lblPennywisePantry);
//
//	    //Informative label instructing what to do next
//	    JLabel lblInstructions = new JLabel("Would you like to view a particular recipe or all recipes?");
//	    lblInstructions.setForeground(Color.BLACK);
//	    lblInstructions.setFont(new Font("Tahoma", Font.PLAIN, 14));
//	    lblInstructions.setBounds(38, 49, 344, 20);
//	    contentPane.add(lblInstructions);
//
//	    //All radio button
//	    JRadioButton rdbtnAll = new JRadioButton("View All");
//	    rdbtnAll.setForeground(Color.BLACK);
//	    rdbtnAll.setSelected(true);
//	    buttonGroup.add(rdbtnAll);
//	    rdbtnAll.setFont(new Font("Tahoma", Font.BOLD, 14));
//	    rdbtnAll.setBounds(93, 119, 102, 23);
//	    contentPane.add(rdbtnAll);
//
//	    //Search button
//	    JRadioButton rdbtnSearch = new JRadioButton("Search:");
//	    rdbtnSearch.setForeground(Color.BLACK);
//	    buttonGroup.add(rdbtnSearch);
//	    rdbtnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
//	    rdbtnSearch.setBounds(93, 157, 77, 23);
//	    contentPane.add(rdbtnSearch);
//	    textField = new JTextField();
//	    textField.setForeground(Color.BLACK);
//	    textField.setFont(new Font("Tahoma", Font.BOLD, 14));
//	    textField.setBounds(173, 160, 154, 20);
//	    contentPane.add(textField);
//	    textField.setColumns(10);
//
//	  //Submit Button
//	    JButton btnSubmit = new JButton("SUBMIT");
//	    btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
//	    btnSubmit.setForeground(Color.BLACK);
//	    btnSubmit.addActionListener(ignored -> {
//
//	    });
//
//	    btnSubmit.setBounds(29, 239, 104, 39);
//	    contentPane.add(btnSubmit);
//
//	    //Button to close the program
//	    JButton btnClose = new JButton("CLOSE");
//	    btnClose.setForeground(Color.BLACK);
//	    btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
//	    btnClose.addMouseListener(new MouseAdapter() {
//	      @Override
//	      public void mouseClicked(MouseEvent arg0) {
//	        dispose();
//	      }
//	    });
//
//	    btnClose.setBounds(286, 239, 104, 39);
//	    contentPane.add(btnClose);
//
//	    //Button that will log the user out (b/c the last screen was login) and take them to login screen
//	    JButton btnBack = new JButton("BACK");
//	    btnBack.setForeground(Color.BLACK);
//	    btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
//	    btnBack.addActionListener(e -> {
//	    	TaskGui task = new TaskGui();
//	    	task.setVisible(true);
//	    	dispose();
//
//	    });
//
//	    btnBack.setBounds(159, 239, 104, 39);
//	    contentPane.add(btnBack);
//	}
//}
