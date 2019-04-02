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
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditAccountGUI extends JFrame {

	private JPanel contentPane;
	private JComboBox GenderDB;

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
		setResizable(false);
		setBounds(100, 100, 595, 676);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 38, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		final BLFacade facade = MainGUI.getBusinessLogic();

		JLabel Genderlbl = new JLabel("Gender");
		Genderlbl.setFont(new Font("Roboto", Font.PLAIN, 15));
		Genderlbl.setForeground(Color.ORANGE);
		GridBagConstraints gbc_Genderlbl = new GridBagConstraints();
		gbc_Genderlbl.insets = new Insets(0, 0, 5, 5);
		gbc_Genderlbl.gridx = 1;
		gbc_Genderlbl.gridy = 14;
		contentPane.add(Genderlbl, gbc_Genderlbl);

		GenderDB = new JComboBox();
		GenderDB.addItem(facade.getCurrentUser().getGender());
		if (facade.getCurrentUser().getGender().toString() != "female")
			GenderDB.addItem("female");

		GenderDB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				GenderDB.getSelectedItem();
			}
		});

		GridBagConstraints gbc_GenderDB = new GridBagConstraints();
		gbc_GenderDB.insets = new Insets(0, 0, 5, 5);
		gbc_GenderDB.fill = GridBagConstraints.HORIZONTAL;
		gbc_GenderDB.gridx = 2;
		gbc_GenderDB.gridy = 14;
		contentPane.add(GenderDB, gbc_GenderDB);

		final JLabel WarningLabel = new JLabel("");
		WarningLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		WarningLabel.setForeground(Color.RED);
		GridBagConstraints gbc_WarningLabel = new GridBagConstraints();
		gbc_WarningLabel.insets = new Insets(0, 0, 5, 5);
		gbc_WarningLabel.gridx = 1;
		gbc_WarningLabel.gridy = 19;
		contentPane.add(WarningLabel, gbc_WarningLabel);

		JLabel titleNewLabel = new JLabel("Please, modify the fields and press Update button");
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
		Usernamefield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Component frame = null;
				JOptionPane.showMessageDialog(frame,
					    "Not editable because it is a primary key");
			}
		});
		
		Usernamefield.setEditable(false);
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

		
		final JTextField PasswordDB = new JTextField(facade.getCurrentUser().getPassword());
		PasswordDB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if (PasswordDB.getText().length() < 4) 
					WarningLabel.setText("Password should be at least 5 characters long");
				else
					WarningLabel.setText("");
			}
		});
		
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
		BirthdateDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
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

		final JTextField EmailAddressDB = new JTextField(facade.getCurrentUser().getAddressEmail());
		EmailAddressDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
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

		final JTextField FirstnameDB = new JTextField(facade.getCurrentUser().getFirstname());
		FirstnameDB.addFocusListener(new FocusAdapter() {
			
		});
		
		
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

		final JTextField LastnameDB = new JTextField(facade.getCurrentUser().getLastname());
		LastnameDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lname = LastnameDB.getText();
			}
		});
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
		gbc_CreditLbl.gridy = 16;
		contentPane.add(CreditLbl, gbc_CreditLbl);

		JLabel CreditValue = new JLabel(facade.getCurrentUser().getAccountFunds() + " Betcoins");
		CreditValue.setFont(new Font("SansSerif", Font.PLAIN, 18));
		CreditValue.setForeground(Color.WHITE);
		GridBagConstraints gbc_CreditValue = new GridBagConstraints();
		gbc_CreditValue.insets = new Insets(0, 0, 5, 5);
		gbc_CreditValue.gridx = 2;
		gbc_CreditValue.gridy = 16;
		contentPane.add(CreditValue, gbc_CreditValue);

		JButton FinishButton = new JButton(" Update and Finish");
		FinishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				BLFacade facade = MainGUI.getBusinessLogic();
				Account a = facade.getCurrentUser();
				/*if (Usernamefield.getText() != facade.getCurrentUser().getUsername()) {
					facade.UpdateUsername(Usernamefield.getText(), a.getUsername());              THIS IS JUST IN CASE BUT NOT USED BECAUSE USERNAME IS PRIMARY KEY AND CANNOT BE OVERWRITTEN
				}
				*/
				if (FirstnameDB.getText() != facade.getCurrentUser().getFirstname()) {
					 facade.UpdateFirstname(FirstnameDB.getText(), a.getUsername());
				 }
				
				 if (LastnameDB.getText() != facade.getCurrentUser().getLastname()) {
					facade.UpdateLastname(LastnameDB.getText(), a.getUsername());
				 }
				
				if (PasswordDB.getText() != facade.getCurrentUser().getPassword()) {
					facade.UpdatePassword(PasswordDB.getText(), a.getUsername());
				}
				
				 if (EmailAddressDB.getText() != facade.getCurrentUser().getAddressEmail()) {
					facade.UpdateEmailAddress(EmailAddressDB.getText(), a.getUsername());
				 }
					
				 if (GenderDB.getSelectedItem() != facade.getCurrentUser().getGender().toString())
					facade.UpdateGender(GenderDB.getSelectedItem().toString(), a.getUsername());

				System.out.println("Information Updated");
				WarningLabel.setForeground(Color.GREEN);
				WarningLabel.setText("Changed Saved");
				HomepageGUI back = new HomepageGUI(); //
				back.setVisible(true);
				dispose();

			}
			
		});

		GridBagConstraints gbc_FinishButton = new GridBagConstraints();
		gbc_FinishButton.insets = new Insets(0, 0, 5, 5);
		gbc_FinishButton.gridx = 1;
		gbc_FinishButton.gridy = 18;
		contentPane.add(FinishButton, gbc_FinishButton);

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
		gbc_btnGetMoreCoins.gridy = 18;
		contentPane.add(btnGetMoreCoins, gbc_btnGetMoreCoins);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLFacade facade = MainGUI.getBusinessLogic();
				facade.deleteCurrentUser();
				System.out.print(facade.getCurrentUser());
				HomepageGUI home = new HomepageGUI();
				home.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnLogOut = new GridBagConstraints();
		gbc_btnLogOut.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogOut.gridx = 1;
		gbc_btnLogOut.gridy = 20;
		contentPane.add(btnLogOut, gbc_btnLogOut);

	}

}
