package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import businessLogic.BLFacade;

import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class HomepageGUI {

	private JFrame frmBetAndRuin;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomepageGUI window = new HomepageGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public HomepageGUI() {
		initialize();
		updateData();
	}
	
	public void updateData() {
		BLFacade facade=MainGUI.getBusinessLogic();
		//facade.updateData();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBetAndRuin = new JFrame();
		frmBetAndRuin.setTitle(ResourceBundle.getBundle("Etiquetas").getString("HomepageGUI.frmBetAndRuin.title")); //$NON-NLS-1$ //$NON-NLS-2$
		frmBetAndRuin.getContentPane().setBackground(Color.BLACK);
		frmBetAndRuin.getContentPane().setForeground(Color.BLACK);
		frmBetAndRuin.setBounds(100, 100, 450, 400);
		frmBetAndRuin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBetAndRuin.setLocationRelativeTo(null); 
		frmBetAndRuin.setVisible(true);

		final JButton btnRegister = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Register"));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
						
				RegistrationGUI registration = new RegistrationGUI();	
				registration.setLocationRelativeTo(null);
				frmBetAndRuin.dispose();
				registration.setVisible(true);
					
			}
			
		});
		
		final JButton btnEnterAsA = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Enterasaguest"));

		btnEnterAsA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				MainGuestGUI guest = new MainGuestGUI();
				guest.setLocationRelativeTo(null);
				guest.setVisible(true);
				frmBetAndRuin.dispose();
			}
			});
		
		final JLabel lblOr = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("or"));
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setForeground(new Color(255, 255, 0));
		
		final JLabel lblAlreadyHaveAn = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("AlreadyAccount"));
		lblAlreadyHaveAn.setForeground(new Color(255, 255, 0));
		
		final JButton btnSignIn = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Signin"));
		
		btnSignIn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) 
		{
		//redirect to LogInGUI class
		LogInGUI log = new LogInGUI();
		log.setLocationRelativeTo(null); //Centers window
		log.setVisible(true);
		frmBetAndRuin.dispose();
							
		}
		});
		
		JSeparator separator = new JSeparator();
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		//logo.setIcon(new ImageIcon("img\\ATG.png"));
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\ATG.png").getImage().getScaledInstance(250, 140, Image.SCALE_DEFAULT));
		logo.setIcon(imageIcon);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("English");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("en"));
				System.out.println("Locale: "+Locale.getDefault());
				btnRegister.setText(ResourceBundle.getBundle("Etiquetas").getString("Register"));
				btnEnterAsA.setText(ResourceBundle.getBundle("Etiquetas").getString("Enterasaguest"));
				btnSignIn.setText(ResourceBundle.getBundle("Etiquetas").getString("Signin"));
				lblAlreadyHaveAn.setText(ResourceBundle.getBundle("Etiquetas").getString("AlreadyAccount"));
				lblOr.setText(ResourceBundle.getBundle("Etiquetas").getString("or"));
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 0));
		rdbtnNewRadioButton.setBackground(new Color(0, 0, 0));
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Castillano");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("es"));
				System.out.println("Locale: "+Locale.getDefault());
				btnRegister.setText(ResourceBundle.getBundle("Etiquetas").getString("Register"));
				btnEnterAsA.setText(ResourceBundle.getBundle("Etiquetas").getString("Enterasaguest"));
				btnSignIn.setText(ResourceBundle.getBundle("Etiquetas").getString("Signin"));
				lblAlreadyHaveAn.setText(ResourceBundle.getBundle("Etiquetas").getString("AlreadyAccount"));
				lblOr.setText(ResourceBundle.getBundle("Etiquetas").getString("or"));
				
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton_1.setForeground(new Color(255, 255, 0));
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Euskara");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("eus"));
				System.out.println("Locale: "+Locale.getDefault());
				btnRegister.setText(ResourceBundle.getBundle("Etiquetas").getString("Register"));
				btnEnterAsA.setText(ResourceBundle.getBundle("Etiquetas").getString("Enterasaguest"));
				btnSignIn.setText(ResourceBundle.getBundle("Etiquetas").getString("Signin"));
				lblAlreadyHaveAn.setText(ResourceBundle.getBundle("Etiquetas").getString("AlreadyAccount"));
				lblOr.setText(ResourceBundle.getBundle("Etiquetas").getString("or"));
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton_2.setForeground(new Color(255, 255, 0));
		
		
		
		GroupLayout groupLayout = new GroupLayout(frmBetAndRuin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(147, Short.MAX_VALUE)
					.addComponent(lblAlreadyHaveAn)
					.addGap(48)
					.addComponent(btnSignIn)
					.addGap(97))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(logo, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(57, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtnNewRadioButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(rdbtnNewRadioButton_1)
							.addGap(78)
							.addComponent(rdbtnNewRadioButton_2))
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(162)
					.addComponent(btnRegister, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(164))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(85)
					.addComponent(btnEnterAsA, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addGap(93))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(100)
					.addComponent(lblOr, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(104, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(logo, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addComponent(btnRegister)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblOr)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEnterAsA)
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSignIn)
						.addComponent(lblAlreadyHaveAn))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(rdbtnNewRadioButton_2)
						.addComponent(rdbtnNewRadioButton_1))
					.addContainerGap())
		);
		frmBetAndRuin.getContentPane().setLayout(groupLayout);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	/*public void dispose() {
		// TODO Auto-generated method stub
		
	}*/

	/*protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}*/
}
