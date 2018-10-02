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
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.WindowConstants;
//
//import javax.swing.JScrollPane;
//
//public class ViewRecipesInventory extends JFrame {
//
//	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewRecipesInventory frame = new ViewRecipesInventory();
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
//	public ViewRecipesInventory() {
//		setTitle("Pennywise Pantry");
//	    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//	    setBounds(100, 100, 440, 367);
//	    JPanel contentPane = new JPanel();
//	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//	    setContentPane(contentPane);
//	    contentPane.setLayout(null);
//
//		JButton btnClose = new JButton("CLOSE");
//	    btnClose.setForeground(Color.BLACK);
//	    btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
//	    btnClose.addMouseListener(new MouseAdapter() {
//	      @Override
//	      public void mouseClicked(MouseEvent arg0) {
//	        dispose();
//	      }
//	    });
//
//	    btnClose.setBounds(273, 218, 104, 39);
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
//	    btnBack.setBounds(59, 218, 104, 39);
//	    contentPane.add(btnBack);
//
//	    JScrollPane scrollPane = new JScrollPane();
//	    scrollPane.setBounds(195, 76, 126, 61);
//	    contentPane.add(scrollPane);
//	}
//}
