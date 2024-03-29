package gui;
import java.text.DateFormat;
import java.util.*;

import javax.swing.*;

import com.toedter.calendar.JCalendar;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;






import businessLogic.BLFacade;


import domain.Event;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;




public class CreateEventGUI extends JFrame  {
private static final long serialVersionUID = 1L;
	
  private JComboBox<Event> jComboBoxEvents=new JComboBox<Event>();
  DefaultComboBoxModel<Event> modelEvents=new DefaultComboBoxModel<Event>();
  
  private JLabel jLabelListOfEvents = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("ListEvents"));
  private JLabel jLabelQuery = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("Event"));
  private JLabel jLabelEventDate = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("EventDate"));


  private JTextField jTextFieldQuery = new JTextField();
  private JCalendar jCalendar = new JCalendar();
  private Calendar calendarMio = null;

  private JScrollPane scrollPaneEvents = new JScrollPane();


  private JButton jButtonCreate = new JButton(ResourceBundle.getBundle("Etiquetas").getString("CreateEvent"));
  private JButton jButtonClose = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Close"));
  private JButton jButtonDelete = new JButton(ResourceBundle.getBundle("Etiquetas").getString("Delete"));
  private JLabel jLabelMsg = new JLabel();
  private JLabel jLabelError = new JLabel();

  Date firstDay = null;
  
  
  public CreateEventGUI(Vector<domain.Event> v)
  {
  	getContentPane().setBackground(Color.BLACK);
    try
    {
      jbInit(v);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  private void jbInit(Vector<domain.Event> v) throws Exception
  {
	  
    this.getContentPane().setLayout(null);
    this.setSize(new Dimension(604, 370));
    this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("CreateQuery"));
    
    
    jComboBoxEvents.setModel(modelEvents);
    jComboBoxEvents.setBounds(new Rectangle(275, 47, 250, 20));
    jLabelListOfEvents.setFont(new Font("Roboto Cn", Font.PLAIN, 15));
    jLabelListOfEvents.setForeground(Color.ORANGE);
    jLabelListOfEvents.setBounds(new Rectangle(290, 18, 277, 20));
    jLabelQuery.setFont(new Font("Roboto Cn", Font.PLAIN, 15));
    jLabelQuery.setForeground(Color.ORANGE);
    jLabelQuery.setBounds(new Rectangle(49, 210, 41, 20));
    jTextFieldQuery.setBounds(new Rectangle(100, 211, 429, 20));
    
    jCalendar.setBounds(new Rectangle(40, 50, 225, 150));
    scrollPaneEvents.setBounds(new Rectangle(25, 44, 346, 116));
    
    jButtonCreate.setBounds(new Rectangle(100, 275, 130, 30));
    jButtonCreate.setEnabled(false);
    
    jButtonCreate.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButtonCreate_actionPerformed(e);
        }
      });
    jButtonClose.setBounds(new Rectangle(275, 275, 130, 30));
    jButtonClose.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          jButtonClose_actionPerformed(e);
        }
      });
    
    jLabelMsg.setBounds(new Rectangle(275, 182, 305, 20));
    jLabelMsg.setForeground(Color.red);
    //jLabelMsg.setSize(new Dimension(305, 20));
    
    jLabelError.setBounds(new Rectangle(175, 240, 305, 20));
    jLabelError.setForeground(Color.red);
    
    
    this.getContentPane().add(jLabelMsg, null);
    this.getContentPane().add(jLabelError, null);

    this.getContentPane().add(jButtonClose, null);
    this.getContentPane().add(jButtonCreate, null);
    this.getContentPane().add(jButtonDelete, null);
    this.getContentPane().add(jTextFieldQuery, null);
    this.getContentPane().add(jLabelQuery, null);
    this.getContentPane().add(jLabelListOfEvents, null);
    this.getContentPane().add(jComboBoxEvents, null);
    
    this.getContentPane().add(jCalendar, null);
    jLabelEventDate.setForeground(Color.ORANGE);
    jLabelEventDate.setFont(new Font("Roboto Cn", Font.PLAIN, 15));

    jLabelEventDate.setBounds(new Rectangle(40, 15, 140, 25));
    jLabelEventDate.setBounds(40, 16, 140, 25);
    getContentPane().add(jLabelEventDate);
    
    final JButton jButtonDelete = new JButton(ResourceBundle.getBundle("Etiquetas").getString("CreateEventGUI.btnNewButton.text")); //$NON-NLS-1$ //$NON-NLS-2$
    jButtonDelete.setEnabled(false);
    jButtonDelete.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		jButtonDelete_actionPerformed(arg0);
    	}
    });
    jButtonDelete.setBounds(275, 101, 254, 20);
    getContentPane().add(jButtonDelete);
    

    
    // Code for JCalendar
    this.jCalendar.addPropertyChangeListener(new PropertyChangeListener()
    {
        public void propertyChange(PropertyChangeEvent propertychangeevent)
      {
        if (propertychangeevent.getPropertyName().equals("locale"))
        {
          jCalendar.setLocale((Locale) propertychangeevent.getNewValue());
        }
        else if (propertychangeevent.getPropertyName().equals("calendar"))
        {
          calendarMio = (Calendar) propertychangeevent.getNewValue();
          DateFormat dateformat1 = DateFormat.getDateInstance(1, jCalendar.getLocale());
          jCalendar.setCalendar(calendarMio);
          firstDay=trim(new Date(jCalendar.getCalendar().getTime().getTime()));
    	  

      	
      	try {
      		BLFacade facade=MainGUI.getBusinessLogic();

      		Vector<domain.Event> events=facade.getEvents(firstDay);
      		
      		if (events.isEmpty() ) jLabelListOfEvents.setText(ResourceBundle.getBundle("Etiquetas").getString("NoEvents")+ ": "+dateformat1.format(calendarMio.getTime()));
      		  else jLabelListOfEvents.setText(ResourceBundle.getBundle("Etiquetas").getString("Events")+ ": "+dateformat1.format(calendarMio.getTime()));
      		jComboBoxEvents.removeAllItems();
    		  System.out.println("Events "+events);

      		for (domain.Event ev:events)
                  modelEvents.addElement(ev);
      		jComboBoxEvents.repaint();
      		
      		if (events.size()==0)
      			jButtonDelete.setEnabled(false);
      		else
      			jButtonDelete.setEnabled(true);
      			jButtonCreate.setEnabled(true);

            } catch (Exception e1) {

     	        jLabelError.setText(e1.getMessage());
 	       }

        }
        paintDaysWithEvents(jCalendar);
      } 
    });
  }
  
  
  
  
  
  
  
  private Date trim(Date date) {

      Calendar calendar = Calendar.getInstance();
      calendar.setTime(date);
      calendar.set(Calendar.MILLISECOND, 0);
      calendar.set(Calendar.SECOND, 0);
      calendar.set(Calendar.MINUTE, 0);
      calendar.set(Calendar.HOUR_OF_DAY, 0);
      return calendar.getTime();
  }
  
	public static void paintDaysWithEvents(JCalendar jCalendar){
		// For each day in current month, it is checked if there are events, and in that case, the background color for that day is changed.
				BLFacade facade=MainGUI.getBusinessLogic();

				      Calendar calendar = Calendar.getInstance();
				      calendar.setTime(jCalendar.getDate());
				      
				      calendar.set(Calendar.DAY_OF_MONTH, 1);     
				      calendar.set(Calendar.MILLISECOND, 0);
				      calendar.set(Calendar.SECOND, 0);
				      calendar.set(Calendar.MINUTE, 0);
				      calendar.set(Calendar.HOUR_OF_DAY, 0);

				      int offset=calendar.get(Calendar.DAY_OF_WEEK);
				      if (Locale.getDefault().equals(new Locale("es"))) offset+=4;
				      else	offset+=5;

				      int month=calendar.get(Calendar.MONTH);
				      
				      while (month==calendar.get(Calendar.MONTH)){
				    	  Vector<domain.Event> events=facade.getEvents(calendar.getTime());
				    	  if (events.size()>0) {
				    		  // Obtain the component of the day in the panel of the DayChooser of the JCalendar.
				    		  // The component is located after the decorator buttons of "Sun", "Mon",... or "Lun", "Mar"...,
				    		  // the empty days before day 1 of month, and all the days previous to each day.
				    		  // That number of components is calculated with "offset" and is different in English and Spanish
				    		  Component o=(Component) jCalendar.getDayChooser().getDayPanel().getComponent(calendar.get(Calendar.DAY_OF_MONTH)+offset);; 
				    		  o.setBackground(Color.CYAN);
				    	  }
				    	  calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+1);
				      }
			}
	
  private void jButtonCreate_actionPerformed(ActionEvent e)
  {
	    //domain.Event event=((domain.Event)jComboBoxEvents.getSelectedItem());
	  	 	
	  	try {
	  		jLabelError.setText("");
	  		jLabelMsg.setText("");

	  	    //Displays an exception if the query field is empty
	  		String inputQuery= jTextFieldQuery.getText();

	  		if (inputQuery.length()>0) {
	  		    
	  			//It could be to trigger an exception if the introduced string is not a number
	  			

	  			//Obtain the business logic from a StartWindow class (local or remote)
	  			BLFacade facade=MainGUI.getBusinessLogic();
	  			jButtonDelete.setEnabled(true);    // SHOULD 
	  			facade.createEvent(firstDay,inputQuery);
	  			updateCalendar();

	  			jLabelMsg.setText(ResourceBundle.getBundle("Etiquetas").getString("EventCreated"));
  			}
//	  	} catch (EventFinished e1) {
//	  		jLabelMsg.setText( ResourceBundle.getBundle("Etiquetas").getString("ErrorEventHasFinished")+": "+event.getDescription());
//	  	} catch (QuestionAlreadyExist e1) {
//		    jLabelMsg.setText( ResourceBundle.getBundle("Etiquetas").getString("ErrorQueryAlreadyExist"));
//	    }
//	  	catch (java.lang.NumberFormatException e1) {
//		    jLabelError.setText(ResourceBundle.getBundle("Etiquetas").getString("ErrorNumber"));
	    }catch (Exception e1) {

	  		e1.printStackTrace();

	  	}
  }
  private void updateCalendar() {
	  DateFormat dateformat1 = DateFormat.getDateInstance(1, jCalendar.getLocale());
	  
	  BLFacade facade=MainGUI.getBusinessLogic();
	  Vector<domain.Event> events=facade.getEvents(firstDay);
	  if (events.isEmpty() ) jLabelListOfEvents.setText(ResourceBundle.getBundle("Etiquetas").getString("NoEvents")+ ": "+dateformat1.format(calendarMio.getTime()));
		  else jLabelListOfEvents.setText(ResourceBundle.getBundle("Etiquetas").getString("Events")+ ": "+dateformat1.format(calendarMio.getTime()));
		jComboBoxEvents.removeAllItems();
	  System.out.println("Events "+events);

		for (domain.Event ev:events)
          modelEvents.addElement(ev);
		jComboBoxEvents.repaint();
	  
	  paintDaysWithEvents(jCalendar);
}
  
  private void jButtonDelete_actionPerformed(ActionEvent e){
	    domain.Event event=((domain.Event)jComboBoxEvents.getSelectedItem());
	  	 	
	  	try {
	  		jLabelError.setText("");
	  		jLabelMsg.setText("");

  			BLFacade facade=MainGUI.getBusinessLogic();

  			facade.deleteEvent(event);
  			updateCalendar();

  			jLabelMsg.setText(ResourceBundle.getBundle("Etiquetas").getString("EventDeleted"));
	    }catch (Exception e1) {

	  		e1.printStackTrace();

	  	}
  }

private void jButtonClose_actionPerformed(ActionEvent e)
  {
    this.setVisible(false);
  }
}