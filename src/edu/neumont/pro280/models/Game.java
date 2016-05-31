package edu.neumont.pro280.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Game")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "game_name")
	private String gameName;
	
	@Transient
	private Set<Round> rounds = new HashSet<Round>();
	
	private Set<User> users = new HashSet<User>();
	
	public Set<Round> getRounds() {
		return rounds;
	}

	public Set<User> getUsers() {
		return users;
	}

	public Game(){
		
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName() {
		gameName = UUID.randomUUID().toString();
	}

	public void setRounds(Set<Round> rounds) {
		this.rounds = rounds;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public void addUserToGame(User user) {

	}
}
