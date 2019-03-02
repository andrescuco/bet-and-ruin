package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomepageGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

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
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel title = new JLabel("Bet and Ruin");
		title.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
						
				RegistrationGUI registration = new RegistrationGUI();	
				frame.dispose();
				registration.setVisible(true);
					
			}
			
		});
		
		JButton btnEnterAsA = new JButton("Enter as a guest");
		btnEnterAsA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				MainGUI guest = new MainGUI();
				guest.setVisible(true);
				frame.dispose();
				//add code 
			}
		});
		
		JLabel lblOr = new JLabel("or");
		
		JLabel lblAlreadyHaveAn = new JLabel("Already have an account?");
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				//redirect to LogInGUI class
				LogInGUI log = new LogInGUI();
				log.setVisible(true);
				frame.dispose();
				
			}
		});
		
		JSeparator separator = new JSeparator();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(98)
					.addComponent(title)
					.addContainerGap(97, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(97, Short.MAX_VALUE)
					.addComponent(lblAlreadyHaveAn)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSignIn)
					.addGap(139))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(161)
					.addComponent(btnEnterAsA)
					.addContainerGap(162, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(211)
					.addComponent(lblOr)
					.addContainerGap(213, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(178)
					.addComponent(btnRegister)
					.addContainerGap(183, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(title)
					.addPreferredGap(ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
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

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
