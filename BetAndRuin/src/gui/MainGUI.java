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
		this.setSize(495, 290);
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
			jContentPane.setLayout(new GridLayout(6, 1, 5, 5));
			jContentPane.add(getLblNewLabel());
			jContentPane.add(getBoton3());
			jContentPane.add(getBoton2());
			jContentPane.add(getEventButton());
			jContentPane.add(getLblAccountSettings());
			jContentPane.add(getPanel());
			
			 
		}
		return jContentPane;
	}



	
		
	

	private JButton getEventButton() {
		if (jButtonCreateEvent == null) {
			jButtonCreateEvent = new JButton();
			jButtonCreateEvent.setBackground(Color.DARK_GRAY);
			jButtonCreateEvent.setForeground(Color.ORANGE);
			jButtonCreateEvent.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateOrDeleteEvent"));
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
			jButtonCreateQuery.setBackground(Color.DARK_GRAY);
			jButtonCreateQuery.setForeground(Color.ORANGE);
			jButtonCreateQuery.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateQuery"));
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
			jButtonQueryQueries.setBackground(Color.DARK_GRAY);
			jButtonQueryQueries.setForeground(Color.ORANGE);
			jButtonQueryQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("QueryQueries"));
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
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setVgap(15);
			flowLayout.setHgap(15);
			panel.add(getRdbtnNewRadioButton_1());
			panel.add(getRdbtnNewRadioButton_2());
			panel.add(getRdbtnNewRadioButton());
		}
		return panel;
	}
	
	private void redibujar() {
		jLabelSelectOption.setText(ResourceBundle.getBundle("Etiquetas").getString("SelectOption"));
		jButtonQueryQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("QueryQueries"));
		jButtonCreateQuery.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateQuery"));
		lblAccountSettings.setText(ResourceBundle.getBundle("Etiquetas").getString("Account"));
		jButtonCreateEvent.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateOrDeleteEvent"));
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("MainTitle"));
	}
	
	//If user is logged, show account settings button, if guest show login button
	
	private JButton getLblAccountSettings() {
		
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

			lblAccountSettings.setBackground(Color.BLACK);
			lblAccountSettings.setFont(new Font("Roboto", Font.BOLD, 13));
			lblAccountSettings.setForeground(Color.ORANGE);
			lblAccountSettings.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\user-3.png").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
			lblAccountSettings.setIcon(imageIcon);//$NON-NLS-1$ //$NON-NLS-2$
		}
		return lblAccountSettings;
	}
} // @jve:decl-index=0:visual-constraint="0,0"

