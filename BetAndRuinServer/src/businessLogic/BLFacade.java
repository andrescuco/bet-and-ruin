package businessLogic;

import java.util.Vector;
import java.util.Date;





//import domain.Booking;
import domain.Question;
import domain.Transaction;
import domain.Wallet;
import domain.Account;
import domain.Bet;
import domain.Event;
import exceptions.EventFinished;
import exceptions.InsuficientFunds;
import exceptions.QuestionAlreadyExist;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Interface that specifies the business logic.
 */
@WebService
public interface BLFacade  {
	

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
	@WebMethod Question createQuestion(Event event, String question, float betMinimum) throws EventFinished, QuestionAlreadyExist;
	
	
	/**
	 * This method retrieves the events of a given date 
	 * 
	 * @param date in which events are retrieved
	 * @return collection of events
	 */
	@WebMethod public Vector<Event> getEvents(Date date);
	
	
	
	/**
	 * This method calls the data access to initialize the database with some events and questions.
	 * It is invoked only when the option "initialize" is declared in the tag dataBaseOpenMode of resources/config.xml file
	 */	
	@WebMethod public void initializeBD();

	//@WebMethod public boolean Register(String username, String password);
	@WebMethod public boolean Register(String fname, String lname, String em, String d, String uname, String passw, String gender, int funds);
	@WebMethod	public boolean UsernameAvailable(String username);

	
	 
	@WebMethod Event createEvent(Date date, String inputQuery);
	@WebMethod	public boolean isValidUser(String username, String password);
	@WebMethod	public boolean checkPassword(Account a, String password);
	@WebMethod	public Account getCurrentUser();
	@WebMethod	public boolean deleteCurrentUser();
	


	@WebMethod Event deleteEvent(Event event);
	

	boolean UpdateFirstname(String firstname, String username);


	boolean UpdateLastname(String lastname, String username);


	boolean UpdateEmailAddress(String email, String username);


	boolean UpdateUsername(String username, String usernamedefault);


	Boolean UpdatePassword(String password, String username);


	boolean UpdateGender(String gender, String username);


	@WebMethod public Bet placeBet(float amount, Question question) throws InsuficientFunds, EventFinished;
	@WebMethod public Vector<Bet> getAllBets();

	float addFunds(float funds);
	
	@WebMethod public void updateData();
	@WebMethod public Transaction  createTransaction(float amount, Date date, String description);
	@WebMethod public Vector<Transaction> getTransactions();
}