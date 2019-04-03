package gui;

/**
 * @author Software Engineering teachers
 */


import javax.swing.*;

import domain.Event;
import businessLogic.BLFacade;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout.Alignment;

import com.objectdb.o.BTS;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;


public class MainGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	private JButton jButtonCreateQuery = null;
	private JButton jButtonCreateEvent = null;
	private JButton jButtonQueryQueries = null;

    private static BLFacade appFacadeInterface;
	
	public static BLFacade getBusinessLogic(){
		return appFacadeInterface;
	}
	
	public static void setBussinessLogic (BLFacade afi){
		appFacadeInterface=afi;
	}
	protected JLabel jLabelSelectOption;
	protected JLabel Icon;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JPanel panel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton lblAccountSettings;
	private JButton btnBetHistorywButton;
	
	
	/**
	 * This is the default constructor
	 */
	public MainGUI() {
		super();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					//if (ConfigXML.getInstance().isBusinessLogicLocal()) facade.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Error: "+e1.toString()+" , probably problems with Business Logic or Database");
				}
				System.exit(1);
			}
		});

		initialize();
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		// this.setSize(271, 295);
		this.setSize(534, 420);
		this.setContentPane(getJContentPane());
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("MainTitle"));
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setBackground(Color.BLACK);
			GridBagLayout gbl_jContentPane = new GridBagLayout();
			gbl_jContentPane.columnWidths = new int[]{173, 140, 205, 0};
			gbl_jContentPane.rowHeights = new int[]{42, 46, 43, 45, 0, 40, 0, 0};
			gbl_jContentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_jContentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			jContentPane.setLayout(gbl_jContentPane);
			GridBagConstraints gbc_jLabelSelectOption = new GridBagConstraints();
			gbc_jLabelSelectOption.gridwidth = 3;
			gbc_jLabelSelectOption.insets = new Insets(0, 0, 5, 0);
			gbc_jLabelSelectOption.anchor = GridBagConstraints.WEST;
			gbc_jLabelSelectOption.fill = GridBagConstraints.BOTH;
			gbc_jLabelSelectOption.gridx = 0;
			gbc_jLabelSelectOption.gridy = 0;
			jContentPane.add(getLblNewLabel(), gbc_jLabelSelectOption);
			GridBagConstraints gbc_jButtonCreateQuery = new GridBagConstraints();
			gbc_jButtonCreateQuery.gridwidth = 3;
			gbc_jButtonCreateQuery.anchor = GridBagConstraints.WEST;
			gbc_jButtonCreateQuery.fill = GridBagConstraints.BOTH;
			gbc_jButtonCreateQuery.insets = new Insets(0, 0, 5, 0);
			gbc_jButtonCreateQuery.gridx = 0;
			gbc_jButtonCreateQuery.gridy = 1;
			jContentPane.add(getBoton2(), gbc_jButtonCreateQuery);
			GridBagConstraints gbc_jButtonCreateEvent = new GridBagConstraints();
			gbc_jButtonCreateEvent.gridwidth = 3;
			gbc_jButtonCreateEvent.anchor = GridBagConstraints.WEST;
			gbc_jButtonCreateEvent.fill = GridBagConstraints.BOTH;
			gbc_jButtonCreateEvent.insets = new Insets(0, 0, 5, 0);
			gbc_jButtonCreateEvent.gridx = 0;
			gbc_jButtonCreateEvent.gridy = 2;
			jContentPane.add(getEventButton(), gbc_jButtonCreateEvent);
			GridBagConstraints gbc_jButtonQueryQueries = new GridBagConstraints();
			gbc_jButtonQueryQueries.gridwidth = 3;
			gbc_jButtonQueryQueries.insets = new Insets(0, 0, 5, 0);
			gbc_jButtonQueryQueries.anchor = GridBagConstraints.WEST;
			gbc_jButtonQueryQueries.fill = GridBagConstraints.BOTH;
			gbc_jButtonQueryQueries.gridx = 0;
			gbc_jButtonQueryQueries.gridy = 3;
			jContentPane.add(getBoton3(), gbc_jButtonQueryQueries);
			GridBagConstraints gbc_lblAccountSettings = new GridBagConstraints();
			gbc_lblAccountSettings.gridwidth = 3;
			gbc_lblAccountSettings.fill = GridBagConstraints.BOTH;
			gbc_lblAccountSettings.insets = new Insets(0, 0, 5, 0);
			gbc_lblAccountSettings.gridx = 0;
			gbc_lblAccountSettings.gridy = 4;
			jContentPane.add(getLblAccountSettings(), gbc_lblAccountSettings);
			GridBagConstraints gbc_btnBetHistorywButton = new GridBagConstraints();
			gbc_btnBetHistorywButton.gridwidth = 3;
			gbc_btnBetHistorywButton.insets = new Insets(0, 0, 5, 0);
			gbc_btnBetHistorywButton.anchor = GridBagConstraints.WEST;
			gbc_btnBetHistorywButton.fill = GridBagConstraints.BOTH;
			gbc_btnBetHistorywButton.gridx = 0;
			gbc_btnBetHistorywButton.gridy = 5;
			jContentPane.add(getBtnBetHistorywButton(), gbc_btnBetHistorywButton);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.gridwidth = 3;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 6;
			jContentPane.add(getPanel(), gbc_panel);
			
			 
		}
		return jContentPane;
	}



	
		
	

	private JButton getEventButton() {
		if (jButtonCreateEvent == null) {
			jButtonCreateEvent = new JButton();
			jButtonCreateEvent.setBackground(Color.WHITE);
			jButtonCreateEvent.setForeground(Color.BLACK);
			jButtonCreateEvent.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateOrDeleteEvent"));
			ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\type.png").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
			jButtonCreateEvent.setIcon(imageIcon);
			jButtonCreateEvent.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					BLFacade facade=MainGUI.getBusinessLogic();
					//Vector<Event> events=facade.getAllEvents();
					JFrame CreateEventGUI = new CreateEventGUI(new Vector<Event>());
					CreateEventGUI.setLocationRelativeTo(null);
					CreateEventGUI.setVisible(true);
				}
			});
		}
		return jButtonCreateEvent;
	}

	/**
	 * This method initializes boton1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBoton2() {
		if (jButtonCreateQuery == null) {
			jButtonCreateQuery = new JButton();
			jButtonCreateQuery.setBackground(Color.WHITE);
			jButtonCreateQuery.setForeground(Color.BLACK);
			jButtonCreateQuery.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateQuery"));
			ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\question.png").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
			jButtonCreateQuery.setIcon(imageIcon);
			jButtonCreateQuery.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					BLFacade facade=MainGUI.getBusinessLogic();
					//Vector<Event> events=facade.getAllEvents();
					JFrame CreateQuestionGUI = new CreateQuestionGUI(new Vector<Event>());
					CreateQuestionGUI.setLocationRelativeTo(null);
					CreateQuestionGUI.setVisible(true);
				}
			});
		}
		return jButtonCreateQuery;
	}
	
	/**
	 * This method initializes boton2
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBoton3() {
		if (jButtonQueryQueries == null) {
			jButtonQueryQueries = new JButton();
			jButtonQueryQueries.setBackground(Color.WHITE);
			jButtonQueryQueries.setForeground(Color.BLACK);
			jButtonQueryQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("QueryQueries"));
			ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\download.png").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
			jButtonQueryQueries.setIcon(imageIcon);
			jButtonQueryQueries.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFrame FindQuestionsGUI = new FindQuestionsGUI();
					FindQuestionsGUI.setLocationRelativeTo(null);
					FindQuestionsGUI.setVisible(true);
				}
			});
		}
		return jButtonQueryQueries;
	}
	

	private JLabel getLblNewLabel() {
		if (jLabelSelectOption == null) {
			jLabelSelectOption = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("SelectOption"));
			jLabelSelectOption.setFont(new Font("Tahoma", Font.BOLD, 13));
			jLabelSelectOption.setForeground(Color.ORANGE);
			jLabelSelectOption.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabelSelectOption;
	}
	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("English");
			rdbtnNewRadioButton.setBackground(Color.GRAY);
			rdbtnNewRadioButton.setForeground(Color.ORANGE);
			rdbtnNewRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Locale.setDefault(new Locale("en"));
					System.out.println("Locale: "+Locale.getDefault());
					redibujar();				}
			});
			buttonGroup.add(rdbtnNewRadioButton);
		}
		return rdbtnNewRadioButton;
	}
	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("Euskara");
			rdbtnNewRadioButton_1.setBackground(Color.GRAY);
			rdbtnNewRadioButton_1.setForeground(Color.ORANGE);
			rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Locale.setDefault(new Locale("eus"));
					System.out.println("Locale: "+Locale.getDefault());
					redibujar();				}
			});
			buttonGroup.add(rdbtnNewRadioButton_1);
		}
		return rdbtnNewRadioButton_1;
	}
	private JRadioButton getRdbtnNewRadioButton_2() {
		if (rdbtnNewRadioButton_2 == null) {
			rdbtnNewRadioButton_2 = new JRadioButton("Castellano");
			rdbtnNewRadioButton_2.setBackground(Color.GRAY);
			rdbtnNewRadioButton_2.setForeground(Color.ORANGE);
			rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Locale.setDefault(new Locale("es"));
					System.out.println("Locale: "+Locale.getDefault());
					redibujar();
				}
			});
			buttonGroup.add(rdbtnNewRadioButton_2);
		}
		return rdbtnNewRadioButton_2;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.GRAY);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			panel.add(getRdbtnNewRadioButton());
			panel.add(getRdbtnNewRadioButton_2());
			panel.add(getRdbtnNewRadioButton_1());
		}
		return panel;
	}
	
	private void redibujar() {
		jLabelSelectOption.setText(ResourceBundle.getBundle("Etiquetas").getString("SelectOption"));
		jButtonQueryQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("QueryQueries"));
		jButtonCreateQuery.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateQuery"));
		lblAccountSettings.setText(ResourceBundle.getBundle("Etiquetas").getString("Account"));
		jButtonCreateEvent.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateOrDeleteEvent"));
		btnBetHistorywButton.setText(ResourceBundle.getBundle("Etiquetas").getString("BettingHistory"));
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("MainTitle"));
	}
	
	//If user is logged, show account settings button, if guest show login button
	
	private JButton getLblAccountSettings() {	
		
		if (lblAccountSettings == null) {
			lblAccountSettings = new JButton("Account Settings");
			lblAccountSettings.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					EditAccountGUI EditAccountGUI = new EditAccountGUI();
					EditAccountGUI.setLocationRelativeTo(null);
					EditAccountGUI.setVisible(true);
					dispose();
				}
			
			});
			
	
			
		
	
		
		/*if (facade.getCurrentUser() == null) {
			
			if (lblAccountSettings == null) {
				lblAccountSettings = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Account"));
				lblAccountSettings.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						EditAccountGUI EditAccountGUI = new EditAccountGUI();
						EditAccountGUI.setLocationRelativeTo(null);
						EditAccountGUI.setVisible(true);
						dispose();
					}
				});
		} else {
			System.out.print(facade.getCurrentUser());
		}*/

			lblAccountSettings.setBackground(Color.WHITE);
			lblAccountSettings.setFont(new Font("Roboto", Font.BOLD, 13));
			lblAccountSettings.setForeground(Color.BLACK);
			lblAccountSettings.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\user-3.png").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
			lblAccountSettings.setIcon(imageIcon);//$NON-NLS-1$ //$NON-NLS-2$
		}
		return lblAccountSettings;
	}

		// TODO Auto-generated method stub
		
	private JButton getBtnBetHistorywButton() {
		if (btnBetHistorywButton == null) {
			btnBetHistorywButton = new JButton(ResourceBundle.getBundle("Etiquetas").getString("BettingHistory"));
			ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\betting_3.jpg").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
			btnBetHistorywButton.setIcon(imageIcon);
			btnBetHistorywButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					BettingHistoryGUI enter = new BettingHistoryGUI();
					enter.createAndShowGUI();
					dispose();
				
				}
			});
		}
		return btnBetHistorywButton;
	}
	}
// @jve:decl-index=0:visual-constraint="0,0"

