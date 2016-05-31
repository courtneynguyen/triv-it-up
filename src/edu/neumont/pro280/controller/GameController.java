package edu.neumont.pro280.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.neumont.pro280.managers.GameManager;
import edu.neumont.pro280.managers.UserManager;
import edu.neumont.pro280.models.Answer;
import edu.neumont.pro280.models.Game;
import edu.neumont.pro280.models.ModelAndView;
import edu.neumont.pro280.models.Question;
import edu.neumont.pro280.models.Result;
import edu.neumont.pro280.models.Round;
import edu.neumont.pro280.models.User;

@Stateless
@LocalBean
public class GameController {

	@EJB
	GameManager gameManager;
	@EJB
	UserManager userManager;

	private ModelAndView mav;
	private Game game;
	private HashMap<String, Game> games = new HashMap<String, Game>();
	private HashMap<Integer, ArrayList<Result>> userGames = new HashMap<Integer, ArrayList<Result>>();

	public GameController() {

	}

	public Game createGame(int userId) {

		game = new Game();
		game.setGameName();
		Round round = new Round();
		User user = userManager.findUserById(userId);
		int rounds = 6;
		// Set<Question> gameQuest = new HashSet<Question>();
		Set<Round> gameRounds = new HashSet<Round>();
		Set<User> gameUsers = new HashSet<User>();
		// List<Round> tempRounds = new ArrayList<Round>();
		List<User> tempUsers = new ArrayList<User>();

		if (user != null) {
			tempUsers.add(user);
			List<Question> question = gameManager
					.generateRandomQuestion(rounds);
			rounds = question.size(); // needed because list may not actually be
										// 10... due to duplicates.
										// System.out.println("Rounds after creation and query: "
										// + rounds);
			for (int x = 0; x < rounds; x++) {
				round = new Round();
				round.setQuestion(question.get(x));
				gameRounds.add(round);
			}

			for (User u : tempUsers) {
				gameUsers.add(u);
			}

			game.setRounds(gameRounds);
			game.setUsers(gameUsers);

			// System.out.println("Created gamename: " + game.getGameName());
			games.put(game.getGameName(), game);

			mav = new ModelAndView(game, "/WEB-INF/jsp/Gameboard.jsp");
		}
		return game;
	}

	public Game createGame(int userId, int categoryId) {

		game = new Game();
		game.setGameName();
		Round round = new Round();
		User user = userManager.findUserById(userId);
		int rounds = 6;

		// Set<Question> gameQuest = new HashSet<Question>();
		Set<Round> gameRounds = new HashSet<Round>();
		Set<User> gameUsers = new HashSet<User>();
		// List<Round> tempRounds = new ArrayList<Round>();
		List<User> tempUsers = new ArrayList<User>();

		if (user != null) {
			tempUsers.add(user);
			List<Question> question = gameManager.generateCategorizedQuestions(
					rounds, categoryId);
			rounds = question.size(); // needed because list may not actually be
										// 10... due to duplicates.
										// System.out.println("Rounds after creation and query: "
										// + rounds);
			for (int x = 0; x < rounds; x++) {
				round = new Round();
				round.setQuestion(question.get(x));
				gameRounds.add(round);
			}

			for (User u : tempUsers) {
				gameUsers.add(u);
			}

			game.setRounds(gameRounds);
			game.setUsers(gameUsers);

			// System.out.println("Created gamename: " + game.getGameName());
			games.put(game.getGameName(), game);

			mav = new ModelAndView(game, "/WEB-INF/jsp/Gameboard.jsp");
		}

		return game;
	}

	public Game findGameByName(String name) {
		Game g = new Game();
		g = games.get(name);
		// System.out.println("Find game by name: " + name);
		return g;

	}

	public ModelAndView getRound(String gameName, int index) {
		// System.out.println("MAV get round " + index);
		Round round = getRound(index, gameName);
		mav = new ModelAndView(round, "/WEB-INF/jsp/Gameboard.jsp");
		return mav;
	}

	public Round getRound(int index, String gameName) {
		Round round = new Round();
		Object[] testObj = games.get(gameName).getRounds().toArray();
		// System.out.println("Getting round:  " + (index));
		round = (Round) testObj[index];
		// System.out.println("Round got: " +
		// round.getQuestion().getQuestion());
		return round;
	}

	public Question questionByRound(Round round) {

		Question quest = round.getQuestion();
		return quest;
	}

	public int answersByRound(Round r) {

		return r.getQuestion().getAnswers().size();
	}

	public void storeScoreOfUser(int userId, int roundNum, String gameName,
			int answerId) {
		int tempNumber = 5;
		gameManager.updateUserScore(userId, tempNumber);

		ArrayList<Result> results = new ArrayList<Result>();
		User user = userManager.findUserById(userId);
		Answer answer = gameManager.findAnswerById(answerId);
		// System.out.println("Get round to store it: " + roundNum);

		Round round = this.getRound((roundNum), gameName);
		Result result = new Result();

		if (answer.getCorrectAnswer())
			result.setUsersScore(1);
		result.setAnswer(answer);
		result.setRound(round);
		result.setUser(user);

		if (userGames.get(userId) != null) {
			for (Result r : userGames.get(userId)) {
				results.add(r);
			}
		}
		// System.out.println("stored score. size is: " + results.size());
		results.add(result);
		// System.out.println("Added recent score: " + results.size());
		userGames.put(userId, results);
		// =======
		// // public ModelAndView singleRound(int roundNum, String gameName) {
		// // Round round = new Round();
		// // Round[] rounds = null;
		// //
		// // Object[] object = game.getRounds().toArray();
		// // round = (Round) object[0];
		// //
		// // mav = new ModelAndView(round, "/WEB-INF/jsp/Gameboard.jsp");
		// //
		// // return mav;
		// //
		// // }
		//
		// public void storeScoreOfUser(int userId, int answerId, int roundNum,
		// String gameName)
		// {
		// // int tempNumber = 5;
		// // gameManager.updateUserScore(userId, tempNumber);
		//
		// ArrayList<Result> results = new ArrayList<Result>();
		// User user = userManager.findUserById(userId);
		// Answer answer = gameManager.findAnswerById(answerId);
		// System.out.println("Get round to store it: " + roundNum);
		//
		// Round round = this.getRound((roundNum), gameName);
		// Result result = new Result();
		//
		// result.setAnswer(answer);
		// result.setRound(round);
		// result.setUser(user);
		//
		// if (userGames.get(userId) != null) {
		// for (Result r : userGames.get(userId)) {
		// results.add(r);
		// }
		// }
		// // System.out.println("stored score. size is: " + results.size());
		// results.add(result);
		// // System.out.println("Added recent score: " + results.size());
		// userGames.put(userId, results);
		// >>>>>>> b32a01d480464bd0b65cfbd686047fb7a16aaa14

	}

	public ArrayList<Result> getUsersResults(int userId) {
		return userGames.get(userId);
	}

	public ModelAndView getUserResultMAV(int userId) {
		mav = new ModelAndView(userGames.get(userId), "/WEB-INF/jsp/Result.jsp");
		return mav;
	}

	public void setUM(UserManager um) {
		userManager = um;
	}

	public void setGM(GameManager gm) {
		gameManager = gm;
	}
}
