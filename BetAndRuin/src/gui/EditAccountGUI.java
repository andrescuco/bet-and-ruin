package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.Account;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;

public class EditAccountGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditAccountGUI frame = new EditAccountGUI();
					frame.setVisible(true);
					frame.setTitle("My Information");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditAccountGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{38, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		BLFacade facade=MainGUI.getBusinessLogic(); 
		
		JLabel titleNewLabel = new JLabel("Please, modify the fields and press Enter");
		titleNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		titleNewLabel.setForeground(Color.ORANGE);
		GridBagConstraints gbc_titleNewLabel = new GridBagConstraints();
		gbc_titleNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_titleNewLabel.gridx = 1;
		gbc_titleNewLabel.gridy = 0;
		contentPane.add(titleNewLabel, gbc_titleNewLabel);
		
		JLabel Usernamelbl = new JLabel("Username");
		Usernamelbl.setForeground(Color.ORANGE);
		Usernamelbl.setFont(new Font("Roboto", Font.PLAIN, 15));
		GridBagConstraints gbc_Usernamelbl = new GridBagConstraints();
		gbc_Usernamelbl.insets = new Insets(0, 0, 5, 5);
		gbc_Usernamelbl.gridx = 1;
		gbc_Usernamelbl.gridy = 2;
		contentPane.add(Usernamelbl, gbc_Usernamelbl);
		
		final JTextField Usernamefield = new JTextField(facade.getCurrentUser().getUsername());
		Usernamefield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usernamefield.getText();
			}
		});
		Usernamefield.setEditable(true);
		Usernamefield.setFont(new Font("Roboto", Font.PLAIN, 12));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		contentPane.add(Usernamefield, gbc_comboBox);
		
		JLabel Passwordlbl = new JLabel("Password");
		Passwordlbl.setForeground(Color.ORANGE);
		Passwordlbl.setFont(new Font("Roboto", Font.PLAIN, 15));
		GridBagConstraints gbc_Passwordlbl = new GridBagConstraints();
		gbc_Passwordlbl.insets = new Insets(0, 0, 5, 5);
		gbc_Passwordlbl.gridx = 1;
		gbc_Passwordlbl.gridy = 4;
		contentPane.add(Passwordlbl, gbc_Passwordlbl);
		
		JTextField PasswordDB = new JTextField(facade.getCurrentUser().getPassword());
		GridBagConstraints gbc_PasswordDB = new GridBagConstraints();
		gbc_PasswordDB.fill = GridBagConstraints.BOTH;
		gbc_PasswordDB.insets = new Insets(0, 0, 5, 5);
		gbc_PasswordDB.gridx = 2;
		gbc_PasswordDB.gridy = 4;
		contentPane.add(PasswordDB, gbc_PasswordDB);
		
		JLabel Birthdatelbl = new JLabel("Birthdate");
		Birthdatelbl.setForeground(Color.ORANGE);
		Birthdatelbl.setFont(new Font("Roboto", Font.PLAIN, 15));
		GridBagConstraints gbc_Birthdatelbl = new GridBagConstraints();
		gbc_Birthdatelbl.insets = new Insets(0, 0, 5, 5);
		gbc_Birthdatelbl.gridx = 1;
		gbc_Birthdatelbl.gridy = 6;
		contentPane.add(Birthdatelbl, gbc_Birthdatelbl);
		
		JTextField BirthdateDB = new JTextField(facade.getCurrentUser().getBirthdayDate());
		GridBagConstraints gbc_BirthdateDB = new GridBagConstraints();
		gbc_BirthdateDB.fill = GridBagConstraints.BOTH;
		gbc_BirthdateDB.insets = new Insets(0, 0, 5, 5);
		gbc_BirthdateDB.gridx = 2;
		gbc_BirthdateDB.gridy = 6;
		contentPane.add(BirthdateDB, gbc_BirthdateDB);
		
		JLabel EmailAddresslbl = new JLabel("Email Address");
		EmailAddresslbl.setForeground(Color.ORANGE);
		EmailAddresslbl.setFont(new Font("Roboto", Font.PLAIN, 15));
		GridBagConstraints gbc_EmailAddresslbl = new GridBagConstraints();
		gbc_EmailAddresslbl.insets = new Insets(0, 0, 5, 5);
		gbc_EmailAddresslbl.gridx = 1;
		gbc_EmailAddresslbl.gridy = 8;
		contentPane.add(EmailAddresslbl, gbc_EmailAddresslbl);
		
		JTextField EmailAddressDB = new JTextField(facade.getCurrentUser().getAddressEmail());
		GridBagConstraints gbc_EmailAddressDB = new GridBagConstraints();
		gbc_EmailAddressDB.fill = GridBagConstraints.BOTH;
		gbc_EmailAddressDB.insets = new Insets(0, 0, 5, 5);
		gbc_EmailAddressDB.gridx = 2;
		gbc_EmailAddressDB.gridy = 8;
		contentPane.add(EmailAddressDB, gbc_EmailAddressDB);
		
		JLabel Firstnamelbl = new JLabel("Firstname");
		Firstnamelbl.setForeground(Color.ORANGE);
		Firstnamelbl.setFont(new Font("Roboto", Font.PLAIN, 15));
		GridBagConstraints gbc_Firstnamelbl = new GridBagConstraints();
		gbc_Firstnamelbl.insets = new Insets(0, 0, 5, 5);
		gbc_Firstnamelbl.gridx = 1;
		gbc_Firstnamelbl.gridy = 10;
		contentPane.add(Firstnamelbl, gbc_Firstnamelbl);
		
		JTextField FirstnameDB = new JTextField(facade.getCurrentUser().getFirstname());
		GridBagConstraints gbc_FirstnameDB = new GridBagConstraints();
		gbc_FirstnameDB.fill = GridBagConstraints.BOTH;
		gbc_FirstnameDB.insets = new Insets(0, 0, 5, 5);
		gbc_FirstnameDB.gridx = 2;
		gbc_FirstnameDB.gridy = 10;
		contentPane.add(FirstnameDB, gbc_FirstnameDB);
		
		JLabel Lastnamelbl = new JLabel("Lastname");
		Lastnamelbl.setForeground(Color.ORANGE);
		Lastnamelbl.setFont(new Font("Roboto", Font.PLAIN, 15));
		GridBagConstraints gbc_Lastnamelbl = new GridBagConstraints();
		gbc_Lastnamelbl.insets = new Insets(0, 0, 5, 5);
		gbc_Lastnamelbl.gridx = 1;
		gbc_Lastnamelbl.gridy = 12;
		contentPane.add(Lastnamelbl, gbc_Lastnamelbl);
		
		JTextField LastnameDB = new JTextField(facade.getCurrentUser().getLastname());
		GridBagConstraints gbc_LastnameDB = new GridBagConstraints();
		gbc_LastnameDB.fill = GridBagConstraints.BOTH;
		gbc_LastnameDB.insets = new Insets(0, 0, 5, 5);
		gbc_LastnameDB.gridx = 2;
		gbc_LastnameDB.gridy = 12;
		contentPane.add(LastnameDB, gbc_LastnameDB);
		
		JLabel CreditLbl = new JLabel("Credit available");
		CreditLbl.setFont(new Font("Roboto", Font.PLAIN, 15));
		CreditLbl.setForeground(Color.ORANGE);
		GridBagConstraints gbc_CreditLbl = new GridBagConstraints();
		gbc_CreditLbl.insets = new Insets(0, 0, 5, 5);
		gbc_CreditLbl.gridx = 1;
		gbc_CreditLbl.gridy = 14;
		contentPane.add(CreditLbl, gbc_CreditLbl);
		
		JLabel CreditValue = new JLabel(facade.getCurrentUser().getAccountFunds()+ " Betcoins");
		CreditValue.setFont(new Font("SansSerif", Font.PLAIN, 18));
		CreditValue.setForeground(Color.WHITE);
		GridBagConstraints gbc_CreditValue = new GridBagConstraints();
		gbc_CreditValue.insets = new Insets(0, 0, 5, 5);
		gbc_CreditValue.gridx = 2;
		gbc_CreditValue.gridy = 14;
		contentPane.add(CreditValue, gbc_CreditValue);
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomepageGUI back = new HomepageGUI();
				back.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 16;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnGetMoreCoins = new JButton("Get more coins");
		btnGetMoreCoins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WalletGUI go = new WalletGUI();
				go.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnGetMoreCoins = new GridBagConstraints();
		gbc_btnGetMoreCoins.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetMoreCoins.gridx = 2;
		gbc_btnGetMoreCoins.gridy = 16;
		contentPane.add(btnGetMoreCoins, gbc_btnGetMoreCoins);
	}

}
