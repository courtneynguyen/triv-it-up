package edu.neumont.pro280.models;

import java.util.ArrayList;
import java.util.List;

public class Team {
	private List<Player> teamMembers;
	private double currentTeamConfidenceLevel;
	private double initialTeamConfidence;

	public Team() {
		teamMembers = new ArrayList<Player>();
	}

	public void addPlayer(Player player) {

	}

	public List<Player> getTeamMembers() {
		return teamMembers;
	}

	public double getTeamConfidenceLevel() {
		return currentTeamConfidenceLevel;
	}

	public double getInitialTeamConfidence() {
		return initialTeamConfidence;
	}

	public void calculateInitialTeamConfidence() {

		double totalConfidence = 0;

		for (Player player : teamMembers) {
			totalConfidence += player.getConfidenceLevel();
		}

		initialTeamConfidence = totalConfidence / teamMembers.size();
		currentTeamConfidenceLevel = initialTeamConfidence;
	}

	public void adjustConfidenceLevel(double adjustBy) {
		currentTeamConfidenceLevel += adjustBy;
	}

	public boolean hasMember(Player player) {
		return teamMembers.contains(player);
	}
}
