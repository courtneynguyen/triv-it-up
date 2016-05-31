package edu.neumont.pro280.servlets;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.neumont.pro280.controller.GameController;
import edu.neumont.pro280.helper.DataType;
import edu.neumont.pro280.managers.GameManager;
import edu.neumont.pro280.managers.UserManager;
import edu.neumont.pro280.models.Game;
import edu.neumont.pro280.models.ModelAndView;
import edu.neumont.pro280.models.Result;
import edu.neumont.pro280.models.Round;
import edu.neumont.pro280.models.User;

/**
 * Servlet implementation class SingleGameServlet
 */
@WebServlet("/game/*")
public class SingleGameServlet extends HttpServlet {

	@Inject
	UserManager userManager;
	@Inject
	GameManager gameManager;

	private static final long serialVersionUID = 1L;
	private GameController gameController;
	private Map<String, Game> games;
	private ModelAndView mav;
	String regex = "(/game(/([\\w\\d-]+))?((/([\\w\\d]+)){2}?)?)";

	@Override
	public void init() {
		gameController = new GameController();
		games = new HashMap<String, Game>();

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SingleGameServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		//
		// System.out.println("Get game servlet...");
		// System.out.println("User sess: " + sess.getAttribute("userId"));
		if (sess.getAttribute("userId") != null) {
			int userId = (Integer) sess.getAttribute("userId");
			User user = userManager.findUserById(userId);
			String uri = request.getRequestURI();
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(uri);

			while (matcher.find()) {
				if (matcher.group(6) != null) {
					String gameName = matcher.group(3);
					gameController.setUM(userManager);
					gameController.setGM(gameManager);
					Game game = gameController.findGameByName(gameName);
					int roundNum = Integer.parseInt(matcher.group(6));
					System.out.println("first round Number... "
							+ (roundNum - 1));
					mav = gameController.getRound(game.getGameName(),
							(roundNum - 1));
					Round round = (Round) mav.getModel();
					int size = gameController.questionByRound(round)
							.getAnswers().size();

					request.setAttribute("index", roundNum);
					roundNum = roundNum + 1;

					request.setAttribute("game", game);
					request.setAttribute("round", mav.getModel());
					request.setAttribute("user", user);
					request.setAttribute("amountQ", size);
					request.setAttribute("pageURL", request.getContextPath()
							+ "/game/" + gameName + "/round/" + roundNum);
					request.getRequestDispatcher(mav.getViewName()).forward(
							request, response);

				} else if (matcher.group(0) != null) {
					gameController.setUM(userManager);
					gameController.setGM(gameManager);
					request.setAttribute("user", user);
					request.setAttribute("categoriesList",
							gameManager.getListOfCategories());
					request.getRequestDispatcher("/WEB-INF/jsp/StartPage.jsp")
							.forward(request, response);

				}
			}

		} else {
			request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession sess = request.getSession();
		if (sess.getAttribute("userId") != null) {
			int num = 0;
			int userId = (Integer) sess.getAttribute("userId");
			User user = userManager.findUserById(userId);
			String uri = request.getRequestURI();
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(uri);
			num = DataType.createInteger(request.getParameter("group1"));

			while (matcher.find()) {
				if (matcher.group(6) != null) {
					int roundNum = Integer.parseInt(matcher.group(6));
					String gameName = matcher.group(3);
					int gameSize = gameController.findGameByName(gameName)
							.getRounds().size();
					if ((roundNum - 1) <= gameSize) {

						boolean wasCorrect = false;
						wasCorrect = gameManager.isCorrect(num);
						Game game = gameController.findGameByName(gameName);

						System.out.println("Round Number to store... "
								+ (roundNum - 2));
						// <<<<<<< HEAD
						gameController.storeScoreOfUser(userId, (roundNum - 2),
								gameName, num);
						// =======
						// gameController.storeScoreOfUser(userId, num,
						// (roundNum - 2), gameName);
						// >>>>>>> b32a01d480464bd0b65cfbd686047fb7a16aaa14

						if (roundNum - 1 < gameSize) {
							mav = gameController.getRound(game.getGameName(),
									(roundNum - 1));
							request.setAttribute("index", roundNum);
							roundNum = roundNum + 1;
							int size = gameController
									.answersByRound((Round) mav.getModel());

							request.setAttribute("game", game);
							request.setAttribute("round", mav.getModel());
							request.setAttribute("user", user);
							request.setAttribute("amountQ", size);
							request.setAttribute("pageURL",
									request.getContextPath() + "/game/"
											+ gameName + "/round/" + roundNum);
						} else {

							mav = gameController.getUserResultMAV(userId);
							double score = 0;
							for (Result r : (ArrayList<Result>) mav.getModel()) {
								score += r.getUsersScore();
							}
							score = (score / ((ArrayList<Result>) mav
									.getModel()).size());

							NumberFormat percentFormat = NumberFormat
									.getPercentInstance();
							percentFormat.setMaximumFractionDigits(1);
							System.out.println("Score is.. " + score);
							String result = percentFormat.format(score);
							System.out.println("Result is.. " + result);
							request.setAttribute("score", result);
							request.setAttribute("results", mav.getModel());
						}

					} else {
						// 404 error
					}

					request.getRequestDispatcher(mav.getViewName()).forward(
							request, response);

				} else if (matcher.group(3) != null) {
					String action = matcher.group(3);
					System.out.println("Creating game...");
					int catId = 0;
					if (action.equals("create")) {
						if (isInteger(request.getParameter("category"))) {
							catId = Integer.parseInt(request
									.getParameter("category"));
						}

						String mode = request.getParameter("gamemode");
						if (mode.equals("Single Player")) {
							if (catId == 0) {
								gameController.setUM(userManager);
								gameController.setGM(gameManager);
								System.out.println("creating new game...");
								System.out.println("user id: " + userId);
								Game game = gameController.createGame(userId);
								System.out.println("Game name: "
										+ game.getGameName());
								request.setAttribute("game", game);
								response.sendRedirect(request.getContextPath()
										+ "/game/" + game.getGameName()
										+ "/round/1");
							} else {
								// player chose a category...
								System.out.println("Category chosen: " + catId);
								gameController.setUM(userManager);
								gameController.setGM(gameManager);
								System.out.println("creating new game...");
								System.out.println("user id: " + userId);
								Game game = gameController.createGame(userId,
										catId);
								System.out.println("Game name: "
										+ game.getGameName());
								request.setAttribute("game", game);
								response.sendRedirect(request.getContextPath()
										+ "/game/" + game.getGameName()
										+ "/round/1");
							}
						} else if (mode.equals("Multi Player")) {

						} else {
							// none was selected...
						}
					}
				} else if (matcher.group(0) != null) {
					int selectedCategory = Integer.parseInt(request
							.getParameter("category"));
					gameController.setUM(userManager);
					gameController.setGM(gameManager);
					Game game = gameController.createGame(userId,
							selectedCategory);
					request.setAttribute("game", game);
					request.getRequestDispatcher("/WEB-INF/jsp/GameBoard.jsp")
							.forward(request, response);
				}
			}

		} else {

			request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(
					request, response);
		}
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		// only got here if we didn't return false
		return true;
	}

}
