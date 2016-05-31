package edu.neumont.pro280.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "question")
	private String question;

	@OneToMany(mappedBy = "associatedQuestions", cascade = CascadeType.ALL)
	private Set<Answer> answers;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category associatedCategory;

	public Question() {

	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setAssociatedCategory(Category associatedCategory) {
		this.associatedCategory = associatedCategory;
	}

	public Category getAssociatedCategory() {
		return associatedCategory;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}
}
