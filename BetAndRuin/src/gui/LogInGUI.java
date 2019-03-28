package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.Account;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;

public class LogInGUI extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInGUI frame = new LogInGUI();
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
	public LogInGUI() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 363);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBounds(77, 97, 89, 13);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBackground(new Color(255, 255, 255));
		lblPassword.setBounds(77, 145, 100, 20);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		final JLabel label = new JLabel("");
		label.setBounds(77, 274, 0, 0);
		
		JButton btnNewButton = new JButton("Log In\r\n");
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.setBounds(77, 210, 133, 41);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textField.getText();
				String password = new String(passwordField.getPassword());
				
				BLFacade facade=MainGUI.getBusinessLogic();
				
				if (username.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill in all the fields", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if (facade.isValidUser(username, password)) {
						MainGUI enter = new MainGUI(); /* OPENING THE MAIN GUI*/
						enter.setLocationRelativeTo(null);
						enter.setVisible(true);
						SwingUtilities.windowForComponent(contentPane).dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(181, 90, 177, 26);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(181, 142, 177, 26);
		
		JLabel lblPleaseLogIn = new JLabel("Login");
		lblPleaseLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseLogIn.setForeground(new Color(255, 255, 255));
		lblPleaseLogIn.setBounds(15, 16, 409, 49);
		lblPleaseLogIn.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBackground(new Color(255, 255, 255));
		btnReturn.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReturn.setBounds(225, 210, 133, 41);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomepageGUI e = new HomepageGUI();
				e.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblUsername);
		contentPane.add(lblPassword);
		contentPane.add(passwordField);
		contentPane.add(textField);
		contentPane.add(btnNewButton);
		contentPane.add(label);
		contentPane.add(btnReturn);
		contentPane.add(lblPleaseLogIn);
	}
}
