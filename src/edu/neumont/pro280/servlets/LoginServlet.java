package edu.neumont.pro280.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.neumont.pro280.managers.UserManager;
import edu.neumont.pro280.models.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login/*")
public class LoginServlet extends HttpServlet {

	@EJB
	UserManager userManager;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// String username = (String) req.getAttribute("username");
		// String password = (String) req.getAttribute("password");
		// User currentUser = userManager.findUserByUsername(username);
		// System.out.println("This is currentUser... " + username);
		// HttpSession session = req.getSession();
		// req.setAttribute("user", currentUser);
		req.getRequestDispatcher("/WEB-INF/jsp/Gameboard.jsp").forward(req,resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = (String) req.getParameter("username");
		String password = (String) req.getParameter("password");
		System.out.println("Username of logging in user... " + username);
		User currentUser = userManager.loginUser(username, password);
		if (currentUser != null) {
			HttpSession session = req.getSession();
			// System.out.println("User logged in: " + currentUser.getId());
			session.setAttribute("userId", currentUser.getId());
			// System.out.println(currentUser.getUsername() + " username?");
			req.setAttribute("user", currentUser);
			System.out.println("What is context path? " + req.getContextPath());
			resp.sendRedirect(req.getContextPath() + "/game");
		} else {
			req.setAttribute("error", "Your login information was incorrect.");
			req.getRequestDispatcher("/jsp/index.jsp").forward(req,
					resp);
		}
		// System.out.println("This is loggedin user... "
		// + currentUser.getUsername());

	}

}
