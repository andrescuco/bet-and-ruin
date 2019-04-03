package businessLogic;

import java.util.Date;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.jws.WebMethod;
import javax.jws.WebService;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.Question;
import domain.Account;
import domain.Bet;
import domain.Event;
import exceptions.EventFinished;
import exceptions.InsuficientFunds;
import exceptions.QuestionAlreadyExist;

/**
 * It implements the business logic as a web service.
 */
@WebService(endpointInterface = "businessLogic.BLFacade")
public class BLFacadeImplementation  implements BLFacade {
	Account currentUser = null;

	public BLFacadeImplementation()  {		
		System.out.println("Creating BLFacadeImplementation instance");
		ConfigXML c=ConfigXML.getInstance();
		
		if (c.getDataBaseOpenMode().equals("initialize")) {
			DataAccess dbManager=new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
			dbManager.initializeDB();
			dbManager.close();
			}
		
	}

	/**
	 * This method creates a question for an event, with a question text and the minimum bet
	 * 
	 * @param event to which question is added
	 * @param question text of the question
	 * @param betMinimum minimum quantity of the bet
	 * @return the created question, or null, or an exception
	 * @throws EventFinished if current data is after data of the event
 	 * @throws QuestionAlreadyExist if the same question already exists for the event
	 */
   @WebMethod
   public Question createQuestion(Event event, String question, float betMinimum) throws EventFinished, QuestionAlreadyExist{
	   
	    //The minimum bed must be greater than 0
	    DataAccess dBManager=new DataAccess();
		Question qry=null;
		
	    
		if(new Date().compareTo(event.getEventDate())>0)
			throw new EventFinished(ResourceBundle.getBundle("Etiquetas").getString("ErrorEventHasFinished"));
				
		
		 qry=dBManager.createQuestion(event,question,betMinimum);		

		dBManager.close();
		
		return qry;
   };
   @WebMethod
   public Event createEvent(Date date, String eventName) {
	    DataAccess dBManager=new DataAccess();
		Event qry=null;
		
		 qry=dBManager.createEvent(date, eventName);		

		dBManager.close();
		
		return qry;
   }
	
	/**
	 * This method invokes the data access to retrieve the events of a given date 
	 * 
	 * @param date in which events are retrieved
	 * @return collection of events
	 */
    @WebMethod	
	public Vector<Event> getEvents(Date date)  {
		DataAccess dbManager=new DataAccess();
		Vector<Event>  events=dbManager.getEvents(date);
		dbManager.close();
		return events;
	}
    

	/**
	 * This method invokes the data access to initialize the database with some events and questions.
	 * It is invoked only when the option "initialize" is declared in the tag dataBaseOpenMode of resources/config.xml file
	 */	
    @WebMethod	
	 public void initializeBD(){
		DataAccess dBManager=new DataAccess();
		dBManager.initializeDB();
		dBManager.close();
	}
    /*
     * 
     * This method gets information from GUI, and communicates with database
     * if created successfully returns true
     */
    @WebMethod	
	 public boolean Register(String fname, String lname, String em, String d, String uname, String passw, String gender, int funds){
		DataAccess dBManager=new DataAccess();
		boolean created = dBManager.createAccount(fname,lname,em,d,uname, passw, gender, funds);
		// Sets current user when registering a new account
		currentUser = dBManager.findAccount(uname);;
		dBManager.close();
		return created;
	} 
    
   
    
  
    
    @WebMethod	
	 public boolean UsernameAvailable(String username){
		DataAccess dBManager=new DataAccess();
		boolean notAvailable = dBManager.usernameExists(username);
		dBManager.close();
		return !notAvailable;
	}
    
 
    
    @Override
	public boolean isValidUser(String username, String password) {
		DataAccess dBManager=new DataAccess();
		if (dBManager.findAccount(username) == null) {
			return false;
		} else {
			Account a = dBManager.findAccount(username);
			dBManager.close();
			return checkPassword(a, password);
		}
	}
    
    public Account getCurrentUser() {
    	return currentUser;
    }
    
    public boolean deleteCurrentUser() {
    	currentUser = null;
    	return true;
    }
    
    public boolean checkPassword(Account a, String password) {
    	if (a.getPassword().equals(password)) {
    		currentUser = a;
    		System.out.print("The user is " + currentUser);
    		return true;
    	} else {
    		return false;
    	}
    	
    }
    
  
    @WebMethod
	public Event deleteEvent(Event event) {
    	DataAccess dBManager = new DataAccess();
    	Event ev = dBManager.deleteEvent(event);
    	return ev;
    }

	@Override
	public boolean UpdateFirstname(String firstname, String username) {
		DataAccess dBManager = new DataAccess();
    	boolean update2 = dBManager.updateFirstname(firstname, username);
    	dBManager.close();
    	return update2;
		
	}

	@Override
	public boolean UpdateLastname(String lastname, String username) {
		DataAccess dBManager = new DataAccess();
    	boolean update3 = dBManager.updateLastname(lastname, username);
    	dBManager.close();
    	return update3;
	}

	@Override
	public boolean UpdateGender(String gender, String username) {
		// TODO Auto-generated method stub
		DataAccess dBManager = new DataAccess();
    	boolean update6 = dBManager.updateGender(gender, username);
    	dBManager.close();
    	return update6;
	}

	@Override
	public boolean UpdateUsername(String username, String usernamedefault) {
		// TODO Auto-generated method stub
		DataAccess dBManager = new DataAccess();
    	boolean update1 = dBManager.updateUsername(username, usernamedefault);
    	dBManager.close();
    	return update1;
	}

	@Override
	public Boolean UpdatePassword(String password, String username) {
		// TODO Auto-generated method stub
		DataAccess dBManager = new DataAccess();
    	boolean update5 = dBManager.updatePassword(password, username);
    	dBManager.close();
    	return update5;
	}

	@Override
	public boolean UpdateEmailAddress(String email, String username) {
		// TODO Auto-generated method stub
		DataAccess dBManager = new DataAccess();
    	boolean update4 = dBManager.updateEmailAddress(email, username);
    	dBManager.close();
    	return update4;
	}
    
    @WebMethod
    public Bet placeBet(float amount, Question question) throws InsuficientFunds {
    	DataAccess dBManager = new DataAccess();
    	Account acc = getCurrentUser(); // Needs to update information
    	//Checking if there is enough money on wallet
    	if(acc.getAccountFunds() < amount) {
    		throw new InsuficientFunds(ResourceBundle.getBundle("Etiquetas").getString("InsuficientFunds"));
    	}
    	Bet bet = dBManager.createBet(amount, question, acc);
    	dBManager.updateFunds(acc.getAccountFunds()-amount, acc);
    	updateCurrentUser();
    	return bet;
    	
    }

	private void updateCurrentUser() {
		DataAccess dBManager = new DataAccess();
		currentUser = dBManager.findAccount(getCurrentUser().getUsername());
	}
 

}

