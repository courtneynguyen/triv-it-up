package edu.neumont.pro280.models;

public class Player 
{
	public enum PlayerState {PLAYING, SPECTATOR}
	private PlayerState currentState = PlayerState.PLAYING;
	private double confidenceLevel;
	private int questionsAsked;
	private int questionsAnsweredCorrectly;
	private int flipFlopAndRight;
	private int flipFlopAndWrong;
	private final User user;
	
	public Player(User user) 
	{
		if(user == null) throw new IllegalArgumentException("User cannot be null.");
		this.user = user;
	}
	
	public void changePlayerState(PlayerState state) 
	{
		this.currentState = state;
	}

	public double getConfidenceLevel() 
	{
		return confidenceLevel;
	}

	public int getQuestionsAsked() 
	{
		return questionsAsked;
	}

	public int getQuestionsAnsweredCorrectly() 
	{
		return questionsAnsweredCorrectly;
	}

	public int getFlipFlopAndRight() 
	{
		return flipFlopAndRight;
	}

	public int getFlipFlopAndWrong() 
	{
		return flipFlopAndWrong;
	}
	
	public void calculateConfidenceLevel() 
	{
		
	}
	
	public void incrementQuestionsAsked() 
	{
		
	}
	
	public void incrementQuestionsAnswerdCorrectly() 
	{
		
	}
	
	public void incrementFlipFlopAndRight() 
	{
		
	}
	
	public void incrementFlipFloAndWrong() 
	{
		
	}
	
}
