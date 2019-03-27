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
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		BLFacade facade=MainGUI.getBusinessLogic(); 
		
		JLabel Usernamelbl = new JLabel("Username");
		Usernamelbl.setFont(new Font("Roboto", Font.PLAIN, 12));
		GridBagConstraints gbc_Usernamelbl = new GridBagConstraints();
		gbc_Usernamelbl.insets = new Insets(0, 0, 5, 5);
		gbc_Usernamelbl.gridx = 1;
		gbc_Usernamelbl.gridy = 1;
		contentPane.add(Usernamelbl, gbc_Usernamelbl);
		
		JLabel UsernameDB = new JLabel(facade.getCurrentUser().getUsername());
		GridBagConstraints gbc_UsernameDB = new GridBagConstraints();
		gbc_UsernameDB.insets = new Insets(0, 0, 5, 5);
		gbc_UsernameDB.gridx = 3;
		gbc_UsernameDB.gridy = 1;
		contentPane.add(UsernameDB, gbc_UsernameDB);
		UsernameDB.getName();
		//Implement code to retrieve Username from database
		//UsernameDB.setText(facade.getCurrentUser().getUsername());
		
		JButton btnEditUsername = new JButton("Edit Username");
		GridBagConstraints gbc_btnEditUsername = new GridBagConstraints();
		gbc_btnEditUsername.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditUsername.gridx = 8;
		gbc_btnEditUsername.gridy = 1;
		contentPane.add(btnEditUsername, gbc_btnEditUsername);
		
		JLabel Passwordlbl = new JLabel("Password");
		Passwordlbl.setFont(new Font("Roboto", Font.PLAIN, 12));
		GridBagConstraints gbc_Passwordlbl = new GridBagConstraints();
		gbc_Passwordlbl.insets = new Insets(0, 0, 5, 5);
		gbc_Passwordlbl.gridx = 1;
		gbc_Passwordlbl.gridy = 3;
		contentPane.add(Passwordlbl, gbc_Passwordlbl);
		
		JLabel PasswordDB = new JLabel(facade.getCurrentUser().getPassword());
		GridBagConstraints gbc_PasswordDB = new GridBagConstraints();
		gbc_PasswordDB.insets = new Insets(0, 0, 5, 5);
		gbc_PasswordDB.gridx = 3;
		gbc_PasswordDB.gridy = 3;
		contentPane.add(PasswordDB, gbc_PasswordDB);
		
		JButton btnEditPassword = new JButton("Edit Password");
		GridBagConstraints gbc_btnEditPassword = new GridBagConstraints();
		gbc_btnEditPassword.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditPassword.gridx = 8;
		gbc_btnEditPassword.gridy = 3;
		contentPane.add(btnEditPassword, gbc_btnEditPassword);
		
		JLabel Birthdatelbl = new JLabel("Birthdate");
		Birthdatelbl.setFont(new Font("Roboto", Font.PLAIN, 12));
		GridBagConstraints gbc_Birthdatelbl = new GridBagConstraints();
		gbc_Birthdatelbl.insets = new Insets(0, 0, 5, 5);
		gbc_Birthdatelbl.gridx = 1;
		gbc_Birthdatelbl.gridy = 5;
		contentPane.add(Birthdatelbl, gbc_Birthdatelbl);
		
		JLabel BirthdateDB = new JLabel(facade.getCurrentUser().getBirthdayDate());
		GridBagConstraints gbc_BirthdateDB = new GridBagConstraints();
		gbc_BirthdateDB.insets = new Insets(0, 0, 5, 5);
		gbc_BirthdateDB.gridx = 3;
		gbc_BirthdateDB.gridy = 5;
		contentPane.add(BirthdateDB, gbc_BirthdateDB);
		
		JButton btnEditBirthdate = new JButton("Edit Birthdate");
		GridBagConstraints gbc_btnEditBirthdate = new GridBagConstraints();
		gbc_btnEditBirthdate.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditBirthdate.gridx = 8;
		gbc_btnEditBirthdate.gridy = 5;
		contentPane.add(btnEditBirthdate, gbc_btnEditBirthdate);
		
		JLabel EmailAddresslbl = new JLabel("Email Address");
		EmailAddresslbl.setFont(new Font("Roboto", Font.PLAIN, 12));
		GridBagConstraints gbc_EmailAddresslbl = new GridBagConstraints();
		gbc_EmailAddresslbl.insets = new Insets(0, 0, 5, 5);
		gbc_EmailAddresslbl.gridx = 1;
		gbc_EmailAddresslbl.gridy = 7;
		contentPane.add(EmailAddresslbl, gbc_EmailAddresslbl);
		
		JLabel EmailAddressDB = new JLabel(facade.getCurrentUser().getAddressEmail());
		GridBagConstraints gbc_EmailAddressDB = new GridBagConstraints();
		gbc_EmailAddressDB.insets = new Insets(0, 0, 5, 5);
		gbc_EmailAddressDB.gridx = 3;
		gbc_EmailAddressDB.gridy = 7;
		contentPane.add(EmailAddressDB, gbc_EmailAddressDB);
		
		JButton btnEditEmailAddress = new JButton("Edit Email Address");
		GridBagConstraints gbc_btnEditEmailAddress = new GridBagConstraints();
		gbc_btnEditEmailAddress.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditEmailAddress.gridx = 8;
		gbc_btnEditEmailAddress.gridy = 7;
		contentPane.add(btnEditEmailAddress, gbc_btnEditEmailAddress);
		
		JLabel Firstnamelbl = new JLabel("Firstname");
		Firstnamelbl.setFont(new Font("Roboto", Font.PLAIN, 12));
		GridBagConstraints gbc_Firstnamelbl = new GridBagConstraints();
		gbc_Firstnamelbl.insets = new Insets(0, 0, 5, 5);
		gbc_Firstnamelbl.gridx = 1;
		gbc_Firstnamelbl.gridy = 9;
		contentPane.add(Firstnamelbl, gbc_Firstnamelbl);
		
		JLabel FirstnameDB = new JLabel(facade.getCurrentUser().getFirstname());
		GridBagConstraints gbc_FirstnameDB = new GridBagConstraints();
		gbc_FirstnameDB.insets = new Insets(0, 0, 5, 5);
		gbc_FirstnameDB.gridx = 3;
		gbc_FirstnameDB.gridy = 9;
		contentPane.add(FirstnameDB, gbc_FirstnameDB);
		
		JButton btnEditFirstname = new JButton("Edit Firstname");
		GridBagConstraints gbc_btnEditFirstname = new GridBagConstraints();
		gbc_btnEditFirstname.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditFirstname.gridx = 8;
		gbc_btnEditFirstname.gridy = 9;
		contentPane.add(btnEditFirstname, gbc_btnEditFirstname);
		
		JLabel Lastnamelbl = new JLabel("Lastname");
		Lastnamelbl.setFont(new Font("Roboto", Font.PLAIN, 12));
		GridBagConstraints gbc_Lastnamelbl = new GridBagConstraints();
		gbc_Lastnamelbl.insets = new Insets(0, 0, 5, 5);
		gbc_Lastnamelbl.gridx = 1;
		gbc_Lastnamelbl.gridy = 11;
		contentPane.add(Lastnamelbl, gbc_Lastnamelbl);
		
		JLabel LastnameDB = new JLabel(facade.getCurrentUser().getLastname());
		GridBagConstraints gbc_LastnameDB = new GridBagConstraints();
		gbc_LastnameDB.insets = new Insets(0, 0, 5, 5);
		gbc_LastnameDB.gridx = 3;
		gbc_LastnameDB.gridy = 11;
		contentPane.add(LastnameDB, gbc_LastnameDB);
		
		JButton btnEditLastname = new JButton("Edit Lastname");
		GridBagConstraints gbc_btnEditLastname = new GridBagConstraints();
		gbc_btnEditLastname.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditLastname.gridx = 8;
		gbc_btnEditLastname.gridy = 11;
		contentPane.add(btnEditLastname, gbc_btnEditLastname);
		
		JLabel CreditLbl = new JLabel("Credit available");
		GridBagConstraints gbc_CreditLbl = new GridBagConstraints();
		gbc_CreditLbl.insets = new Insets(0, 0, 5, 5);
		gbc_CreditLbl.gridx = 1;
		gbc_CreditLbl.gridy = 13;
		contentPane.add(CreditLbl, gbc_CreditLbl);
		
		JButton btnGetMoreCredit = new JButton("Get more credit");
		btnGetMoreCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WalletGUI credit = new WalletGUI();
				credit.setVisible(true);
				dispose();
			}
		});
		
		JLabel CreditValue = new JLabel(facade.getCurrentUser().getAccountFunds()+ " Betcoins");
		GridBagConstraints gbc_CreditValue = new GridBagConstraints();
		gbc_CreditValue.insets = new Insets(0, 0, 5, 5);
		gbc_CreditValue.gridx = 3;
		gbc_CreditValue.gridy = 13;
		contentPane.add(CreditValue, gbc_CreditValue);
		GridBagConstraints gbc_btnGetMoreCredit = new GridBagConstraints();
		gbc_btnGetMoreCredit.insets = new Insets(0, 0, 5, 0);
		gbc_btnGetMoreCredit.gridx = 8;
		gbc_btnGetMoreCredit.gridy = 13;
		contentPane.add(btnGetMoreCredit, gbc_btnGetMoreCredit);
		
		JButton btnReturn = new JButton("Return ");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGUI back = new MainGUI();
				back.setVisible(true);
				dispose();
			}
		});
		
		GridBagConstraints gbc_btnReturn = new GridBagConstraints();
		gbc_btnReturn.insets = new Insets(0, 0, 0, 5);
		gbc_btnReturn.gridx = 5;
		gbc_btnReturn.gridy = 16;
		contentPane.add(btnReturn, gbc_btnReturn);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BLFacade facade=MainGUI.getBusinessLogic();
				facade.getCurrentUser().changeToLogout();
				System.out.print("isLogged has been set to " + facade.getCurrentUser().getLoginStatus());
				MainGUI back = new MainGUI();
				back.setVisible(true);
				dispose();
			} 
		});
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.gridx = 8;
		gbc_btnLogout.gridy = 16;
		contentPane.add(btnLogout, gbc_btnLogout);
	}

}
