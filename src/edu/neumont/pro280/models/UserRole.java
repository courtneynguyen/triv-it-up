package edu.neumont.pro280.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UserRole")
public class UserRole {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;

	@ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
	private List<User> users;

	// @JoinColumn(name = "user_id")
	// private User user;
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

}
