package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bet {
	
	@Id @GeneratedValue
	private int betNumber;
	private float betAmount;
	private boolean isFinished;
	private Date betDate;
	
	private Account account;
	private Question question;
	
	public Bet(float amount, Date date, Question quest, Account acc) {
		betAmount = amount;
		betDate = date;
		question = quest;
		account = acc;
	}

	public Date getBetDate() {
		return betDate;
	}

	public void setBetDate(Date betDate) {
		this.betDate = betDate;
	}

	public float getBetAmount() {
		return betAmount;
	}
	
	public int getBetNumber() {
		return betNumber;
	}
	
	public Question getQuestion() {
		return question;
	}
	
	public Boolean isBetFinished() {
		return this.isFinished;
	}
	
}
