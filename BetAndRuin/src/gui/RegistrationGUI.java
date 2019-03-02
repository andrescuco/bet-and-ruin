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
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationGUI frame = new RegistrationGUI();
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
	public RegistrationGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 650, 500);
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
		
		JRadioButton maleChoice = new JRadioButton("Male");
		
		JRadioButton femaleChoice = new JRadioButton("Female");
		
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
		
		JDateChooser dateChooserBirthdate = new JDateChooser();
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
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
		
		
		
	
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(title))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(159)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblLastname)
										.addComponent(lblBirthdate)
										.addComponent(lblEmail)
										.addComponent(lblPassword)
										.addComponent(lblNewLabel)
										.addComponent(idPicture))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(79)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(passwordField, 296, 296, 296)
												.addComponent(FirstnameField, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
												.addComponent(LastnameField, 296, 296, 296)
												.addComponent(EmailAddressField, 296, 296, 296)
												.addComponent(dateChooserBirthdate, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(btnNewButton)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(messageLabel))))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(104)
											.addComponent(maleChoice)
											.addGap(18)
											.addComponent(femaleChoice))))
								.addComponent(lblFirstname)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(267)
							.addComponent(registerButton)))
					.addContainerGap())
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
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblBirthdate)
							.addGap(18)
							.addComponent(lblEmail)
							.addGap(18)
							.addComponent(lblPassword))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(dateChooserBirthdate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(EmailAddressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(idPicture))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(femaleChoice)
								.addComponent(maleChoice))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton)
								.addComponent(messageLabel))))
					.addGap(35)
					.addComponent(registerButton)
					.addGap(65))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
