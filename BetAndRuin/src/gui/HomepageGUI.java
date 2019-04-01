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
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class HomepageGUI {

	private JFrame frame;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
						
				RegistrationGUI registration = new RegistrationGUI();	
				registration.setLocationRelativeTo(null);
				frame.dispose();
				registration.setVisible(true);
					
			}
			
		});
		
		JButton btnEnterAsA = new JButton("Enter as a guest");

		btnEnterAsA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				MainGuestGUI guest = new MainGuestGUI();
				guest.setLocationRelativeTo(null);
				guest.setVisible(true);
				frame.dispose();
			}
			});
		
		JLabel lblOr = new JLabel("or");
		
		JLabel lblAlreadyHaveAn = new JLabel("Already have an account?");
		lblAlreadyHaveAn.setForeground(Color.WHITE);
		
		JButton btnSignIn = new JButton("Sign in");
		
		btnSignIn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) 
		{
		//redirect to LogInGUI class
		LogInGUI log = new LogInGUI();
		log.setLocationRelativeTo(null); //Centers window
		log.setVisible(true);
		frame.dispose();
							
		}
		});
		
		JSeparator separator = new JSeparator();
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		//logo.setIcon(new ImageIcon("img\\ATG.png"));
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\ATG.png").getImage().getScaledInstance(250, 140, Image.SCALE_DEFAULT));
		logo.setIcon(imageIcon);
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(97, Short.MAX_VALUE)
					.addComponent(lblAlreadyHaveAn)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSignIn)
					.addGap(139))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(211)
					.addComponent(lblOr)
					.addContainerGap(213, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(logo, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(57, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(175)
					.addComponent(btnRegister)
					.addContainerGap(186, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(156)
					.addComponent(btnEnterAsA)
					.addContainerGap(167, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(logo, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addComponent(btnRegister)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblOr)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEnterAsA)
					.addGap(24)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSignIn)
						.addComponent(lblAlreadyHaveAn))
					.addGap(34))
		);
		frame.getContentPane().setLayout(groupLayout);
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
