package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;

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
import java.awt.Dimension;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{16, 96, 122, 134, 0};
		gbl_contentPane.rowHeights = new int[]{0, 41, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\wallet.png").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
		
		JLabel lblMyWallet = new JLabel("My Wallet");
		lblMyWallet.setFont(new Font("Roboto", Font.PLAIN, 16));
		GridBagConstraints gbc_lblMyWallet = new GridBagConstraints();
		gbc_lblMyWallet.insets = new Insets(0, 0, 5, 5);
		gbc_lblMyWallet.gridx = 2;
		gbc_lblMyWallet.gridy = 0;
		contentPane.add(lblMyWallet, gbc_lblMyWallet);
		lblMyWallet.setIcon(imageIcon);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditAccountGUI back = new EditAccountGUI();
				back.setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.EAST;
		gbc_btnBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnBack.gridx = 3;
		gbc_btnBack.gridy = 0;
		contentPane.add(btnBack, gbc_btnBack);
		
		JLabel lblAvalaibleCredit = new JLabel("Availaible credit:");
		lblAvalaibleCredit.setFont(new Font("Roboto", Font.PLAIN, 15));
		GridBagConstraints gbc_lblAvalaibleCredit = new GridBagConstraints();
		gbc_lblAvalaibleCredit.fill = GridBagConstraints.BOTH;
		gbc_lblAvalaibleCredit.insets = new Insets(0, 0, 5, 5);
		gbc_lblAvalaibleCredit.gridx = 1;
		gbc_lblAvalaibleCredit.gridy = 2;
		contentPane.add(lblAvalaibleCredit, gbc_lblAvalaibleCredit);
		
		JLabel lblNewLabel = new JLabel("*amount to be displayed*");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblGetMoreCredits = new JLabel("Get more credits");
		lblGetMoreCredits.setFont(new Font("Roboto", Font.BOLD, 14));
		GridBagConstraints gbc_lblGetMoreCredits = new GridBagConstraints();
		gbc_lblGetMoreCredits.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetMoreCredits.gridx = 2;
		gbc_lblGetMoreCredits.gridy = 4;
		contentPane.add(lblGetMoreCredits, gbc_lblGetMoreCredits);
		
		JLabel lblMoreCreditsChoose = new JLabel(" Choose an option below:");
		lblMoreCreditsChoose.setFont(new Font("Roboto", Font.PLAIN, 13));
		GridBagConstraints gbc_lblMoreCreditsChoose = new GridBagConstraints();
		gbc_lblMoreCreditsChoose.insets = new Insets(0, 0, 5, 5);
		gbc_lblMoreCreditsChoose.gridx = 2;
		gbc_lblMoreCreditsChoose.gridy = 5;
		contentPane.add(lblMoreCreditsChoose, gbc_lblMoreCreditsChoose);
		
		final JRadioButton PaypalButt = new JRadioButton("Paypal");
		GridBagConstraints gbc_PaypalButt = new GridBagConstraints();
		gbc_PaypalButt.insets = new Insets(0, 0, 5, 5);
		gbc_PaypalButt.gridx = 1;
		gbc_PaypalButt.gridy = 6;
		contentPane.add(PaypalButt, gbc_PaypalButt);
		
		JLabel lblOr = new JLabel("or");
		lblOr.setFont(new Font("Roboto", Font.PLAIN, 14));
		GridBagConstraints gbc_lblOr = new GridBagConstraints();
		gbc_lblOr.insets = new Insets(0, 0, 5, 5);
		gbc_lblOr.gridx = 2;
		gbc_lblOr.gridy = 6;
		contentPane.add(lblOr, gbc_lblOr);
		
		final JRadioButton VisaButt = new JRadioButton("Visa/Mastercard");
		GridBagConstraints gbc_VisaButt = new GridBagConstraints();
		gbc_VisaButt.insets = new Insets(0, 0, 5, 0);
		gbc_VisaButt.gridx = 3;
		gbc_VisaButt.gridy = 6;
		contentPane.add(VisaButt, gbc_VisaButt);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean isPaypalSelected = PaypalButt.isSelected();
				 
				if (isPaypalSelected) {
				 
				    // the Paypal option is selected
				 
				} else {
				 
				    // the Visa/mastercard option is deselected
				 
				}
			}
		});
		GridBagConstraints gbc_btnContinue = new GridBagConstraints();
		gbc_btnContinue.insets = new Insets(0, 0, 0, 5);
		gbc_btnContinue.gridx = 2;
		gbc_btnContinue.gridy = 9;
		contentPane.add(btnContinue, gbc_btnContinue);
		
		ButtonGroup group = new ButtonGroup();
        group.add(PaypalButt);
        group.add(VisaButt);
		
		
		
	
		
		
	}



	private Icon ImageIcon(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
