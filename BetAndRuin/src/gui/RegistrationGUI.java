package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import businessLogic.BLFacade;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;

public class RegistrationGUI extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField FirstnameField;
	private JTextField LastnameField;
	private JTextField EmailAddressField;
	private final JFileChooser openFileChooser;
	private BufferedImage originalBI;  //BufferedImage
	private JTextField usernameField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegistrationGUI frame = new RegistrationGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public RegistrationGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 654, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//the title
		JLabel title = new JLabel("Please, fill in these information");
		title.setFont(new Font("Tahoma", Font.PLAIN, 43));
		
		
		JLabel lblFirstname = new JLabel("Firstname");
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFirstname.setForeground(Color.BLACK);
		
		JLabel lblLastname = new JLabel("Lastname");
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblBirthdate = new JLabel("Birthdate");
		lblBirthdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblEmail = new JLabel("Email address");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		passwordField = new JPasswordField();
		
		final JRadioButton maleChoice = new JRadioButton("Male");
		buttonGroup.add(maleChoice);
		
		final JRadioButton femaleChoice = new JRadioButton("Female");
		buttonGroup.add(femaleChoice);
		
		FirstnameField = new JTextField();
		FirstnameField.setColumns(10);
		
		LastnameField = new JTextField();
		LastnameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Gender");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		EmailAddressField = new JTextField();
		EmailAddressField.setColumns(10);
		
		JLabel idPicture = new JLabel("ID picture");
		idPicture.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		final JDateChooser dateChooserBirthdate = new JDateChooser();
		
		
		openFileChooser = new JFileChooser();
		openFileChooser.setCurrentDirectory(new File("c:\\temps"));
		openFileChooser.setFileFilter(new FileNameExtensionFilter("PNG images", "png"));
		
		final JLabel messageLabel = new JLabel("");
		
		JButton btnNewButton = new JButton("Open file");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int returnValue = openFileChooser.showOpenDialog(getParent());
				
				
				if (returnValue == JFileChooser.APPROVE_OPTION)
				{
					try {
						originalBI = ImageIO.read(openFileChooser.getSelectedFile()); 	//read the file
						 
					}catch (IOException ioe) {
						messageLabel.setText("Failed to load image file!");
					}
				}
				else if (returnValue == JFileChooser.CANCEL_OPTION)
				{
					messageLabel.setText("You canceled it, try again");
				}
				else  {
					messageLabel.setText("No file chosen");
				}
				
			}
		});
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		final JLabel warningLabel = new JLabel("");
		warningLabel.setHorizontalAlignment(SwingConstants.CENTER);
		warningLabel.setForeground(new Color(255, 0, 0));
		
		usernameField = new JTextField();
		usernameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				BLFacade facade=MainGUI.getBusinessLogic();
				String username = usernameField.getText();
				
				if(facade.UsernameAvailable(username)) {
					warningLabel.setText("");
					//warningLabel.setForeground(new Color(0, 204, 0));
				}
				else {
					warningLabel.setText("Username Not available");
					warningLabel.setForeground(new Color(255, 0, 0));
				}
			}
		});
		usernameField.setColumns(10);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fname = FirstnameField.getText();
				if(fname.equals("")) {
					warningLabel.setText("Enter first name");
					return;
				}
				String lname = LastnameField.getText();
				if(lname.equals("")) {
					warningLabel.setText("Enter last name");
					return;
				}
				String email = EmailAddressField.getText();
				if(email.equals("")) {
					warningLabel.setText("Enter Email");
					return;
				}
				String birthdate = "";
				if(dateChooserBirthdate.getDate()!= null)birthdate = dateChooserBirthdate.getDate().toString();
				else {
					warningLabel.setText("Date of birth not correct");
					return;
				}
				String username = usernameField.getText();
				if(username.equals("")) {
					warningLabel.setText("Enter username");
					return;
				}
				String password = new String(passwordField.getPassword());
				if(password.equals("")) {
					warningLabel.setText("Enter password");
					return;
				}
				String gender = "";
				if(maleChoice.isSelected())
					gender="male";
				else if(femaleChoice.isSelected())
					gender="female";
				if(gender.equals("")) {
					warningLabel.setText("Gender not chosen");
					return;
				}
				System.out.println(fname + lname + email + birthdate + username + password + gender);
				
				BLFacade facade=MainGUI.getBusinessLogic();
				if(facade.Register(fname, lname, email, birthdate, username, password, gender)) {
					System.out.println("success");
					setVisible(false);
					dispose();
				}
				//TODO make validation of data before, and expand Account class for remaining variables
			}
		});
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
	
		
	
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(title))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(123)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblLastname)
										.addComponent(lblBirthdate)
										.addComponent(lblEmail)
										.addComponent(lblUsername)
										.addComponent(lblPassword)
										.addComponent(lblNewLabel)
										.addComponent(idPicture))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(99)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(btnNewButton)
													.addGap(18)
													.addComponent(messageLabel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(maleChoice)
													.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
													.addComponent(femaleChoice)
													.addGap(152))))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(passwordField, Alignment.LEADING)
												.addComponent(usernameField, Alignment.LEADING)
												.addComponent(EmailAddressField, Alignment.LEADING)
												.addComponent(dateChooserBirthdate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(LastnameField, Alignment.LEADING)
												.addComponent(FirstnameField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)))))
								.addComponent(lblFirstname)))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(255)
							.addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
					.addGap(0))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(188)
					.addComponent(warningLabel, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
					.addGap(195))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(title)
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirstname)
						.addComponent(FirstnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastname)
						.addComponent(LastnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBirthdate)
						.addComponent(dateChooserBirthdate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(EmailAddressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername)
						.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(maleChoice)
						.addComponent(femaleChoice)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(messageLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(idPicture))
					.addGap(9)
					.addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(warningLabel, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
