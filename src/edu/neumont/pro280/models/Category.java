package edu.neumont.pro280.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "category")
	private String category;

	public Category() {

	}

	public String getCategory() {
		return category;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	@OneToMany(mappedBy = "associatedCategory", cascade = CascadeType.ALL)
	private Set<Question> questions;
}
