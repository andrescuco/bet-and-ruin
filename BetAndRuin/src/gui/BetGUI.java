package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.Question;
import exceptions.EventFinished;
import exceptions.InsuficientFunds;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BetGUI extends JFrame {

	private JPanel contentPane;
	private JTextField BetAmountField;

	public BetGUI(final Question question) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Getting info from given question
		
		
		
		JLabel questionLabel = new JLabel(question.getQuestion());
		questionLabel.setForeground(Color.ORANGE);
		
		JLabel lblEnterYourBet = new JLabel("Enter your bet:");
		lblEnterYourBet.setForeground(Color.ORANGE);
		
		BetAmountField = new JTextField();
		BetAmountField.setColumns(10);
		
		JLabel minBetLabel = new JLabel("Minimum Bet: " + question.getBetMinimum());
		minBetLabel.setForeground(Color.ORANGE);
		final JLabel warningLabel = new JLabel("");
		
		JButton betButton = new JButton("Place Bet");
		betButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!BetAmountField.getText().isEmpty()) {
					if(Float.parseFloat(BetAmountField.getText()) <= question.getBetMinimum()) {
						warningLabel.setText("Your bet has to be bigger");
					}
					else {
						BLFacade facade=MainGUI.getBusinessLogic();
						
						try {
							facade.placeBet(Float.parseFloat(BetAmountField.getText()), question);
							warningLabel.setText("");
						}	
						catch(InsuficientFunds e1) {
							warningLabel.setText( ResourceBundle.getBundle("Etiquetas").getString("InsuficientFunds"));
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (EventFinished e1) {
							warningLabel.setText( ResourceBundle.getBundle("Etiquetas").getString("ErrorEventHasFinished"));
							e1.printStackTrace();
						}
					}
				}
				else {
					warningLabel.setText("Enter your bet");
				}
			}
		});
		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		closeButton.setBounds(new Rectangle(138, 420, 130, 30));
		
		JLabel Symbol = new JLabel("New label");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\putmoney.png").getImage().getScaledInstance(250, 140, Image.SCALE_DEFAULT));
		Symbol.setIcon(imageIcon);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(Symbol)
							.addGap(94)
							.addComponent(questionLabel, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEnterYourBet, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
							.addGap(67)
							.addComponent(BetAmountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(minBetLabel)
					.addGap(95))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addComponent(closeButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(betButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(71, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(144)
					.addComponent(warningLabel)
					.addContainerGap(280, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(Symbol))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterYourBet, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(BetAmountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(minBetLabel))
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(closeButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(betButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(warningLabel)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
