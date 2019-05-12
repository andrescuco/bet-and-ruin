package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import domain.Account;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import businessLogic.BLFacade;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class WalletGUI extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WalletGUI frame = new WalletGUI();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setTitle("My digital wallet");
				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WalletGUI() {
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 463);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		BLFacade facade=MainGUI.getBusinessLogic(); 
		
		JLabel lblMyWallet = new JLabel("My Wallet");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\Wallet-Free-PNG-Image.png").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
		lblMyWallet.setIcon(imageIcon);
		lblMyWallet.setForeground(Color.ORANGE);
		lblMyWallet.setFont(new Font("Roboto", Font.BOLD, 20));
		lblMyWallet.setIcon(imageIcon);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditAccountGUI back = new EditAccountGUI();
				back.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblAvailableCredit = new JLabel("Available credit:");
		lblAvailableCredit.setForeground(Color.ORANGE);
		lblAvailableCredit.setFont(new Font("Roboto", Font.PLAIN, 21));
		
		final JLabel lblWalletFunds = new JLabel(MainGUI.getCurrentUser().getWalletFunds()+ " Betcoins");
		lblWalletFunds.setForeground(Color.RED);
		lblWalletFunds.setFont(new Font("Roboto Cn", Font.BOLD, 21));
		
		JButton btnWithdrawFunds = new JButton("Withdraw funds");
		btnWithdrawFunds.setForeground(new Color(255, 255, 255));
		btnWithdrawFunds.setBackground(new Color(0, 128, 0));
		btnWithdrawFunds.setFont(new Font("Roboto", Font.ITALIC, 18));
		btnWithdrawFunds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WithdrawGUI open = new WithdrawGUI();
				open.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblGetMoreCredits = new JLabel("Get more credits");
		lblGetMoreCredits.setForeground(Color.ORANGE);
		lblGetMoreCredits.setFont(new Font("Roboto", Font.BOLD, 16));
		
		JLabel lblMoreCreditsChoose = new JLabel(" Choose an option below:");
		lblMoreCreditsChoose.setForeground(Color.ORANGE);
		lblMoreCreditsChoose.setFont(new Font("Roboto", Font.PLAIN, 13));
		
		final JRadioButton PaypalButt = new JRadioButton("Paypal");
		PaypalButt.setBackground(Color.BLACK);
		PaypalButt.setForeground(Color.ORANGE);
		
		JLabel lblOr = new JLabel("or");
		lblOr.setForeground(Color.ORANGE);
		lblOr.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		final JRadioButton VisaButt = new JRadioButton("Visa/Mastercard");
		VisaButt.setBackground(Color.BLACK);
		VisaButt.setForeground(Color.ORANGE);
		
		final JComboBox fundsToAdd = new JComboBox();
		JButton btnContinue = new JButton("Continue");
		btnContinue.setForeground(new Color(255, 255, 255));
		btnContinue.setFont(new Font("Roboto", Font.ITALIC, 18));
		btnContinue.setBackground(new Color(0, 128, 0));
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean isPaypalSelected = PaypalButt.isSelected();
				 
				float funds = Float.parseFloat(fundsToAdd.getSelectedItem().toString());
				Account acc = MainGUI.getCurrentUser();
				funds = facade.addFunds(acc, funds);
				lblWalletFunds.setText(Float.toString(funds) + " Betcoins");
				
				
				
				    // the Visa/mastercard option is selected
				 
				
			}
		});
		
		
		fundsToAdd.addItem(100);
		fundsToAdd.addItem(500);
		fundsToAdd.addItem(1000);
		
		ButtonGroup group = new ButtonGroup();
        group.add(PaypalButt);
        group.add(VisaButt);
        
        JSeparator separator = new JSeparator();
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(112)
        					.addComponent(lblAvailableCredit, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(lblWalletFunds)
        					.addPreferredGap(ComponentPlacement.RELATED))
        				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
        					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(lblMyWallet)
        					.addGap(72)))
        			.addPreferredGap(ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
        			.addComponent(btnBack))
        		.addComponent(separator, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap(243, Short.MAX_VALUE)
        			.addComponent(lblGetMoreCredits)
        			.addGap(221))
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap(209, Short.MAX_VALUE)
        			.addComponent(btnWithdrawFunds)
        			.addGap(203))
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap(216, Short.MAX_VALUE)
        			.addComponent(lblMoreCreditsChoose)
        			.addGap(209))
        		.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
        			.addGap(178)
        			.addComponent(PaypalButt)
        			.addGap(49)
        			.addComponent(lblOr)
        			.addGap(41)
        			.addComponent(VisaButt)
        			.addContainerGap(116, Short.MAX_VALUE))
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap(193, Short.MAX_VALUE)
        			.addComponent(fundsToAdd, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
        			.addGap(179))
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap(240, Short.MAX_VALUE)
        			.addComponent(btnContinue)
        			.addGap(227))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(14)
        					.addComponent(lblMyWallet)
        					.addGap(18)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblWalletFunds)
        						.addComponent(lblAvailableCredit, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(btnBack))
        			.addGap(18)
        			.addComponent(btnWithdrawFunds)
        			.addGap(33)
        			.addComponent(separator, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(lblGetMoreCredits)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(lblMoreCreditsChoose)
        			.addGap(19)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblOr)
        				.addComponent(PaypalButt)
        				.addComponent(VisaButt))
        			.addGap(18)
        			.addComponent(fundsToAdd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btnContinue)
        			.addGap(64))
        );
        contentPane.setLayout(gl_contentPane);
		
		
		
	
		
		
	}
}
