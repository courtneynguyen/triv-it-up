package edu.neumont.pro280.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Result")
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "answer")
	private Answer answer;

	@Column(name = "round")
	private Round round;

	@Column(name = "user")
	private User user;

	@Column(name = "users_score")
	private double usersScore;

	public Result() {

	}

	public Answer getAnswer() {
		return answer;
	}

	public Round getRound() {
		return round;
	}

	public User getUser() {
		return user;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public void setRound(Round round) {
		this.round = round;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsersScore(double usersScore) {
		this.usersScore = usersScore;
	}

	public double getUsersScore() {
		return usersScore;
	}
}