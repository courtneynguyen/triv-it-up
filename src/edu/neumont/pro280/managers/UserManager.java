package edu.neumont.pro280.managers;

import java.util.List;

import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.geronimo.transaction.manager.SetRollbackOnlyException;
import org.apache.openjpa.lib.jdbc.ReportingSQLException;
import org.apache.openjpa.persistence.EntityExistsException;

import edu.neumont.pro280.models.User;

@Stateless
@LocalBean
public class UserManager {
	@PersistenceContext(unitName = "UserService")
	EntityManager em;

	public User findUserById(int id) {

		return em.find(User.class, id);
		// return null;
	}

	public User findUserByUsername(String user) {
		System.out.println("User to find is: " + user);
		TypedQuery<User> query = em.createQuery(
				"SELECT u FROM User u WHERE u.username=:user", User.class);
		query.setParameter("user", user);

		List<User> userList = query.getResultList();
		User returnUser = null;
		System.out.println("list size: " + userList.size());
		if (userList.size() == 1) {
			for (User user1 : userList) {
				returnUser = user1;
			}
		}
		return returnUser;
		// return null;
	}

	public User loginUser(String user, String pass) {
		System.out.println("Logging in user... : " + user);
		TypedQuery<User> query = em
				.createQuery(
						"SELECT u FROM User u WHERE u.username=:user AND u.password=:pass",
						User.class);
		query.setParameter("user", user);
		query.setParameter("pass", pass);

		// List<User> userList = query.getResultList();
		User returnUser = query.getSingleResult();
		// System.out.println("list size: " + userList.size());
		return returnUser;
	}

	public User findUserByEmail(String email) {

		// TypedQuery<User> getUserFromName = em.createQuery(
		// "SELECT u FROM User u Where u.email = :email", User.class);
		// getUserFromName.setParameter("email", email);
		//
		// User returnUser = null;
		// List<User> userList = getUserFromName.getResultList();
		//
		// if (userList.size() < 2 && userList.size() > 0) {
		// for (User user : userList) {
		// returnUser = user;
		// }
		// }
		// return returnUser;
		return null;

	}

	public int getUserIdByEmail(String email) {
		User user = findUserByEmail(email);

		return user.getId();
	}

	public void createUser(User user) throws EntityExistsException,
			ReportingSQLException, SetRollbackOnlyException,
			EJBTransactionRolledbackException {
		try {
			em.persist(user);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
