package edu.neumont.pro280.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.neumont.pro280.controller.GameController;
import edu.neumont.pro280.managers.GameManager;
import edu.neumont.pro280.managers.UserManager;
import edu.neumont.pro280.models.Game;
import edu.neumont.pro280.models.ModelAndView;

/**
 * Servlet implementation class MultiGameServlet
 */
@WebServlet("/multi-game/*")
public class MultiGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	UserManager userManager;
	@Inject
	GameManager gameManager;

	private GameController gameController;
	private Map<String, Game> games;
	private ModelAndView mav;
	String regex = "(/multi-game(/([\\w\\d-]+))?((/([\\w\\d]+)){2}?)?)";

	@Override
	public void init() {
		gameController = new GameController();
		games = new HashMap<String, Game>();

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MultiGameServlet() {
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
