package gui;



import java.awt.*;
import java.awt.event.*;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

import businessLogic.BLFacade;

import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFrame;

/* MenuDemo.java requires images/middle.gif. */

/*
 * This class is just like MenuLookDemo, except the menu items
 * actually do something, thanks to event listeners.
 */
public class BettingHistoryGUI implements ActionListener, ItemListener {
    JTextArea output;
    static JScrollPane scrollPaneBets = new JScrollPane();
    private static JTable tableBets= new JTable();
	private static DefaultTableModel tableModelBets;
	
	private static String[] columnNamesBets = new String[] {
			ResourceBundle.getBundle("Etiquetas").getString("BetAmount"), 
			ResourceBundle.getBundle("Etiquetas").getString("BetDescription"), 

	};
	
    String newline = "\n";

    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu("Bet Status");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);

        //a group of JMenuItems
        menuItem = new JMenuItem("Past bets",
                                 KeyEvent.VK_T);
        //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        ImageIcon icon = createImageIcon("img/presentsymbol.png");
        menuItem = new JMenuItem("Current bets", icon);
        menuItem.setMnemonic(KeyEvent.VK_B);
        menuItem.addActionListener(this);
        menu.add(menuItem);


        

        //Build second menu in the menu bar.
        menu = new JMenu("Date filter");
        menu.setMnemonic(KeyEvent.VK_N);
        menu.getAccessibleContext().setAccessibleDescription(
                "This menu does nothing");
        menuBar.add(menu);
        
        menuItem = new JMenuItem("This year", KeyEvent.VK_I);
        menu.getAccessibleContext();
        menu.add(menuItem);
        menuItem = new JMenuItem("This Month", KeyEvent.VK_X);
        menu.getAccessibleContext();
        menu.add(menuItem);
        menuItem = new JMenuItem("This Week", KeyEvent.VK_9);
        menu.getAccessibleContext();
        menu.add(menuItem);

        return menuBar;
    }

    public Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPaneBets = new JScrollPane(output);

        //Add the text area to the content pane.
        contentPane.add(scrollPaneBets, BorderLayout.CENTER);

        return contentPane;
    }

    public void actionPerformed(ActionEvent e) {                          /******************************************************************************************************************************************    */
        JMenuItem source = (JMenuItem)(e.getSource());
        
        String s = "Action event detected."
                   + newline                                              ///////////////////// IMPLEMENT THE BET HISTORY HERE /////////////////////
                   + "    Event source: " + source.getText()
                   + " (an instance of " + getClassName(source) + ")";
        output.append(s + newline);
        output.setCaretPosition(output.getDocument().getLength());        /*********************************************************************************************************************************************** */
    }

    public void itemStateChanged(ItemEvent e) {
        JMenuItem source = (JMenuItem)(e.getSource());
        String s = "Item event detected."
                   + newline
                   + "    Event source: " + source.getText()
                   + " (an instance of " + getClassName(source) + ")"
                   + newline
                   + "    New state: "
                   + ((e.getStateChange() == ItemEvent.SELECTED) ?
                     "selected":"unselected");
        output.append(s + newline);
        output.setCaretPosition(output.getDocument().getLength());
    }

    // Returns just the class name -- no package info.
    protected String getClassName(Object o) {
        String classString = o.getClass().getName();
        int dotIndex = classString.lastIndexOf(".");
        return classString.substring(dotIndex+1);
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = BettingHistoryGUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    static void createAndShowGUI() {           //////////// CALL THIS METHOD TO RUN GUI /////////////////////
        //Create and set up the window.
        JFrame frame = new JFrame("My Betting History");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setForeground(Color.BLACK);

        //Create and set up the content pane.
        BettingHistoryGUI demo = new BettingHistoryGUI();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane());
        frame.setIconImage(new ImageIcon("/img/betting_3.jpg").getImage());
        
        
        //Getting Data
        scrollPaneBets.setViewportView(tableBets);
		tableModelBets = new DefaultTableModel(null, columnNamesBets);

		tableBets.setModel(tableModelBets);
		tableBets.getColumnModel().getColumn(0).setPreferredWidth(25);
		tableBets.getColumnModel().getColumn(1).setPreferredWidth(268);
        
        tableModelBets.setDataVector(null, columnNamesBets);
		tableModelBets.setColumnCount(2); // another column added to allocate ev objects

		BLFacade facade=MainGUI.getBusinessLogic();
		Vector<domain.Bet> bets=facade.getAllBets();

		//if (bets.isEmpty() ) jLabelEvents.setText(ResourceBundle.getBundle("Etiquetas").getString("NoEvents")+ ": "+dateformat1.format(calendarMio.getTime()));
		//else jLabelEvents.setText(ResourceBundle.getBundle("Etiquetas").getString("Events")+ ": "+dateformat1.format(calendarMio.getTime()));
		for (domain.Bet bet:bets){
			Vector<Object> row = new Vector<Object>();

			System.out.println("Bets "+bet);

			row.add(bet.getBetAmount());
			row.add(bet.getQuestion().getQuestion());
			//row.add(bet); // ev object added in order to obtain it with tableModelEvents.getValueAt(i,2)
			tableModelBets.addRow(row);		
		}
		tableBets.getColumnModel().getColumn(0).setPreferredWidth(25);
		tableBets.getColumnModel().getColumn(1).setPreferredWidth(268);
		//tableBets.getColumnModel().removeColumn(tableEvents.getColumnModel().getColumn(2)); // not shown in JTable
		//Display the window.
        frame.setSize(450, 260);
        frame.setVisible(true);
    }

    	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
