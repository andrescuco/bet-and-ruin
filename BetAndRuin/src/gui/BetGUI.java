package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.Question;
import exceptions.InsuficientFunds;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;

public class BetGUI extends JFrame {

	private JPanel contentPane;
	private JTextField BetAmountField;

	public BetGUI(final Question question) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Getting info from given question
		
		
		
		JLabel questionLabel = new JLabel(question.getQuestion());
		
		JLabel lblEnterYourBet = new JLabel("Enter your bet:");
		
		BetAmountField = new JTextField();
		BetAmountField.setColumns(10);
		
		JLabel minBetLabel = new JLabel("Minimum Bet: " + question.getBetMinimum());
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
						}	
						catch(InsuficientFunds e1) {
							warningLabel.setText( ResourceBundle.getBundle("Etiquetas").getString("InsuficientFunds"));
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
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(169)
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
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(144)
					.addComponent(warningLabel)
					.addContainerGap(164, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
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
					.addContainerGap(27, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
