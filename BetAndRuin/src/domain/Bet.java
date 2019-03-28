package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bet {
	
	@Id @GeneratedValue
	private int betNumber;
	private float betAmount;
	private Account account;
	private Question question;
	
	public Bet(float amount, Question quest, Account acc) {
		betAmount = amount;
		question = quest;
		account = acc;
	}

	public float getBetAmount() {
		return betAmount;
	}
	
}
