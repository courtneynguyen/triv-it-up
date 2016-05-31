package edu.neumont.pro280.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "User")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "q_amount_correct", nullable = true)
	private int qAmountCorrect;

	@Column(name = "total_q_asked", nullable = true)
	private int totalQuestionsAsked;

	@Column(name = "top_ten_perc", nullable = true)
	private int topTenPerc;

	@Column(name = "confidence_level", nullable = true)
	private double confidenceLevel;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = " user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<UserRole> roles;

	@Column(name = "last_Played")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar lastPlayed = new GregorianCalendar();

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String user) {
		username = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
	}

	public void setQAmountCorrect(int qAmountCorrect) {
		this.qAmountCorrect = qAmountCorrect;
	}

	public int getQAmountCorrect() {
		return qAmountCorrect;
	}

	public void setTopTenPerc(int topTenPerc) {
		this.topTenPerc = topTenPerc;
	}

	public int getTopTenPerc() {
		return topTenPerc;
	}

	public void setConfidenceLevel(double confidenceLevel) {
		this.confidenceLevel = confidenceLevel;
	}

	public double getConfidenceLevel() {
		return confidenceLevel;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	@Override
	public String toString() {
		return this.username + " and email: " + this.email + " #" + this.id;
	}

	public int getTotalQuestionsAsked() {
		return totalQuestionsAsked;
	}

	public void setTotalQuestionsAsked(int totalQuestionsAsked) {
		this.totalQuestionsAsked = totalQuestionsAsked;
	}

	public void setLastPlayed(Calendar lastPlayed) {
		this.lastPlayed = lastPlayed;
	}

	public Calendar getLastPlayed() {
		return lastPlayed;
	}
}
