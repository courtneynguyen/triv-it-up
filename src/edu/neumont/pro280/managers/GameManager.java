package edu.neumont.pro280.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.neumont.pro280.models.Answer;
import edu.neumont.pro280.models.Category;
import edu.neumont.pro280.models.Question;
import edu.neumont.pro280.models.Result;
import edu.neumont.pro280.models.Round;
import edu.neumont.pro280.models.User;

@Stateless
@LocalBean
public class GameManager {
	@PersistenceContext(unitName = "UserService")
	EntityManager em;
	Random rand;

	HashMap<Integer, Set<Result>> userResults = new HashMap<Integer, Set<Result>>();

	public List<Question> generateRandomQuestion(int num) {

		Question q = null;
		List<Question> questions = new ArrayList<Question>();
		List<Answer> answer2 = null;
		Set<Answer> answers;
		TypedQuery<Question> query = em.createQuery("SELECT DISTINCT q FROM Question q", Question.class);

		int size = query.getResultList().size();

		while (questions.size() < num) {
			rand = new Random();
			Question t = null;
			int index = rand.nextInt(num);
			t = (Question) query.getResultList().get(index);
			if (!questions.contains(t)) {
				questions.add(t);
			}
		}
		// int index = 0;
		// System.out.println("Passed in # rounds: " + num);

		if (size > 0) {
			for (int x = 0; x < num; x++) {
				answers = new HashSet<Answer>();
				q = questions.get(x);
				TypedQuery<Answer> aq = em.createQuery("SELECT a FROM Answer a WHERE a.associatedQuestions.id=:questId", Answer.class);
				aq.setParameter("questId", q.getId());
				answer2 = aq.getResultList();

				for (Answer a : answer2) {
					answers.add(a);
				}
				
				questions.get(x).setAnswers(answers);
			}
		}
		return questions;
	}

	public List<Question> generateCategorizedQuestions(int numberOfQuestions, int categoryId) {

		Question q = null;
		List<Question> questions = new ArrayList<Question>();
		List<Answer> answerList = null;
		Set<Answer> answers;
		
		System.out.println("CategoryID is: " + categoryId);
		TypedQuery<Question> query = em.createQuery("SELECT DISTINCT q FROM Question q WHERE q.associatedCategory.id =:categoryid", Question.class);
		query.setParameter("categoryid", categoryId);

		int categorizedQuestionsSize = query.getResultList().size();
		System.out.println("Categorized Questions Size: " + categorizedQuestionsSize);
		
		for(int i = 0; i < numberOfQuestions; i++)
		{
			Question newQuestion = null;
			newQuestion = (Question) query.getResultList().get(i);
			questions.add(newQuestion);
		}
		
		
//		while (questions.size() < numberOfQuestions) {
//			Question t = null;
//			int index = rand.nextInt(numberOfQuestions);
//			t = (Question) query.getResultList().get(index);
//			if (!questions.contains(t)) {
//				questions.add(t);
//			}
//		}
		
		System.out.println("Passed in # rounds: " + numberOfQuestions);
		if (categorizedQuestionsSize > 0) 
		{
			for (int x = 0; x < numberOfQuestions; x++) 
			{
				answers = new HashSet<Answer>();
				q = questions.get(x);

				TypedQuery<Answer> aq = em.createQuery("SELECT a FROM Answer a WHERE a.associatedQuestions.id=:questId", Answer.class);
				aq.setParameter("questId", q.getId());
				answerList = aq.getResultList();

				for (Answer a : answerList) 
				{
					answers.add(a);
				}
				questions.get(x).setAnswers(answers);
			}
		}
		return questions;
	}
	public boolean isCorrect(int id) {
		Answer ans = em.find(Answer.class, id);
		return ans.getCorrectAnswer();
	}

	public Answer findAnswerById(int answerId) {
		Answer answer = em.find(Answer.class, answerId);
		return answer;

	}

	public Category getCategory(int categoriesRequested) {
		List<Category> categories = getListOfCategories();

		return categories.get(categoriesRequested);
	}

	public List<Category> getListOfCategories() {

		List<Category> categories = new ArrayList<Category>();
		TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c",	Category.class);

		categories = query.getResultList();
		return categories;
	}
	
	public void updateUserScore(int userId, int tempNumber)
	{
//		TypedQuery<User> query = em.createQuery("UPDATE DISTINCT User SET confidence_level =:tempnumber WHERE id =:userid", User.class);
//		query.setParameter("tempnumber", tempNumber);
//		query.setParameter("userid", userId);
	}
}
