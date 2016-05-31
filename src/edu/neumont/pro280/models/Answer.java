package edu.neumont.pro280.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Answer")
public class Answer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "answer")
	private String answer;

	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question associatedQuestions;

	@Column(name = "isCorrect", columnDefinition = "INT(1)")
	private boolean correctAnswer;

	public Answer() {
		setCorrectAnswer(false);
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setAssociatedQuestions(Question associatedQuestions) {
		this.associatedQuestions = associatedQuestions;
	}

	public Question getAssociatedQuestions() {
		return associatedQuestions;
	}

	public void setCorrectAnswer(boolean isCorrectAnswer) {
		this.correctAnswer = isCorrectAnswer;
	}

	public boolean getCorrectAnswer() {
		return correctAnswer;
	}

}
