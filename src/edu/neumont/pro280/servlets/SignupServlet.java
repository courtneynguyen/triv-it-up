package edu.neumont.pro280.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.geronimo.transaction.manager.SetRollbackOnlyException;
import org.apache.openjpa.lib.jdbc.ReportingSQLException;
import org.apache.openjpa.persistence.EntityExistsException;

import edu.neumont.pro280.managers.UserManager;
import edu.neumont.pro280.models.Role;
import edu.neumont.pro280.models.User;
import edu.neumont.pro280.models.UserRole;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/signup/*")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	UserManager userManager;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = (String) req.getParameter("username");
		if (username.contains(" ")) {
			req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req,
					resp);
		} else {
			List<User> users = new ArrayList<User>();
			String password = (String) req.getParameter("password");
			String email = (String) req.getParameter("email");
			UserRole role = new UserRole();
			role.setRole(Role.USER);
			role.setUsername(username);

			System.out.println("Username of created user... " + username);

			try {
				User currentUser = new User();
				currentUser.setUsername(username);
				currentUser.setEmail(email);
				currentUser.setPassword(password);
				users.add(currentUser);
				role.setUsers(users);
				List<UserRole> roles = new ArrayList<UserRole>();
				roles.add(role);
				currentUser.setRoles(roles);
				userManager.createUser(currentUser);
				System.out.println("This is currentUser... "
						+ currentUser.getUsername());
				HttpSession session = req.getSession();
				req.setAttribute("user", currentUser);
				req.getRequestDispatcher("/WEB-INF/jsp/Gameboard.jsp").forward(
						req, resp);
			} catch (EntityExistsException e) {
				System.out.println("Error caught");
				req.getRequestDispatcher("/WEB-INF/jsp/Gameboard.jsp").forward(
						req, resp);

			} catch (ReportingSQLException e) {
				System.out.println("Error caught");
				req.getRequestDispatcher("/WEB-INF/jsp/Gameboard.jsp").forward(
						req, resp);
			} catch (SetRollbackOnlyException e) {
				System.out.println("setroll");
				req.getRequestDispatcher("/WEB-INF/jsp/Gameboard.jsp").forward(
						req, resp);
			} catch (EJBTransactionRolledbackException e) {
				System.out.println("EJBTRANSACTION");
				req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req,
						resp);
			}
		}

	}
}
