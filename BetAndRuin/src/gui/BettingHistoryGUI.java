package gui;



import java.awt.*;
import javax.swing.table.TableCellRenderer;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.Vector;
import javax.swing.UIManager;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import businessLogic.BLFacade;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;

/* MenuDemo.java requires images/middle.gif. */

/*
 * This class is just like MenuLookDemo, except the menu items
 * actually do something, thanks to event listeners.
 */
public class BettingHistoryGUI extends JFrame {
    JTextArea output;
    JScrollPane scrollPaneBets = new JScrollPane();
    private static JTable tableBets= new JTable();
	private static DefaultTableModel tableModelBets;
	private static final JButton backbutton = new JButton("Back");
	
	private static String[] columnNamesBets = new String[] {
			ResourceBundle.getBundle("Etiquetas").getString("BetAmount"), 
			//ResourceBundle.getBundle("Etiquetas").getString("Event"),
			ResourceBundle.getBundle("Etiquetas").getString("Question"),
			ResourceBundle.getBundle("Etiquetas").getString("Date"), 

	};
	
    String newline = "\n";
    /**
     * @wbp.nonvisual location=147,239
     */
   

 
    
    

    public static JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        //Create the menu bar.
        menuBar = new JMenuBar();
        menuBar.setBackground(Color.black);

        //Build the first menu.
        menu = new JMenu("Bet Status");
        menu.setForeground(Color.ORANGE);
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
        //menuItem.addActionListener(null);
        menu.add(menuItem);

       


        

        //Build second menu in the menu bar.
        menu = new JMenu("Date filter");
        menu.setForeground(Color.ORANGE);
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

//    public static Container createContentPane() {
//        //Create the content-pane-to-be.
//        JPanel contentPane = new JPanel(new BorderLayout());
//        contentPane.setOpaque(true);
//
//        //Create a scrolled text area.
//        output = new JTextArea(5, 30);
//        output.setEditable(false);
//        scrollPaneBets = new JScrollPane(output);
//
//        //Add the text area to the content pane.
//        contentPane.add(scrollPaneBets, BorderLayout.CENTER);
//
//        return contentPane;
//    }

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
   
    
    
    public BettingHistoryGUI() throws HeadlessException {
		super();
		
		//Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPaneBets = new JScrollPane(output);

        //Add the text area to the content pane.
        contentPane.add(scrollPaneBets, BorderLayout.CENTER);
        
      //Create and set up the window.
        //JFrame frame = new JFrame("My Betting History");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setForeground(Color.ORANGE);
        setBackground(Color.BLACK);

        //Create and set up the content pane.
        //BettingHistoryGUI demo = new BettingHistoryGUI();
        setJMenuBar(createMenuBar());
        setContentPane(contentPane);
        setIconImage(new ImageIcon("/img/betting_3.jpg").getImage());
        
        
        //Getting Data
        scrollPaneBets.setViewportView(tableBets);
		tableModelBets = new DefaultTableModel(null, columnNamesBets);

		tableBets.setModel(tableModelBets);
		tableBets.getColumnModel().getColumn(0).setPreferredWidth(25);
		tableBets.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableBets.getColumnModel().getColumn(2).setPreferredWidth(100);
		//tableBets.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        tableModelBets.setDataVector(null, columnNamesBets);
		tableModelBets.setColumnCount(4); // another column added to allocate ev objects

		BLFacade facade=MainGUI.getBusinessLogic();
		Vector<domain.Bet> bets=facade.getAllBets(MainGUI.getCurrentUser());

		//if (bets.isEmpty() ) jLabelEvents.setText(ResourceBundle.getBundle("Etiquetas").getString("NoEvents")+ ": "+dateformat1.format(calendarMio.getTime()));
		//else jLabelEvents.setText(ResourceBundle.getBundle("Etiquetas").getString("Events")+ ": "+dateformat1.format(calendarMio.getTime()));
		for (domain.Bet bet:bets){
			Vector<Object> row = new Vector<Object>();

			System.out.println("Bets "+bet);

			row.add(bet.getBetAmount());
			
			//TODO: FIX RELATION Bet -> Question -> Event
			
			//row.add(bet.getQuestion().getEvent().getDescription()); 
			row.add(bet.getQuestion().getQuestion());
			final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			row.add(sdf.format(bet.getBetDate()));
			//row.add(bet); // ev object added in order to obtain it with tableModelEvents.getValueAt(i,2)
			tableModelBets.addRow(row);		
		}
		
		class ButtonRenderer extends JButton implements TableCellRenderer {

			  public ButtonRenderer() {
			    setOpaque(true);
			  }

			  public Component getTableCellRendererComponent(JTable table, Object value,
			      boolean isSelected, boolean hasFocus, int row, int column) {
			    if (isSelected) {
			      setForeground(table.getSelectionForeground());
			      setBackground(table.getSelectionBackground());
				  System.out.print(isSelected); // Button has been clicked
			    } else {
			      setForeground(table.getForeground());
			      setBackground(UIManager.getColor("Button.background"));
			    }
			    setText((value == null) ? "" : value.toString());
			    return this;
			  }
			 
			}
		
		class ButtonEditor extends DefaultCellEditor {
			  protected JButton button;

			  private String label;

			  private boolean isPushed;

			  public ButtonEditor(JCheckBox checkBox) {
			    super(checkBox);
			    button = new JButton();
			    button.setOpaque(true);
			    button.addActionListener(new ActionListener() {
			      public void actionPerformed(ActionEvent e) {
			    	 fireEditingStopped();
			      }
			  });
			  }
		}

		tableBets.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableBets.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableBets.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
		tableBets.getColumnModel().getColumn(3).setCellEditor(
		        new ButtonEditor(new JCheckBox()));
		tableBets.getColumnModel().getColumn(2).setPreferredWidth(200);
		
		
		//tableBets.getColumnModel().getColumn(3).setPreferredWidth(200);
		//tableBets.getColumnModel().removeColumn(tableEvents.getColumnModel().getColumn(2)); // not shown in JTable
		//Display the window.
        setSize(625, 300);
        setVisible(true);
        
        backbutton.setVerticalTextPosition(AbstractButton.BOTTOM);
        backbutton.setHorizontalTextPosition(AbstractButton.CENTER);
        contentPane.add(backbutton, BorderLayout.CENTER);
        
	}
}
