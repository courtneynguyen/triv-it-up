package edu.neumont.pro280.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("")
public class Home extends HttpServlet {

	Connection db;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Home() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession sess = req.getSession();
		System.out.println(sess.getAttribute("userId") + " userId??");
		if (sess.getAttribute("userId") == null
				|| sess.getAttribute("userId") == "") {
			req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req,
					resp);
		} else {
			System.out.println("Get? ");
			resp.sendRedirect("/game");
			// req.getRequestDispatcher("/WEB-INF/jsp/Gameboard.jsp").forward(req,
			// resp);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
	// }

}
