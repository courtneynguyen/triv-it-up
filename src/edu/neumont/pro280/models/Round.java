package edu.neumont.pro280.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Game")
public class Round {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "question")
	private Question question;
	
	@OneToMany
	private Set<Result> results = new HashSet<Result>();

	public Round() {

	}

	public Question getQuestion() {
		return question;
	}

	public Set<Result> getResults() {
		return results;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setResults(Set<Result> answers) {
		this.results = answers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}